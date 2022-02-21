package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> pocketmon = new HashMap<>();
		String[] arr = new String[N+1];
		
		for(int i=1; i<=N; i++) {
			String name = br.readLine();
			pocketmon.put(name, i);
			arr[i]=name;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			if(str.charAt(0)>=65) {
				sb.append(pocketmon.get(str)).append('\n');
			} else {
				int key = Integer.parseInt(str);
				sb.append(arr[key]).append('\n');
			}
		}
		
		System.out.println(sb.toString());
	}

}
