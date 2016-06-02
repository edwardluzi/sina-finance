package org.goldenroute.sinafinance.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.apache.log4j.Logger;
import org.goldenroute.sinafinance.Bar;
import org.goldenroute.sinafinance.TimeseriesOperations;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TimeseriesTemplate implements TimeseriesOperations
{
    private static final Logger logger = Logger.getLogger(TimeseriesTemplate.class);
    private static final List<Integer> supportedScales = Arrays.asList(new Integer[] { 1, 5, 15, 30, 60 });

    private static final String BASE_URL_1_MINUTES = "http://hq.sinajs.cn/format=text&list=";
    private static final String BASE_URL_OTHERS = "http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/CN_MarketData.getKLineData";

    private final RestOperations restOperations;
    private final ObjectMapper objectMapper;

    public TimeseriesTemplate(RestOperations restOperations, ObjectMapper objectMapper)
    {
        this.restOperations = restOperations;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Bar> getTimeseries(String symbol, int scale, int datalen)
    {
        if (!supportedScales.contains(scale))
        {
            throw new IllegalArgumentException("scale");
        }

        if (datalen <= 0)
        {
            throw new IllegalArgumentException("datalen");
        }

        if (scale == 1)
        {
            return request1(symbol, datalen);
        }
        else
        {
            return request5Plus(symbol, scale, datalen);

        }
    }

    private List<Bar> request1(String symbol, int datalen)
    {
        String response = null;

        try
        {
            response = restOperations.getForObject(BASE_URL_1_MINUTES + "ml_" + symbol, String.class);
        }
        catch (RestClientException e)
        {
            response = null;
            logger.error(e);
        }

        List<Bar> bars = null;

        if (response != null)
        {
            try
            {
                String[] items = response.split("=");

                if (items.length == 2)
                {
                    bars = parseBars(items[1]);
                }
            }
            catch (Exception e)
            {
                logger.debug(e);
            }
        }

        if (bars != null && bars.size() > datalen)
        {
            bars.subList(0, bars.size() - datalen).clear();
        }

        return bars;
    }

    @SuppressWarnings({ "checkstyle:GenericWhitespace" })
    private List<Bar> request5Plus(String symbol, int scale, int datalen)
    {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL_OTHERS).queryParam("symbol", symbol)
                .queryParam("scale", Integer.toString(scale)).queryParam("ma", "no")
                .queryParam("datalen", Integer.toString(datalen));

        String response = null;

        try
        {
            response = restOperations.getForObject(builder.build().toUri(), String.class);
        }
        catch (RestClientException e)
        {
            response = null;
            logger.error(e);
        }

        List<Bar> bars = null;

        if (response != null)
        {
            try
            {
                bars = objectMapper.<List<Bar>> readValue(response, new TypeReference<List<Bar>>()
                {
                });
            }
            catch (IOException e)
            {
                logger.error(e);
            }
        }

        return bars;
    }

    private List<Bar> parseBars(String base64Content)
    {
        List<Bar> bars = new ArrayList<>();

        for (int start = 0; start <= base64Content.length() - 16; start += 16)
        {
            byte[] decoded = Base64.getDecoder().decode(
                    base64Content.substring(start, start + 16).getBytes(StandardCharsets.US_ASCII));

            int average = (decoded[3]) & 0xff000000 | (decoded[2] << 16) & 0x00ff0000 | (decoded[1] << 8) & 0x0000ff00
                    | (decoded[0] << 0) & 0x000000ff;

            if (average == -1)
            {
                break;
            }

            long volume = (decoded[11]) & 0xff000000L | (decoded[10] << 16) & 0x00ff0000L | (decoded[9] << 8)
                    & 0x0000ff00L | (decoded[8] << 0) & 0x000000ffL;

            double avg = average / 1000.0;

            bars.add(new Bar(null, avg, avg, avg, avg, volume));
        }

        return bars;
    }
}
