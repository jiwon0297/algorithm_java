package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17298_오큰수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> tmp = new Stack<Integer>(); //임시 스택
		Stack<Integer> res = new Stack<Integer>(); //결과 스택
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] A = new int[N];
		
		for(int i=0; i<N; i++) A[i]=Integer.parseInt(st.nextToken());
		
		for(int i=N-1; i>=0; i--) {
			//비어있지 않고 들어온 수보다 작거나 같은 수들 모두 pop
			while(!tmp.isEmpty() && A[i]>=tmp.peek()) tmp.pop();
		
			//비었다면 -1
			if(tmp.isEmpty()) res.push(-1);
			else res.push(tmp.peek()); //나머지는 peek
			tmp.push(A[i]); //임시스택에 현재 값 추가
		}
		
		while(!res.isEmpty()) sb.append(res.pop()).append(" ");
		
		System.out.println(sb);
		
		
	}

}
