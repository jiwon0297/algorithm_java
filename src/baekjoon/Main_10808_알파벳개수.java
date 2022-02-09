package baekjoon;

import java.util.Scanner;

public class Main_10808_알파벳개수 {

	public static void main(String[] args) {
		int[] num = new int[26];
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		for(int i=0; i<s.length(); i++ ) {
			char ch = s.charAt(i);
			num[ch-97]++;
		}
		
		for(int i : num) {
			System.out.print(i+" ");
		}
	}

}
