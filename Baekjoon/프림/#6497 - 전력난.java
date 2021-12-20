import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 전력난
// https://www.acmicpc.net/problem/6497

public class p1916 {
	static int M, N, res;
	static LinkedList<Node>[] adjList;
	static boolean[] visit;
	
	private static class Node implements Comparable<Node> {
		int vertex, weight;
		
		Node(int v, int w) {
			this.vertex = v;
			this.weight = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			res = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			if(M+N == 0) break;
			
			visit = new boolean[M];
			adjList = new LinkedList[M];
			for(int i=0; i<M; i++) adjList[i] = new LinkedList<>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				adjList[from].add(new Node(to, weight));
				adjList[to].add(new Node(from, weight));
				res += weight;
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0));
			
			while(!pq.isEmpty()) {
				Node now = pq.poll();
				
				if(visit[now.vertex]) continue;
				visit[now.vertex] = true;
				res -= now.weight;
				
				for(Node next : adjList[now.vertex]) {
					if(visit[next.vertex]) continue;
					pq.add(next);
				}
			}
			
			System.out.println(res);
		}
	}
}