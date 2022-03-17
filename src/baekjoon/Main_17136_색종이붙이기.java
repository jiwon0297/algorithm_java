package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기 {

	static int[][] map;
	static int[] paper= {5,5,5,5,5};
	static int res = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		map = new int[10][10];
		for(int i=0; i<10; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,0);
		if(res==Integer.MAX_VALUE) res=-1;
		
		System.out.println(res);
	}

	private static void dfs(int r, int c, int cnt) {
		if(r==9 && c==10) {
			res=Math.min(res, cnt);
			return;
		}
		
		if(cnt>=res) return;
		
		if(c==10) {
			dfs(r+1, 0, cnt);
			return;
		}
		
		if(map[r][c]==1) {
			for(int i=4; i>=0; i--) {
				if(paper[i]>0 && isAvailable(r,c,i+1)) {
					attach(r,c,i+1);
					paper[i]--;
					dfs(r,c+1,cnt+1);
					detach(r,c,i+1);
					paper[i]++;
				}
			}
		} else dfs(r,c+1,cnt);
	}

	private static boolean isAvailable(int r, int c, int size) {
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(!chk(i,j) || map[i][j]==0) return false;
			}
		}
		return true;
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<10 && c>=0 && c<10;
	}

	private static void attach(int r, int c, int size) {
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				map[i][j]=0;
			}
		}
	}
	
	private static void detach(int r, int c, int size) {
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				map[i][j]=1;
			}
		}
	}

}
