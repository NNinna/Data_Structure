//path compression [recursive]
public class UnionFind6 implements UF{
	private int[] id;


	public UnionFind6(int size) {
		this.id = new int[size];

		for (int i = 0; i < size; i++) {
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

	public int find(int index) {
		if (index < 0 || index >= id.length) {
			throw new IllegalArgumentException("index is out of boundary");
		}

		if (index != id[index]) {
			id[index] = find(id[index]);
		}

		return id[index];
	}


}
