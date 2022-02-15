package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2023_신기한소수 {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static boolean[] prime; // 3
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());		
		dfs("",0);
		System.out.println(sb);
	}

	private static void dfs(String num, int cnt) {
		if(cnt==N) {
			sb.append(num).append("\n");
			return;
		}
		
		for(int i=0; i<=9; i++) {
			String st = num+i;
			if(isPrime(Integer.parseInt(st))) dfs(st,cnt+1);
		}
	}

	private static boolean isPrime(int n) {
		if(n<2) return false;
		if(n==2) return true;

//		n보다 작은수로 나누기		
//		for(int i=2; i<n; i++) {
//			if(n%i==0) return false;
//		}
		
		
//		n의 제곱근보다 작은수로 나누기
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i==0) return false;
		}
		
		return true;
	}

}
