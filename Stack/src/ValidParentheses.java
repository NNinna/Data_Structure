import java.util.Stack;

public class ValidParentheses {
	public boolean Solution(String s){
		Stack<Character> stack = new Stack();
		
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			}else {
				if (stack.isEmpty()) {
					return false;
				}
				if (c == ')' && stack.pop() != '(') {
					return false;
				}else if (c == ']' && stack.pop() != '[') {
					return false;
				}else if (c == '}' && stack.pop() != '{') {
					return false;
				}
			}
		}
		return stack.isEmpty();
		
	}
	
	public static void main(String[] args) {
		System.out.println(new ValidParentheses().Solution("([]{})"));
		System.out.println(new ValidParentheses().Solution("{}(["));
	}
}
