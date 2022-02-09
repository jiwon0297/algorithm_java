package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2798_블랙잭 {

	static int max;
	static int[] card;
	static int M;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		card = new int[N];	
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			card[i]=Integer.parseInt(st.nextToken());
		}
		
		max=-1;
		combi(0,0,0);

		System.out.println(max);
	}

	private static void combi(int cnt, int start, int sum) {
		if(cnt==3) {
			if(sum<=M && sum>max) max=sum;
			return;
		}
		
		for(int i=start; i<N; i++) {
			combi(cnt+1, i+1, sum+card[i]);
		}
	}

}
