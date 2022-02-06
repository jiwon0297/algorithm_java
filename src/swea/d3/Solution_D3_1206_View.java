package swea.d3;

import java.util.Scanner;

public class Solution_D3_1206_View {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			int T = sc.nextInt();
			int[] building = new int[T];
			for(int i=0; i<T; i++) {
				building[i]=sc.nextInt();
			}
			
			int cnt=0;
			for(int i=2; i<T-2; i++) {
				int a = building[i]-building[i-1];
				int b = building[i]-building[i+1];
				int c = building[i]-building[i-2];
				int d = building[i]-building[i+2];
				
				if(a>0 && b>0 && c>0 && d>0) {
					int min = 2147000000;
					if(a<min) min=a;
					if(b<min) min=b;
					if(c<min) min=c;
					if(d<min) min=d;
					
					cnt+=min;
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}
	}

}
