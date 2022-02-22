package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1238_Contact {
	
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			map = new int[N+1][N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N/2; i++) {
				int from=Integer.parseInt(st.nextToken());
				int to=Integer.parseInt(st.nextToken());
				
				map[from][to]=1;
			}
			
			visited=new boolean[N+1];
			bfs(start);
			System.out.println("#"+t+" "+max);
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start]=true;
		
		while(!q.isEmpty()) {
			max=0;
			int size=q.size();
			for(int k=0; k<size; k++) {
				int current = q.poll();
				max=Math.max(max, current);
				for(int i=1; i<=N; i++) {
					if(!visited[i] && map[current][i]==1) {
						visited[i]=true;
						q.offer(i);
					}
				}
			}
		}
	}

}
