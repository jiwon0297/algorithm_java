package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16571_알파틱택토 {

	static int[][] tictacto;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tictacto = new int[3][3];
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				tictacto[i][j] = Integer.parseInt(st.nextToken());
				if (tictacto[i][j] == 1 || tictacto[i][j] == 2)
					cnt++;
			}
		}

		int res = 0;
		if (cnt % 2 == 0) res = game(1); // X차례
		else res = game(2); // O차례

		if (res == 1) System.out.println("W");
		else if (res == 0) System.out.println("D");
		else System.out.println("L");
	}

	private static int game(int x) {
		int min = 2; // 상대방
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tictacto[i][j] == 0) {
					tictacto[i][j] = x;
					if (isWin(x)) min = Math.min(min, -1);
					min = Math.min(min, game(x == 1 ? 2 : 1));
					tictacto[i][j] = 0;
				}
			}
		}

		if (min == 1)
			return -1;
		else if (min == 0 || min == 2)
			return 0;
		else
			return 1;
	}

	private static boolean isWin(int x) {
		//가로
		for (int i = 0; i < 3; i++) {
			if(tictacto[i][0]==x && tictacto[i][0]==tictacto[i][1] &&
					tictacto[i][1]==tictacto[i][2]) return true;
		}
		
		//세로
		for (int i = 0; i < 3; i++) {
			if(tictacto[0][i]==x && tictacto[0][i]==tictacto[1][i] &&
					tictacto[1][i]==tictacto[2][i]) return true;
		}
		
		//대각선
		if(tictacto[0][0]==x && tictacto[0][0]==tictacto[1][1] && tictacto[1][1]==tictacto[2][2]) return true; 
		if(tictacto[0][2]==x && tictacto[0][2]==tictacto[1][1] && tictacto[1][1]==tictacto[2][0]) return true;
		
		return false;
	}

}
