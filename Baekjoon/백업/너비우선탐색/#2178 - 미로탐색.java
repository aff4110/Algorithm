import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로 탐색
// https://www.acmicpc.net/problem/2178

public class Main {
	static int N, M, res = Integer.MAX_VALUE;
	static int[][] map, visit;
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static class Node {
		int r, c;
		
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new int[N][M];
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) map[i][j] = (input.charAt(j)-48) - 1;
		}
		
		bfs();
		System.out.println(map[N-1][M-1]);
	}
	
	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		map[0][0] = 1;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				if(map[nr][nc] != 0) continue;
				
				q.add(new Node(nr, nc));
				map[nr][nc] = map[now.r][now.c] + 1;
			}
		}
	}
}