
public class ArrayQueue<E> implements Queue<E>{
	
	private static final int CAPACITY_VALUE = 10;
	
	private E[] data;
	private int size = 0; 
 	
	public ArrayQueue() {
		data = (E[]) new Object[CAPACITY_VALUE];
	}
	
	@Override
	public void offer(E e) {
		if (size == data.length) {
			resize(data.length * 2);
		}
		data[size] = e;
		size++;

	}
	
	private void resize(int capacity) {
		E[] arr = (E[]) new Object[capacity];
		for (int i = 0; i < size; i++) {
			arr[i] = data[i];
		}
		data = arr;
	}

	@Override
	public E poll() {
		if (size == 0) {
			throw new IllegalArgumentException("Queue is empty.");
		}
		E val = data[0];
		for (int i = 0; i < size -1; i++) {
			data[i] = data[i + 1];
		}
		size--;
		
		if (size == data.length / 4 && data.length / 2 != 0) {
			resize(data.length / 2);
		}
		return val;
	}

	@Override
	public E peek() {
		if (size == 0) {
			throw new IllegalArgumentException("Array is empty");
		}
		return data[0];
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		if (size == 0) {
			throw new IllegalArgumentException("Queue is empty.");
		}
		StringBuilder builder = new StringBuilder ();
		for (int i = 0 ; i < size; i++) {
			builder.append(data[i].toString());
		}
		return builder.toString();
	}
	
}
