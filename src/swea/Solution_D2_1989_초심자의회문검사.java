package swea;

import java.util.Scanner;

public class Solution_D2_1989_초심자의회문검사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			String word = sc.next();
			int size = word.length();
			char[] str = new char[size+1];
			for(int i=1; i<=size; i++) {
				str[i]=word.charAt(i-1);
			}
			
			int cnt=0;
			if(size%2==0) {
				int a = size/2;
				for(int i=1; i<=a; i++) {
					if(str[i]==str[size-i+1]) cnt++;
				}
			} else {
				int a = size/2+1;
				for(int i=1; i<a; i++) {
					if(str[i]==str[size-i+1]) cnt++;
				}
			}
			
			if(cnt==size/2) System.out.println("#"+t+" 1");
			else System.out.println("#"+t+" 0");
		}
	}

}
