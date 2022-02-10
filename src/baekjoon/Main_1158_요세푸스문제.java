package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while(q.size()>1) {
			//K-1 번째까지는 뒤로 보내기
			for(int i=0; i<K-1; i++) {
				q.offer(q.poll());
			}
			
			//K번째는 빼내기
			sb.append(q.poll()).append(", ");
		}
		
		sb.append(q.poll()).append(">");
		System.out.println(sb);
	}
}
