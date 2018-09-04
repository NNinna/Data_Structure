
public class LinkedListStack<E> implements Stack<E>{
	
	private Linkedlist<E> list;
	
	public LinkedListStack() {
		list = new Linkedlist();
	}

	@Override
	public E pop() {
		if (list.isEmpty()) {
			return null;
		}
		return list.removeFirst();
	}

	@Override
	public E peek() {
		return list.getFirst();
	}

	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	@Override
	public int size() {
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	@Override 
	public String toString() {
		return list.toString();
	}
	
	
	public static void main(String[] args) {
		Stack<Integer> stack = new LinkedListStack();
		
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}		
		System.out.println("stack : " + stack);
	
		for (int i = 0; i < 5; i++) {
			System.out.println("pop :" + stack.pop());
		}
	
		System.out.println("stack : " + stack);		
		System.out.println("peek : " + stack.peek());
	}
	
}
