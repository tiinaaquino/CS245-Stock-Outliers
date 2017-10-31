/**
 * Class that helps extract information from a Link from the LinkedList
 * @author tinaaquino
 */

public class Link {

	private StockData stock;
	private Link next;
	
	//constructors
	public Link(StockData stock, Link next) {
		this.stock = stock;
		this.next = next;
	}
	
	public Link(StockData stock) {
		this.stock = stock;
	}
	
	//getters
	public StockData getInfo() {
		return stock;
	}
	
	public Link next() {
		return next;
	}
	
	// setters
	public void setNewStock(StockData newStock) {
		this.stock = newStock;
	}
	
	public void setNext(Link newStock) {
		this.next = newStock;
	}
}
