package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2239_스도쿠 {

	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map=new int[9][9];
		for(int i=0; i<9; i++) {
			String str = br.readLine();
			for(int j=0; j<9; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		
		sudoku(0,0);
	}

	private static void sudoku(int r, int c) {
		if(c==9) {
			sudoku(r+1,0);
			return ;
		}
		
		if(r==9) {
			printMap(map);
			System.exit(0);
		}
		
		if(map[r][c]==0) {
			for(int i=1; i<=9; i++) {
				if(!ischk(r,c,i)) continue;
				map[r][c]=i;
				sudoku(r,c+1);
			}
			map[r][c]=0;
			return ;
		}
		
		sudoku(r,c+1);
	}

	private static void printMap(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static boolean ischk(int r, int c, int x) {
		for(int i=0; i<9; i++) {
			if(map[i][c]==x) return false;
			if(map[r][i]==x) return false;
		}

		for(int i=(r/3)*3; i<(r/3)*3+3; i++) {
			for(int j=(c/3)*3; j<(c/3)*3+3; j++){
				if(map[i][j]==x) return false;
			}
		}
		
		return true;
	}

}
