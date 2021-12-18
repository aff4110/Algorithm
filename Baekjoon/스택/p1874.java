import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 스택 수열
// https://www.acmicpc.net/problem/1874

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int now = 1;
		out: for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			while(true) {
				if(!stack.isEmpty() && stack.peek() == input) break;
				if(now > N) break out;
				
				stack.push(now++);
				sb.append("+").append("\n");
			}
			stack.pop();
			sb.append("-").append("\n");
		}
		
		if(stack.isEmpty()) System.out.println(sb);
		else System.out.println("NO");
	}
}