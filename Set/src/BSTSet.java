
public class BSTSet<E extends Comparable<E>> implements Set<E>{

	private BST<E> bst;
	public BSTSet() {
		bst = new BST<>();
	
	}
	@Override
	public void add(E e) {
		bst.add(e);
	}

	@Override
	public boolean contains(E e) {
		return bst.contains(e);
	}

	@Override
	public void remove(E e) {
		bst.remove(e);
	}

	@Override
	public boolean isEmpty() {
		return bst.isEmpty();
	}

	@Override
	public int size() {
		return bst.size();
	}
	
	@Override
	public String toString() {
		return bst.toString();
	}

}
