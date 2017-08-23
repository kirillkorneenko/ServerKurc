package by.bsuir.trucking.command.logic;

public class Item implements Comparable<Item>
{

	public int number;
	public float profit;
	public float weight;

	public Item(int number, float profit, float weight)
	{
		this.number=number;
		this.profit=profit;
		this.weight=weight;
	}

	public int getNumber() {
		return number;
	}

	public float getProfit() {
		return profit;
	}

	public float getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Item i) {
		float ratio = (float)this.profit/this.weight;
		float secondRatio = (float)i.profit/i.weight;
		if(ratio > secondRatio) {
			return -1;
		}
		else if(ratio < secondRatio) {
			return 1;
		}
		return 0;

	}
	public String toString()
	{
		return "Item: " + this.number + " Profit: " + this.profit + " Weight: " + this.weight;
	}

}
