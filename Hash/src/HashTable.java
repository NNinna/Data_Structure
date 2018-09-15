import java.util.TreeMap;

public class HashTable<K,V> {
	
	private TreeMap<K,V>[] hashTable;
	private int size;
	private int M; // capacity
	
	private static final int TopLor = 10;
	private static final int LowLor = 2;
	
	public HashTable(int M) {
		this.M = M;
		hashTable = new TreeMap[M];
		for (int i = 0; i < M; i++) {
			hashTable[i] = new TreeMap<>();
		}
		this.size = 0;
	}
	
	public int hash(K key) {
		return (key.hashCode() & 0x7ffffff) % M;
	}
	
	public int getSize() {
		return size;
	}
	
	public void add(K key, V value) {
		TreeMap<K,V> map = hashTable[hash(key)];
		if (map.containsKey(key)) {
			map.put(key, value);
		}else {
			map.put(key, value);
			size++;
			if (size >=  TopLor * M) {
				resize(this.M * 2);
			}
		}
	}
	
	public V remove(K key) {
		TreeMap<K,V> map =  hashTable[hash(key)];
		V res = null;
		if (map.containsKey(key)) {
			res = map.remove(key);
			size--;
			if (size <  LowLor * M && this.M / 2 > 0) {
				resize(M / 2);
			}
		}
		return res;
	}
	
	public void set(K key, V value) {
		TreeMap<K,V> map = hashTable[hash(key)];
		if (!map.containsKey(key)) {
			throw new IllegalArgumentException("wh");
		}
		map.put(key, value);
	}
	
	public boolean contains(K key) {
		TreeMap<K,V> map = hashTable[hash(key)];
		return map.containsKey(key);
	}
	
	public V get(K key) {
		TreeMap<K,V> map = hashTable[hash(key)];
		if (!map.containsKey(key)) {
			throw new IllegalArgumentException("can't find key");
		}
		return map.get(key);
	}
	
	private void resize(int capacity) {
		TreeMap<K,V>[] table = new TreeMap[capacity];
		for (int i = 0; i < table.length; i++) {
			table[i] = new TreeMap<K,V>();
		}
		this.M = capacity;
		for (int i = 0; i < hashTable.length; i++) {
			TreeMap<K,V> map = hashTable[i];

			for (K k : map.keySet()) {
				table[hash(k)].put(k,map.get(k));
			}
		}
		this.hashTable = table;
	}
}
