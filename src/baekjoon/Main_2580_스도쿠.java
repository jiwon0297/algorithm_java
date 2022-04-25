package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//18100KB 388ms
public class Main_2580_스도쿠 {
	
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		map = new int[9][9];
		for(int i=0; i<9; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
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
				if(!isChk(r,c,i)) continue;
				map[r][c]=i;
				sudoku(r,c+1);
			}
			map[r][c]=0;
			return;
		}
		
		sudoku(r,c+1);
	}
	
	private static void printMap(int[][] map) {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static boolean isChk(int r, int c, int x) {
		//행,열 
		for(int i=0; i<9; i++) {
			if(map[r][i]==x) return false;
			if(map[i][c]==x) return false;
		}
		
		//9칸
		int r_pos = (r/3)*3;
		int c_pos = (c/3)*3;
		for(int i=r_pos; i<r_pos+3; i++) {
			for(int j= c_pos; j<c_pos+3; j++) {
				if(map[i][j]==x) return false;
			}
		}
	
		return true;
	}

}
