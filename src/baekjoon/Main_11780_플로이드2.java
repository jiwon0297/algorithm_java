package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_11780_플로이드2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] dosi = new int[n+1][n+1];
		long[][] dist = new long[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				dosi[i][j]=-1;
				if(i==j) continue;
				dist[i][j]=Integer.MAX_VALUE;
			}
		}
		
		StringTokenizer st = null;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dist[a][b]=Math.min(dist[a][b],c);
			dosi[a][b]=a;
		}
		
		//플로이드와샬
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(dist[i][j]>dist[i][k]+dist[k][j]) {
						dist[i][j]=dist[i][k]+dist[k][j];
						dosi[i][j]=dosi[k][j];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		//map출력 
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(dist[i][j]>=Integer.MAX_VALUE) sb.append("0 ");
				else sb.append(dist[i][j]+" ");
			}
			sb.append("\n");
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(dosi[i][j]==-1) sb.append("0\n");
				else {
					//역추적해서 스택에 담기
					Stack<Integer> s = new Stack<>();
					int to = j;
					s.add(to);
					
					while(i!=dosi[i][to]) {
						to=dosi[i][to];
						s.add(to);
					}
					
					sb.append(s.size()+1+" ");
					sb.append(i+" ");
					while(!s.isEmpty()) sb.append(s.pop()+" ");
					sb.append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
