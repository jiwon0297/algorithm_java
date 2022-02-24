package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14696_딱지놀이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st=null;

		for(int t=0; t<N; t++) {
			st = new StringTokenizer(br.readLine());
			int A[] = new int[5];
			int B[] = new int[5];
			int a = Integer.parseInt(st.nextToken());
			for(int i=0; i<a; i++) {
				A[Integer.parseInt(st.nextToken())]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			for(int i=0; i<b; i++) {
				B[Integer.parseInt(st.nextToken())]++;
			}
			
			boolean isFinish=false;
			for(int i=4; i>0; i--) {
				if(A[i]>B[i]) {
					System.out.println("A");
					isFinish=true;
					break ;
				}
				
				if(A[i]<B[i]) {
					System.out.println("B");
					isFinish=true;
					break ;
				}
			}
			if(!isFinish) System.out.println("D");
		}
	}
}
