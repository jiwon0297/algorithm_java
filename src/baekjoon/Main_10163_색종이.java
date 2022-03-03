package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_10163_색종이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[1002][1002];
		StringTokenizer st = null;
		ArrayList<int[]> point = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int wid = Integer.parseInt(st.nextToken());
			int hei = Integer.parseInt(st.nextToken());
			
			point.add(new int[] {x,y,wid,hei});
			
			for(int r=y; r<y+hei; r++) {
				for(int c=x; c<x+wid; c++) {
					map[r][c]=i;
				}
			}
		}
		
		for(int i=0; i<point.size(); i++) {
			int x = point.get(i)[0];
			int y = point.get(i)[1];
			int wid = point.get(i)[2];
			int hei = point.get(i)[3];
			
			int cnt=0;
			for(int r=y; r<y+hei; r++) {
				for(int c=x; c<x+wid; c++) {
					if(map[r][c]==i) cnt++;
				}
			}	
			System.out.println(cnt);	
		}
	}
}
