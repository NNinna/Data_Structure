
public class Linkedlist<E> {

	private class Node{
		public E e;
		public Node next;

		public Node() {
			e = null;
			next = null;
		}

		public Node (E e) {
			this.e = e;
		}

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}

		public String toString() {
			return e.toString();
		}		
	}

	private Node dummyHead;
	private int size;

	public Linkedlist(){
		dummyHead = new Node();
		size = 0;
	}

	public int getSize(){
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	//add element at index (0 - based)
	public void add(int index, E e){
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Add failed. Illegal index");
		}
		Node pointer = this.dummyHead;
		for (int i = 0; i < index; i++) {
			pointer = pointer.next;
		}
		pointer.next = new Node(e, pointer.next);
		size ++;
	}
	public void addFirst(E e) {
		add(0, e);
	}
	public void addLast(E e) {
		add(size, e);
	}
	//add element at index th
	public void set(int index, E e) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("set fail, index error");
		}
		Node pointer = this.dummyHead.next;
		for (int i = 0; i < index ; i++) {
			pointer = pointer.next;
		}
		pointer.e = e; 
	}

	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("get fail, index error");
		}
		Node pointer = this.dummyHead.next;
		for (int i = 0; i < index; i++) {
			pointer = pointer.next;
		}
		return pointer.e;
	}

	public E getFirst() {
		return get(0);
	}

	public void remove(E e) {
		Node pointer = this.dummyHead;
		while (pointer.next != null) {
			if (e.equals(pointer.next.e)) {
				break;
			}
			pointer = pointer.next;
		}
		if (pointer.next!= null) {
			Node node = pointer.next;;
			pointer.next = node.next;
			node.next = null;
			size --;
		}
	}
	
	public E remove(int index) {
		if (index  < 0 || index > size) {
			throw new IllegalArgumentException("remove fail. index eroor");
		}
		Node pointer = this.dummyHead;
		for (int i = 0; i < index; i++) {
			pointer = pointer.next;
		}
		Node node = pointer.next;
		pointer.next = node.next;
		node.next = null;
		size --;
		return node.e;
	}
	public E removeFirst() {
		return remove(0);
	}
	public E removeLast() {
		return remove( size - 1);
	}

	public boolean contains(E e) {
		Node pointer = this.dummyHead.next;
		while (pointer != null) {
			if (e.equals(pointer.e)) {
				return true;
			}
			pointer = pointer.next;
		}
		return false;
	}
	
	@Override
	public String toString() {
		Node pointer = this.dummyHead.next;
		StringBuilder builder = new StringBuilder();
		while (pointer != null) {
			builder.append(pointer.e);
			pointer = pointer.next;
		}
		return builder.toString();
	}
}
