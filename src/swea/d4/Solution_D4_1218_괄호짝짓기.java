package swea.d4;

import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();

			String str = sc.next();
			int a=0;
			Stack<Character> stack = new Stack<Character>();
			
			for (int i = 0; i < N; i++) {
				char ch = str.charAt(i);

				if(ch=='>' && stack.peek()=='<') stack.pop();
				else if(ch==')' && stack.peek()=='(') stack.pop();
				else if(ch=='}' && stack.peek()=='{') stack.pop();
				else if(ch==']' && stack.peek()=='[') stack.pop();
				else stack.push(ch);
			}
			
			if(stack.isEmpty()) a=1;
			else a=0;
			
			System.out.println("#"+t+" "+a);
		}
	}
}