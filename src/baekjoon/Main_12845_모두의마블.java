package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12845_모두의마블 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max=Integer.MIN_VALUE;
		int sum=0;
		for(int i=0; i<n; i++) {
			int c = Integer.parseInt(st.nextToken());
			if(max<c) {
				max=c;
			}
			sum+=c;
		}
		sum+=max*(n-2);
		System.out.println(sum);
	}

}
