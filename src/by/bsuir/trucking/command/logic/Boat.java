package by.bsuir.trucking.command.logic;

import java.util.ArrayList;


public class Boat
{

	public float maxWeight;
	public ArrayList<Item> items;
	public float profit;

	public Boat(float maxWeight)
	{
		this.maxWeight = maxWeight;
		this.items=new ArrayList<Item>();
		this.profit = 0;
	}

	public void setProfit(float profit) {
		this.profit = profit;
	}


}
