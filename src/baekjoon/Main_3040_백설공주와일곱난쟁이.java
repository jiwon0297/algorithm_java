package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3040_백설공주와일곱난쟁이 {

	static int p[];
	static int nums[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		p = new int[9];
		nums = new int[7];
		for(int i=0; i<9; i++) {
			p[i]=Integer.parseInt(br.readLine());
		}
		
		sb=new StringBuilder();
		combi(0,0,0);
		System.out.println(sb);
	}

	private static void combi(int cnt, int start, int sum) {
		if(cnt==7) {
			if(sum==100) {
				for(int i=0; i<7; i++) {
					sb.append(nums[i]).append('\n');
				}
			}
			return ;
		}
		
		for(int i=start; i<9; i++) {
			nums[cnt]=p[i];
			combi(cnt+1,i+1,sum+p[i]);
		}
	}

}
