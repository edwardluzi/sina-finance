package org.goldenroute.sinafinance;

public class Quote
{
	private String symbol;
	private String name;
	private double open;
	private double historyClose;
	private double price;
	private double dayHigh;
	private double dayLow;
	private double bid;
	private double ask;
	private double volume;
	private double turnover;
	private double bidSize1;
	private double bid1;
	private double bidSize2;
	private double bid2;
	private double bidSize3;
	private double bid3;
	private double bidSize4;
	private double bid4;
	private double bidSize5;
	private double bid5;
	private double askSize1;
	private double ask1;
	private double askSize2;
	private double ask2;
	private double askSize3;
	private double ask3;
	private double askSize4;
	private double ask4;
	private double askSize5;
	private double ask5;
	private String timestamp;

	public String getSymbol()
	{
		return symbol;
	}

	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getOpen()
	{
		return open;
	}

	public void setOpen(double open)
	{
		this.open = open;
	}

	public double getHistoryClose()
	{
		return historyClose;
	}

	public void setHistoryClose(double historyClose)
	{
		this.historyClose = historyClose;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public double getDayHigh()
	{
		return dayHigh;
	}

	public void setDayHigh(double dayHigh)
	{
		this.dayHigh = dayHigh;
	}

	public double getDayLow()
	{
		return dayLow;
	}

	public void setDayLow(double dayLow)
	{
		this.dayLow = dayLow;
	}

	public double getBid()
	{
		return bid;
	}

	public void setBid(double bid)
	{
		this.bid = bid;
	}

	public double getAsk()
	{
		return ask;
	}

	public void setAsk(double ask)
	{
		this.ask = ask;
	}

	public double getVolume()
	{
		return volume;
	}

	public void setVolume(double volume)
	{
		this.volume = volume;
	}

	public double getTurnover()
	{
		return turnover;
	}

	public void setTurnover(double turnover)
	{
		this.turnover = turnover;
	}

	public double getBidSize1()
	{
		return bidSize1;
	}

	public void setBidSize1(double bidSize1)
	{
		this.bidSize1 = bidSize1;
	}

	public double getBid1()
	{
		return bid1;
	}

	public void setBid1(double bid1)
	{
		this.bid1 = bid1;
	}

	public double getBidSize2()
	{
		return bidSize2;
	}

	public void setBidSize2(double bidSize2)
	{
		this.bidSize2 = bidSize2;
	}

	public double getBid2()
	{
		return bid2;
	}

	public void setBid2(double bid2)
	{
		this.bid2 = bid2;
	}

	public double getBidSize3()
	{
		return bidSize3;
	}

	public void setBidSize3(double bidSize3)
	{
		this.bidSize3 = bidSize3;
	}

	public double getBid3()
	{
		return bid3;
	}

	public void setBid3(double bid3)
	{
		this.bid3 = bid3;
	}

	public double getBidSize4()
	{
		return bidSize4;
	}

	public void setBidSize4(double bidSize4)
	{
		this.bidSize4 = bidSize4;
	}

	public double getBid4()
	{
		return bid4;
	}

	public void setBid4(double bid4)
	{
		this.bid4 = bid4;
	}

	public double getBidSize5()
	{
		return bidSize5;
	}

	public void setBidSize5(double bidSize5)
	{
		this.bidSize5 = bidSize5;
	}

	public double getBid5()
	{
		return bid5;
	}

	public void setBid5(double bid5)
	{
		this.bid5 = bid5;
	}

	public double getAskSize1()
	{
		return askSize1;
	}

	public void setAskSize1(double askSize1)
	{
		this.askSize1 = askSize1;
	}

	public double getAsk1()
	{
		return ask1;
	}

	public void setAsk1(double ask1)
	{
		this.ask1 = ask1;
	}

	public double getAskSize2()
	{
		return askSize2;
	}

	public void setAskSize2(double askSize2)
	{
		this.askSize2 = askSize2;
	}

	public double getAsk2()
	{
		return ask2;
	}

	public void setAsk2(double ask2)
	{
		this.ask2 = ask2;
	}

	public double getAskSize3()
	{
		return askSize3;
	}

	public void setAskSize3(double askSize3)
	{
		this.askSize3 = askSize3;
	}

	public double getAsk3()
	{
		return ask3;
	}

	public void setAsk3(double ask3)
	{
		this.ask3 = ask3;
	}

	public double getAskSize4()
	{
		return askSize4;
	}

	public void setAskSize4(double askSize4)
	{
		this.askSize4 = askSize4;
	}

	public double getAsk4()
	{
		return ask4;
	}

	public void setAsk4(double ask4)
	{
		this.ask4 = ask4;
	}

	public double getAskSize5()
	{
		return askSize5;
	}

	public void setAskSize5(double askSize5)
	{
		this.askSize5 = askSize5;
	}

	public double getAsk5()
	{
		return ask5;
	}

	public void setAsk5(double ask5)
	{
		this.ask5 = ask5;
	}

	public String getTimestamp()
	{
		return timestamp;
	}

	public void setTimestamp(String timestamp)
	{
		this.timestamp = timestamp;
	}

	public Quote(String content)
	{
		String[] items = content.split("=|,");

		if (items.length != 34)
		{
			throw new IllegalArgumentException("content");
		}

		this.symbol = items[0];
		this.name = items[1];

		this.open = Double.parseDouble(items[2]);
		this.historyClose = Double.parseDouble(items[3]);
		this.price = Double.parseDouble(items[4]);
		this.dayHigh = Double.parseDouble(items[5]);
		this.dayLow = Double.parseDouble(items[6]);
		this.bid = Double.parseDouble(items[7]);
		this.ask = Double.parseDouble(items[8]);
		this.volume = Double.parseDouble(items[9]);
		this.turnover = Double.parseDouble(items[10]);
		this.bidSize1 = Double.parseDouble(items[11]);
		this.bid1 = Double.parseDouble(items[12]);
		this.bidSize2 = Double.parseDouble(items[13]);
		this.bid2 = Double.parseDouble(items[14]);
		this.bidSize3 = Double.parseDouble(items[15]);
		this.bid3 = Double.parseDouble(items[16]);
		this.bidSize4 = Double.parseDouble(items[17]);
		this.bid4 = Double.parseDouble(items[18]);
		this.bidSize5 = Double.parseDouble(items[19]);
		this.bid5 = Double.parseDouble(items[20]);
		this.askSize1 = Double.parseDouble(items[21]);
		this.ask1 = Double.parseDouble(items[22]);
		this.askSize2 = Double.parseDouble(items[23]);
		this.ask2 = Double.parseDouble(items[24]);
		this.askSize3 = Double.parseDouble(items[25]);
		this.ask3 = Double.parseDouble(items[26]);
		this.askSize4 = Double.parseDouble(items[27]);
		this.ask4 = Double.parseDouble(items[28]);
		this.askSize5 = Double.parseDouble(items[29]);
		this.ask5 = Double.parseDouble(items[30]);

		this.timestamp = items[31] + " " + items[32];
	}

	@Override
	public String toString()
	{
		return "Quote [symbol=" + symbol + ", name=" + name + ", open=" + open + ", historyClose="
				+ historyClose + ", price=" + price + ", dayHigh=" + dayHigh + ", dayLow=" + dayLow
				+ ", bid=" + bid + ", ask=" + ask + ", volume=" + volume + ", turnover=" + turnover
				+ ", bidSize1=" + bidSize1 + ", bid1=" + bid1 + ", bidSize2=" + bidSize2
				+ ", bid2=" + bid2 + ", bidSize3=" + bidSize3 + ", bid3=" + bid3 + ", bidSize4="
				+ bidSize4 + ", bid4=" + bid4 + ", bidSize5=" + bidSize5 + ", bid5=" + bid5
				+ ", askSize1=" + askSize1 + ", ask1=" + ask1 + ", askSize2=" + askSize2
				+ ", ask2=" + ask2 + ", askSize3=" + askSize3 + ", ask3=" + ask3 + ", askSize4="
				+ askSize4 + ", ask4=" + ask4 + ", askSize5=" + askSize5 + ", ask5=" + ask5
				+ ", timestamp=" + timestamp + "]";
	}
}
