package swea.d2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1946_간단한압축풀기 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int T = sc.nextInt();
		 
		 for(int t=1; t<=T; t++) {
			 int N = sc.nextInt();
			 char[] zip = new char[N];
			 int[] num = new int[N];
			 Arrays.fill(zip, '-');
			 for(int i=0; i<N ;i++) {
				 char a = sc.next().charAt(0);
				 int b = sc.nextInt();
				 zip[i]=a;
				 num[i]=b;
			 }
			 
			 System.out.println("#"+t);
			 int cnt=1;
			 for(int i=0; i<N; i++) {
				 for(int j=0; j<num[i]; j++) {
					 cnt++;
					 if(cnt%10==1) {
						 System.out.print(zip[i]);
						 System.out.println();
						 cnt=1;
					 } else System.out.print(zip[i]);
				 }
				 System.out.println();
			 }
		 }
	}

}
