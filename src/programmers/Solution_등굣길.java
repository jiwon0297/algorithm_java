package programmers;

//시간복잡도 O(2^(n*m))
public class Solution_등굣길 {
	public static int solution(int m, int n, int[][] puddles) {
		int[][] dp = new int[n + 1][m + 1];
		boolean[][] isPuddles = new boolean[n + 1][m + 1];

		for (int i = 0; i < puddles.length; i++) {
			isPuddles[puddles[i][1]][puddles[i][0]] = true;
		}

		for (int i = 1; i <= n; i++) {
			if (isPuddles[i][1]) break;
			dp[i][1] = 1;
		}

		for (int i = 1; i <= m; i++) {
			if (isPuddles[1][i]) break;
			dp[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= m; j++) {
				if (isPuddles[i][j]) continue;
				dp[i][j] = ((dp[i - 1][j] % 1000000007) + (dp[i][j - 1] % 1000000007)) % 1000000007;
			}
		}
		return dp[n][m];
	}
}
