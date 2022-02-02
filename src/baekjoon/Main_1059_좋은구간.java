package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1059_좋은구간 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int[] S = new int[L];
		for(int i=0; i<L; i++) {
			S[i]=sc.nextInt();
		}
		int n = sc.nextInt();
		
		Arrays.sort(S);
		int max=0;
		int min=0;
		
		for(int i=0; i<L; i++) {
			if(S[i]<n) min=S[i];
			if(S[i]>=n) {
				max=S[i];
				break;
			}
		}
		
		int res=0;
		if(max==n) res=0;
		else res=(n-min)*(max-n)-1;
		
		System.out.println(res);
	}

}
