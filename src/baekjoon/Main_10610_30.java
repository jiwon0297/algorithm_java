package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//288ms
public class Main_10610_30 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] N = br.readLine().toCharArray();
		
		List<Integer> num = new ArrayList<>();
		
		boolean isZero = false;
		int sum=0;
		for(int i=0; i<N.length; i++) {
			if(N[i]=='0') isZero=true;
			sum+=(N[i]-'0');
		}
		
		if(sum%3!=0 || !isZero) {
			System.out.println(-1);
			return;
		}
		
		for(int i=0; i<N.length; i++) num.add(N[i]-'0');
		Collections.sort(num, Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int i : num) {
			sb.append(i);
		}
		
		System.out.println(sb.toString());
	}

}
