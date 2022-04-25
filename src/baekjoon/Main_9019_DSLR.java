package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019_DSLR {

	static int A,B;
	static String[] answer;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t=1; t<=T; t++) {
			st=new StringTokenizer(br.readLine());
			A =  Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			answer=new String[10000];
			visited=new boolean[10000];
			bfs();
		}
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(A);
		visited[A]=true;
		Arrays.fill(answer, "");
		
		while(!q.isEmpty()) {			
			int cur = q.poll();
			
			if(visited[B]) {
				System.out.println(answer[B]);
				return ;
			}
			
			int D = (2*cur) % 10000;
			int S = (cur==0)? 9999:cur-1;
			int L = (cur%1000)*10 + cur/1000;
			int R = (cur%10)*1000 + cur/10;
			
			if(!visited[D]) {
				q.offer(D);
				visited[D]=true;
				answer[D]=answer[cur]+"D";
			}
			
			if(!visited[S]) {
				q.offer(S);
				visited[S]=true;
				answer[S]=answer[cur]+"S";
			}
			
			if(!visited[L]) {
				q.offer(L);
				visited[L]=true;
				answer[L]=answer[cur]+"L";
			}

			if(!visited[R]) {
				q.offer(R);
				visited[R]=true;
				answer[R]=answer[cur]+"R";
			}
		}
	}
}
