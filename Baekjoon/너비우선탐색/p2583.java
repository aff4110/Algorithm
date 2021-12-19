import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 영역 구하기
// https://www.acmicpc.net/problem/2583

public class Main {
	static int M, N, K;
	static int[][] map;
	static LinkedList<Integer> res;
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	private static class Node {
		int r, c;
		
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	private static void bfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		map[r][c] = -1;
		
		int count = 1;
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr<0 || nc<0 || nr>=M || nc>=N) continue;
				if(map[nr][nc] == -1) continue;
				
				q.add(new Node(nr, nc));
				map[nr][nc] = -1; count++;
			}
		} res.add(count);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		res = new LinkedList<>();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int sc = Integer.parseInt(st.nextToken());
			int sr = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			int er = Integer.parseInt(st.nextToken());
			
			for(int j=sr; j<er; j++) {
				for(int k=sc; k<ec; k++) map[j][k] = -1;
			}
		}
		
		int count = 0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == -1) continue;
				bfs(i, j); count++;
			}
		}
		
		System.out.println(count);
		Collections.sort(res);
		for(int i=0; i<res.size(); i++) System.out.print(res.get(i) + " ");
	}
}