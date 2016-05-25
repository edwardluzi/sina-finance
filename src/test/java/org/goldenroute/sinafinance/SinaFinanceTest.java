package org.goldenroute.sinafinance;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.goldenroute.sinafinance.quotes.Quote;
import org.junit.Test;

public class SinaFinanceTest
{
	@Test
	public void test()
	{
		Set<String> symbols = new HashSet<String>(Arrays.asList(new String[] { "sz000651",
				"sh600036" }));

		List<Quote> quotes = SinaFinance.getQuotes(symbols);

		assertNotNull(quotes);
		assert(quotes.size() == 2);
	}
}
