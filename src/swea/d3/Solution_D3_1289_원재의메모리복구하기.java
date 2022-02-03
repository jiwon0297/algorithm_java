package swea.d3;

import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String s = sc.next();
			int[] memory = new int[s.length()];
			for(int i=0; i<s.length(); i++) {
				memory[i]=s.charAt(i)-'0';
			}
			
			int cnt=0;
			for(int i=0; i<memory.length-1; i++) {
				if(memory[i]!=memory[i+1]) cnt++;
			}
			
			if(memory[0]==1) cnt++;
			
			System.out.println("#"+t+" "+cnt);
		}
	}

}
