package swea;

import java.util.Scanner;

public class Solution_D4_3289_서로소집합 {

	static int T,N,M;
	
	static int[] parent;
	static int[] rank;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N=sc.nextInt();
			M=sc.nextInt();
			parent=new int[N+1];
			rank=new int[N+1];
			
			//1.init
			for(int i=1; i<N+1; i++) {
				parent[i]=i;
				rank[i]=1;
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++) {
				int c=sc.nextInt();
				int a=sc.nextInt();
				int b=sc.nextInt();
				
				if(c==0) {
					union(a,b);
				} else if(c==1) {
					sb.append(find(a)==find(b)? "1":"0");
				}
			}
			
			System.out.println("#"+t+" "+sb.toString());
		}
	}

	private static void union(int x, int y) {
		int px=find(x);
		int py=find(y);
		
		if(px==py) return ;
		if(rank[px]<rank[py]) {
			parent[px]=py;
		} else {
			parent[py]=px;
			if(rank[px]==rank[py]) {
				rank[px]++;
			}
		}
	}
	
	private static int find(int x) {
		if(x==parent[x]) return parent[x];
		return parent[x]=find(parent[x]);
	}

}
