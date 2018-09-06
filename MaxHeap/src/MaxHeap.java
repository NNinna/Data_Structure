
public class MaxHeap <E extends Comparable<E>>{
	
	private Array<E> list;
	
	public MaxHeap() {
		list = new Array<>();
	}
	
	public MaxHeap (int capacity) {
		list = new Array<>(capacity);
	}
	
	public MaxHeap(E[] arr) {
		list = new Array<E>(arr);
		for (int i = this.getParent(list.size() - 1); i >= 0; i--) {
			this.siftDown(i);
		}
	}
	
	public void replace(E e) {
		if (list.isEmpty()) {
			throw new IllegalArgumentException("heap is empty");
		}
		list.set(0, e);
		this.siftDown(0);
	}
	
	public void add(E e) {
		list.add(e);
		siftUp(list.size() - 1);
	}
	
	private void siftUp(int index) {
		
		while (index > 0 &&
				list.get(this.getParent(index)).compareTo(list.get(index)) < 0) {
			list.swap(index, this.getParent(index));
			index = this.getParent(index);
		}
	}
	
	private int getParent(int index) {
		if (index == 0) {
			throw new IllegalArgumentException("doesn't have parent");
		}
		return (index - 1) / 2;
	}
	
	public E findMax() {
		if (list.isEmpty()) {
			throw new IllegalArgumentException("heap is empty");
		}
		return list.get(0);
	}
	
	public E retrieveMax() {
		E res = list.get(0);
		list.swap(0, list.size() - 1);
		list.remove(list.size() - 1);
		siftDown(0);
		return res;
	}
	
	private void siftDown(int index) {
		
		while (getLeftChild(index) < list.size()) {
			int max = getLeftChild(index);
			
			if (max + 1 < list.size()
					&& list.get(max + 1).compareTo(list.get(max)) > 0) {
				max = max + 1;
			}
			
			if (list.get(max).compareTo(list.get(index)) > 0) {
				list.swap(max, index);
				index = max;
			}else {
				break;
			}
		}
	}
	
	private int getLeftChild(int index) {
		return index * 2 + 1;
	}
	
	private int getRightChild(int index) {
		return index * 2 + 2;
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int size() {
		return list.size();
	}
}
