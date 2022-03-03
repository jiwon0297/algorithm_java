package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7236_저수지의물의총깊이구하기 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			
			StringTokenizer st = null;
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=st.nextToken().charAt(0);
				}
			}
			
			int[] dr= {0,1,1,1,0,-1,-1,-1};
			int[] dc= {1,1,0,-1,-1,-1,0,1};
			
			int max=1;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]=='W') {
						int cnt=0;
						int cr=i;
						int cc=j;
						for(int d=0; d<8; d++) {
							int nr=cr+dr[d];
							int nc=cc+dc[d];
							
							if(!chk(nr,nc)) continue;
							if(map[nr][nc]=='W') cnt++;
						}
						
						if(cnt>max) max=cnt;
					}
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}

	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}

}
