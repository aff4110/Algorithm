import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 오큰수
// https://www.acmicpc.net/problem/17298

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] nge = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

		Stack<Integer> stack = new Stack<>();
		for(int i=N-1; i>=0; i--) {
			while(true) {
				if(stack.isEmpty()) break;
				if(stack.peek() > arr[i]) break;
				stack.pop();
			}
			
			if(stack.isEmpty()) nge[i] = -1;
			else nge[i] = stack.peek();
			
			stack.push(arr[i]);
		}

		for(int i=0; i<N; i++) sb.append(nge[i] + " ");
		System.out.println(sb);
	}
}