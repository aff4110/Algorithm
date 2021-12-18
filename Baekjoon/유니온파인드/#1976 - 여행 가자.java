import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 여행 가자
// https://www.acmicpc.net/problem/1976

public class Main {
	static int N, M;
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N];
		for(int i=0; i<N; i++) parent[i] = i;
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 0) continue;
				
				union(i, j);
			}
		}
		
		boolean flag = true;
		st = new StringTokenizer(br.readLine());
		int start = find(Integer.parseInt(st.nextToken())-1);
		for(int i=1; i<M; i++) {
			int num = Integer.parseInt(st.nextToken())-1;
			if(start != find(num)) {
				flag = false; break;
			}
		}
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
	
	private static int find(int num) {
		if(parent[num] == num) return num;
		else return parent[num] = find(parent[num]);
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) parent[b] = a;
	}
}