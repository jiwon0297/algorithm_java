package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_18870_좌표압축 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] X = new int[N];
		
		for(int i=0; i<N; i++) {
			X[i]=Integer.parseInt(st.nextToken());
		}
		int[] Xi = new int[N];
		Xi=X.clone();
		
		Arrays.sort(X);
		HashMap<Integer, Integer> map = new HashMap<>();
		int cnt=0;
		for(int i=0; i<X.length; i++) {
			if(!map.containsKey(X[i])) map.put(X[i], cnt++);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(map.get(Xi[i])).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
