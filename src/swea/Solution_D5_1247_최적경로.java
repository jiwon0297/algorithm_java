package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 {

	static int T,N;
	static int[][] map;
	static int min;
	static int res[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map=new int[N+2][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<2; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			//0회사 1MyHome -> 고객 2 3 4 N+1
			min=Integer.MAX_VALUE;
			res=new int[N];
			npr(0, new boolean[N]);
			System.out.println("#"+t+" "+min);
			
		}
	}

	//순열
	private static void npr(int cnt, boolean[] v) {
		if(cnt==N) { //모든 고객 방문
			int start = res[0];
			int end = res[N-1];
			int dis = dist(0,start)+dist(1,end);
			
			for(int i=0; i<N-1; i++) {
				dis += dist(res[i],res[i+1]);
			}
			
			if(dis<min) min=dis;
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(v[i]) continue;
			v[i]=true;
			res[cnt]=i+2;
			npr(cnt+1, v);
			v[i]=false;
		}
	}
	
	private static int dist(int start, int end) {
		return Math.abs(map[start][0]-map[end][0])+Math.abs(map[start][1]-map[end][1]);
	}

}
