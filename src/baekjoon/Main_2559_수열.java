package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2559_수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] temperature = new int[N];
		int max=Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			temperature[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<=N-K; i++) {
			int sum=0;
			for(int j=i; j<i+K; j++) {
				sum+=temperature[j];
			}
			max=Math.max(max, sum);
		}
		System.out.println(max);
	}
}
