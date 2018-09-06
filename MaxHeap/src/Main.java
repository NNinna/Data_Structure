
public class Main {

	public static void main(String[] args) {
		//MaxHeap<Integer> heap = new MaxHeap<>();
		
		Integer[] init = new Integer[]{3,30, 9, 8, 3};	
		MaxHeap<Integer> heap = new MaxHeap<Integer>(init);
		
		
//		for (int i = 10; i < 24; i += 2) {
//			heap.add(i);
//		}
		heap.add(80);
		heap.add(6);
		
		int[] arr = new int[heap.size()];
		
		System.out.println("max:" + heap.findMax());
		System.out.println("size : " + heap.size());
		System.out.println("Is heap empty? " + heap.isEmpty());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = heap.retrieveMax();
			System.out.println(arr[i]);
		}
	}
}
