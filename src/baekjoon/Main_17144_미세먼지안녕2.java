package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕2 {

	static int R,C,T,cleaner;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());		
		map = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) cleaner=i;
			}
		}
		
		for(int t=0; t<T; t++) {
			Queue<int[]> q = new LinkedList<>(); 
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j]>0) q.offer(new int[] {i,j,map[i][j]});
				}
			}
			spread(q);
			clean();
		}
		
		int res=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]>0) res+=map[i][j];
			}
		}
		System.out.println(res);
	} 
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	private static void spread(Queue<int[]> q) {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr=cur[0];
			int cc=cur[1];
			int dust=cur[2];
			
			if(dust<5) continue;
			
			int amount=dust/5;
			int cnt=0;
			
			for(int i=0; i<4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc) || map[nr][nc]==-1) continue;
				
				map[nr][nc]+=amount;
				cnt++;
			}
			
			map[cr][cc]-=(cnt*amount);
		}
	}
	
	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}

	private static void clean() {
		int top=cleaner-1;
		for(int i=top-1; i>0; i--) map[i][0]=map[i-1][0]; //하  
		for(int i=0; i<C-1; i++) map[0][i]=map[0][i+1]; //좌 
		for(int i=0; i<top; i++) map[i][C-1]=map[i+1][C-1]; //상
		for(int i=C-1; i>1; i--) map[top][i]=map[top][i-1]; //우 
		map[top][1]=0;
		
        int down=cleaner;
		for(int i=down+1; i<R-1; i++) map[i][0]=map[i+1][0]; //상
		for(int i=0; i<C-1; i++) map[R-1][i]=map[R-1][i+1]; //좌 
		for(int i=R-1; i>down; i--) map[i][C-1]=map[i-1][C-1]; //하  
		for(int i=C-1; i>1; i--) map[down][i]=map[down][i-1]; //우 
		map[down][1]=0;
	}
}
