import java.util.Scanner;

// 벌집
// https://www.acmicpc.net/problem/2292

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int idx = 1, num = 1;

		while(true) {
			if(num >= N) break;
			num += 6 * idx++;
		}
		System.out.println(idx);
		s.close();
	}
}