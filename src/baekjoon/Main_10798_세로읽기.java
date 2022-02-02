package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10798_세로읽기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[][] alpha = new char[5][15];
		
		for(int i=0; i<5; i++) Arrays.fill(alpha[i], '-');
		for(int i=0; i<5; i++) {
			String str = sc.next();
			for(int j=0; j<str.length(); j++) {
				alpha[i][j]=str.charAt(j);
			}
		}
		
		for(int i=0; i<15; i++) {
			for(int j=0; j<5; j++) {
				if(alpha[j][i]!='-') System.out.print(alpha[j][i]);
			}
		}
	}

}
