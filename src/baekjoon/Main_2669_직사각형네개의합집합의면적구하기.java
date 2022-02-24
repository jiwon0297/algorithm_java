package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2669_직사각형네개의합집합의면적구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[101][101];
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int j=y1; j<y2; j++) {
				for(int k=x1; k<x2; k++) {
					map[j][k]++;
				}
			}
		}
		
		int res=0;
		for(int i=0; i<=100; i++) {
			for(int j=0; j<=100; j++) {
				if(map[i][j]>0) res++;
			}
		}
		
		System.out.println(res);
	}

}
