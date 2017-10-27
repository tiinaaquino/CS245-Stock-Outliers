import java.util.Iterator;

public class ListIterator implements Iterator<Object>{
	
	Link current;
	
	public ListIterator(Link head) {
		current = head;
	}
	
	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public Link next() {
		Link result = current;
		current = current.next();
		return result;
	}
	
}