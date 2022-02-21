package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	static class CCTV {
		int r;
		int c;
		int v;
		int[] dir;
		
		public CCTV(int r, int c, int v) {
			this.r = r;
			this.c = c;
			this.v = v;
			
			if(v==1) {
				this.dir=new int[1];
				dir[0]=0;
			} else if(v==2) {
				this.dir=new int[2];
				dir[0]=0;
				dir[1]=2;
			} else if(v==3) {
				this.dir=new int[2];
				dir[0]=0;
				dir[1]=3;
			} else if(v==4) {
				this.dir=new int[3];
				dir[0]=0;
				dir[1]=2;
				dir[2]=3;
			} else if(v==5) {
				this.dir=new int[4];
				dir[0]=0;
				dir[1]=1;
				dir[2]=2;
				dir[3]=3;
			}
		}

	}
	
	static int N,M,cctvnum;
	static int[][] map;
	static ArrayList<CCTV> cctvs = new ArrayList<CCTV>();
	static int res=Integer.MAX_VALUE;

	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]>=1 && map[i][j]<=5) cctvs.add(new CCTV(i,j,map[i][j]));
			}
		}
		cctvnum=cctvs.size();
		dfs(0);
		System.out.println(res);
	}

	private static void dfs(int idx) {
		if(idx==cctvnum) {
			int[][] cpmap = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					cpmap[i][j]=map[i][j];
				}
			}
			
			//cpmap 재설정 (cctv 감시중인 곳 9로 바꾸기)
			for(int i=0; i<cctvs.size(); i++) {
				CCTV cur = cctvs.get(i);
				int cr=cur.r;
				int cc=cur.c;
				
				for(int j=0; j<cur.dir.length; j++) {
					int d=cur.dir[j];
					
					int nr=cr;
					int nc=cc;
					while(true) {
						nr+=dr[d];
						nc+=dc[d];
						
						if(chk(nr,nc)) {
							if(cpmap[nr][nc]==0) cpmap[nr][nc]=9;
							else if(cpmap[nr][nc]==6) break;
						} else break;
					}
				}
			}
			
			//사각지대 개수 구하기
			int cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(cpmap[i][j]==0) cnt++;
				}
			}
			res=Math.min(res, cnt);
			
		} else {
			CCTV cur = cctvs.get(idx);
			int[] tmp = cur.dir.clone();
			
			//4가지
			if(cur.v==1 || cur.v==3 || cur.v==4) {
				for(int i=0; i<4; i++) {
					for(int j=0; j<cur.dir.length; j++) {
						cur.dir[j]+=i;
						cur.dir[j]=cur.dir[j] % 4;
					}
					dfs(idx+1);
					cur.dir=tmp.clone();
				}
			} 
			
			//2가지
			else if(cur.v==2) {
				for(int i=0; i<2; i++) {
					for(int j=0; j<cur.dir.length; j++) {
						cur.dir[j]+=i;
						cur.dir[j]=cur.dir[j] % 4;
					}
					dfs(idx+1);
					cur.dir=tmp.clone();
				}
			} 
			
			//1가지
			else dfs(idx+1);
		}
		
	}

	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M;
	}

}
