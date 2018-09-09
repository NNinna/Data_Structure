//optimize by size
public class UnionFind3 implements UF {
	private int[] id;
	private int[] size;
	
	public UnionFind3(int size){
		this.id = new int[size];
		this.size = new int[size];

		//initialization
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
			this.size[i] = 1;
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
		
		if (size[a] < size[b]) {
			id[a] = pb;
			size[b] += size[a];
		}else  {
			id[b] = pa;
			size[a] += size[b];
 		}
		
	}
	
	public int find(int index) {
		if (index < 0 || index >= id.length) {
			throw new IllegalArgumentException("index is out of boundary");
		}
		
		while (index != id[index]) {
			index = id[index];
		}
		return index;
	}
	
}
