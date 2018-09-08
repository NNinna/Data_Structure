
public class PriorityQueue <E extends Comparable<E>>{
	private MaxHeap<E> heap;
	
	public PriorityQueue() {
		heap = new MaxHeap();
	}
	
	public void offer(E e) {
		heap.add(e);
	}
	
	public E poll() {
		return heap.poll();
	}
	
	public E peek() {
		return heap.peek();
	}
	
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	public int size() {
		return heap.size();
	}
}
