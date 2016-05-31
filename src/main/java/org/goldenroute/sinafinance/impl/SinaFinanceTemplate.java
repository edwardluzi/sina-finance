package org.goldenroute.sinafinance.impl;

import org.goldenroute.sinafinance.QuoteOperations;
import org.goldenroute.sinafinance.SinaFinance;
import org.goldenroute.sinafinance.TimeseriesOperations;
import org.goldenroute.sinafinance.impl.json.SinaFinaneModule;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SinaFinanceTemplate implements SinaFinance
{
	private TimeseriesOperations timeseriesOperations;
	private QuoteOperations briefQuoteOperations;
	private RestTemplate restTemplate;
	private ObjectMapper objectMapper;

	public SinaFinanceTemplate()
	{
		initialize();
	}

	@Override
	public TimeseriesOperations timeseriesOperations()
	{
		return timeseriesOperations;
	}

	@Override
	public QuoteOperations quoteOperations()
	{
		return briefQuoteOperations;
	}

	@Override
	public RestOperations restOperations()
	{
		return restTemplate;
	}

	protected ObjectMapper getObjectMapper()
	{
		return objectMapper;
	}

	private void initialize()
	{
		objectMapper = new ObjectMapper(new JsonFactory());
		objectMapper.registerModule(new SinaFinaneModule());
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

		restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new SinaFinanceErrorHandler());

		initSubApis();
	}

	private void initSubApis()
	{
		this.timeseriesOperations = new TimeseriesTemplate(restTemplate, objectMapper);
		this.briefQuoteOperations = new QuoteTemplate(restTemplate);
	}
}
