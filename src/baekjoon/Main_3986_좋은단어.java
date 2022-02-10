package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_3986_좋은단어 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int res=0;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			for(int j=0; j<str.length(); j++) {
				char ch = str.charAt(j);
				if(stack.isEmpty()) stack.push(ch);
				else {
					if(stack.peek()==ch) stack.pop();
					else stack.push(ch);
				}
			}
			
			if(stack.size()==0) res++;
		}
		
		System.out.println(res);
	}

}
