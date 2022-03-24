package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5525_IOIOI {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] S = br.readLine().toCharArray();
		
		int cnt=0;
		int sum=0;
		for(int i=2; i<M; i++) {
			if(S[i]=='I' && S[i-1]=='O' && S[i-2]=='I') {
				sum++;
				i++;
			} else sum=0;
			
			if(sum>=N) cnt++;
		}
		
		System.out.println(cnt);
	}

}
