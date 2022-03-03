package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_12927_배수스위치 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int N = input.length();
		
		char[] arr = new char[N+1];
		for(int i=1; i<=N; i++) {
			arr[i]=input.charAt(i-1);
		}
		
		int cnt=0;
		for(int i=1; i<=N; i++) {
			if(arr[i]=='N') continue;
			cnt++;
			for(int j=i; j<=N; j+=i) {
				if(arr[j]=='N') arr[j]='Y';
				else if(arr[j]=='Y') arr[j]='N';
			}
		}
		
		System.out.println(cnt);
	}
}
