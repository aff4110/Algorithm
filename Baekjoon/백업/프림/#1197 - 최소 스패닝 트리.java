package 단계별로풀어보기.최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소 스패닝 트리 (프림)
// https://www.acmicpc.net/problem/1197

public class p1197_2 {
	static int V, E, res;
	static boolean[] visit;
	static LinkedList<Edge>[] adjList;
	
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
		
		visit = new boolean[V+1];
		adjList = new LinkedList[V+1];
		for(int i=1; i<=V; i++) adjList[i] = new LinkedList<>();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Edge(to, weight));
			adjList[to].add(new Edge(from, weight));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(visit[now.node]) continue;
			visit[now.node] = true;
			res += now.weight;
			
			for(Edge next : adjList[now.node]) {
				if(visit[next.node]) continue;
				pq.add(next);
			}
		}
		System.out.println(res);
	}
}