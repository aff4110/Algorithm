import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (1)
// https://www.acmicpc.net/problem/15649

public class Main {
    static int N, M;
    static int[] select;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    private static void work(int cnt) {
        if(cnt == M) {
            for(int i=0; i<M; i++) sb.append(select[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {
            if(visit[i]) continue;
            select[cnt] = i+1;
            visit[i] = true;
            work(cnt+1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        select = new int[M];
        visit = new boolean[N];

        work(0);
        System.out.print(sb);
    }
}