package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2012_등수매기기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] rank = new int[N+1];
		for(int i=1; i<=N; i++) {
			rank[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(rank);
		
		long res =0;
		for(int i=1; i<=N; i++) {
			res+=Math.abs(rank[i]-i);
		}
		
		System.out.println(res);
	}

}
