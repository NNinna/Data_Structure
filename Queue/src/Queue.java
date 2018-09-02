
public interface Queue <E>{
	
	public void offer(E e);
	public E poll();
	public E peek();
	public boolean isEmpty();
	public int size();
	
}
