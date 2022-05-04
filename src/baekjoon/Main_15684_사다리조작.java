package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15684_사다리조작 {
	
	static int N,M,H;
	static int[][] map;
	static boolean flag;
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		if(M==0) {
			System.out.println(0);
			return ;
		}
		
		map = new int[H+1][N+1];
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b]=1;
		}
		
		res=Integer.MAX_VALUE;
		for(int i=0; i<=3; i++) {
			flag=false;
			dfs(0,i);
			if(flag) {
				res=i;
				break;
			}
		}
		
		if(res>3) res=-1;
		System.out.println(res);
	}
	
	//combi
	private static void dfs(int cnt, int max) {
		if(flag) return ;
		if(max==cnt) {
			if(move()) flag=true;
			return ;
		}
		
		for(int i=1; i<=H; i++) {
			for(int j=1; j<N; j++) {
				if(map[i][j-1]!=1 && map[i][j]!=1 && map[i][j+1]!=1) {
					map[i][j]=1;
					dfs(cnt+1, max);
					map[i][j]=0;
				}
			}
		}
	}

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	//사다리타기
	private static boolean move() {
		for(int i=1; i<=N; i++) {
			int idx=i;
			int lev=1;
			while(lev<=H) {
				if(map[lev][idx]==1) idx+=1;
				else if(map[lev][idx-1]==1) idx-=1;
				lev++;
			}
			
			if(idx==i) continue;
			else return false;
		}
		return true;
	}
}
