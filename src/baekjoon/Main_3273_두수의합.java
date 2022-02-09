package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3273_두수의합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine());
		
		Arrays.parallelSort(a);
		
		int cnt=0;
		int left=0;
		int right=n-1;
		int sum=0;
		
		while(left<right) {
			sum=a[left]+a[right];
			if(sum==x) cnt++;
			if(sum<=x) left++;
			else right--;
		}
		
		System.out.println(cnt);
	}

}
