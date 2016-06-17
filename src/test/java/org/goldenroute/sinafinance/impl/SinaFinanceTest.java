package org.goldenroute.sinafinance.impl;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.goldenroute.sinafinance.Bar;
import org.goldenroute.sinafinance.Quote;
import org.goldenroute.sinafinance.SinaFinance;
import org.goldenroute.sinafinance.impl.SinaFinanceTemplate;
import org.junit.Before;
import org.junit.Test;

public class SinaFinanceTest
{
    private static final Logger logger = Logger.getLogger(SinaFinanceTest.class);

    private SinaFinance sinaFinance;

    @Before
    public void setup()
    {
        sinaFinance = new SinaFinanceTemplate();
    }

    @Test
    public void testQuotes()
    {
        Set<String> symbols = new HashSet<String>(Arrays.asList(new String[] { "sz000651", "sh600036" }));

        List<Quote> quotes = sinaFinance.quoteOperations().getQuotes(symbols);

        assertNotNull(quotes);
        assert (quotes.size() == 2);

        for (Quote quote : quotes)
        {
            logger.debug(quote.toString());
        }
    }

    @Test
    public void testTimeseries()
    {
        List<Bar> bars = sinaFinance.timeseriesOperations().getTimeseries("sh600036", 5, 50);
        assertNotNull(bars);
        assert (bars.size() > 0);

        for (Bar bar : bars)
        {
            logger.debug(bar.toString());
        }

        bars = sinaFinance.timeseriesOperations().getTimeseries("sh600036", 1, 10);
        assertNotNull(bars);
        assert (bars.size() > 0);

        for (Bar bar : bars)
        {
            logger.debug(bar.toString());
        }

        bars = sinaFinance.timeseriesOperations().getTimeseries("sh600036", 60, 10);
        assertNotNull(bars);
        assert (bars.size() > 0);

        for (Bar bar : bars)
        {
            logger.debug(bar.toString());
        }
    }
}
