**[Implementation (구현)로 돌아가기](readme.md)**

# [원상 복구 (small)](https://www.acmicpc.net/problem/22858)

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] D, S, P;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        D = new int[N];
        S = new int[N];
        P = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) S[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) D[i] = Integer.parseInt(st.nextToken())-1;

        for(int i=0; i<K; i++) {
            for(int j=0; j<N; j++) P[D[j]] = S[j];
            System.arraycopy(P, 0, S, 0, N);
        }

        for(int i=0; i<N; i++) System.out.print(P[i] + " ");
    }
}
```
