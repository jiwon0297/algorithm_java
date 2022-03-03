package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1493_수의새로운연산 {
	
	static int[][] map=new int[401][401];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		//좌표만들기 
		map[1][1]=1;
		for(int i=2; i<=400; i++) {
			map[i][1]=map[i-1][1]+(i-1);
		}
		for(int i=1; i<=400; i++) {
			for(int j=2; j<=400; j++) {
				map[i][j]=map[i][j-1]+i+j-1;
			}
		}
		
		for(int t=1; t<=T; t++) {
			st=new StringTokenizer(br.readLine());
			int p=Integer.parseInt(st.nextToken());
			int q=Integer.parseInt(st.nextToken());
			int px=0, py=0;
			int qx=0, qy=0;
			boolean isp=false;
			boolean isq=false;
			
			for(int i=1; i<=400; i++) {
				for(int j=1; j<=400; j++) {
					if(map[i][j]==p) {
						isp=true;
						py=i;
						px=j;
					}
					
					if(map[i][j]==q) {
						isq=true;
						qy=i;
						qx=j;
					}
					
					if(isp && isq) break;
				}
				if(isp && isq) break;
			}
			System.out.println("#"+t+" "+map[py+qy][px+qx]);
		}
	}
}
