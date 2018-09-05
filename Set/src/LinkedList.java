
public class LinkedList<E> {
	private class Node<E>{
		public E e;
		public Node next;
		
		public Node(E e) {
			this.e = e;
			this.next = null;
		}
		
		public Node() {
			this(null, null);
		}
		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
	}
	
	private Node dummyHead;
	private int size;
	
	public LinkedList() {
		dummyHead = new Node();
		size = 0;
	}
	
	public boolean contains (E e) {
		Node pointer = this.dummyHead.next;

		while (pointer != null) {
			if (e.equals(pointer.e)) {
				return true;
			}
			pointer = pointer.next;
		}
		return false;
	}
	
	public void add(E e) {
		size++;
		this.dummyHead.next = new Node(e, this.dummyHead.next);
	}
	
	public boolean remove(E e) {
		Node pointer = this.dummyHead;
		while (pointer.next != null) {
			if (e.equals(pointer.next.e)) {
				Node deleteNode = pointer.next;
				pointer.next = deleteNode.next;
				deleteNode.next = null;
				size--;
				return true;
			}
			pointer = pointer.next;
		}
		return false;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Node pointer = this.dummyHead.next;
		while (pointer != null) {
			builder.append(pointer.e);
			if (pointer.next != null) {
				builder.append("-");
			}
			pointer = pointer.next;
		}
		return builder.toString();
	}
}


