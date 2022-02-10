package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_1259_팰린드롬수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.next();
			if(str.charAt(0)=='0') break;
			
			Stack<Character> stack = new Stack<Character>();
			if(str.length()%2==0) {
				for(int i=0; i<str.length(); i++) {
					char ch = str.charAt(i);
					
					if(stack.isEmpty()) stack.push(ch);
					else {
						if(stack.peek()==ch) stack.pop();
						else stack.push(ch);
					}
				}
			} else {
				for(int i=0; i<str.length(); i++) {
					if(i==str.length()/2) continue;
					char ch = str.charAt(i);
					
					if(stack.isEmpty()) stack.push(ch);
					else {
						if(stack.peek()==ch) stack.pop();
						else stack.push(ch);
					}
				}
			}
			
			if(stack.size()==0) System.out.println("yes");
			else System.out.println("no");
		}
	}

}
