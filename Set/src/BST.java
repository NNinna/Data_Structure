
public class BST <E extends Comparable<E>>{

	private class Node{
		public E e;
		public Node right, left;

		public Node(E e) {
			this.e = e;
			this.right = this.left = null;
		}

		public Node(E e, Node left, Node right) {
			this.e = e ;
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
		root = add(root, e);
	}

	private Node add(Node node, E e) {
		if (node == null) {
			size++;
			return new Node(e);
		}
		int res = e.compareTo(node.e);

		if (res < 0) {
			node.left = add(node.left, e);
		}else {
			node.right = add(node.right, e);
		}

		return node;
	}

	public boolean contains(E e) {
		return contains(root, e);
	}

	private boolean contains(Node node, E e) {
		if(node == null) {
			return false;
		}
		int res = e.compareTo(node.e);

		if (res > 0) {
			return contains (node.right, e);
		}else {
			return contains (node.left, e);
		}
	}

	public void remove(E e) {
		root = remove(root, e);
	} 

	public Node remove(Node node, E e) {
		if (node == null) {
			return null;
		}

		int res = e.compareTo(node.e);
		if (res > 0) {
			node.right = remove(node.right, e);
			return node;
		}else if (res < 0){
			node.left = remove(node.left, e);
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
			}
			
			Node sucessor = this.findMin(node.right);
			sucessor.right = this.removeMin(node.right);
			sucessor.left = node.left;

			node.left = node.right = null;
			return sucessor;
		}
	}

	//precondition : size > 0
	private Node findMin(Node node) {
		if (node.left == null) {
			return node;
		}
		return findMin(node.left);
	}

	private Node removeMin(Node node) {
		if (node.left == null) {
			Node right = node.right;
			node.right = null;
			size -- ;
			return right;
		}

		node.left = removeMin(node.left);
		return node;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override 
	public String toString() {
		StringBuilder builder = new StringBuilder();
		this.generateString(builder, 0, root);
		return builder.toString();
	}
	
	public void generateString(StringBuilder builder,int depth, Node node) {
		if (node == null) {
			return;
		}
		builder.append(generateDepth(depth)+ node.e + "\n");
		generateString(builder, depth + 1, node.left);
		generateString(builder, depth + 1, node.right);
	}
	
	public String generateDepth(int depth) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			builder.append("-");
		}
		return builder.toString();
	}
	
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		bst.add(10);
		bst.add(12);
		bst.add(5);
		bst.add(9);
		bst.add(8);		

		bst.remove(8);
		System.out.println(bst);
	}
}
