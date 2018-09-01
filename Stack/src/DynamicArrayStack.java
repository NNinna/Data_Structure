
/**
 * Use array to implement stack.
 * @author Nina
 *
 * @param <E>
 */
public class DynamicArrayStack<E> implements Stack<E> {
	
	private E[] data;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;
	
	public DynamicArrayStack() {
		data = (E[]) new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	@Override
	public E pop() {
		size --;
		E value = data[size];
		data[size] = null;
		
		if (size == data.length / 4 && data.length / 2 != 0) {
			resize(data.length / 2);
		}
		return value;
	}

	@Override
	public E peek() {
		return data[size - 1];
	}

	@Override
	public void push(E e) {
		if (size == data.length) {
			resize(data.length * 2);
		}
		data[size] = e;
		size ++;
	}
	
	private void resize(int capacity) {
		E[] arr = (E[]) new Object[capacity];
		for (int i = 0; i < size; i++) {
			arr[i] = data[i];
		}
		data = arr;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < size; i++) {
			builder.append(data[i]);
			builder.append(" ");
		}
		return builder.toString();
	}
	
}
