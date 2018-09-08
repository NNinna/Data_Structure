
public class Main {
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {3,4,2,5,3,9,0};
		
		SegmentTree<Integer> tree = new SegmentTree<>(arr, new Merger<Integer> (){

			@Override
			public Integer merge(Integer a, Integer b) {

				return a + b;
			}
			
		});
		
		System.out.println("0-1 :" + tree.query(0, 1));
		tree.update(1, 9);
		System.out.println("0-1 :" + tree.query(0, 1));
		
	}
}
