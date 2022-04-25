package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18443_우체국2 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] res = new int[100];
		for(int i=0; i<100; i++) res[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(res);
		for(int i : res) System.out.print(i+" ");
		
	}

}
