package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16927_배열돌리기2 {

	static int N;
	static int M;
	static int R;
	static int[][] arr;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int i, j, d = 0, nr;

		for (int idx = 0; idx < Math.min(N, M) / 2; idx++) {
			nr = R % ((N - idx * 2) * 2 + (M - idx * 2) * 2 - 4); // 새롭게 추가한 코드. 해당하는 테두리의 크기를 modulo 해주어, 반복 횟수를 줄인다.
			while (nr-- != 0) {
				i = idx;
				j = idx;
				d = 0;
				int tmp = arr[i][j];

				while (d != 4) {
					if (i + dr[d] < idx || i + dr[d] >= N - idx || j + dc[d] < idx || j + dc[d] >= M - idx) {
						d++;
						continue;
					}
					arr[i][j] = arr[i + dr[d]][j + dc[d]];
					i += dr[d];
					j += dc[d];
				}
				arr[idx + 1][idx] = tmp;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int a = 0; a < N; a++) {
			for (int b = 0; b < M; b++) {
				sb.append(arr[a][b]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}
}
