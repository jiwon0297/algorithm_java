package swea;

import java.util.Scanner;

//다시 하기
public class Solution_D2_2001_파리퇴치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int max = -2147000000;
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int sum = 0;
					for (int a = 0; a < M; a++) {
						for (int b = 0; b < M; b++) {
							sum += map[i+a][j+b];

						}
						if (sum > max)
							max = sum;
					}
				}
			}
			System.out.println("#"+t+" "+max);
		}

	}

}
