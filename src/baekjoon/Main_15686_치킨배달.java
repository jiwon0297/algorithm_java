package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {

	static int N,M,min;
	static int[][] map;
	static ArrayList<int[]> chicken;
	static ArrayList<int[]> person;
	static boolean[] open;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map=new int[N][N];
		chicken=new ArrayList<>();
		person=new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					chicken.add(new int[] {i,j});
				}
				if(map[i][j]==1) {
					person.add(new int[] {i,j});
				}
			}
		}
		
		open=new boolean[chicken.size()];
		min=Integer.MAX_VALUE;
		dfs(0,0);
		System.out.println(min);
	}
	
	private static void dfs(int start, int cnt) {
		if(cnt==M) {
			int res=0;
			for(int i=0; i<person.size(); i++) {
				int dis=Integer.MAX_VALUE;
				for(int j=0; j<chicken.size(); j++) {
					if(open[j]) {
						dis=Math.min(dis, dist(person.get(i),chicken.get(j)));
					}
				}
				res+=dis;
			}
			min=Math.min(min, res);
			return ;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			if(!open[i]) {
				open[i]=true;
				dfs(i+1, cnt+1);
				open[i]=false;
			}
		}
		
	}

	public static int dist(int[] p1, int[] p2) {
		return Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
	}

}
