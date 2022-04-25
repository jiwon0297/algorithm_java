package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {
		
	static Shark[][] map;
	static int R,C,M;
	
	static int[] dr = {-1,1,0,0}; //상하우좌
	static int[] dc = {0,0,1,-1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R][C];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			map[r][c]=new Shark(r,c,s,d,z);
		}
		
		int sum=0;
		for(int j=0; j<C; j++) {
			for(int i=0; i<R; i++) {
				if(map[i][j]!=null) {
					sum+=map[i][j].z;
					map[i][j]=null;
					break;
				}
			}		
			moveShark();
		}
		System.out.println(sum);
	}

	private static void moveShark() {
		Queue<Shark> q = new LinkedList<>();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]!=null) q.add(map[i][j]);
			}
		}
		
		map = new Shark[R][C];
		while(!q.isEmpty()) {
			Shark cur = q.poll();
			int speed = cur.s;
			if(cur.d==0 || cur.d==1) speed %= (R -1) * 2; 
			else if(cur.d==2 || cur.d==3) speed %= (C -1) * 2;
			
			for(int s=0; s<speed; s++) {
				int nr = cur.r+dr[cur.d];
				int nc = cur.c+dc[cur.d];
				
				if(!chk(nr,nc)) {
					cur.r-=dr[cur.d];
					cur.c-=dc[cur.d];
					if(cur.d==0 || cur.d==2) cur.d++;
					else if(cur.d==1 || cur.d==3) cur.d--;
					continue;
				}
				
				cur.r=nr;
				cur.c=nc;
			}
			
			if(map[cur.r][cur.c]!=null) {
				if(map[cur.r][cur.c].z < cur.z) map[cur.r][cur.c]=new Shark(cur.r, cur.c, cur.s, cur.d, cur.z);
			} else map[cur.r][cur.c]=new Shark(cur.r, cur.c, cur.s, cur.d, cur.z);
		}
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}

	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
