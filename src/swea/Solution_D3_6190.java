package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D3_6190 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] num= new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				num[i]=Integer.parseInt(st.nextToken());
			}
			
			int max=-1;
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					int a=num[i]*num[j];
					if(isIncre(a)) max=Math.max(max, a);
				}
			}

			System.out.println("#"+t+" "+max);
		}
	}

	private static boolean isIncre(int a) {
		String str = Integer.toString(a);
		
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i)<str.charAt(i-1)) return false;
		}
		
		return true;
	}

}
