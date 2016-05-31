package org.goldenroute.sinafinance.impl.json;

import org.goldenroute.sinafinance.SinaFinanceObject;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class SinaFinaneModule extends SimpleModule
{
	private static final long serialVersionUID = 2187084305052393830L;

	public SinaFinaneModule()
	{
		super("SinaFinaneModule");
	}

	@Override
	public void setupModule(SetupContext context)
	{
		context.setMixInAnnotations(SinaFinanceObject.class, SinaFinanceObjectMixin.class);
	}
}
