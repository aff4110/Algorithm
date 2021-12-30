import java.util.Scanner;

// 설탕 배달
// https://www.acmicpc.net/problem/2839

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int n3 = 0, n5 = 0;
		int num = N;
		
		if(N%5 == 0) System.out.println(N/5);
		else {
			while(true) {
				if(num < 0) { System.out.println("-1"); break; }
				if(num == 0) break;
				
				num -= 3; n3++;
				if(num%5 == 0) {
					n5 += (num/5); num = 0; break;
				}
			}
			if(num == 0) System.out.println(n3+n5);
		}
		s.close();
	}
}