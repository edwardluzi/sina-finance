package org.goldenroute.sinafinance;

import java.util.List;

public interface TimeseriesOperations
{
    List<Bar> getTimeseries(String symbol, int scale, int datalen);
}
