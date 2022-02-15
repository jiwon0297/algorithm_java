package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {

	static int N,r,c, cnt;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map=new int[N][N];
		
		recur(0,0,(int)Math.pow(2,N));	
	}

	private static void recur(int row, int col, int size) {
		if(row==r && col==c) {
			System.out.println(cnt);
			return ;
		}
		
		if(row<=r && r<(row+size) && col<=c && c<(col+size)) {
			recur(row,col,size/2);
			recur(row,col+size/2,size/2);
			recur(row+size/2,col,size/2);
			recur(row+size/2,col+size/2,size/2);
		} else cnt+=size * size;
	}

}
