import java.util.Stack;

public class BSTMap <K extends Comparable<K>, V> implements Map<K,V>{
	private class Node{
		public K key;
		public V value;
		public Node right, left;
		
		public Node() {
			this.key = null;
			this.value = null;
			this.right = this.left = null;
		}
		
		public Node(K key, V value, Node right, Node left) {
			this.key = key;
			this.value = value;
			this.right = right;
			this.left = left;
		}
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.right = this.left = null;
		}
		
		@Override
		public String toString() {
			return "["+this.key +" : "+ this.value+"]";
		}
	}
	
	private Node root;
	private int size;
	public BSTMap() {
		size = 0;
	}
	
	@Override
	public void set(K key, V value) {
		
		Node node = findNode(root, key);
		if (node == null) {
			throw new IllegalArgumentException();
		}
		node.value = value;
	}
	
	private Node findNode(Node node, K key) {
		if (node == null) {
			return node;
		}
		int res = key.compareTo(node.key);
		if (res == 0) {
			return node;
		}else if (res > 0) {
			return findNode(node.right, key);
		}else {
			return findNode(node.left, key);
		}
	}
	
	
	@Override
	public void put(K key, V value) {
		root = addNode(root, key, value);
	}
	
	private Node addNode(Node node, K key, V value) {
		if (node == null) {
			size++;
			return new Node(key, value);
		}
		int res = key.compareTo(node.key);
		if (res == 0) {
			throw new IllegalArgumentException("key existed");
		}else if (res > 0){
			node.right = addNode(node.right, key, value);
		}else {
			node.left = addNode(node.left, key, value);
		}
		return node;
	}
	@Override
	public V get(K key) {
		Node node = this.findNode(root, key);
		return node.value;
	}
	@Override
	public V remove(K key) {
		Node node = this.findNode(root, key);
		if (node != null) {
			V val = node.value;
			root = remove(root, key);
			return val;
		}
	
		return null;
	}
	
	private Node remove(Node node, K key) {
		if (node == null) {
			return null;
		}
		int res = key.compareTo(node.key);
		
		if (res > 0) {
			node.right = remove(node.right, key);
			return node;
		}else if (res < 0) {
			node.left = remove(node.left, key);
			return node;
		}else {
			if (node.left == null) {
				Node right = node.right;
				node.right = null;
				size--;
				return right;
			}else if (node.right == null) {
				Node left = node.left;
				node.left = null;
				size--;
				return left;
			}else {
				Node min = findMin(root.right);
				min.right = removeMin(root.right);
				min.left = node.left;
				
				node.left = node.right = null;
				return min;
			}
		}
	}
	
	//precondition node != null
	private Node findMin(Node node) {
		if (node.left == null) {
			return node;
		}
		return findMin(node.left);
	}
	
	//precondition node != null
	private Node removeMin(Node node) {
		if (node.left == null) {
			Node right = node.right;
			node.right = null;
			size--;
			return right;
		}
		
		node.left = removeMin(node.left);
		return node;
	}
	
	@Override
	public boolean contains(K key) {
		Node node = this.findNode(root, key);
		return node != null;
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
		return preOrder(root);
	}
	
	private String preOrder (Node node) {
		StringBuilder builder = new StringBuilder();
		
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
		
			builder.append(cur);
			if (cur.left != null) {
				stack.push(cur.left);
			}
			if (cur.right != null) {
				stack.push(cur.right);
			}
		}
		return builder.toString();
	}
	
}
