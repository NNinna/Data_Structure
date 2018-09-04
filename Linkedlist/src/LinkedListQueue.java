
public class LinkedListQueue<E> implements Queue<E>{

	private class Node{
		public E e;
		public Node next;
		
		public Node() {
			e = null;
			next = null;
		}
		
		public Node (E e) {
			this.e = e;
			this.next = null;
		}
		
		public Node (E e, Node next) {
			this.e = e;
			this.next = next;
		}
	}
	
	private Node tail;
	private Node front;
	private int size;
	
	public LinkedListQueue () {
		tail = new Node();
		front = tail;
		size = 0;
	}
	
	@Override
	public void offer(E e) {
		tail.next = new Node(e);
		tail = tail.next;
		size++;
	}

	@Override
	public E poll() {
		if (this.isEmpty()) {
			throw new IllegalArgumentException("there is no element");
		}
		Node node = front.next;
		front.next = node.next;
		node.next = null;
		size --;
		return node.e;
	}

	@Override
	public E peek() {
		if (this.isEmpty()) {
			throw new IllegalArgumentException("there is no element");
		}
		return front.next.e;
	}

	@Override
	public boolean isEmpty() {

		return size == 0;
	}

	@Override
	public int size() {
		
		return size;
	}
	
	@Override
	public String toString() {
		if (this.isEmpty()) {
			throw new IllegalArgumentException("there is no element");
		}
		StringBuilder builder = new StringBuilder();
		Node pointer = front.next;
		while (pointer != null) {
			builder.append(pointer.e);
			pointer = pointer.next;
		}
		
		return builder.toString();
		
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedListQueue<>();
		
		for (int i = 0; i < 10; i++) {
			queue.offer(i);
		}
		
		System.out.println("queue : " + queue);
		
		for (int i = 0; i < 7; i++) {
			System.out.println("poll from queue : " + queue.poll());
		}
		System.out.println("queue : " + queue);
		
		System.out.println("peek queue : " + queue.peek());
		
	}

}
