package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047_동전0 {

	static int[] coin;
	static int N,K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coin = new int[N];
		
		for(int i=0; i<N; i++) {
			coin[i]=Integer.parseInt(br.readLine());
		}
		
		int cnt=0;
		for(int i=N-1; i>=0 && K>0 ; i--) {
			cnt+=K/coin[i];
			K=K%coin[i];
		}
		
		System.out.println(cnt);
	}


}
