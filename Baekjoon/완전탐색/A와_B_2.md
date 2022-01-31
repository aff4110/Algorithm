**[Brute Force (완전탐색)로 돌아가기](readme.md)**

# [A와 B 2](https://www.acmicpc.net/problem/12919)

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String S, T;
    static int res;

    private static void make(String word) {
        if(word.length() == S.length()) {
            if(S.equals(word)) res = 1;
            return;
        }

        if(word.charAt(word.length()-1) == 'A') {
            make(word.substring(0, word.length()-1));
        }
        if(word.charAt(0) == 'B') {
            make(new StringBuffer(word.substring(1)).reverse().toString());
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        make(T);
        System.out.println(res);
    }
}
```
