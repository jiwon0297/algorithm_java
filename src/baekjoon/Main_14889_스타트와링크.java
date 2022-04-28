package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	
	static boolean[] selected;
	static int N;
	static int[][] map;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		StringTokenizer st = null;
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		min=Integer.MAX_VALUE;
		selected=new boolean[N+1];
		dfs(0,1);
		System.out.println(min);
	}

	private static void dfs(int cnt, int idx) {
		if(cnt==N/2) {
			int start = 0;
			int link = 0;
			for(int i=1; i<=N; i++) {
				for(int j=i+1; j<=N; j++) {
					if(selected[i] && selected[j]) start+=map[i][j]+map[j][i];
					else if(!selected[i] && !selected[j]) link+=map[i][j]+map[j][i];
				}
			}
			min=Math.min(min, Math.abs(start-link));
		}
		
		for(int i=idx; i<=N; i++) {
			if(selected[i]) continue;
			selected[i]=true;
			dfs(cnt+1, i+1);
			selected[i]=false;
		}
	}

}
