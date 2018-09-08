import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode {


	public List<Integer> solution(int[] num, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : num) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			}else {
				map.put(i, map.get(i) + 1);
			}
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o1) - map.get(o2);
			}

		}

				);

		for (int i : map.keySet()) {
			if (queue.size() < k) {
				queue.offer(i);
			}else {
				if (map.get(queue.peek()) < map.get(i)) {
					queue.poll();
					queue.offer(i);
				}
			}

		}

		List<Integer> res = new ArrayList<>();
		while (!queue.isEmpty()) {
			res.add(queue.poll());
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Leetcode().solution(new int[] {1,1,1,2,2,3}, 2));

	}
}
