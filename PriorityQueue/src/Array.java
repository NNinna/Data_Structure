
public class Array<E> {
	private E[] data;
	private int size;
	private static final int CAPACITY_VALUE = 10;
	
	public Array(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}
	
	public Array() {
		this(CAPACITY_VALUE);
	}
	
	public Array(E[] arr) {
		this(arr.length);
		
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		size = arr.length;
	}
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Index is out of boundary.");
		}
		return data[index];
	}
	
	public E getFirst() {
		return get(0);
	}
	
	public void add(E e) {
		if (size == data.length) {
			resize(data.length * 2);
		}
		data[size] = e;
		size++;
	}
	
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Index is out of boundary.");
		}
		E res = data[index];
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		data[size - 1] = null;
		size --;
		if (size <= data.length / 4 && data.length / 2 > 0) {
			resize(data.length / 2);
		}
		return res;
	}
	public void set(int index, E e) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Index is out of boundary.");
		}
		data[index] = e;
	}
	public E removeLast() {
		return remove(size - 1);
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	private void resize(int capacity) {
		E[] arr = (E[]) new Object[capacity];
		for (int i = 0; i < size; i++) {
			arr[i] = data[i];
		}
		data = arr;
	}
	

	
	public void swap(int i, int j) {
		E temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
