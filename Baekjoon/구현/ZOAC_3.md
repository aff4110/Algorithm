**[Implementation (구현)로 돌아가기](readme.md)**

# [ZOAC 3](https://www.acmicpc.net/problem/20436)

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[][] keyboard = new char[3][10];
    static int[] left, right;

    private static int[] pressKey(char key) {
        int[] findKey = new int[3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<10; j++) {
                if(keyboard[i][j] == key) {
                    findKey[0] = i; findKey[1] = j;
                    if((i<2 && j<5) || (i==2 && j<4)) findKey[2] = 0;
                    else findKey[2] = 1;
                }
            }
        } return findKey;
    }

    public static void main(String[] args) throws Exception {
        String qwerty = "";
        for(int i=0; i<3; i++) {
            if(i == 0) qwerty = "qwertyuiop";
            if(i == 1) qwerty = "asdfghjkl";
            if(i == 2) qwerty = "zxcvbnm";
            for(int j=0; j<qwerty.length(); j++) keyboard[i][j] = qwerty.charAt(j);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        left = new int[3];
        right = new int[3];
        left = pressKey(st.nextToken().charAt(0));
        right = pressKey(st.nextToken().charAt(0));

        int count = 0;
        String input = br.readLine();
        for(int i=0; i<input.length(); i++) {
            int[] now = pressKey(input.charAt(i));
            if(now[2] == 0) {
                count += (Math.abs(now[0]-left[0]) + Math.abs(now[1]-left[1]) + 1);
                left = now;
            }
            if(now[2] == 1) {
                count += (Math.abs(now[0]-right[0]) + Math.abs(now[1]-right[1]) + 1);
                right = now;
            }
        }
        System.out.println(count);
    }
}
```
