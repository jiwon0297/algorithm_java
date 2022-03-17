package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2331_반복수열 {
	
	static int A,P;
	static ArrayList<Integer> D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		D=new ArrayList<>();
		D.add(A);
		
		int cnt=0;
		while(true) {
			String num = Integer.toString(D.get(cnt));
			int sum=0;
			for(int i=0; i<num.length(); i++) {
				sum+=Math.pow((num.charAt(i)-'0'),P);
			}
			
			if(D.contains(sum)) {
				int ans=D.indexOf(sum);
				System.out.println(ans);
				break;
			}
			
			D.add(sum);
			cnt++;
		}
	}

}
