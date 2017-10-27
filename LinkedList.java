public class LinkedList {

	private Link head;
	private Link tail;
	private Link target;
	private int endingDate;
	private int size;
	private double sum;
	private int n;
	
	//constructor
	public LinkedList() {
		head = null;
		tail = head;
		target = null;
		endingDate = 0;
		size = 0;
		sum = 0;
		n = 0;
	}
	
	// getters
	public int size() {
		return size;
	}
	
	public Link get(int position) {
		ListIterator it = new ListIterator(head);
		int i = 0;
		if (!empty()) {
			while (i < size() && it.hasNext()) {
				if (i == position) {
					return it.next();
				}
				i++;
				it.next();
			}
		}
		return null;
	}
	
	public Link getPrevLink(int position) throws Exception {
		ListIterator it = new ListIterator(head);
		
		if (position < size()) {
			Link current = head;
			int i = 0;
			
			if (position == 0) {
				return current;
			}
			
			while (it.hasNext() && i <= size()) {
				if (i == position - 1) {
					return it.next();
				}
				i++;
				it.next();
			}
		}
		else {
			throw new Exception("Position exceeds size.");
		}
		return null;
	}
	
	public double getVarian(String date) {
		Link current = head;
		boolean value = false;
		
		while (current != null) {
			if (current.getInfo().getDate().equals(date)) {
				target = current;
				value = true;
				break;
			}
			current = current.next();
		}
		
		if (value == false) {
			return -1;
		}
		
		setEndingDate(target);
		current = target.next();
		
		while (compareDate(current) && current != null) {
			n++;
			sum += current.getInfo().getClosePrice();
			current = current.next();
		}
		
		double mean = sum/n;
		double high = 0;
		Link tempLink = target;
		while (compareDate(tempLink) && tempLink != null) {
			high = high + Math.pow((tempLink.getInfo().getClosePrice() - mean), 2);
			tempLink = tempLink.next();
		}
		
		return (high/(n-1));
	}
	
	// setters
	public void setEndingDate(Link target) {
		int date = Integer.parseInt(convertDate(target.getInfo().getDate()));
		endingDate = date + 10000 - 1;
	}
	
	//other functions
	/**
	 * add (Object data)
	 * add(int position, Object data)
	 * remove (int position)
	 * iterator()
	 * 
	 */
	
	public void add(StockData data) {
		if (head == null) {
			head = new Link(data);
			size++;
			return;
		}
		
		if (tail == null) {
			tail = new Link(data);
			head.setNext(tail);
		}
		
		else {
			Link newLink = new Link(data);
			tail.setNext(newLink);
			tail = newLink;
		}
		size++;
	}
	
	public void add(int position, StockData data) throws Exception{
		if (head == null) {
			head = new Link(data);
			size++;
			return;
		}
		
		if (position != 0 && position < size()) {
			Link prevLink = getPrevLink(position);
			Link tempLink = prevLink.next();
			prevLink.setNext(new Link(data, tempLink));
		}
		
		else if (position == size()) {
			if (tail == null) {
				tail = new Link(data);
				head.setNext(tail);
			}
			else {
				Link newLink = new Link(data);
				tail.setNext(newLink);
				tail = newLink;
			}
		}
		
		else {
			Link newLink = new Link(data, head);
			head = newLink;
		}
		
		size++;
	}
	
	public boolean empty() {
		return size == 0;
	}
	
	public void remove(int position) throws Exception {
		if (!empty()) {
			Link prevLink = getPrevLink(position);
			Link newLink = prevLink.next();
			prevLink.setNext(newLink.next());
			size--;
		}
		else {
			System.out.println("This is an empty list.");
		}
	}
	
	public String convertDate(String date) {
		String day = date.substring(8, date.length() - 1).equals("0") ? date.substring(9, date.length())
				: date.substring(8, date.length());
		String month = date.substring(5, 6).equals("0") ? date.substring(6, 7) : date.substring(5, 7);
		String year = "20" + date.substring(2, 4);
		return (year + month + day);
	}
	
	public boolean compareDate(Link target) {
		int date = Integer.parseInt(convertDate(target.getInfo().getDate()));
		if (date <= endingDate) {
			return true;
		}
		return false;
	}
	
	public void Output(String date, String symbol) {
		double varian = getVarian(date);
		System.out.println();
		System.out.println("Outlier for " + symbol + " of " + date + ": \n");
		
		if (n == 0 || varian == -1) {
			System.out.println("There is insufficient data for this period.");
			return;
		}
		
		Link current = target;
		while (current != null && compareDate(current)) {
			if (current.getInfo().getClosePrice() > varian) {
				System.out.println(current.getInfo().getDate()+ ": " + current.getInfo().getClosePrice());
			}
			current = current.next();
		}
		
		System.out.println();
		
	}
}
