package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Score implements Comparable<Score>{
	String name;
	int kor;
	int eng;
	int math;
	
	Score(String name, int kor, int eng, int math) {
		super();
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}

	@Override
	public int compareTo(Score o) {
		if(this.kor>o.kor) return -1;
		else if(this.kor==o.kor) {
			if(this.eng<o.eng) return -1;
			else if(this.eng==o.eng) {
				if(this.math>o.math) return -1;
				else if(this.math==o.math) {
					if(this.name.compareTo(o.name)<0) return -1;
					else return 1;
				}
			}
		}
		return 1;
	}
}

public class Main_10825_국영수 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		ArrayList<Score> scores = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String name = sc.next();
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int math = sc.nextInt();
			
			scores.add(new Score(name, kor, eng, math));
		}
		
		Collections.sort(scores);
		
		for(Score i : scores) {
			System.out.println(i.name);
		}
	}

}


