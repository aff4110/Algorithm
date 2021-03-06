import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 프린터 큐
// https://www.acmicpc.net/problem/1966

public class Main {
	private static class Page {
		int priority, number;
		
		Page(int p, int n) {
			this.priority = p;
			this.number = n;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	// 문서의 개수 N
			int M = Integer.parseInt(st.nextToken());	// 조회할 문서 M
			
			int[] remain = new int[10];
			Queue<Page> printer = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int num = Integer.parseInt(st.nextToken());
				printer.add(new Page(num, i));
				remain[num]++;
			}
			
			int res = 0;
			out:for(int i=9; i>0; i--) {
				while(true) {
					if(remain[i] == 0) break;
					
					Page now = printer.poll();
					if(now.priority == i) {
						res++;
						remain[i]--;
						if(now.number == M) break out;
					}
					printer.add(now);
				}
			}
			System.out.println(res);
		}
	}
}