package swea.d1;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D1_2063_중간값찾기 {
	
	static int N;
	static int[] arr;
	
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		arr=new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i]=scann.nextInt();
		}
		
		Arrays.sort(arr);
		System.out.println(arr[N/2]);
		
	}

}
