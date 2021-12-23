import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로봇 청소기
// https://www.acmicpc.net/problem/14503

public class Main {
	static int N, M, res, count;
	static int idx[], map[][];
	
	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, -1, 0, 1 };
	
	private static void clean(int r, int c, int d) {
		if(map[r][c] == 0) map[r][c] = 2;
		
		for(int i=1; i<=4; i++) {
			int nd = (d+i) % 4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];
			
			if(map[nr][nc] == 0) { 
				clean(nr, nc, nd); break; 
			}
			
			if(i == 4) {
				int br = r - dr[d];
				int bc = c - dc[d];
				if(map[br][bc] == 1) break;
				clean(br, bc, d);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		idx = new int[3];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<3; i++) idx[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		if(idx[2] == 3) idx[2] = 1;
		else if(idx[2] == 1) idx[2] = 3;
		clean(idx[0], idx[1], idx[2]);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++)
				if(map[i][j] == 2) res++;
		}
		System.out.println(res);
	}
}