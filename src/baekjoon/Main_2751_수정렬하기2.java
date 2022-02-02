package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main_2751_수정렬하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> num = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			num.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(num);
		
		for(int a : num) {
			sb.append(a).append('\n');
		}
		System.out.println(sb);
	}

}
