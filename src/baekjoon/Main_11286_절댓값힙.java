package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {
			if(Math.abs(a)==Math.abs(b)) return a>b? 1:-1;
			return Integer.compare(Math.abs(a), Math.abs(b));
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int x= Integer.parseInt(br.readLine());
			if(x==0) {
				if(pq.isEmpty()) sb.append(0).append('\n');
				else sb.append(pq.poll()).append('\n');
			} else {
				pq.offer(x);
			}
		}
		
		System.out.println(sb.toString());
	}

}
