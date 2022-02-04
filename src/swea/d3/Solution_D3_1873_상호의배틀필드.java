package swea.d3;

import java.util.Scanner;

public class Solution_D3_1873_상호의배틀필드 {

	static int T;
	static int H, W;
	static char[][] map;

	static int r;
	static int c;
	static int d;

	public static void main(String[] args) {

		Scanner scc = new Scanner(System.in);
		T = scc.nextInt();

		for (int t = 1; t <= T; t++) {
			H = scc.nextInt();
			W = scc.nextInt();
			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				char[] cs = scc.next().toCharArray();
				for (int j = 0; j < W; j++) {
					map[i][j] = cs[j];

					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						r = i;
						c = j;
					}

					switch (map[i][j]) {
					case '^':
						d = 0;
						break;
					case 'v':
						d = 1;
						break;
					case '<':
						d = 2;
						break;
					case '>':
						d = 3;
						break;
					}
				}
			}

			int N = scc.nextInt();
			String S = scc.next();

			for (int i = 0; i < N; i++) {
				go(map, S.charAt(i));
			}

			System.out.print("#" + t + " ");
			print(map);
		}

	}

	private static void print(char[][] map2) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map2[i][j]);
			}
			System.out.println();
		}
	}

	private static void go(char[][] tank, char ch) {
		int idx = 0;
		switch (ch) {
		case 'U':
			d = 0;
			tank[r][c] = '^';

			if (r > 0 && tank[r - 1][c] == '.') {
				tank[r - 1][c] = tank[r][c];
				tank[r][c] = '.';
				r -= 1;
			}

			break;

		case 'D':
			d = 1;
			tank[r][c] = 'v';

			if (r < H - 1 && tank[r + 1][c] == '.') {
				tank[r + 1][c] = tank[r][c];
				tank[r][c] = '.';
				r += 1;
			}
			break;

		case 'L':
			d = 2;
			tank[r][c] = '<';

			if (c > 0 && tank[r][c - 1] == '.') {
				tank[r][c - 1] = tank[r][c];
				tank[r][c] = '.';
				c -= 1;
			}
			break;

		case 'R':
			d = 3;
			tank[r][c] = '>';

			if (c < W - 1 && tank[r][c + 1] == '.') {
				tank[r][c + 1] = tank[r][c];
				tank[r][c] = '.';
				c += 1;
			}
			break;

		case 'S':
			switch (d) {
			case 0:
				idx = r;
				while (true) {
					if (idx - 1 < 0 || tank[idx - 1][c] == '#')
						break;
					if (tank[idx - 1][c] == '*') {
						tank[idx - 1][c] = '.';
						break;
					}
					idx--;
				}
				break;

			case 1:
				idx = r;
				while (true) {
					if (idx + 1 >= H || tank[idx + 1][c] == '#')
						break;
					if (tank[idx + 1][c] == '*') {
						tank[idx + 1][c] = '.';
						break;
					}
					idx++;
				}
				break;

			case 2:
				idx = c;
				while (true) {
					if (idx - 1 < 0 || tank[r][idx - 1] == '#')
						break;
					if (tank[r][idx - 1] == '*') {
						tank[r][idx - 1] = '.';
						break;
					}
					idx--;
				}
				break;

			case 3:
				idx = c;
				while (true) {
					if (idx + 1 >= W || tank[r][idx + 1] == '#')
						break;
					if (tank[r][idx + 1] == '*') {
						tank[r][idx + 1] = '.';
						break;
					}
					idx++;
				}
				break;

			}

		default:
			break;
		}
	}

}
