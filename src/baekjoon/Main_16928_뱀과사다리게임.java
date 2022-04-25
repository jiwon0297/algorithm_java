package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16928_뱀과사다리게임 {
	
	static int N,M;
	static int[] cnt, snakeandladder;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		snakeandladder = new int[101];
		visited = new boolean[101];
		cnt = new int[101];
		
		for(int i=0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			snakeandladder[x]=y;
		}
		bfs(1);	
	}

	private static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(idx);
		cnt[idx]=0;
		visited[idx]=true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur==100) {
				System.out.println(cnt[cur]);
				return;
			}
			
			for(int i=1; i<=6; i++) {
				int next=cur+i;
				
				if(next>100 || visited[next]) continue;
				
				if(snakeandladder[next]!=0) {
					if(!visited[snakeandladder[next]]) {
						visited[snakeandladder[next]]=true;
						cnt[snakeandladder[next]]=cnt[cur]+1;
						q.offer(snakeandladder[next]);
					}	
				} else {
					visited[next]=true;
					cnt[next]=cnt[cur]+1;
					q.offer(next);
				}
			}
		}
	}
}
