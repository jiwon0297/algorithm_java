package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2476_주사위게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		int res=0;
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if(A==B) {
				if(B==C) res=Math.max(res, 10000+B*1000);
				else res=Math.max(res, 1000+B*100);
			} else if(B==C) {
				if(A!=B) res=Math.max(res, 1000+B*100);
			} else if(A==C) {
				if(A!=B) res=Math.max(res, 1000+C*100);
			} else {
				int max = Math.max(A, B);
				max=Math.max(max, C);
				res=Math.max(res, max*100);
			}
		}
		
		System.out.println(res);
	}

}
