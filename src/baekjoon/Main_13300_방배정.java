package baekjoon;

import java.util.Scanner;

public class Main_13300_방배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] girl = new int[7];
		int[] boy = new int[7];
		for(int i=0; i<N; i++) {
			int S = sc.nextInt();
			int Y = sc.nextInt();
			
			if(S==1) {
				boy[Y]++;
			} else if(S==0) {
				girl[Y]++;
			}
		}
		
		int res=0;
		for(int i=1; i<7; i++) {
			if(girl[i]>0) {
				int a=0;
				if(girl[i]%K==0) {
					a=girl[i]/K;
				} else {
					a=(girl[i]/K)+1;
				}
				res+=a;
			}
			
			if(boy[i]>0) {
				int a=0;
				if(boy[i]%K==0) {
					a=boy[i]/K;
				} else {
					a=(boy[i]/K)+1;
				}
				res+=a;
			}
		}
		
		System.out.println(res);
	}

}
