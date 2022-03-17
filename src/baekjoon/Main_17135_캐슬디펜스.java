package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	
	static int N,M,D;
	static int[][] map;
	static int res;
	static ArrayList<int[]> enemy=new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) enemy.add(new int[] {i,j});
			}
		}
		
		combi(0,0,new int[3]);
		System.out.println(res);
	}

	private static void combi(int start , int cnt, int[] arr) {
		if(cnt==3) {
			int score=game(arr);
			res=Math.max(res, score);
			return ;
		}
		
		for(int i=start; i<M; i++) {
			arr[cnt]=i;
			combi(i+1, cnt+1, arr);
		}
	}

	private static int game(int[] arr) {
		int r=N;
		int cnt=0;
		boolean[] death = new boolean[enemy.size()];
		Arrays.fill(death, true);
		
		while(r>0) {
			int[][] kill = new int[3][2];
			
			for(int i=0; i<3; i++) {
				int dist=D;
				int[] cur = {r,arr[i]};
				kill[i][1]=M;
				kill[i][0]=-1;
				
				for(int j=0; j<death.length; j++) {
					if(!death[j]) continue;
					int[] e = enemy.get(j);
					int ad=distance(cur, e);
					if((ad==dist && e[1]<kill[i][1])||(ad<dist)) {
						dist=distance(cur,e);
						kill[i]=e;
					}
				}
			}
			
			r--;
			for(int i=0; i<death.length; i++) {
				for(int j=0; j<kill.length; j++) {
					if((kill[j][1]==enemy.get(i)[1]) && (kill[j][0]==enemy.get(i)[0]) && death[i]) {
						cnt++;
						death[i]=false;
					}
				}
				
				if(enemy.get(i)[0]==r) death[i]=false;
			}
		}
		return cnt;
	}

	private static int distance(int[] cur, int[] e) {
		return Math.abs(cur[0]-e[0])+Math.abs(cur[1]-e[1]);
	}


}
