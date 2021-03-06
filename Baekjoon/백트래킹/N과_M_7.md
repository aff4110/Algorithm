**[Backtracking (백트래킹)으로 돌아가기](readme.md)**

# [N과 M (7)](https://www.acmicpc.net/problem/15656)

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, select;
    static StringBuilder sb = new StringBuilder();

    private static void work(int cnt) {
        if(cnt == M) {
            for(int i=0; i<M; i++) sb.append(select[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {
            select[cnt] = arr[i];
            work(cnt+1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        select = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        work(0);
        System.out.print(sb);
    }
}
```
