package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {
	
	static int N;
	static int[][] map;
	static int white, blue;

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
		
		white=0;
		blue=0;
		recur(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
	}

	private static void recur(int row, int col, int size) {
		
		if(chk(row,col,size)) {
			if(map[row][col]==0) white++;
			else blue++;
			
			return;
		}
		
		recur(row,col,size/2);
		recur(row+size/2,col,size/2);
		recur(row,col+size/2,size/2);
		recur(row+size/2,col+size/2,size/2);
	}

	private static boolean chk(int row, int col, int size) {
		int color = map[row][col];
		
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				if(map[i][j]!=color) return false;
			}
		}
		
		return true;
	}

}
