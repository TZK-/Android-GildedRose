package fr.iutvalence.info.m4104.gildedroseinn;

public class Item {
    private final String name;

	private int sellIn;

	private int quality;

	public Item(String name, int sellIn, int quality)
	{
		this.name = name;
		this.sellIn = sellIn;
		this.setQuality(quality);
	}

	public String getName()
	{
		return this.name;
	}

	public void setSellIn(int sellIn)
	{
		this.sellIn = sellIn;
	}

	public int getSellIn()
	{
		return this.sellIn;
	}

	public int getQuality()
	{
		return quality;
	}

	public void setQuality(int quality)
	{
		this.quality = quality;
	}
}

