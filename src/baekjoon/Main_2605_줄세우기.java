package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2605_줄세우기 {

	static int[] line;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		line = new int[N];
		for(int i=0; i<N; i++) {
			line[i]=i+1;
			int num = Integer.parseInt(st.nextToken());
			if(num!=0) {
				for(int j=i; j>i-num; j--) {
					swap(j);
				}
			}
		}
		
		for(int i:line) System.out.print(i+" ");
	}

	private static void swap(int i) {
		int tmp = line[i];
		line[i]=line[i-1];
		line[i-1]=tmp;
	}

}
