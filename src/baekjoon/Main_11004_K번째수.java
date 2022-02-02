package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11004_K번째수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Long> A = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			A.add(Long.parseLong(st.nextToken()));
		}
		
		Collections.sort(A);
		
		System.out.println(A.get(K-1));
	}

}
