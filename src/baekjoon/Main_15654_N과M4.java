package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654_N과M4 {
	
	static int[] p;
	static int N;
	static int M;
	static int[] nums;
	static boolean[] chk;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p=new int[N];
		chk=new boolean[N];
		nums = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			p[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p);

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
			if(chk[i]) continue;
			chk[i]=true;
			nums[cnt]=p[i];
			go(cnt+1);
			chk[i]=false;
		}
	}

}
