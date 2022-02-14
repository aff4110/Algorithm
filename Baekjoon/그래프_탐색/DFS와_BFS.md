**[Simulation (시뮬레이션)으로 돌아가기](readme.md)**

# [DFS와 BFS](https://www.acmicpc.net/problem/1260)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static List<Integer>[] adjList;
    static boolean[] dfsChk, bfsChk;

    private static void dfs(int now) {
        dfsChk[now] = true;
        System.out.print(now + " ");

        for(int next : adjList[now])
            if(!dfsChk[next]) dfs(next);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(V); bfsChk[V] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");

            for(int next : adjList[now]) {
                if(!bfsChk[next]) { q.add(next); bfsChk[next] = true; }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        dfsChk = new boolean[N+1];
        bfsChk = new boolean[N+1];
        adjList = new LinkedList[N+1];
        for(int i=1; i<=N; i++) adjList[i] = new LinkedList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }

        for(int i=1; i<=N; i++) Collections.sort(adjList[i]);

        dfs(V);
        System.out.println();

        bfs();
        System.out.println();
    }
}
```
