package org.goldenroute.sinafinance;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.goldenroute.sinafinance.impl.SinaFinanceTemplate;
import org.junit.Before;
import org.junit.Test;

public class SinaFinanceTest
{
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
    }

    @Test
    public void testTimeseries()
    {
        List<Bar> ticks = sinaFinance.timeseriesOperations().getTimeseries("sh600036", 5, 10);
        assertNotNull(ticks);
        assert (ticks.size() > 0);

        ticks = sinaFinance.timeseriesOperations().getTimeseries("sh600036", 1, 10);
        assertNotNull(ticks);
        assert (ticks.size() > 0);
    }
}
