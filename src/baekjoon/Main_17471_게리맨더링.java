package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {
	
	static int N, min;
	static int[] population;
	static ArrayList<Integer>[] adj;
	static boolean[] visited, isA;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		population = new int[N+1];
		adj = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			population[i]=Integer.parseInt(st.nextToken());
			adj[i]=new ArrayList<>();
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for(int j=0; j<size; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		min=Integer.MAX_VALUE;
		isA=new boolean[N+1];
		subset(1);
		
		System.out.println(min==Integer.MAX_VALUE? -1:min);	
	}

	private static void subset(int idx) {
		if(idx==N+1) {
			if(bfs()) {
				int A=0, B=0;
				for(int i=1; i<=N; i++) {
					if(isA[i]) A+=population[i];
					else B+=population[i];
				}
				min=Math.min(min, Math.abs(A-B));
			}
			return ;
		}
		
		isA[idx]=true;
		subset(idx+1);
		isA[idx]=false;
		subset(idx+1);
	}

	private static boolean bfs() {
		visited=new boolean[N+1];
		
		int Aidx=-1, Bidx=-1;
		for(int i=1; i<=N; i++) {
			if(isA[i]) {
				Aidx=i;
				break;
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(!isA[i]) {
				Bidx=i;
				break;
			}
		}
		
		if(Aidx==-1 || Bidx==-1) return false;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(Aidx);
		visited[Aidx]=true;
		while(!q.isEmpty()) {
			int now = q.poll();
			int size = adj[now].size();
			for(int i=0; i<size; i++) {
				int next = adj[now].get(i);
				if(visited[next] || !isA[next]) continue;
				visited[next]=true;
				q.offer(next);
			}
		}
		
		q.offer(Bidx);
		visited[Bidx]=true;
		while(!q.isEmpty()) {
			int now = q.poll();
			int size = adj[now].size();
			for(int i=0; i<size; i++) {
				int next = adj[now].get(i);
				if(visited[next] || isA[next]) continue;
				visited[next]=true;
				q.offer(next);
			}
		}
		
		for(int i=1; i<=N; i++) if(!visited[i]) return false;
		
		return true;
	}

}
