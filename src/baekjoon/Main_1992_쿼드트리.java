package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1992_쿼드트리 {

	static int[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String st = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j]=st.charAt(j)-'0';
			}
		}
		
		sb=new StringBuilder();
		tree(0,0,N);
		System.out.println(sb.toString());
	}

	private static void tree(int r, int c, int size) {
		
		if(chk(r,c,size)) {
			sb.append(map[r][c]);
			return ;
		}
		
		int s = size/2;
		sb.append("(");
		tree(r,c,s);
		tree(r,c+s,s);
		tree(r+s,c,s);
		tree(r+s,c+s,s);
		sb.append(")");
	}

	private static boolean chk(int r, int c, int size) {
		int a = map[r][c];
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(map[i][j]!=a) return false;
			}
		}
		return true;
	}

}
