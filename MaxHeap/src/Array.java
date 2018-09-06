
public class Array <E>{
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
		data = (E[]) new Object[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		size = data.length;
	}
	
	public void set(int index, E e) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("index is out of boundary");
		}
		data[index] = e;
	}
	
	public void add (E e) {
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
	
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("remove failed! index is out of boundary");
		}
		E res = data[index];
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		data[size - 1] = null;
		size --;
		
		if (size <= data.length / 4 && data.length / 2 != 0) {
			resize(data.length / 2);
		}
		return res;
	}
	
	public void swap (int i, int j) {
		E e = data[i];
		data[i] = data[j];
		data[j] = e;
	}
	
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("out of boundary");
		}
		return data[index];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}
