import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최단경로
// https://www.acmicpc.net/problem/1753

public class Main {
	static int INF = Integer.MAX_VALUE;
	static int V, E, K;
	
	static LinkedList<Edge>[] adjList;
	static int[] distance;
	static boolean[] visit;
	
	private static class Edge implements Comparable<Edge> {
		int node, weight;
		
		Edge(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		adjList = new LinkedList[V+1];
		for(int i=1; i<=V; i++) adjList[i] = new LinkedList<>();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Edge(to, weight));
		}
		
		visit = new boolean[V+1];
		distance = new int[V+1];
		Arrays.fill(distance, INF);
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(K, 0));
		distance[K] = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(visit[now.node]) continue;
			visit[now.node] = true;
			
			for(Edge next : adjList[now.node]) {
				if(visit[next.node]) continue;
				if(distance[now.node] + next.weight < distance[next.node]) {
					distance[next.node] = distance[now.node] + next.weight;
					pq.add(new Edge(next.node, distance[next.node]));
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(distance[i] == INF) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
}