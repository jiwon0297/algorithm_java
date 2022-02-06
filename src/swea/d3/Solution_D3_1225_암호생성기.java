package swea.d3;

import java.util.Scanner;

public class Solution_D3_1225_암호생성기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int T = sc.nextInt();
			int[] code = new int[8];
			for(int i=0; i<8; i++) {
				code[i]=sc.nextInt();
			}
			
			int cnt=1;
			while(true) {
				if(cnt>5) {
					cnt=1;
				}
				
				int num = code[0]-cnt;
				if(num<=0) {
					num=0;
					for(int i=1; i<8; i++) {
						code[i-1]=code[i];
					}
					code[7]=num;
					break;
				}
				else {
					for(int i=1; i<8; i++) {
						code[i-1]=code[i];
					}
					code[7]=num;
				}
				
				cnt++;
			}
			
			System.out.print("#"+t);
			for(int i : code) {
				System.out.print(" "+i);
			}
			System.out.println();
		}
	}

}
