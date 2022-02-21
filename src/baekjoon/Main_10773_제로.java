package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773_제로 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		Stack<Integer> s = new Stack<>();
		for(int i=0; i<K; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num==0) s.pop();
			else s.push(num);
		}
		
		int sum=0;
		for(int i: s) {
			sum+=i;
		}
		
		System.out.println(sum);
	}

}
