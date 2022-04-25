package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_5604_구간합 {
	
	static long A,B;
	static long sum;
	static long[] cnt;
	static long point;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st= null;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			st=new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			
			cnt = new long[10];
			point=1;
			while(A<=B) {
				while(B%10!=9 && A<=B) {
					calc(B);
					B--;
				}
				if(B<A) break;
				
				while(A%10!=0 && A<=B) {
					calc(A);
					A++;
				}
				if(B<A) break;
				
				A/=10;
				B/=10;
				
				for(int i=0; i<10; i++) {
					cnt[i]+=(B-A+1)*point;
				}
				point*=10;
			}
			
			sum=0;
			for(int i=0; i<10; i++) {
				sum+=i*cnt[i];
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb.toString());
	}

	private static void calc(long x) {
		for(long i=x; i>0; i/=10) {
			String s = Long.toString(i);
			cnt[s.charAt(s.length()-1)-'0']+=point;
		}
	}

}
