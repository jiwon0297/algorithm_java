package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_종이의개수 {

	static int N;
	static int[][] map;
	static int cnt0;
	static int cnt_1;
	static int cnt1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		cnt0=0;
		cnt_1=0;
		cnt1=0;
		recur(0,0,N);
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt_1+"\n").append(cnt0+"\n").append(cnt1+"\n");
		System.out.println(sb.toString());
	}

	private static void recur(int r, int c, int size) {
		if(chk(r,c,size)==-1) {
			cnt_1++;
			return;
		} 
		if(chk(r,c,size)==0) {
			cnt0++;
			return;
		} 
		if(chk(r,c,size)==1) {
			cnt1++;
			return;
		} 
		
		int s=size/3;
		recur(r,c,s);
		recur(r,c+s,s);
		recur(r,c+2*s,s);
		recur(r+s,c,s);
		recur(r+s,c+s,s);
		recur(r+s,c+2*s,s);
		recur(r+2*s,c,s);
		recur(r+2*s,c+s,s);
		recur(r+2*s,c+2*s,s);
		
		
	}

	private static int chk(int r, int c, int size) {

		int num = map[r][c];
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(map[i][j]!=num) return -2;
			}
		}
		
		return num;
	}

}
