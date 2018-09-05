import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable> {
	
	private class Node<E>{
		public E e;
		public Node left;
		public Node right;
		
		public Node(E e) {
			this.e = e;
			this.left = left;
			this.right = right;
		}
		
		public Node(E e, Node left, Node right) {
			this.e = e;
			this.left = left;
			this.right = right;
		}
		
	}
	
	private Node root;
	private int size;
	
	public BST() {
		root = null;
		size = 0;
	}
	
	public void add(E e) {
		
		root =add(root, e);
		
	}
		
	
	
	private Node add (Node root, E e) {
		if (root == null) {
			size++;
			return new Node(e);
		}
		
		if (e.compareTo(root.e) > 0) {
			root.right = add(root.right, e);
		}else {
			root.left = add(root.left, e);
		}
		
		return root;
	}
	
	public boolean contains(E e) {
		return contains(root, e);
	}
	
	private boolean contains(Node root, E e) {
		if(root == null) {
			return false;
		}
		
		if (e.compareTo(root.e) == 0) {
			return true;
		}else if(e.compareTo(root.e) > 0) {
			return contains(root.right, e);
		}else {
			return contains(root.left, e);
		}
	}
	
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node node) {
		if (node != null) {
			System.out.println(node.e);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public void preOrderNr() {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.println(cur.e);
			if (cur.right != null) {
				stack.push(cur.right);
			}else if (cur.left != null){
				stack.push(cur.left);
			}
		}
	}
	
	public void levelOrder() {
		if (root == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.println(node.e);
			if (node.right != null) {
				queue.offer(node.right);
			}else if (node.left != null) {
				queue.offer(node.left);
			}
		}
	}
	
	public void deleteNode(E e) {
		
	}
	
	private Node deleteNode(Node node, E e) {
		if (node == null) {
			return null;
		}
		
		int val = e.compareTo(node.e);
		if (val == 0) {
			if(node.left == null) {
				Node right = node.right;
				node.right = null;
				size --;
				return right;
			}else if (node.right == null){
				Node left = node.left;
				node.left = null;
				size --;
				return left;
			}else {
				Node max = findMax();
				max.left = removeMaxRecurisve(node.left);
				max.right = node.right;
				
				node.left = node.right = null;
				return max;
			}
		}else if (val> 0) {
			node.right = deleteNode(node.right, e);
			return node;
		}else {
			node.left = deleteNode(node.left, e);
			return node;
		}
	}
	
	public void removeMaxRecurisve() {
		removeMaxRecurisve(root);
	}
	
	private Node removeMaxRecurisve(Node node) {
		if (node.right == null){
			Node left = node.left;
			node.left = null;
			size --;
			return left;
		}
		
		node.right = removeMaxRecurisve(node.right);
		return node;
		
	}
	
	public Node findMax(Node node) {
		if (node.right == null) {
			return node;
		}
		return findMax(node.right);
	}
	public Node findMax() {
		if (root == null) {
			return root;
		}
		Node pointer = root;
		while (pointer.right != null) {
			pointer = pointer.right;
		}
		return pointer;
	}
	
	public Node findMin() {
		if (root == null) {
			return root;
		}
		Node pointer = root;
		while (pointer.left != null) {
			pointer = pointer.left;
		}
		return pointer;
	}
	
}
