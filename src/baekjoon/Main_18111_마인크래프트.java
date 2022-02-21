package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18111_마인크래프트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
	
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(max<map[i][j]) max=map[i][j];
				if(min>map[i][j]) min=map[i][j];
			}
		}
		
		int time = Integer.MAX_VALUE;
		int height = -1;
		
		for(int i=min; i<=max; i++) {
			int sec = 0;
			int inven = B;
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					int diff=map[j][k]-i;
					if(diff>0) {
						sec+=2*diff;
						inven+=diff;
					} else if(diff<0) {
						sec=sec-diff;
						inven+=diff;
					}
				}
			}
			
			if(inven>=0) {
				if(sec<=time) {
					time=sec;
					height=i;
				}
			}
		}
		
		System.out.println(time+" "+height);
	}

}
