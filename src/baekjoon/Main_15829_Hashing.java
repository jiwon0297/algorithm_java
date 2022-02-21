package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_15829_Hashing {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		long res=0;
		int M = 1234567891;
		long r=1;
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			int a = ch-'a'+1;
			res += (long) (a*r % M);
			r=(r*31)% M;
		}
		
		System.out.println(res%M);
	}

}
