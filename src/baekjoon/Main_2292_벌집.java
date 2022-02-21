package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2292_벌집 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		if(N==1) {
			System.out.println(1);
			return ;
		}
		
		int an=2;
		int k= 1;
		while(an<=N) {
			an=an+6*k;
			k++;
		}
		
		System.out.println(k);
	}

}
