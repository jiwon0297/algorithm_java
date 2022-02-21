package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//다시 풀어보기...
public class Main_16234_인구이동 {

	static int N,L,R;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt=0;
		boolean isMove=false; //이동하는지
		while(true) {
			visited=new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(bfs(i,j)) isMove=true; //이동
				}
			}
			if(!isMove) break; //안하면 break
			cnt++;
			isMove=false;
		}
		
		System.out.println(cnt);
		
	}

	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,-1,1};
	
	private static boolean bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>(); //bfs 큐		
		Queue<int[]> open = new LinkedList<>(); //국경 열린 큐
		q.offer(new int[] {r,c});
		
		int sum=0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			if(visited[cr][cc]) continue;
			visited[cr][cc]=true;
			open.offer(new int[] {cr,cc}); //국경 열림
			sum+=map[cr][cc];
			
			for(int i=0; i<4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc)) continue;
				if(visited[nr][nc]) continue;
				
				int diff = Math.abs(map[cr][cc]-map[nr][nc]);
				if(diff>=L && diff<=R) q.offer(new int[] {nr,nc});
			}
		}
		
		if(open.size()<=1) return false;
		sum=sum/open.size(); //열린 수대로 (연합개수) 나눔
		
		while(!open.isEmpty()) {
			int[] cur= open.poll();
			map[cur[0]][cur[1]]=sum;
		}
		
		return true;
	}
	
	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}

}
