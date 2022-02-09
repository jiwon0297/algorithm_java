package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_17413_단어뒤집기2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		boolean chk = false; //<> 구분하기
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch=='<') {
				chk=true;
				while(!stack.isEmpty()) System.out.print(stack.pop()); 
				System.out.print(ch);
			} else if(ch=='>') {
				chk=false;
				System.out.print(ch);
			} else if(chk) {
				System.out.print(ch);
			} else if(!chk) {
				if(ch==' ') {
					while(!stack.isEmpty()) System.out.print(stack.pop());
					System.out.print(ch);
				} else {
					stack.push(ch);
				}
			}
		}
		
		while(!stack.isEmpty()) System.out.print(stack.pop());
	}

}
