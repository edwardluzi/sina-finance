package org.goldenroute.sinafinance;

import java.util.Collection;
import java.util.List;

import org.goldenroute.sinafinance.quotes.Quote;
import org.goldenroute.sinafinance.quotes.QuotesRequest;

public class SinaFinance
{
	public static List<Quote> getQuotes(Collection<String> symbols)
	{
		QuotesRequest request = new QuotesRequest(symbols);
		return request.getResult();
	}
}
