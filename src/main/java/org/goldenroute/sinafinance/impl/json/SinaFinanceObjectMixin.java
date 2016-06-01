package org.goldenroute.sinafinance.impl.json;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class SinaFinanceObjectMixin
{
    @JsonAnySetter
    abstract void add(String key, Object value);
}
