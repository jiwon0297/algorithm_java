package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949_균형잡힌세상 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			if(str.charAt(0)=='.') break;
		
			Stack<Character> stack = new Stack<Character>();
			
			for(int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				switch(ch) {
				case '(':
					stack.push(ch);
					break;
					
				case ')':
					if(!stack.isEmpty()) {
						if(stack.peek()=='(') stack.pop();
						else stack.push(ch);
					} else stack.push(ch);
					break;
					
				case '[':
					stack.push(ch);
					break;
					
				case ']':
					if(!stack.isEmpty()) {
						if(stack.peek()=='[') stack.pop();
						else stack.push(ch);
					} else stack.push(ch);
					break;
				}
			}
			
			if(stack.isEmpty()) System.out.println("yes");
			else System.out.println("no");
		}
	}

}
