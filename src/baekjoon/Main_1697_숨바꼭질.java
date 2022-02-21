package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1697_숨바꼭질 {
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] visited = new int[1000001];
		
		if(N==K) {
			System.out.println(0);
			return ;
		}
		
		int res = Integer.MAX_VALUE;
		Queue<Integer> q = new LinkedList<Integer>();
		visited[N]=1;
		q.offer(N);
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0; i<3; i++) {
				int next;
				
				if(i==0) next=cur+1;
				else if(i==1) next=cur-1;
				else next=cur*2;
				
				if(next==K) {
					System.out.println(visited[cur]);
					return;
				}
				
				if(next>=0 && next<visited.length && visited[next]==0) {
					q.offer(next);
					visited[next]=visited[cur]+1;
				}
			}
		}
	}



}
