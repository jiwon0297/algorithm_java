package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합 {
	
	static int N,S, res;
	static int[] num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		num = new int[N];
		for(int i=0; i<N; i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		
		res=0;
		subset(0,0);
		System.out.println(S==0? res-1 : res);
		
	}

	private static void subset(int idx, int sum) {
		if(idx==N) {
			if(sum==S) res++;
			return ;
		}
		
		subset(idx+1, sum+num[idx]);
		subset(idx+1, sum);
	}

}
