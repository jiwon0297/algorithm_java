package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_요리사 {

	static int N;
	static int[][] map;
	static boolean[] visited;
	static int res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[N];
			res=Integer.MAX_VALUE;
			cook(0,0);
			
			sb.append("#"+t+" "+res+"\n");
		}
		System.out.println(sb);
	}

	private static void cook(int idx, int cnt) {
		if(cnt>N/2) return;
		if(idx>=N) return;
		if(cnt==N/2) {
			int a=0;
			int b=0;
			
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					for(int j=0; j<N; j++) {
						if(visited[j]) a+=map[i][j];
					}
				} else if(!visited[i]) {
					for(int j=0; j<N; j++) {
						if(!visited[j]) b+=map[i][j];
					}
				}
			}
			
			res=Math.min(res, Math.abs(a-b));
			return;
		}
		
		visited[idx]=true;
		cook(idx+1, cnt+1);
		visited[idx]=false;
		cook(idx+1, cnt);
	}

}
