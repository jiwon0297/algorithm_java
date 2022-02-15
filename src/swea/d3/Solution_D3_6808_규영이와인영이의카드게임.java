package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D3_6808_규영이와인영이의카드게임 {

	static List<Integer> kyu;
	static List<Integer> in;
	static int[] nums;
	static int[] card;
	static boolean[] chk;
	static int lose;
	static int win;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			card = new int[18];
			kyu = new ArrayList<>();
			in = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				kyu.add(Integer.parseInt(st.nextToken()));
				card[kyu.get(i) - 1]++;
			}

			for (int i = 0; i < 18; i++) {
				if (card[i] == 0)
					in.add(i + 1);
			}

			nums = new int[9];
			chk = new boolean[9];
			
			lose = 0;
			win = 0;
			perm(0, 0, 0);
			System.out.println("#"+t+" "+win+" "+lose);
		}
	}

	private static void perm(int cnt, int ksum, int isum) {
		if (cnt == 9) {
			if (ksum < isum) lose++;
			else if (ksum > isum) win++;
			
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (chk[i]) continue;
			
			chk[i] = true;
			nums[cnt] = in.get(i);
			if (nums[cnt] > kyu.get(cnt)) perm(cnt + 1, ksum, isum + nums[cnt] + kyu.get(cnt));
			else if (nums[cnt] < kyu.get(cnt)) perm(cnt + 1, ksum + nums[cnt] + kyu.get(cnt), isum);
			chk[i] = false;
		}
	}

}
