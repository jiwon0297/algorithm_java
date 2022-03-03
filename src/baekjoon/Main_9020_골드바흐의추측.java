package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9020_골드바흐의추측 {

	static boolean[] prime=new boolean[10001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			makePrime();
			
			int p = N/2;
			int q = N/2;
			
			while(!isPrime(p,q)) {
				p--;
				q++;
			}
			
			System.out.println(p+" "+q);
		}
	}

	private static boolean isPrime(int p, int q) {
		return prime[p]==false && prime[q]==false;
	}

	private static void makePrime() {
		prime[0]=prime[1]=true;
		
		for(int i=2; i<=Math.sqrt(10000); i++) {
			if(prime[i]) continue;
			
			for(int j=i+i; j<=10000; j+=i) {
				prime[j]=true;
			}
		}
	}

}
