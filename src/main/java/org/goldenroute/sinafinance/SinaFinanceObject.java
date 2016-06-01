package org.goldenroute.sinafinance;

import java.util.HashMap;
import java.util.Map;

public abstract class SinaFinanceObject
{
    private Map<String, Object> extraData;

    public SinaFinanceObject()
    {
        extraData = new HashMap<String, Object>();
    }

    public Map<String, Object> getExtraData()
    {
        return extraData;
    }

    protected void add(String key, Object value)
    {
        extraData.put(key, value);
    }
}
