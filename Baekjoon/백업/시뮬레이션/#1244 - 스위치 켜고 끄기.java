import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스위치 켜고 끄기
// https://www.acmicpc.net/problem/1244

public class Main {
	static int N, student;
	static int[] arr;
	
	private static void turnSwitch(int idx) {
		arr[idx] = arr[idx] == 0 ? 1 : 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		student = Integer.parseInt(br.readLine());
		
		for(int i=0; i<student; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				for(int j=b; j<=N; j+=b) turnSwitch(j-1);
			}
			else if(a == 2) {
				turnSwitch(b-1);
				
				int left = b-2, right = b;
				while(true) {
					if(left < 0 || right >=N || arr[left] != arr[right]) break;
					turnSwitch(left); turnSwitch(right);
					left--; right++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			if(i!=0 && i%20 == 0) System.out.println();
			System.out.print(arr[i] + " ");
		}
	}
}