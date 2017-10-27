/*
 * class to extract data from the file
 */

public class StockData {

	private String date;
	private double openPrice;
	private double closePrice;
	private double highPrice;
	private double lowPrice;
	private double adjClosePrice;
	private int volume;
	
	// constructor
	public StockData(String date, double openPrice, double highPrice, double lowPrice, double closePrice,
			double adjClosePrice, int volume) {

		this.date = date;
		this.openPrice = openPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.closePrice = closePrice;
		this.adjClosePrice = adjClosePrice;
		this.volume = volume;
	}
	
	//setters
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}
	
	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}
	
	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}
	
	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}
	
	public void setAdjClosePrice(double adjClosePrice) {
		this.adjClosePrice = adjClosePrice;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	//getters
	public String getDate() {
		return date;
	}
	
	public double getOpenPrice() {
		return openPrice;
	}
	
	public double getClosePrice() {
		return closePrice;
	}
	
	public double getHighPrice() {
		return highPrice;
	}
	
	public double getLowPrice() {
		return lowPrice;
	}
	
	public double getAdjClosePrice() {
		return adjClosePrice;
	}
	
	public int getVolume() {
		return volume;
	}
	
	//toString
	public String toString() {
		String date = getDate();
		double openPrice = getOpenPrice();
		double closePrice = getClosePrice();
		double highPrice = getHighPrice();
		double lowPrice = getLowPrice();
		double adjClosePrice = getAdjClosePrice();
		int volume = getVolume();
		
		String output = "Date: " + date + "\n" +
						"Open price: " + openPrice + "\n" +
						"Close price: " + closePrice + "\n" +
						"High price: " + highPrice + "\n" +
						"Low price: " + lowPrice + "\n" +
						"Adj Close price: " + adjClosePrice + "\n" +
						"Volume: " + volume + "\n";
		return output;
		
	}
}
