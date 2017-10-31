/**
 * Class to be used to facilitate iteration through the Object instances
 * contained on the LinkedList
 * 
 * @author tinaaquino
 */

import java.util.Iterator;

public class ListIterator implements Iterator<Object>{
	
	Link current;
	
	public ListIterator(Link head) {
		current = head;
	}
	
	/**
	 * @return
	 * 		"true" if there is an Object after the current location 
	 */
	@Override
	public boolean hasNext() {
		return current != null;
	}

	/**
	 * advances to the next Object instance
	 * @return
	 * 		copy of the next Object instance
	 */
	@Override
	public Link next() {
		Link result = current;
		current = current.next();
		return result;
	}
	
}
