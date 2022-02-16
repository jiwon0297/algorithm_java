package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1929_소수구하기 {
	
	static boolean[] prime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		
		makePrime(N);
		
		for(int i=M; i<=N; i++) {
			if(!prime[i]) System.out.println(i);
		}
	}

	private static void makePrime(int n) {
		prime=new boolean[n+1];
		if(n<2) return;
		prime[0]=prime[1]=true;
		
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(prime[i]) continue;
			
			for(int j=i+i; j<prime.length; j+=i) {
				prime[j]=true;
			}
		}
	}

}
