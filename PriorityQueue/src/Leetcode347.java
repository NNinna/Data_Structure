import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode347 {
	public static void main(String[] args) {
//		//MaxHeap<Integer> heap = new MaxHeap<>();
//		
//		Integer[] init = new Integer[]{3,30, 9, 8, 3};	
//		MaxHeap<Integer> heap = new MaxHeap<Integer>(init);
//		
////		for (int i = 10; i < 24; i += 2) {
////			heap.add(i);
////		}
//		heap.add(80);
//		heap.add(6);
//		
//		int[] arr = new int[heap.size()];
//		
//		System.out.println("max:" + heap.peek());
//		System.out.println("size : " + heap.size());
//		System.out.println("Is heap empty? " + heap.isEmpty());
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = heap.poll();
//			System.out.println(arr[i]);
//		}
		
		System.out.println(new Leetcode347().solution(new int[] {1,1,1,2,2,3}, 2));
	}
	
	class Freq implements Comparable<Freq>{
		public int e;
		public int freq;
		
		public Freq(int e, int freq) {
			this.e = e;
			this.freq = freq;
		}
		
		@Override
		public int compareTo(Freq another) {
			return another.freq - this.freq;
		}
		
	}
	
	public List<Integer> solution(int[] num, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i : num) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			}else {
				map.put(i, map.get(i) + 1);
			}
		}
		
		MaxHeap<Freq> heap = new MaxHeap<>();
		for (int i : map.keySet()) {
			if (heap.size() < k) {
				heap.add(new Freq(i, map.get(i)));
			}else {
				if (heap.peek().freq < map.get(i)) {
					heap.replace(new Freq(i, map.get(i)));
				}
			}
		}
		
		List<Integer> res = new ArrayList<>();
		while (!heap.isEmpty()) {
			res.add(heap.poll().e);
		}
		return res;
	}
	
}
