package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2810_컵홀더 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String info = br.readLine();
		
		int cnt=1;
		for(int i=0; i<info.length(); i++) {
			if(info.charAt(i)=='S') cnt++;
			if(info.charAt(i)=='L') {
				cnt++;
				i++;
			}
		}
		
		if(cnt>N) cnt=N;
		System.out.println(cnt);
	}

}
