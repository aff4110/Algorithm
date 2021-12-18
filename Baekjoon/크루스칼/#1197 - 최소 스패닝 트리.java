import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소 스패닝 트리 (크루스칼)
// https://www.acmicpc.net/problem/1197

public class Main {
	static int V, E, res;
	static int[] parent;
	
	private static class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
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
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());	// 정점의 개수 V
		E = Integer.parseInt(st.nextToken());	// 간선의 개수 E
		
		parent = new int[V+1];
		for(int i=1; i<=V; i++) parent[i] = i;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());	// 시작정점
			int to = Integer.parseInt(st.nextToken());		// 도착정점
			int weight = Integer.parseInt(st.nextToken());	// 가중치
			pq.add(new Edge(from, to, weight));
		}
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			int from = find(now.from);
			int to = find(now.to);
			
			if(from == to) continue;
			union(from, to);
			res += now.weight;
		}
		System.out.println(res);
	}
}