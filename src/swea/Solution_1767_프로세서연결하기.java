package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {
	
	static int N;
	static int[][] map;
	static int min,max;
	static ArrayList<int[]> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(i==0 || i==N-1 || j==0 || j==N-1) continue;
					if(map[i][j]==1) list.add(new int[] {i,j});
				}
			}
			min=Integer.MAX_VALUE;
			max=Integer.MIN_VALUE;
			
			dfs(0,0,0);
			
			sb.append("#"+t+" "+min+"\n");
		}
		System.out.println(sb);
	}
	
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	private static void dfs(int idx, int corecnt, int len) {
		if(idx==list.size()) {
			if(max<corecnt) {
				max=corecnt;
				min=len;
			} else if(max==corecnt) {
				if(min>len) min=len;
			}
			
			return;
		}
		
		int r = list.get(idx)[0];
		int c = list.get(idx)[1];
		
		for(int d=0; d<4; d++) {
			int cnt=0;
			int nr=r;
			int nc=c;
			while(true) {
				nr+=dr[d];
				nc+=dc[d];
				
				if(!chk(nr,nc)) break;
				if(map[nr][nc]==1) {
					cnt=0;
					break;
				}
				cnt++;
			}
			
			int cr=r;
			int cc=c;
			for(int i=0; i<cnt; i++) {
				cr+=dr[d];
				cc+=dc[d];
				map[cr][cc]=1;
			}
			
			if(cnt==0) dfs(idx+1, corecnt, len);
			else {
				dfs(idx+1, corecnt+1, len+cnt);	
				
				cr=r;
				cc=c;
				for(int i=0; i<cnt; i++) {
					cr+=dr[d];
					cc+=dc[d];
					map[cr][cc]=0;
				}
			}
		}
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
