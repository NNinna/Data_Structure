
public class LoopArrayQueue<E> implements Queue<E> {
	
	private E[] data;
	
	private int size;
	private int front;
	private int tail;
	
	private static final int CAPACITY_VALUE = 10;
	 
	public LoopArrayQueue() {
		data = (E[]) new Object[CAPACITY_VALUE + 1];
		front = 0;
		tail = 0;
		size = 0;
	}

	@Override
	public void offer(E e) {
		if ((tail + 1) % data.length == front) {
			resize(data.length * 2);
		}
		data[tail] = e;
		tail = (tail + 1) % (data.length);
		size++;
		
	}
	
	private void resize(int capacity) {
		E[] arr = (E[]) new Object[capacity + 1];
		int j = 0;
		int len = data.length;
		for (int i = front; i != tail; ) {
			arr[j] = data[i];
			i = (i + 1) % len;
			j++;
		}
		front = 0;
		tail = size -1;
		data = arr;
	}

	@Override
	public E poll() {
		if (size == 0) {
			throw new IllegalArgumentException("queue is empty.");
		}
		E val = data[front];
		front = (front + 1) % data.length;
		size --;
		
		if (size == data.length / 4  && data.length / 2 != 0) {
			resize(data.length / 2);
		}
		return val;
	}

	@Override
	public E peek() {
		if (size == 0) {
			throw new IllegalArgumentException("queue is empty.");
		}
		
		return data[front];
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
		StringBuilder builder = new StringBuilder();

		for (int i = front; i != tail;) {
			builder.append(data[i]);
			i = (i + 1) % data.length;
		}
		return builder.toString();
		
	}
}
