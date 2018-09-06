
public class Main {
	public static void main(String[] args) {
		Map<String, Integer> map = new BSTMap<>();

		for (int i = 0; i < 30; i += 3) {
			map.put(String.valueOf(i), i);
		}
		System.out.println(map);
		
		for (int i = 9; i < 16; i += 3) {
			map.remove(String.valueOf(i));
		}
		System.out.println(map);
		
		System.out.println("Key 3: " + map.get("3"));
		System.out.println("size : " + map.size());
		System.out.println("isEmpty? " + map.isEmpty());
		System.out.println("contains key 3? " + map.contains("3") );
		System.out.println("contains key 8? " + map.contains("8") );
	}
}
