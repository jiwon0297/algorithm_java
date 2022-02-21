package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2231_분해합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int a=1;
		
		while(a<N) {
			int sum=a;
			String st = Integer.toString(a);
			
			for(int i=0; i<st.length(); i++) {
				sum+=(st.charAt(i)-'0');
			}
			
			if(sum==N) {
				System.out.println(a);
				return;
			}
			
			a++;
		}
		
		System.out.println(0);
	}

}
