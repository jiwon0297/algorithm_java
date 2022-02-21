package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의양팔저울 {
	
	static int N,res;
	static int[] weight, arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			weight = new int[N];
			for(int i=0; i<N; i++) {
				weight[i]=Integer.parseInt(st.nextToken());
			}
			
			arr=new int[N];
			visited=new boolean[N];			
			res=0;
			perm(0);
			
			System.out.println("#"+t+" "+res);
		}
	}

	private static void perm(int cnt) {
		if(cnt==N) {
			subset(0,0,0);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			
			visited[i]=true;
			arr[cnt]=weight[i];
			perm(cnt+1);
			visited[i]=false;
		}
	}

	private static void subset(int i, int right, int left) {
		if(i==N) {
			res++;
			return;
		}
		
		if(right+arr[i]<=left) {
			subset(i+1, right+arr[i], left);
		}
		
		subset(i+1, right, left+arr[i]);
	}

}
