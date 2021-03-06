import java.io.BufferedReader;
import java.io.InputStreamReader;

// 스택
// https://www.acmicpc.net/problem/10828

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] stack = new int[N];
		int idx = 0;
		
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			
			switch(input[0]) {
			case "push":
				stack[idx++] = Integer.parseInt(input[1]);
				break;
			case "pop":
				if(idx == 0) sb.append("-1\n");
				else sb.append(stack[--idx]).append("\n");
				break;
			case "size":
				sb.append(idx).append("\n");
				break;
			case "empty":
				if(idx == 0) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "top":
				if(idx == 0) sb.append("-1\n");
				else sb.append(stack[idx-1]).append("\n");
				break;
			}
		}
		
		System.out.println(sb);
	}
}