import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 제로
// https://www.acmicpc.net/problem/10773

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input == 0) stack.pop();
			else stack.push(input);
		}
		
		int sum = 0;
		for(int val : stack) sum += val;
		System.out.println(sum);
	}
}