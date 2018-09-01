
public class Main {
	
	public static void main(String[] args) {
		Stack<String> stack = new DynamicArrayStack<>();
		
		for (int i = 0; i < 11; i++) {
			stack.push(String.valueOf(i));
		}
		
		stack.push("1");
		System.out.println(stack.peek());
		
		stack.push("2");
		System.out.println(stack.pop());
		
		System.out.println("Is empty? " + stack.isEmpty() );
		System.out.println("size = " + stack.size());
		
		System.out.println(stack);
	}
	
}
