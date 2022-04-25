package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_4014_활주로건설 {
	
	static int N,X,cnt;
	static int[][] map1,map2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			st=new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map1 = new int[N][N];
			map2 = new int[N][N];
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map1[i][j]=Integer.parseInt(st.nextToken());
					map2[j][i]=map1[i][j];
				}
			}
			
			cnt=0;
			for(int i=0; i<N; i++) {
				cnt+=isPos(map1[i]);
				cnt+=isPos(map2[i]);
			}
			
			sb.append(cnt+"\n");
		}
		
		System.out.println(sb);
	}

	private static int isPos(int[] map) {
		boolean[] check = new boolean[N];
		for(int i=0; i<N-1; i++) {
			int now=map[i];
			int next=map[i+1];
			
			if(Math.abs(now-next)>1) return 0;
			if(check[i+1] || next==now) continue;
			
			if(now>next) {
				for(int j=i+1; j<=i+X; j++) {
					if(j>=N || map[j]!=next || check[j]) return 0;
					check[j]=true;
				}
			} else if(now<next){
				for(int j=i; j>i-X; j--) {
					if(j<0 || map[j]!=now || check[j]) return 0;
					check[j]=true;
				}
			}
		}
		return 1;
	}
}
