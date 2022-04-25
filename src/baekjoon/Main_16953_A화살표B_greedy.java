package baekjoon;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_16953_A화살표B_greedy {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int ans=1;
		while(B!=A) {
			if(B<A) {
				ans=-1;
				break;
			}
			
			if(B%10!=1 && B%2!=0) {
				ans=-1;
				break;
			}
			
			if(B%2==0) B/=2;
			else B=(B-1)/10;
			
			ans++;
		}
		
		System.out.println(ans);
	}

}
