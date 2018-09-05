
public class Main {

	public static void main(String[] args) {
		Set<Integer> set1 = new LinkedListSet<>();
		Set<Integer> set2 = new BSTSet<>();
		
		for (int i = 0; i < 10; i += 2) {
			set1.add(i);
			set2.add(i);
		}

		for (int i = 0; i < 5; i += 2) {
			set1.remove(i);
			set2.remove(i);
		}
		
		for (int i = 11; i < 16; i += 2) {
			set1.remove(i);
			set2.remove(i);
		}

		
		
		System.out.println("linkedlistset: "+ set1);
		System.out.println("BSTset : \n" + set2);
		
		
	}
}
