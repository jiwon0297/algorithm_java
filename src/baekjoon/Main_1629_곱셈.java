package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629_곱셈 {
	
	static int C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(recur(A,B));
	}
	
	private static long recur(long A, long B) {
		if(B==1) {
			return A%C;
		}
		
		long tmp = recur(A,B/2);
		
		if(B%2==1) {
			return (tmp * tmp)% C * A % C;
		}
		
		return tmp*tmp %C;
	}

}
