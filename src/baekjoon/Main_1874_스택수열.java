package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_1874_스택수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		
		int start = 0;
		while(N-->0) {
			int num = sc.nextInt();
			
			if(num>start) {
				for(int i=start+1; i<=num; i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				start=num;
			} else if(stack.peek()!=num) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append('-').append('\n');
		}
		
		System.out.println(sb);
	}

}
