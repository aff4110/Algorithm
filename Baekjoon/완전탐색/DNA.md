**[Brute Force (완전탐색)로 돌아가기](readme.md)**

# [DNA](https://www.acmicpc.net/problem/1969)

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, res;
    static String[] DNA;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        DNA = new String[N];
        for(int i=0; i<N; i++) DNA[i] = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            int[] value = new int[4];

            for(int j=0; j<N; j++) {
                switch(DNA[j].charAt(i)) {
                    case 'A': value[0]++; break;
                    case 'C': value[1]++; break;
                    case 'G': value[2]++; break;
                    case 'T': value[3]++; break;
                }
            }

            int maxValue = value[0], idx = 0;
            for(int j=1; j<4; j++) {
                if(value[j] > maxValue) { maxValue = value[j]; idx = j; }
            } res += (N-maxValue);

            switch(idx) {
                case 0: sb.append("A"); break;
                case 1: sb.append("C"); break;
                case 2: sb.append("G"); break;
                case 3: sb.append("T"); break;
            }
        }
        System.out.println(sb);
        System.out.println(res);
    }
}
```
