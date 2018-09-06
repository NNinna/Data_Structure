
public interface Map <K,V>{
	void set(K key, V value);
	void put(K key, V value);
	V get(K key);
	V remove(K key);
	boolean contains(K key);
	boolean isEmpty();
	int size();
	
}
