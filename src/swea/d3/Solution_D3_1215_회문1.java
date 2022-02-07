package swea.d3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1215_회문1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int N = sc.nextInt();
			if(N==1) {
				System.out.println("#"+t+" "+64);
				continue;
			}
			char[][] map = new char[8][8];
			int res=0;
			for(int i=0; i<8; i++) {
				String str= sc.next();
				for(int j=0; j<8; j++) {
					map[i][j]=str.charAt(j);
				}
			}
			
			for(int i=0; i<8; i++) {
				for(int j=0; j<=8-N; j++) {
					if(isPalin(Arrays.copyOfRange(map[i], j, j+N))) res++;
				}
			}
			
			for(int i=0; i<8; i++) {
				char[] tmp = new char[8];
				for(int j=0; j<8; j++) {
					tmp[j]=map[j][i];
				}
				
				for(int j=0; j<=8-N; j++) {
					if(isPalin(Arrays.copyOfRange(tmp, j, j+N))) res++;
				}
			}
			
			System.out.println("#"+t+" "+res);
		}
	}
	
	private static boolean isPalin(char[] tmp) {
		if(tmp.length==2) {
			if(tmp[0]==tmp[1]) return true;
			return false;
		}
		
		int half=tmp.length/2;
		
		for(int i=0; i<half; i++) {
			if(tmp[i]!=tmp[tmp.length-1-i]) return false;
		}
		
		return true;
	}

}
