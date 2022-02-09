package baekjoon;

import java.util.Scanner;

public class Main_1475_방번호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		
		int[] num = new int[9];
		
		for(int i=0; i<N.length(); i++) {
			char ch = N.charAt(i);
			if(ch=='9' || ch=='6') num[6]++;
			else num[ch-'0']++;
		}
		
		if(num[6]%2==0) num[6]=num[6]/2;
		else num[6]=(num[6]/2)+1;
		
		int max=-1;
		for(int i=0; i<9; i++) {
			if(num[i]>max) max=num[i];
		}
		
		System.out.println(max);
	}

}
