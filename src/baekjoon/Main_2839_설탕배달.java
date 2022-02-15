package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2839_설탕배달 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int cnt=0;
		while(N>0) {
			if(N%5==0) {
				cnt+=N/5;
				break;
			} else {
				N-=3;
				if(N<0) {
					cnt=-1;
					break;
				} else cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
