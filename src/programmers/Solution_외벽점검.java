package programmers;

class Solution_외벽점검 {

	static int answer = -1;
	static int[] spreadWeak;
	static int weaklen;

	public static int solution(int n, int[] weak, int[] dist) {
		weaklen = weak.length;
		spreadWeak = spreadPoint(n, weak);
		for (int i = 1; i <= dist.length; i++) {
			perm(0, i, dist, new boolean[dist.length], new int[i]);
		}
		return answer;
	}

	private static void perm(int cnt, int idx, int[] dist, boolean[] visited, int[] num) {
		if (answer != -1) return ;
		if (cnt == idx) {
			chk(num);
			return;
		}

		for (int i = 0; i < dist.length; i++) {
			if (visited[i]) continue;
			num[cnt] = dist[i];
			visited[i] = true;
			perm(cnt + 1, idx, dist, visited, num);
			visited[i] = false;
		}
	}

	private static void chk(int[] res) {
		outer: for (int i = 0; i < weaklen; i++) {
			int start = i;
			int f = 0;
			for (int j = i; j < i + weaklen; j++) {
				if (spreadWeak[j] - spreadWeak[start] > res[f]) {
					start = j;
					f++;
				}
				if (f == res.length) continue outer;
			}
			answer = res.length;
			return;
		}
	}

	private static int[] spreadPoint(int n, int[] weak) {
		int[] spread = new int[weak.length * 2 - 1];
		for (int i = 0; i < weak.length; i++) {
			spread[i] = weak[i];
		}
		for (int i = 0; i < weak.length - 1; i++) {
			spread[i + weak.length] = weak[i] + n;
		}
		return spread;
	}

}