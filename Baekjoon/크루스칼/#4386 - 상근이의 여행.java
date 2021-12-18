import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 상근이의 여행
// https://www.acmicpc.net/problem/9372

public class Main {
	static int N, parent[];
	static double res, position[][];
	
	private static class Edge implements Comparable<Edge> {
		int from, to;
		double weight;
		
		Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return (int) (weight - o.weight);
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
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		N = Integer.parseInt(br.readLine());
		
		parent = new int[N];
		for(int i=0; i<N; i++) parent[i] = i;
		
		position = new double[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			position[i][0] = Double.parseDouble(st.nextToken());
			position[i][1] = Double.parseDouble(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i == j) continue;
				double width = Math.abs(position[i][0] - position[j][0]);
				double height = Math.abs(position[i][1] - position[j][1]);
				pq.add(new Edge(i, j, Math.sqrt(width*width + height*height)));
			}
		}

		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			int from = find(now.from);
			int to = find(now.to);
			
			if(from == to) continue;
			union(from, to);
			res += now.weight;
		}
		
		System.out.printf("%.2f", res);
	}
}