package org.goldenroute.sinafinance;

import java.io.Serializable;

public class Bar extends SinaFinanceObject implements Serializable
{
    private static final long serialVersionUID = 1935132976213452865L;

    private String day;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;

    public String getDay()
    {
        return day;
    }

    public void setDay(String day)
    {
        this.day = day;
    }

    public double getOpen()
    {
        return open;
    }

    public void setOpen(double open)
    {
        this.open = open;
    }

    public double getHigh()
    {
        return high;
    }

    public void setHigh(double high)
    {
        this.high = high;
    }

    public double getLow()
    {
        return low;
    }

    public void setLow(double low)
    {
        this.low = low;
    }

    public double getClose()
    {
        return close;
    }

    public void setClose(double close)
    {
        this.close = close;
    }

    public double getVolume()
    {
        return volume;
    }

    public void setVolume(double volume)
    {
        this.volume = volume;
    }

    public Bar()
    {
    }

    public Bar(String day, double open, double high, double low, double close, double volume)
    {
        super();
        this.day = day;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    @Override
    public String toString()
    {
        return "Bar [day=" + day + ", open=" + open + ", high=" + high + ", low=" + low + ", close=" + close
                + ", volume=" + volume + "]";
    }
}
