//union -> O(h) find its parent then change it parent to another one's parent
//find -> O(h) 
public class UnionFind2 implements UF {
	private int[] id;
	
	public UnionFind2 (int capacity) {
		id = new int[capacity];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	@Override
	public boolean isConnected(int a, int b) {
		return find(a) == find(b);
	}

	@Override
	public void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if (pa == pb) {
			return;
		}
		
		id[a] = pb;
		
	}
	
	public int find (int index) {
		if (index < 0 || index >= id.length) {
			throw new IllegalArgumentException("out of boundray");
		}
		
		//continue finding its parent id
		//until id[i] == i means no more parent node
		while (index != id[index]) {
			index = id[index];
		}
		return index;
	}
}
