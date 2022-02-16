package swea;
import java.util.Scanner;

public class Solution_D2_1204_최빈수구하기 {

	static int T;
	static int[] score;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N=sc.nextInt();
			int res=0;
			int maxx=-2147000000;
			score = new int[101];
			for(int i=0; i<1000; i++) {
				int a=sc.nextInt();
				score[a]++;
			}
			
			for(int i=0; i<score.length; i++) {
				if(score[i]>=maxx) {
					maxx=score[i];
					res=i;
				}
			}
			
			System.out.println("#"+N+" "+res);
		}
	}

}
