import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연산자 끼워넣기
// https://www.acmicpc.net/problem/14888

public class Main {
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] arr, sel;
	static int[] arith = new int[4];
	
	private static void work(int cnt) {
		if(cnt == N-1) {
			int res = arr[0];
			for(int i=1; i<N; i++) {
				switch(sel[i-1]) {
					case 0: res += arr[i]; break;
					case 1: res -= arr[i]; break;
					case 2: res *= arr[i]; break;
					case 3: res /= arr[i]; break;
				}
			}
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(arith[i] == 0) continue;
			sel[cnt] = i;
			arith[i]--;
			
			work(cnt+1);
			
			arith[i]++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];	// 주어진 배열 담기
		sel = new int[N-1];	// 연산자 순열 담는 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) arith[i] = Integer.parseInt(st.nextToken());
		
		work(0);
		
		System.out.println(max);
		System.out.println(min);
	}
}