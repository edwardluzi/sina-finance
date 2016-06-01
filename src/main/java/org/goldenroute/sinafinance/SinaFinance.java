package org.goldenroute.sinafinance;

import org.springframework.web.client.RestOperations;

public interface SinaFinance
{
    TimeseriesOperations timeseriesOperations();

    QuoteOperations quoteOperations();

    RestOperations restOperations();
}
