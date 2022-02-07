package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10828_스택 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int num=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(st.hasMoreTokens()) num=Integer.parseInt(st.nextToken());
			
			switch(str) {
			case "push":
				stack.push(num);
				break;
				
			case "pop":
				if(!stack.isEmpty()) System.out.println(stack.pop());
				else System.out.println(-1);
				break;
				
			case "size":
				System.out.println(stack.size());
				break;
				
			case "empty":
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
				
			case "top":
				if(!stack.isEmpty()) System.out.println(stack.get(stack.size()-1));
				else System.out.println(-1);
				
				break;
				
			default :
				break;
			}
		}
	}

}
