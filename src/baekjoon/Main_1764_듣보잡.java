package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1764_듣보잡 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			set.add(name);
		}
		
		ArrayList<String> res = new ArrayList<>();
		int cnt=0;
		for(int i=0; i<M; i++) {
			String name = br.readLine();
			if(set.contains(name)) {
				res.add(name);
				cnt++;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append('\n');
		
		Collections.sort(res);
		for(String i : res) {
			sb.append(i).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
