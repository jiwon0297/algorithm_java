package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {
	
	static int sr,sc,N,M,ans;
	static char[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='0') {
					sr=i;
					sc=j;
				}
			}
		}
		
		visited=new boolean[N][M][64];
		ans=bfs(sr,sc);
		System.out.println(ans);
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,-1,1};
	
	private static int bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		visited[sr][sc][0]=true;
		q.offer(new int[] {sr,sc,0,0});
		
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			int cnt = cur[2];
			int key = cur[3];
			
			if(map[cr][cc]=='1') return cnt;
			
			for(int i=0; i<4; i++) {
				int nr = cr+dr[i];
				int nc = cc+dc[i];
				
				if(!chk(nr,nc) || visited[nr][nc][key] || map[nr][nc]=='#') continue;
				
				if(map[nr][nc]>='a' && map[nr][nc]<='f') {
					int nkey = 1 << (map[nr][nc]-'a');
					nkey = nkey | key;
					if(visited[nr][nc][nkey]) continue;
					visited[nr][nc][key]=true;
					visited[nr][nc][nkey]=true;
					q.offer(new int[] {nr,nc,cnt+1, nkey});
				}
				
				else if (map[nr][nc]>='A' && map[nr][nc]<='Z') {
					int door = 1 << (map[nr][nc]-'A');
					if((key&door)==0) continue;
					visited[nr][nc][key]=true;
					q.offer(new int[] {nr,nc,cnt+1,key});
				}
				
				else {
					visited[nr][nc][key]=true;
					q.offer(new int[] {nr,nc,cnt+1,key});
				}
			}
		}
		
		return -1;
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
