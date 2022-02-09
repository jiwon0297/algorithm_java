package swea.d3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution_D3_1234_비밀번호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int N = sc.nextInt();
			Stack<Character> stack = new Stack<Character>();
			String pw = sc.next();
			for(int i=0; i<N; i++) {
				char ch = pw.charAt(i);
				if(stack.isEmpty()) {
					stack.push(ch);
				} else {
					if(stack.peek()==ch) {
						stack.pop();
					} else stack.push(ch);
				}
			}
			
			List<Character> ans = new ArrayList<>();
			
			System.out.print("#"+t+" ");
			while(!stack.empty()) {
				ans.add(stack.pop());
			}
			
			for(int i=ans.size()-1; i>=0; i--) {
				System.out.print(ans.get(i));
			}
			System.out.println();
		}
	}

}
