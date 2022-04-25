package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {

	static int T,K;
	static int[][] map;
	static int[] score = {1,2,4,8};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		T=Integer.parseInt(br.readLine());
	
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			K=Integer.parseInt(br.readLine());
			map=new int[4][8];
			for(int i=0; i<4; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<K; i++) {
				st=new StringTokenizer(br.readLine());
				int mag = Integer.parseInt(st.nextToken())-1;
				int d = Integer.parseInt(st.nextToken());
				
				int[] dir = new int[4];
				dir[mag]=d;
				
				for(int j=mag+1; j<4; j++) {
					if(map[j-1][2]==map[j][6]) break;
					else dir[j]=-dir[j-1];
				}
				
				for(int j=mag-1; j>=0; j--) {
					if(map[j][2]==map[j+1][6]) break;
					else dir[j]=-dir[j+1];
				}
				
				for(int j=0; j<4; j++) {
					if(dir[j]==0) continue;
					map[j]=rotate(map[j],dir[j]);
				}
			}
			
			int res=0;
			for(int i=0; i<4; i++) {
				if(map[i][0]==1) res+=score[i];
			}
			sb.append(res+"\n");
		}
		System.out.println(sb.toString());
	}

	private static int[] rotate(int[] mag1, int dir) {
		int[] res = new int[8];
		if(dir==1) {
			for(int i=1; i<8; i++) {
				res[i]=mag1[i-1];
			}
			res[0]=mag1[7];
		} else if(dir==-1) {
			for(int i=0; i<7; i++) {
				res[i]=mag1[i+1];
			}
			res[7]=mag1[0];
		}
		return res;
	}

}
