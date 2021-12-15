import java.util.Scanner;

// 팩토리얼
// https://www.acmicpc.net/problem/10872

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
	    
		System.out.println(factorial(T));	
	}
	
	static int factorial(int num) {
		if(num <= 1) return 1;
		return num * factorial(num - 1);
	}
}