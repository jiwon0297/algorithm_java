package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_5431_민석이의과제체크하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] student = new int[N+1];
			Arrays.fill(student, 1);
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<K; i++) {
				student[Integer.parseInt(st.nextToken())]--;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t);
			for(int i=1; i<=N; i++) {
				if(student[i]==1) sb.append(" ").append(i);
			}
			
			System.out.println(sb);
		}
	}

}
