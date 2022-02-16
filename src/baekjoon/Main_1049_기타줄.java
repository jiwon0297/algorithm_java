package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1049_기타줄 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		int minset = Integer.MAX_VALUE;
		int minmono = Integer.MAX_VALUE;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int set = Integer.parseInt(st.nextToken());
			int mono = Integer.parseInt(st.nextToken());
			
			if(minset>set) minset=set;
			if(minmono>mono) minmono=mono;
		}

		int a = (N/6+1)*minset; //팩으로 다사기
		int b = (N/6)*minset+(N%6)*minmono; //팩이랑 낱개 섞어서
		int c = N*minmono; //낱개로 다사기
		
		int res = Math.min(Math.min(a, b), c);
		
		System.out.println(res);
		
		
	}

}
