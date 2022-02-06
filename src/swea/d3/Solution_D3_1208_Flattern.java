package swea.d3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1208_Flattern {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			int N = sc.nextInt();
			int[] dump = new int[100];
			
			for(int i=0; i<100; i++) {
				dump[i]=sc.nextInt();
			}
			
			while(N>0) {
				Arrays.sort(dump);
				dump[0]++;
				dump[99]--;
				N--;
			}
			
			Arrays.sort(dump);
			int res = dump[99]-dump[0];
			System.out.println("#"+t+" "+res);
		}
	}

}
