package org.goldenroute.sinafinance;

import java.util.HashMap;
import java.util.Map;

public abstract class SinaFinanceObject
{
	private Map<String, Object> extraData;

	public SinaFinanceObject()
	{
		this.extraData = new HashMap<String, Object>();
	}

	public Map<String, Object> getExtraData()
	{
		return this.extraData;
	}

	protected void add(String key, Object value)
	{
		this.extraData.put(key, value);
	}
}
