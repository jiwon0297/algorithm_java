package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609_최대공약수와최소공배수 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int max=Integer.MIN_VALUE;
		for(int i=1; i<=Math.min(N, M); i++) {
			if(N%i==0 && M%i==0) {
				if(i>max) max=i;
			}
		}
		
		
		System.out.println(max);
		System.out.println(N/max * M/max * max);
		
	}
	
	

}
