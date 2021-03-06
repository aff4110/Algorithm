**[Backtracking (백트래킹)으로 돌아가기](readme.md)**

# [N과 M (9)](https://www.acmicpc.net/problem/15663)

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, select;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static LinkedHashSet<String> list = new LinkedHashSet<>();

    private static void work(int cnt) {
        if(cnt == M) {
            StringBuilder res = new StringBuilder();
            for(int now : select) res.append(now).append(" ");

            list.add(res.toString());
            return;
        }

        for(int i=0; i<N; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            select[cnt] = arr[i];
            work(cnt+1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        select = new int[M];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        work(0);
        for(String now : list) sb.append(now).append("\n");
        System.out.print(sb);
    }
}
```
