package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15651_N과M3 {
	
	static int N;
	static int M;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		nums=new int[M];
		
		go(0);
		System.out.println(sb);
	}

	private static void go(int cnt) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				sb.append(nums[i]).append(' ');
			}
			sb.append('\n');
			return ;
		}
		
		for(int i=0; i<N; i++) {
			nums[cnt]=i+1;
			go(cnt+1);
		}
	}
	
	

}
