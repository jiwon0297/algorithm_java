package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_10816_숫자카드2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> card = new HashMap<Integer, Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			int key = Integer.parseInt(st.nextToken());
			card.put(key, card.getOrDefault(key, 0)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			sb.append(card.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(" ");
		}
		
		System.out.println(sb.toString());
		
		
		
	}

}
