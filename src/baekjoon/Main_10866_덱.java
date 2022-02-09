package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_10866_덱 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new ArrayDeque<>();
		
		int num=0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(st.hasMoreTokens()) num =Integer.parseInt(st.nextToken());
			
			switch(command) {
			case "push_front" :
				dq.offerFirst(num);
				break;
				
			case "push_back" :
				dq.offerLast(num);
				break;
				
			case "pop_front" :
				if(dq.isEmpty()) sb.append("-1").append("\n");
				else sb.append(dq.pollFirst()).append("\n");
				break;
				
			case "pop_back" :
				if(dq.isEmpty()) sb.append("-1").append("\n");
				else sb.append(dq.pollLast()).append("\n");
				break;
				
			case "size" :
				sb.append(dq.size()).append("\n");
				break;
				
			case "empty" :
				if(dq.isEmpty()) sb.append("1").append("\n");
				else sb.append("0").append("\n");
				break;
				
			case "front" :
				if(dq.isEmpty()) sb.append("-1").append("\n");
				else sb.append(dq.peekFirst()).append("\n");
				break;
				
			case "back" :
				if(dq.isEmpty()) sb.append("-1").append("\n");
				else sb.append(dq.peekLast()).append("\n");
				break;
				
			default:
				break;
			}
		}
		
		System.out.println(sb);
	}

}
