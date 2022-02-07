package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_9012_괄호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int a=0;
			String st= sc.next();
			Stack<Character> stack = new Stack<Character>();
			for(int i=0; i<st.length(); i++) {
				if(st.charAt(i)=='(') stack.push('(');
				else if(stack.isEmpty()) a=1;
				else stack.pop();
				
			}
			
			if(!stack.isEmpty() || a==1) System.out.println("NO");
			else System.out.println("YES");
		}
	}

}
