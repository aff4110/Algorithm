**[Simulation (시뮬레이션)으로 돌아가기](readme.md)**

# [ABCDE](https://www.acmicpc.net/problem/13023)

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean res = false;
    static boolean[] visit;
    static LinkedList<Integer>[] adjList;

    private static void work(int now, int cnt) {
        if(res) return;
        if(cnt == 4) {
            res = true;
            return;
        }

        for(int next : adjList[now]) {
            if(visit[next]) continue;

            visit[next] = true;
            work(next, cnt+1);
            visit[next] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        adjList = new LinkedList[N];
        for(int i=0; i<N; i++) adjList[i] = new LinkedList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }

        for(int i=0; i<N; i++) {
            Arrays.fill(visit, false);
            visit[i] = true;
            work(i, 0);
        }

        System.out.println(res ? "1" : "0");
    }
}
```
