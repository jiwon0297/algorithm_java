package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기 {
	
	static int n;
	static Pos house,festival;
	static Pos[] convinience;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			house = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			convinience = new Pos[n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				convinience[i]=new Pos(x,y);
			}
			st = new StringTokenizer(br.readLine());
			festival = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			boolean flag = false;
			if(dist(house, festival)<=1000) flag=true;
			else flag=bfs();
			
			if(flag) sb.append("happy\n");
			else sb.append("sad\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean bfs() {
		boolean[] visited = new boolean[n];
		Queue<Pos> q = new LinkedList<>();
		q.offer(house);
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			if(dist(cur, festival)<=1000) return true;
			
			for(int i=0; i<n; i++) {
				Pos next = convinience[i];
				if(visited[i] || dist(next,cur)>1000) continue;
				visited[i]=true;
				q.offer(next);
			}
		}
		
		return false;
	}

	private static int dist(Pos p1, Pos p2) {
		return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
	}
	
	static class Pos {
		int x,y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
