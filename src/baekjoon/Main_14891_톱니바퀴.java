package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[4][8];
		for(int i=0; i<4; i++) {
			String str = br.readLine();
			for(int j=0; j<8; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			int[] d = new int[4];
			d[num]=dir;
			
			for(int j=num+1; j<4; j++) {
				if(map[j-1][2]==map[j][6]) break;
				else d[j]=-d[j-1];
			}
			
			for(int j=num-1; j>=0; j--) {
				if(map[j][2]==map[j+1][6]) break;
				else d[j]=-d[j+1];
			}
			
			int[][] copy = new int[4][8];
			for(int j=0; j<4; j++) {
				if(d[j]==0) continue;
				if(d[j]==1) {
					for(int k=1; k<=7; k++) {
						copy[j][k]=map[j][k-1];
					}
					copy[j][0]=map[j][7];
				}
				if(d[j]==-1) {
					for(int k=0; k<7; k++) {
						copy[j][k]=map[j][k+1];
					}
					copy[j][7]=map[j][0];
				}
				map[j]=copy[j];
			}
		}
		
		int sum=0;
		if(map[0][0]==1) sum+=1;
		if(map[1][0]==1) sum+=2;
		if(map[2][0]==1) sum+=4;
		if(map[3][0]==1) sum+=8;
		System.out.println(sum);
	} 

}
