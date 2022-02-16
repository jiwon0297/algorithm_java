package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2875_대회or인턴 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int res=0;
		res=Math.min(N/2, M);
		int num = N-(2*res) + M-res;
		K=K-num;
		
		if(K>0) {
			while(K>0) {
				res--;
				K-=3;
			}
		}
		
		System.out.println(res);
	}

}
