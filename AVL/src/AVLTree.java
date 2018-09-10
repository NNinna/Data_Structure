import java.util.ArrayList;

public class AVLTree <E extends Comparable<E>>{

	public class Node{
		public E e;
		public int height;
		public Node left, right;

		public Node(E e, Node left, Node right) {
			this.e = e;
			this.left = left;
			this.right = right;
			this.height = 1;
		}
		public Node(E e) {
			this(e, null, null);
		}

		public Node() {
			this(null, null, null);
		}
	}

	private Node root;
	private int size;

	public AVLTree() {
		this.root = null;
		this.size = 0;
	}

	public int getBalanceFactor(Node node) {
		return getHeight(node.left) - getHeight(node.right);
	}

	public int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	public boolean isBST() {
		ArrayList<E> list = new ArrayList<>();
		inorder(root, list);

		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).compareTo(list.get(i + 1)) > 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

	private boolean isBalanced(Node node) {
		if (node == null) {
			return true;
		}

		int balanceFactor = getBalanceFactor(node);
		if (Math.abs(balanceFactor) > 1) {
			return false;
		}

		return isBalanced(node.right) && isBalanced(node.left);
	}

	//if tree doesn't have height value
	private int isBalancedTree(Node node) {
		if (node == null) {
			return 0;
		}

		int right = isBalancedTree(node.right);
		int left = isBalancedTree(node.left);


		if (right == -1 || left == -1 && Math.abs(left - right) > 1) {
			return -1;
		}

		return 1 + Math.max(right, left);
	}



	private void inorder(Node node, ArrayList<E> list) {
		if (node != null) {
			inorder (node.left, list);
			list.add(node.e);
			inorder (node.right, list);
		}
	}

	public void add(E e) {
		root = add(root, e);
	}


	public void remove(E e) {
		root = remove(root, e);
	}

	private Node remove(Node node, E e) {
		if (node == null) {
			return null;
		}
		int val = node.e.compareTo(e);
		Node resNode = null;
		if (val < 0) {
			node.right = remove(node.right,e);
			resNode = node;
		}else if (val > 0) {
			node.left = remove(node.left, e);
			resNode = node;
		}else {
			if (node.left == null) {
				resNode = node.right;
				node.right = null;
				size--;
			}else if (node.right == null){
				resNode = node.left;
				node.left = null;
				size --;
			}else {
				Node successor = findMin(node.right);
				successor.right = remove(successor.right, successor.e);
				successor.left = node.left;

				node.left = node.right = null;
				resNode = successor;
			}
		}
		
		if (resNode == null) {
			return null;
		}

		//update height
		resNode.height = 1 + Math.max(getHeight(resNode.right), getHeight(resNode.left));

		//Balance facoter
		int balanceFactor = getBalanceFactor(resNode);

		//LL
		if (balanceFactor > 1 && getBalanceFactor(resNode.left) >= 0) {
			return this.rightRotated(resNode);
		}

		//RR
		if (balanceFactor < -1 && getBalanceFactor(resNode.right) <= 0) {
			return this.leftRotate(resNode);
		}

		//LR
		if (balanceFactor > 1 && getBalanceFactor(resNode.left) < 0) {
			resNode.left = this.leftRotate(resNode.left);
			return this.rightRotated(resNode);
		}

		//RL
		if (balanceFactor < -1 && getBalanceFactor(resNode.right) > 0 ) {
			resNode.right = this.rightRotated(resNode.right);
			return this.leftRotate(resNode);
		}
		return resNode;
	}

	private Node findMin(Node node) {
		if (node.left != null) {
			return findMin(node.left);
		}
		return node;
	}


	private Node add(Node node, E e) {
		if (node == null) {
			size++;
			return new Node(e);
		}

		int val = node.e.compareTo(e);
		if (val < 0) {
			node.right = add(node.right, e);
		}else {
			node.left = add(node.left, e);
		}

		//update height
		node.height = 1 + Math.max(getHeight(node.right), getHeight(node.left));

		//Balance facoter
		int balanceFactor = getBalanceFactor(node);

		//LL
		if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
			return this.rightRotated(node);
		}

		//RR
		if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
			return this.leftRotate(node);
		}

		//LR
		if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
			node.left = this.leftRotate(node.left);
			return this.rightRotated(node);
		}

		//RL
		if (balanceFactor < -1 && getBalanceFactor(node.right) > 0 ) {
			node.right = this.rightRotated(node.right);
			return this.leftRotate(node);
		}
		return node;
	}


	//        y                              x
	//       / \                           /   \
	//      x   T4   right rotation       z     y
	//     / \       - - - - - - - ->    / \   / \
	//    z   T3                       T1  T2 T3 T4
	//   / \
	// T1   T2
	private Node rightRotated(Node node) {
		Node x = node.left;
		node.left = x.right;
		x.right = node;

		//update height
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		node.height = Math.max(getHeight(node.left), getHeight(node.left)) + 1;
		return x;
	}

	//    y                             x
	//  /  \                          /   \
	// T1   x    left rotation       y     z
	//     / \   - - - - - - - ->   / \   / \
	//   T2  z                     T1 T2 T3 T4
	//      / \
	//     T3 T4
	private Node leftRotate(Node node) {
		Node x = node.right;
		node.right = x.left;
		x.left = node;

		//update height
		x.height = Math.max(getHeight(x.right), getHeight(x.left)) + 1;
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

		return x;
	}

	public boolean contains(E e) {
		return contains(root, e);
	}

	private boolean contains(Node node, E e) {
		if (node == null) {
			return false;
		}

		int val = node.e.compareTo(e);

		if (val < 0) {
			return contains(node.right, e);
		}else {
			return contains(node.left, e);
		}
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
		AVLTree<Integer> tree = new AVLTree<>();
		tree.add(10);
		tree.add(12);
		tree.add(5);
		tree.add(9);
		tree.add(8);
		tree.add(11);
		
		tree.remove(5);

		System.out.println(tree);
		System.out.println("Is a balanced tree? " + tree.isBalanced());
		System.out.println("Is a binary search tree? " + tree.isBST());
	}

}
