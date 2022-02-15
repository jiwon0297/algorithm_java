package baekjoon;

import java.util.Scanner;

public class Main_4153_직각삼각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if(a==0 && b==0 && c==0) break;
			
			int max = Math.max(a,b);
			max = Math.max(max, c);
			
			if(max==a) {
				isTri(b,c,a);
			} else if(max==b) {
				isTri(a,c,b);
			} else if(max==c) {
				isTri(b,a,c);
			} 
		}
	}
	
	public static void isTri(int a, int b, int max) {
		int res = a*a + b*b;
		if(res==(max*max)) System.out.println("right");
		else System.out.println("wrong");
	}

}
