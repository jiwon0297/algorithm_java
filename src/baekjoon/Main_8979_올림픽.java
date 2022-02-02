package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

class Pair implements Comparable<Pair> {

	int nationNum;
	int gold;
	int silver;
	int bronze;
	int rank;

	Pair(int nationNum, int gold, int silver, int bronze) {
		this.nationNum = nationNum;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
		this.rank = 1;
	}

	@Override
	public int compareTo(Pair o) {
		if (this.gold > o.gold) return -1;
		else if (this.gold == o.gold) {
			if (this.silver > o.silver) return -1;
			else if (this.silver == o.silver) {
				if (this.bronze > o.bronze) return -1;
				else if (this.bronze == o.bronze) return 0;
			}
		}
		return 1;
	}

}

public class Main_8979_올림픽 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		Pair[] pair = new Pair[N];
		for (int i = 0; i < N; i++) {
			int nation = sc.nextInt();
			int gold = sc.nextInt();
			int silver = sc.nextInt();
			int bronze = sc.nextInt();

			pair[i] = new Pair(nation, gold, silver, bronze);
		}

		Arrays.sort(pair);
		calRank(pair);

		for (int i = 0; i < N; i++) {
			if (pair[i].nationNum == K) {
				System.out.println(pair[i].rank);
				break;
			}
		}
	}

	public static void calRank(Pair[] pair) {
		for (int i = 1; i < pair.length; i++) {
			if (pair[i].gold == pair[i - 1].gold && pair[i].silver == pair[i - 1].silver
					&& pair[i].bronze == pair[i - 1].bronze) {
				pair[i].rank = pair[i - 1].rank;
			} else
				pair[i].rank = i + 1;
		}
	}

}
