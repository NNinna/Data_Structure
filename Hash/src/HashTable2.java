import java.util.TreeMap;

public class HashTable2<K,V> {
	
	 private final int[] capacity
     = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
     49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
     12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};
	
	
	private TreeMap<K,V>[] hashTable;
	private int size;
	private int M; // capacity
	private int capacityIndex = 0;
	
	private static final int TopLor = 10;
	private static final int LowLor = 2;

	
	public HashTable2() {
		this.M = capacity[capacityIndex];
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
			if (size >=  TopLor * M && capacityIndex + 1 < capacity.length) {
				capacityIndex ++;
				resize(capacity[capacityIndex]);
			}
		}
	}
	
	public V remove(K key) {
		TreeMap<K,V> map =  hashTable[hash(key)];
		V res = null;
		if (map.containsKey(key)) {
			res = map.remove(key);
			size--;
			if (size <  LowLor * M && capacityIndex - 1 >= 0) {
				capacityIndex--;
				resize(capacity[capacityIndex]);
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
			throw new IllegalArgumentException("wh");
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

