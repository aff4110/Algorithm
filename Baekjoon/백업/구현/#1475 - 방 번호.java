import java.io.BufferedReader;
import java.io.InputStreamReader;

// 방 번호
// https://www.acmicpc.net/problem/1475

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[10];
		
		while(true) {
			int now = N % 10;
			
			if(now == 9) num[6]++;
			else num[now]++;
			
			N /= 10;
			if(N == 0) break;
		}
		num[6] = (num[6]+1)/2;
		
		int res = 0;
		for(int i=0; i<10; i++) res = Math.max(res, num[i]);
		System.out.println(res);
	}
}