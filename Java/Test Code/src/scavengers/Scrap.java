package scavengers;

public class Scrap {
	protected int scrapWeight;
	protected String scrapType;

	public void setScrapWeight(int weightIn) {
		this.scrapWeight = weightIn;
	}

	public void setScrapType(String typeIn) {
		this.scrapType = typeIn;
	}

	public int getScrapWeight() {
		return scrapWeight;
	}

	public String getScrapType() {
		return scrapType;
	}

	public void reduce(int amount) {
		if (amount <= scrapWeight) {
			scrapWeight = scrapWeight - amount;
		} else
			scrapWeight = 0;
	}

}
