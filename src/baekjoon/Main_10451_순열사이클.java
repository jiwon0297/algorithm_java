package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10451_순열사이클 {
	
	static int N;
	static int[] map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for(int t=1; t<=T; t++) {
			N= Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			map = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				int x = Integer.parseInt(st.nextToken());
				map[i]=x;
			}
			
			int cnt=0;
			visited=new boolean[N+1];
			for(int i=1; i<=N; i++) {
				if(!visited[i] && bfs(i)==1) cnt++;
			}
			
			System.out.println(cnt);
		}
	}

	private static int bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		visited[idx]=true;
		q.offer(idx);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(map[cur]==idx) return 1;
			visited[map[cur]]=true;
			q.offer(map[cur]);
		}
		
		return 0;
	}

}
