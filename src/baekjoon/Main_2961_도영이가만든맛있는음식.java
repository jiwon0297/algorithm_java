package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {

	static int[] S;
	static int[] B;
	static int N;
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S=new int[N];
		B=new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S[i]=Integer.parseInt(st.nextToken());
			B[i]=Integer.parseInt(st.nextToken());
		}
		
		min=Integer.MAX_VALUE;
		
		subset(0,1,0,0);
		System.out.println(min);
	}
	
	private static void subset(int cnt, int Ssum, int Bsum, int c) {
		if(cnt==N) {
			int diff = Math.abs(Ssum-Bsum);
			if(diff<min && c!=0) min=diff;
			return ;
		}
		
		subset(cnt+1, Ssum*S[cnt], Bsum+B[cnt],c+1);
		subset(cnt+1, Ssum, Bsum, c);
	}

}
