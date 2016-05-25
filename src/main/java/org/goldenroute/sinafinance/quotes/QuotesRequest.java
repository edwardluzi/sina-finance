package org.goldenroute.sinafinance.quotes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.goldenroute.sinafinance.utils.SinaErrorHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class QuotesRequest
{
	private static final Logger logger = Logger.getLogger(QuotesRequest.class);

	private final String BASE_URL = "http://hq.sinajs.cn/format=text&list=";

	private Collection<String> symbols;
	private RestTemplate restTemplate;

	public QuotesRequest(Collection<String> symbols)
	{
		this.symbols = symbols;
		this.restTemplate = new RestTemplate();
		this.restTemplate.setErrorHandler(new SinaErrorHandler());
	}

	public List<Quote> getResult()
	{
		String response;
		List<Quote> quotes = new ArrayList<>();

		try
		{
			response = this.restTemplate.getForObject(BASE_URL + String.join(",", this.symbols),
					String.class);
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
