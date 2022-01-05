package 구현;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

// 통계학
// https://www.acmicpc.net/problem/2108

public class p2108 {
	static int[] arr, hash;
	
	private static class Number implements Comparable<Number> {
		int value, count;
		
		Number(int value, int count) {
			this.value = value;
			this.count = count;
		}
		
		@Override
		public int compareTo(Number o) {
			return o.count - count;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		hash = new int[8001];
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		LinkedList<Number> numList = new LinkedList<>();
		for(int i=-4000; i<=4000; i++) numList.add(new Number(i, 0));
		
		for(int i=0; i<N; i++) {
			int num = arr[i] = Integer.parseInt(br.readLine());
			numList.get(num+4000).count++;
			sum += num;
			hash[num+4000]++;
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		
		Arrays.sort(arr);
		Collections.sort(numList);
		
		int mode = 0;
		if(numList.get(0).count == numList.get(1).count) mode = numList.get(1).value;
		else mode = numList.get(0).value;
		
		System.out.println(Math.round((double)sum / N));
		System.out.println(arr[N/2]);
		System.out.println(mode);
		System.out.println(max - min);
	}
}