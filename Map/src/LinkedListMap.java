
public class LinkedListMap <K,V> implements Map<K,V> {

	private class Node{
		public K key;
		public V value;
		public Node next;
		
		public Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public Node() {
			this.key = null;
			this.value = null; 
			this.next = null;
		}
	}
	
	private Node dummyHead;
	private int size;
	
	public LinkedListMap() {
		dummyHead = new Node();
		size = 0;
	}
	@Override
	public void set(K key, V value) {
		Node pointer = dummyHead.next;
		
		while (pointer != null) {
			if (pointer.key.equals(key)) {
				pointer.value = value;
			}
			pointer = pointer.next;
		}
	}

	@Override
	public void put(K key, V value) {
		if(!this.contains(key)) {
			this.dummyHead.next = new Node(key, value, this.dummyHead.next);
		}
	}

	@Override
	public V get(K key) {
		Node pointer = this.dummyHead.next;
		while (pointer != null) {
			if (pointer.key.equals(key)) {
				return pointer.value;
			}
			pointer = pointer.next;
		}
		return null;
	}

	@Override
	public V remove(K key) {
		Node pointer = this.dummyHead;
		while (pointer.next != null) {
			if (pointer.next.key.equals(key)) {
				Node deleteNode = pointer.next;
				pointer.next = deleteNode.next;
				deleteNode.next = null;
				return deleteNode.value;
			}
			pointer = pointer.next;
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		Node pointer = this.dummyHead.next;
		while (pointer != null) {
			if (pointer.key.equals(key)) {
				return true;
			}
			pointer = pointer.next;
		}
		return false;
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
		StringBuilder builder = new StringBuilder();
		Node pointer = this.dummyHead.next;
		while (pointer != null) {
			builder.append("[" + pointer.key +", " + pointer.value + "]");
			if (pointer.next != null) {
				builder.append(" ");
			}
			pointer = pointer.next;
		}
		return builder.toString();
	}
	
}
