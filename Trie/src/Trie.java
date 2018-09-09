import java.util.HashMap;

public class Trie {
	private class Node{
		public boolean isWord;
		public HashMap<Character, Node> children;
		
		public Node(boolean isWord){
            this.isWord = isWord;
            this.children = new HashMap<>();
        }
		
		public Node(){
			this(false);
		}

	}
	
	private Node root;
	private int size; //num of words
	
	public Trie() {
		root = new Node();
		size = 0;
	}
	
	public void add(String word) {
		Node pointer = root;
		for (char c : word.toCharArray()) {
			if (!pointer.children.containsKey(c)) {
				pointer.children.put(c, new Node());
			}
			pointer = pointer.children.get(c);
		}
		
		//!!! must check this condition
		if (!pointer.isWord) {
			pointer.isWord = true;
			size ++;
		}
	}
	
	public boolean search(String word) {
		Node pointer = root;
		for (int i = 0; i < word.length(); i++) {
			if (pointer.children.containsKey(word.charAt(i))) {
				pointer = pointer.children.get(word.charAt(i));
			}else {
				return false;
			}
		}
		
		return pointer.isWord;
	}
	
	public int size() {
		return size;
	}
	
	//leetcode211 
	// search a literal word or a regular expression string containing 
	//only letters a-z or .. A .
	public boolean matchPattern(String pattern) {
		return matchPattern(root, pattern, 0);
	}
	
	private boolean matchPattern(Node node, String pattern, int index) {
		if (index == pattern.length()) {
			return node.isWord;
		}
		char c = pattern.charAt(index);
		if (c != '.') {
			if (!node.children.containsKey(c)) {
				return false;
			}
			return matchPattern(node.children.get(c), pattern, index + 1);
		}else {
			for (char val : node.children.keySet()) {
				if (matchPattern(node.children.get(val), pattern, index + 1)) {
					return true;
				}
			}
			return false;
		}
		
	}
	
	//check if there is a word start with specific prefix
	public boolean findPrefix(String prefix) {
		Node pointer = root;
		for (char c : prefix.toCharArray()) {
			if (!pointer.children.containsKey(c)) {
				return false;
			}
			pointer = pointer.children.get(c);
		}
		return true;
	}
	

	
	public static void main(String[] args) {
		
		Trie trie = new Trie();
		
		trie.add("panda");
		trie.add("pan");
		trie.add("start");
		
		System.out.println("how many word is there ? " + trie.size);
		
		System.out.println("does it match pattern '.an'? " + trie.matchPattern(".an"));
		System.out.println("does it match pattern 'pan.'? " + trie.matchPattern("pan."));

		System.out.println("is there pan ? " + trie.search("pan"));
		System.out.println("is there pa ? " + trie.search("pa"));
		System.out.println("is there e? " + trie.search("e"));
		System.out.println("is there strt? " + trie.search("strt"));

	}
	
	
}
