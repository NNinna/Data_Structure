
public class MaxHeap <E extends Comparable<E>> {
	private Array<E> arr;
	
	public MaxHeap() {
		arr = new Array<>();
	}
	
	
	public MaxHeap(E[] data) {
		arr = new Array(data);
		for (int i = getParent(arr.size() - 1); i >= 0; i--) {
			siftdown(i);
		}
	}
	
	public int size() {
		return arr.size();
	}
	
	public boolean isEmpty() {
		return arr.isEmpty();
	}
	
	public void add(E e) {
		arr.add(e);
		siftUp(arr.size() - 1);
	}
	
	public E peek() {
		return arr.getFirst();
	}
	
	public E poll() {
		E res = arr.getFirst();
		arr.swap(0, arr.size() - 1);
		arr.removeLast();
		siftdown(0);
		return res;
	}
	
	public void replace(E e) {
		arr.set(0, e);
		siftdown(0);
	}
	
	private void siftdown(int index) {
		
		while (getLeftChild(index) < arr.size()) {
			int maxIndex = getLeftChild(index);
			if (maxIndex + 1 < arr.size() && arr.get(maxIndex + 1).compareTo(arr.get(maxIndex)) > 0) {
				maxIndex = maxIndex + 1;
			}
			
			if (arr.get(maxIndex).compareTo(arr.get(index)) > 0) {
				arr.swap(maxIndex, index);
				index = maxIndex;
			}else {
				break;
			}
		}
	}
	
	private void siftUp(int index) {
		
		while (index > 0 && arr.get(index).compareTo(arr.get(getParent(index))) > 0) {
			int parent = getParent(index);
			arr.swap(index, parent);
			index = parent;
		}

	}
	
	private int getLeftChild(int index) {
		return 2 * index + 1;
	}
	
	private int getRightChild(int index) {
		return 2 * index + 2;
	}
	
	private int getParent(int index) {
		if (index == 0) {
			throw new IllegalArgumentException("It is the root.");
		}
		return (index - 1) / 2;
	}
	
	
}
