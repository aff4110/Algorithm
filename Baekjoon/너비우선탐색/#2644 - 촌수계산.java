import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 촌수계산
// https://www.acmicpc.net/problem/2644

public class Main {
	static int N, A, B;
	static int[] count;
	static LinkedList<Integer>[] adjList;
	
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(A);
		count[A] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : adjList[now]) {
				if(count[next] != -1) continue;
				q.add(next);
				count[next] = count[now] + 1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		adjList = new LinkedList[N+1];
		for(int i=1; i<=N; i++) adjList[i] = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		count = new int[N+1];
		Arrays.fill(count, -1);
		
		bfs();
		
		System.out.println(count[B]);
	}
}