
public class Main {
	public static void main(String[] args){
		//Queue<Integer> queue = new ArrayQueue();
		Queue<Integer> queue = new LoopArrayQueue();
		
		for (int i = 0; i < 11; i++) {
			queue.offer(i);
		}
		
		System.out.println("queue : " + queue);
		
		System.out.println("dequeue : " + queue.poll());
		
		System.out.println("queue : " + queue);
		
		System.out.println("peek : " + queue.peek());
		
		queue.offer(10);
		queue.offer(11);
		System.out.println("queue : " + queue);
		
		for (int i = 0; i < 10; i++) {
			System.out.println("poll :" + queue.poll());
		}
		System.out.println("queue : " + queue);
	}
}
