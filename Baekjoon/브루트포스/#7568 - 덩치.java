import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 덩치
// https://www.acmicpc.net/problem/7568

public class Main {
	static int N, list[][], rank[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N][2];
		rank = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());	// 몸무게
			list[i][1] = Integer.parseInt(st.nextToken());	// 키
		}
		
		for(int i=0; i<N; i++) {
			rank[i] = 1;
			for(int j=0; j<N; j++) {
				if(list[i][0] < list[j][0] && list[i][1] < list[j][1]) rank[i]++; 
			}
		}
		
		for(int i=0; i<N; i++) System.out.print(rank[i] + " ");
	}
}