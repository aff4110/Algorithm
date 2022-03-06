**[Backtracking (백트래킹)으로 돌아가기](readme.md)**

# [넴모넴모\_Easy](https://www.acmicpc.net/problem/14712)

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, res;
    static int[][] map;

    private static void work(int cnt) {
        if(cnt == N*M) {
            res++; return;
        }

        boolean flag = true;
        int nr = cnt/M, nc = cnt%M;
        if(nr-1>=0 && nc-1>=0) {
            int sum = map[nr-1][nc-1] + map[nr-1][nc] + map[nr][nc-1] + map[nr][nc];
            if (sum == 3) flag = false;
        }

        if(flag) {
            map[cnt/M][cnt%M] = 1;
            work(cnt+1);
        }
        map[cnt/M][cnt%M] = 0;
        work(cnt+1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        work(0);
        System.out.println(res);
    }
}
```
