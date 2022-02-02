package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1920_수찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i]=sc.nextInt();
		}
		
		Arrays.sort(A);
		
		int M=sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			if(search(A,sc.nextInt())>=0) sb.append(1).append('\n');
			else sb.append(0).append('\n');
		}
		
		System.out.println(sb);
		
		
	}
	
	private static int search(int[] arr, int num) {
		int left=0;
		int right=arr.length-1;
		
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(num<arr[mid]) {
				right=mid-1;
			} else if(num>arr[mid]) {
				left=mid+1;
			} else return mid;
		}
		
		return -1;
	}

}
