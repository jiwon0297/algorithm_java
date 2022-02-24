package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2635_수이어가기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int max=0;
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			ArrayList<Integer> num = new ArrayList<>();
			num.add(N);
			num.add(i);
			int prev1=N;
			int prev2=i;
			
			while(true) {
				int tmp=prev1-prev2;
				if(tmp>=0) num.add(tmp);
				else break;
				prev1=prev2;
				prev2=tmp;
			}
			if(max<num.size()) {
				max=num.size();
				result=num;
			}
		}
		
		System.out.println(max);
		for(int i: result) {
			System.out.print(i+" ");
		}
	}

}
