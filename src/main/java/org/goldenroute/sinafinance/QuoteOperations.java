package org.goldenroute.sinafinance;

import java.util.Collection;
import java.util.List;

public interface QuoteOperations
{
    List<Quote> getQuotes(Collection<String> symbols);
}
