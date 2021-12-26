import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오목
// https://www.acmicpc.net/problem/2615

public class Main {
	static int cnt;
	static int[][] map = new int[19][19];
	
	static int[] dr = { 0, 1, 1, -1 };
	static int[] dc = { 1, 1, 0,  1 };
	
	private static boolean isFinished(int r, int c) {
		for(int i=0; i<4; i++) {
			cnt = 1;
			for(int j=1; j<5; j++) {
				int nr = r + dr[i]*j;
				int nc = c + dc[i]*j;
				
				if(nr<0 || nc<0 || nr>=19 || nc>=19) continue;
				if(map[nr][nc] == map[r][c]) cnt++;
				else break;
				
				if(cnt == 5) {
					if(r-dr[i]>=0 && c-dc[i]>=0 && r-dr[i]<19 && c-dc[i]<19)
						if(map[r-dr[i]][c-dc[i]] == map[r][c]) break;
					if(r+dr[i]*5>=0 && c+dc[i]*5>=0 && r+dr[i]*5<19 && c+dc[i]*5<19)
						if(map[r+dr[i]*5][c+dc[i]*5] == map[r][c]) break;
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int i=0; i<19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean chk = false;
		out:for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				if(map[i][j] != 0 && isFinished(i, j)) {
					chk = true;
					System.out.println(map[i][j]);
					System.out.println((i+1) + " " + (j+1));
					break out;
				}
			}
		}
		if(!chk) System.out.println("0");
	}
}