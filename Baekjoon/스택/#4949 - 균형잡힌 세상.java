import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 균형잡힌 세상
// https://www.acmicpc.net/problem/4949

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack;
		
		while(true) {
			stack = new Stack<>();
			String input = br.readLine();
			if(input.equals(".")) break;
			
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i) == '(') stack.push('(');
				if(input.charAt(i) == ')') {
					if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
					else stack.push(')');
				}
				
				if(input.charAt(i) == '[') stack.push('[');
				if(input.charAt(i) == ']') {
					if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
					else stack.push(']');
				}
			}
			
			if(stack.isEmpty()) System.out.println("yes");
			else System.out.println("no");
		}
	}
}