import java.util.HashMap;

//leetcode 677
//Implement a MapSum class with insert, and sum methods.
/**
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5
*/
public class MapSum {
	
	private class Node{
		public int val;
		public HashMap<Character,Node> children;
		
		public Node(int val) {
			this.val = val;
			this.children = new HashMap<>();
		}
		
		public Node() {
			this(0);
		}
	}
	
	public Node root;
	
	public MapSum() {
		this.root = new Node();
	}
	
	public void insert(String s, int val) {
		Node pointer = root;
		for (char c : s.toCharArray()) {
			if (!pointer.children.containsKey(c)) {
				pointer.children.put(c, new Node());
			}
			pointer = pointer.children.get(c);
		}
		pointer.val = val;
	}
	
	public int getSum (String prefix) {
		Node pointer = root;
		
		for (char c : prefix.toCharArray()) {
			if (!pointer.children.containsKey(c)) {
				return 0;
			}
			pointer = pointer.children.get(c);
		}
		return getSum(pointer);
	}
	
	private int getSum(Node node) {
		
		int sum = node.val;
		
		for (char c : node.children.keySet()) {
			sum += getSum(node.children.get(c));
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		MapSum mapSum = new MapSum();
		
		mapSum.insert("panda",3);
		mapSum.insert("pan",2);
		mapSum.insert("start", 1);
		

		System.out.println("sum of prefix'pa' 5==" + mapSum.getSum("pa"));
		System.out.println("sum of prefix'star' 1==" + mapSum.getSum("star"));
		System.out.println("sum of prefix'ar' 0==" + mapSum.getSum("ar"));

	}
	
}
