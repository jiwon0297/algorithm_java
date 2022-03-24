package programmers;

public class Solution_1 {
	public int solution(int k, int m, String[] names, int[] amounts) {
		int answer = 0;

		int j = 1;
		if (amounts[0] >= m)
			answer++;
		for (int i = 1; i < names.length; i++) {
			if (names[i].equalsIgnoreCase(names[i - 1]))
				j++;
			else
				j = 1;

			if (j >= k || amounts[i] >= m)
				answer++;
		}
		return answer;
	}
}
