import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 집합의 표현
// https://www.acmicpc.net/problem/1717

public class Main {
	static int N, M;
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for(int i=0; i<=N; i++) parent[i] = i;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int val = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(val == 0) union(a, b);
			if(val == 1) {
				if(find(a) == find(b)) sb.append("YES\n");
				else sb.append("NO\n");
			}
		}
		System.out.println(sb);
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
