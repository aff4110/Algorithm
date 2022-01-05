import java.util.Scanner;

// 영화감독 숌
// https://www.acmicpc.net/problem/1436

public class Main {
	static int N, num;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		num = 666;
		
		while(true) {
			if(String.valueOf(num).contains("666")) { 
				if(N == 1) break;
				N--;
			}
			num++;
		}
		System.out.println(num);
		s.close();
	}
}