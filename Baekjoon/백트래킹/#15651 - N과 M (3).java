import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (3)
// https://www.acmicpc.net/problem/15651

public class Main {
    static int N, M;
    static int[] select;
    static StringBuilder sb = new StringBuilder();

    private static void work(int cnt) {
        if(cnt == M) {
            for(int i : select) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {
            select[cnt] = i+1;
            work(cnt+1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        select = new int[M];
        work(0);
        System.out.print(sb);
    }
}