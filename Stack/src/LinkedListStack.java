import java.util.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

	private LinkedList<E> list;
	
	public void Stack() {
		list = new LinkedList<E> ();
	}
	
	@Override
	public E pop() {
		return list.removeLast();
	}

	@Override
	public E peek() {
		return list.getLast();
	}

	@Override
	public void push(E e) {
		list.add(e);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
