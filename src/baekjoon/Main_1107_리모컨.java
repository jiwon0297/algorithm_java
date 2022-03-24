package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107_리모컨 {
	
	static boolean[] broken;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		broken = new boolean[10];
		if(M>0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		int min=Math.abs(N-100);
		for(int i=0; i<1000000; i++) {
			int len = chk(i);
			if(len>0) {
				int cnt=Math.abs(N-i);
				min=Math.min(min,cnt+len);
			}
		}
		
		System.out.println(min);
	}

	private static int chk(int n) {
		if(n==0) {
			if(broken[0]) return 0;
			else return 1;
		}
		
		int len=0;
		while(n>0) {
			if(broken[n%10]) return 0;
			n/=10;
			len+=1;
		}
		return len;
	}

}
