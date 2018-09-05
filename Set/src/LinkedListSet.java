
public class LinkedListSet<E extends Comparable<E>> implements Set<E>{

	private LinkedList<E> list;
	
	public LinkedListSet() {
		list = new LinkedList<E>();
	}
	
	@Override
	public void add(E e) {
		if (!list.contains(e)) {
			list.add(e);
		}
		
	}

	@Override
	public boolean contains(E e) {
		return list.contains(e);
	}

	@Override
	public void remove(E e) {
		list.remove(e);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override 
	public String toString() {
		return list.toString();
	}
}
