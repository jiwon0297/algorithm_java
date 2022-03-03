package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_7964_부먹왕국의차원관문 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			int[] map = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				map[i]=Integer.parseInt(st.nextToken());
			}
			
			int idx=-1;
			int cnt=0;
			
			while(idx<N-1) {
				boolean chk=false;
				
				for(int j=1; j<=D; j++) {
					if(idx+j<N && map[idx+j]==1) {
						chk=true;
						idx+=j;
						break;
					}
				}
				
				if(!chk) {
					cnt++;
					idx+=D;
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}
	}

}
