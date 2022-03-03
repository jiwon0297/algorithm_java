package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2999_비밀이메일 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String message = br.readLine();
		int N = message.length();
		
		int R=0;
		for(int i=1; i<=Math.sqrt(N); i++) {
			if(N%i==0) R=Math.max(R, i);
		}
		int C=N/R;
		
		char[][] map = new char[C][R];
		
		int idx=0;
		for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				map[i][j]=message.charAt(idx);
				idx++;
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[j][i]);
			}
		}
	}

}
