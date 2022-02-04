package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class S implements Comparable<S>{
	int num;
	int sco;
	
	public S(int num, int sco) {
		super();
		this.num = num;
		this.sco = sco;
	}

	@Override
	public int compareTo(S o) {
		if(this.sco > o.sco) return -1;
		else return 1;
	}
	
}

public class Main_2822_점수계산 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<S> score = new ArrayList<>();
		
		for(int i=1; i<=8; i++) {
			score.add(new S(i, sc.nextInt()));
		}
		
		Collections.sort(score);
		
		int total = 0;
		int[] rank = new int[5];
		for(int i=0; i<5; i++) {
			total+=score.get(i).sco;
			rank[i]=score.get(i).num;
		}
		
		Arrays.sort(rank);
		
		System.out.println(total);
		for(int i=0; i<5; i++) {
			System.out.print(rank[i]+" ");
		}
		
	}

}
