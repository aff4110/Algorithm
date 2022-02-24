**[Backtracking (백트래킹)으로 돌아가기](readme.md)**

# [N과 M (4)](https://www.acmicpc.net/problem/15652)

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] select;
    static StringBuilder sb = new StringBuilder();

    private static void work(int cnt, int idx) {
        if(cnt == M) {
            for(int i=0; i<M; i++) sb.append(select[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=idx; i<N; i++) {
            select[cnt] = i+1;
            work(cnt+1, i);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        select = new int[M];

        work(0, 0);
        System.out.print(sb);
    }
}
```
