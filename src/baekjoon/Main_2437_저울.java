package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2437_저울 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] choo = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			choo[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(choo);
		int sum=0;
		for(int i=0; i<N; i++) {
			if(sum+1<choo[i]) break;
			sum+=choo[i];
		}
		
		System.out.println(sum+1);
	}

}
