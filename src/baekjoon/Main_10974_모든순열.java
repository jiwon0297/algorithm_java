package baekjoon;

import java.util.Scanner;

public class Main_10974_모든순열 {

	static int N;
	static int[] nums;
	static boolean[] chk;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		chk=new boolean[N];
		nums=new int[N];
		go(0);
	}

	private static void go(int cnt) {
		if(cnt==N) {
			for(int i=0; i<N; i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
		}
		
		for(int i=0; i<N; i++) {
			if(chk[i]) continue;
			chk[i]=true;
			nums[cnt]=i+1;
			go(cnt+1);
			chk[i]=false;
		}
	}

}
