//optimized by rank
public class UnionFind4 implements UF{
	private int[] id;
	private int[] rank;
	public UnionFind4(int size) {
		this.id = new int[size];
		this.rank = new int[size];
		
		for (int i = 0; i < size; i ++) {
			id[i] = i;
			rank[i] = 1;
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
		
		if (rank[a] < rank[b]) {
			id[a] = pb;
		}else if (rank[b] < rank[a]) {
			id[b] = pa;
		}else {
			id[b] = pa;
			rank[a] += 1;
		}
				
		
	}
	
	public int find(int index) {
		if (index < 0 || index >= id.length) {
			throw new IllegalArgumentException("Index is out of boundary");
		}
		while (index != id[index]) {
			index = id[index];
		}
		
		return index;
	}
}
