package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1043_거짓말 {

	static int N,M;
	static boolean[] truth;
	static boolean[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		truth = new boolean[N+1];
		
		st=new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		for(int i=0; i<K; i++) {
			truth[Integer.parseInt(st.nextToken())]=true;
		}
		
		int[][] party = new int[M][];
		map = new boolean[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			party[i]=new int[num];

			party[i][0]=Integer.parseInt(st.nextToken());
			for(int j=1; j<num; j++) {
				int x = Integer.parseInt(st.nextToken());
				party[i][j]=x;
				map[party[i][j-1]][party[i][j]]=map[party[i][j]][party[i][j-1]]=true;
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(truth[i]) dfs(i);
		}
		
		int cnt=0;
		for(int i=0; i<M; i++) {
			if(!truth[party[i][0]]) cnt++;
		}
		
		System.out.println(cnt);
	}

	private static void dfs(int n) {
		for(int i=1; i<=N; i++) {
			if(map[n][i] && !truth[i]) {
				truth[i]=true;
				dfs(i);
			}
		}
	}

}
