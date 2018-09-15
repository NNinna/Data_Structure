
public class Main {
	public static void main(String[] args) {
		
		HashTable2<Integer,Student> hashmap = new HashTable2<>();
	
		for (int i = 0; i < 60; i ++) {
			hashmap.add(i, new Student(i,"nina" + i));
		}
		
		System.out.println("current map:");
		for (int i = 0; i < 60; i++) {
			System.out.println(hashmap.get(i));
		}
		
		System.out.println("\nremoving");
		for (int i = 0; i < 40; i+=2) {
			System.out.println(hashmap.remove(i));
		}
		
		System.out.println("if contains 51? " + hashmap.contains(51));
		System.out.println("if contains 52? " + hashmap.contains(22));


	}
}
