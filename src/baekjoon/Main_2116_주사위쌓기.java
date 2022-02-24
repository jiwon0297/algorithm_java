package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2116_주사위쌓기 {

	static int N,res;
	static int[][] dice;
	static boolean[][] visited;
	static int[] opp= {0, 6, 4, 5, 2, 3, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dice=new int[N][7];
		
		StringTokenizer st=null;
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1; j<=6; j++) {
				dice[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		res=0;
		solve();
		System.out.println(res);
	}
	
	private static void solve() {
		int up=0;
		//위아래만 방문체크 
		for(int num=1; num<=6; num++) {
			visited=new boolean[N][7];
			for(int i=1; i<=6; i++) {
				if(dice[0][i]==num) {
					up=dice[0][i];
					visited[0][i]=visited[0][opp[i]]=true;
					break;
				}
			}
			
			//쌓기
			for(int i=1; i<N; i++) {
				for(int j=1; j<=6; j++) {
					if(dice[i][j]==up) {
						up=dice[i][opp[j]];
						visited[i][j]=visited[i][opp[j]]=true;
						break;
					}
				}
			}
			
			res=Math.max(res, sum());
		}
	}

	//옆면의 최대값들 더하기 
	private static int sum() {
		int s=0;
		for(int i=0; i<N; i++) {
			int max=0;
			for(int j=1; j<=6; j++) {
				if(!visited[i][j]) max=Math.max(max, dice[i][j]);
			}
			s+=max;
		}
		return s;
	}

}
