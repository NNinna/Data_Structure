
public class SegmentTree <E> {
	private E[] data;
	private E[] tree;
	
	private Merger<E> merger;
	
	public SegmentTree(E[] data, Merger<E> merger) {
		this.data = (E[]) new Object[data.length];
		this.merger = merger;
		for (int i = 0; i < data.length; i++) {
			this.data[i] = data[i];
		}

		tree = (E[]) new Object[4 * data.length];
		buildTree(0, 0, data.length - 1);
 	}
	
	public void buildTree(int index, int l, int r) {
		if (r == l) {
			tree[index] = data[l];
			return;
		}
		int mid = l + (r - l) / 2;
		int leftChild = getLeftChild(index);
		int rightChild = getRightChild(index);
		
		buildTree(leftChild, l, mid );
		buildTree(rightChild,mid + 1, r);
		tree[index] = merger.merge(tree[leftChild], tree[rightChild]);
		
	}
	
	public void update(int index, E e) {
		if (index < 0 || index >= data.length) {
			throw new IllegalArgumentException("out of boundary");
		}
		data[index] = e;
		update(0, 0, data.length - 1, index, e);
	}
	
	private void update(int index, int l, int r, int i, E e) {
		if (l == r) {
			tree[index] = e;
			return;
		}
		int mid = l + (r - l) / 2;
		if (i <= mid) {
			update (getLeftChild(index), l, mid,i, e);
		}else {
			update (getRightChild(index), mid + 1, r, i,e);
		}
		
		tree[index] = merger.merge(tree[this.getLeftChild(index)], tree[getRightChild(index)]);
		
	}
	
	public E query(int queryL, int queryR){
	        if(queryL < 0 || queryL >= data.length ||
	                queryR < 0 || queryR >= data.length || queryL > queryR)
	            throw new IllegalArgumentException("Index is illegal.");

	        return query(0, 0, data.length - 1, queryL, queryR);
	    }
	
	private  E query(int index, int l, int r , int queryL, int queryR) {
		if (l == queryL && r == queryR) {
			return tree[index];
		}
		
		int mid = l + (r - l) / 2;
		if (queryL > mid) {
			return query(this.getRightChild(index), mid + 1, r, queryL, queryR);
		}else if (queryR <= mid) {
			return query(this.getLeftChild(index), l, mid, queryL, queryR);
		}else {
			return merger.merge(query(this.getLeftChild(index), l, mid,queryL, mid),
					query(this.getRightChild(index), mid + 1, r, mid + 1, queryR));
		}
 	}
	
	public int size() {
		return data.length;
	}
	
	private int getLeftChild(int index) {
		return index * 2 + 1;
	}
	
	private int getRightChild(int index) {
		return index * 2 + 2;
	}
}
