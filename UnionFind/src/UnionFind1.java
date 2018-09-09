//union -> O(n)
//find -> O(1)
public class UnionFind1 implements UF {
	private int[] id;

	public UnionFind1(int capacity) {
		id = new int[capacity];

		//initialization
		for (int i = 0; i < id.length; i ++) {
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
		
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pa) {
				id[i] = pb;
			}
		}
	}
	
	public int find(int index) {
		if (index < 0 || index >= id.length) {
			throw new IllegalArgumentException("out of boundary");
		}
		
		return id[index];
	}
}
