package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7465_창용마을무리의개수 {
	
	static int N,M;
	static int[] parents, rank;
	static boolean[] visited;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parents=new int[N+1];
			rank=new int[N+1];
			for(int i=1; i<=N; i++) {
				parents[i]=i;
				rank[i]=1;
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			
			int cnt=0;
			visited=new boolean[N+1];
			for(int i=1; i<=N; i++) {
				int p = find(i);
				if(!visited[p]) {
					visited[p]=true;
					cnt++;
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}
	}

	private static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa==pb) return false;
		if(rank[pa]<rank[pb]) {
			parents[pa]=pb;
		} else {
			parents[pb]=pa;
			if(rank[pa]==rank[pb]) {
				rank[pa]++;
			}
		}
		return true;
		
	}

	private static int find(int x) {
		if(parents[x]==x) return x;
		else return parents[x]=find(parents[x]);
	}

}
