package org.goldenroute.sinafinance.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.goldenroute.sinafinance.Quote;
import org.goldenroute.sinafinance.QuoteOperations;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

public class QuoteTemplate implements QuoteOperations
{
    private final String BASE_URL = "http://hq.sinajs.cn/format=text&list=";

    private static final Logger logger = Logger.getLogger(QuoteTemplate.class);

    private final RestOperations restOperations;

    public QuoteTemplate(RestOperations restOperations)
    {
        this.restOperations = restOperations;

    }

    @Override
    public List<Quote> getQuotes(Collection<String> symbols)
    {
        String response = null;
        List<Quote> quotes = new ArrayList<>();

        try
        {
            response = restOperations.getForObject(BASE_URL + String.join(",", symbols), String.class);
        }
        catch (RestClientException e)
        {
            response = null;
            logger.error(e);
        }

        if (response != null)
        {
            String[] raws = response.split("\n");

            for (String raw : raws)
            {
                try
                {
                    quotes.add(new Quote(raw));
                }
                catch (Exception e)
                {
                    logger.debug(e.getMessage());
                }
            }
        }

        return quotes;
    }
}
