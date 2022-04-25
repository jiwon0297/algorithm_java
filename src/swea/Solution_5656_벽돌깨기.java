package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {

	static int N,W,H,res;
	static int[] remain, breakcol;
	static Queue<int[]> q;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st=new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];			
			remain=new int[W];
			res=H*W+1;
			int sum=0;
			for(int i=0; i<H; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]!=0) {
						remain[j]++;
						sum++;
					}
				}
			}
			
			if(sum<=N) {
				sb.append("#"+t+" 0\n");
				continue;
			}
			
			dfs(map, 0);
			sb.append("#"+t+" "+res+"\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int[][] map, int cnt) {
		if(cnt==N) {
			int sum=0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j]>0) sum++;
				}
			}
			res=Math.min(res, sum);
			return;
		}
		
		int[][] copy = new int[H][W];
		for(int i=0; i<W; i++) {
			if(remain[i]>0) {
				remain[i]--;
				for(int j=0; j<H; j++) copy[j]=map[j].clone();
				breaking(copy,i);
				dfs(copy,cnt+1);
				remain[i]++;
			}
		}
	
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	private static void breaking(int[][] map, int m) {
		q=new LinkedList<>();
		for(int i=0; i<H; i++) {
			if(map[i][m]>0) {
				q.offer(new int[] {i,m,map[i][m]});
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr=cur[0];
			int cc=cur[1];
			int size=cur[2];
			map[cr][cc]=0;
			
			for(int d=0; d<4; d++) {
				for(int i=1; i<size; i++) {
					int nr=cr+dr[d]*i;
					int nc=cc+dc[d]*i;
					
					if(!chk(nr,nc)) break;
					if(map[nr][nc]==0) continue;
					if(map[nr][nc]==1) map[nr][nc]=0;
					else q.offer(new int[] {nr,nc,map[nr][nc]});
				}
			}
		}
		
		for(int j=0; j<W; j++) {
			String ss="";
			for(int i=H-1; i>=0; i--) {
				if(map[i][j]>0) ss+=Integer.toString(map[i][j]);
			}
			
			for(int i=0; i<ss.length(); i++) map[H-1-i][j]=ss.charAt(i)-'0';
			for(int i=0; i<H-ss.length(); i++) map[i][j]=0;
		}
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<H && c>=0 && c<W;
	}

}
