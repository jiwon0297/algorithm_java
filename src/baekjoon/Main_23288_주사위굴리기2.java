package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_23288_주사위굴리기2 {
	
	static int N, M, K, map[][], ans = 0, d, r, c;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int dice[][] = {
			{ 0, 2, 0, 0 },
			{ 4, 1, 3, 6 },
			{ 0, 5, 0, 0 },
			{ 0, 6, 0, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		d = 1;
		r = 0;
		c = 0;
		
		for (int i = 0; i < K; i++) move();
		System.out.println(ans);
	}

	private static void move() {
		int nr = r + dr[d];
		int nc = c + dc[d];
		
		if (!chk(nr,nc)) {
			d = (d + 2) % 4;
			nr = r + dr[d];
			nc = c + dc[d];
		}
		r = nr;
		c = nc;
		
		//상 
		if (d == 0) { 
			int tmp = dice[0][1];
			for (int i = 0; i < 3; i++) {
				dice[i][1] = dice[i + 1][1];
			}
			dice[3][1] = tmp;
			dice[1][3] = dice[3][1];
		} 
		
		//우 
		else if (d == 1) {
			int tmp = dice[1][3];
			for(int i = 3; i > 0; i--) {
				dice[1][i] = dice[1][i-1];
			}
			dice[1][0] = tmp;
			dice[3][1] = dice[1][3];
		} 
		
		//하 
		else if (d == 2) {
			int tmp = dice[3][1];
			for (int i = 3; i > 0; i--) {
				dice[i][1] = dice[i - 1][1];
			}
			dice[0][1] = tmp;
			dice[1][3] = dice[3][1];
		} 
		
		//좌 
		else {
			int tmp = dice[1][0];
			for(int i = 0; i < 3; i++) {
				dice[1][i] = dice[1][i+1];
			}
			dice[1][3] = tmp;
			dice[3][1] = dice[1][3];
		}


		ans += bfs();

		int A = dice[1][3];
		int B = map[r][c];
		if(A > B) d = (d+1) % 4;
		else if(A < B) d = (d-1 < 0)? 3 : d-1;
	}

	private static int bfs() {
		int B = map[r][c];
		int C = 0;
		boolean[][] visited = new boolean[N][M];
		
		visited[r][c] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c});
		
		while (!q.isEmpty()) {
			int[] p = q.poll();
			int cr = p[0];
			int cc = p[1];
			C++;
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (!chk(nr,nc) || visited[nr][nc] || map[nr][nc]!=B) continue;
				visited[nr][nc] = true;
				q.offer(new int[] {nr,nc});
			}
		}
		return B * C;
	}
	
	private static boolean chk(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
