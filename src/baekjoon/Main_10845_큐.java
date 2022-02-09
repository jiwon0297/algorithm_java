package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10845_큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int num=0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(st.hasMoreTokens()) num =Integer.parseInt(st.nextToken());
			
			switch(command) {
			case "push" :
				queue.offer(num);
				break;
				
			case "front" :
				if(queue.isEmpty()) sb.append("-1").append("\n");
				else sb.append(queue.peek()).append("\n");
				break;
				
			case "back" :
				if(queue.isEmpty()) sb.append("-1").append("\n");
				else sb.append(num).append("\n");
				break;
				
			case "size" :
				sb.append(queue.size()).append("\n");
				break;
				
			case "empty" :
				if(queue.isEmpty()) sb.append("1").append("\n");
				else sb.append("0").append("\n");
				break;
				
			case "pop" :
				if(queue.isEmpty()) sb.append("-1").append("\n");
				else sb.append(queue.poll()).append("\n");
				break;
				
			default:
				break;
			}
		}
		
		System.out.println(sb);
	}

}
