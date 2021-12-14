import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호
// https://www.acmicpc.net/problem/9012

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Stack<Character> stack;
		
		for(int tc=0; tc<T; tc++) {
			stack = new Stack<>();
			String input = br.readLine();
			
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i) == '(') stack.push('(');
				else {
					if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
					else stack.push(')');
				}
			}
			
			if(stack.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}