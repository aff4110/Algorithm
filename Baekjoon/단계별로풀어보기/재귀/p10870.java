import java.util.Scanner;

// 피보나치 수 5
// https://www.acmicpc.net/problem/10870

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		System.out.println(fibonacci(T));
	}

	static int fibonacci(int num) {
		if(num == 0) return 0;
		if(num == 1) return 1;
		return fibonacci(num-1) + fibonacci(num-2);
	}
}