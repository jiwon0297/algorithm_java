package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2491_수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		
		int cnt1=0;
		int cnt2=0;
		int max=Integer.MIN_VALUE;
		
		if(N==1) {
			System.out.println(1);
			return ;
		}
		
		for(int i=0; i<N-1; i++) {
			if(num[i]>num[i+1]) {
				cnt1++;
				cnt2=0;
			}
			else if(num[i]<num[i+1]) {
				cnt2++;
				cnt1=0;
			} else {
				cnt1++;
				cnt2++;
			}

			if(max<cnt1) max=cnt1;
			if(max<cnt2) max=cnt2;
		}
		
		System.out.println(max+1);
	}

}
