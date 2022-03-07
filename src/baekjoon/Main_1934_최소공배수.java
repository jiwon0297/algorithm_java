package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1934_최소공배수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for(int t=1; t<=T; t++) {
			st=new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int res =최소공배수(A,B);
			System.out.println(res);
		}
	}

	private static int 최소공배수(int a, int b) {
		return a*b/최대공약수(a,b); // A*B = 최대공배수*최대공약수 
	}

	private static int 최대공약수(int a, int b) {
		if(b==0) return a;
		else return 최대공약수(b,a%b); //a,b 최대공약수는 b, a%b의 최대공약수와 같음 
	}

}
