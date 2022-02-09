package baekjoon;

import java.util.Scanner;

public class Main_2941_크로아티아알파벳 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String alpha = sc.next();
		int res = 0;
		
		for(int i=0; i<alpha.length(); i++) {
			char ch = alpha.charAt(i);
			
			if(ch=='c') {
				if(i<alpha.length()-1) {
					if(alpha.charAt(i+1)=='=') i++;
					else if(alpha.charAt(i+1)=='-') i++;
				}
			}
			
			else if(ch=='d') {
				if(i<alpha.length()-1) {
					if(alpha.charAt(i+1)=='z') {
						if(i<alpha.length()-2) {
							if(alpha.charAt(i+2)=='=') i+=2;
						}
					}
					else if(alpha.charAt(i+1)=='-') i++;
				}
			}
			
			else if(ch=='l') {
				if(i<alpha.length()-1) {
					if(alpha.charAt(i+1)=='j') i++;
				}
			}
			
			else if(ch=='n') {
				if(i<alpha.length()-1) {
					if(alpha.charAt(i+1)=='j') i++;
				}
			}
			
			else if(ch=='s') {
				if(i<alpha.length()-1) {
					if(alpha.charAt(i+1)=='=') i++;
				}
			}
			
			else if(ch=='z') {
				if(i<alpha.length()-1) {
					if(alpha.charAt(i+1)=='=') i++;
				}
			}
			
			res++;
		}
	
		System.out.println(res);
	}

}
