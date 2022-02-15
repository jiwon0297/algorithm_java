package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1655_가운데를말해요 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> maxq = new PriorityQueue<Integer>(Comparator.reverseOrder());
		PriorityQueue<Integer> minq = new PriorityQueue<Integer>();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			if(maxq.size()==minq.size()) {
				maxq.offer(Integer.parseInt(br.readLine()));
				
				if(!minq.isEmpty() && maxq.peek()>minq.peek()) {
					minq.offer(maxq.poll());
					maxq.offer(minq.poll());
				}
			} else {
				minq.offer(Integer.parseInt(br.readLine()));
				
				if(maxq.peek()>minq.peek()) {
					minq.offer(maxq.poll());
					maxq.offer(minq.poll());
				}
			}
			
			sb.append(maxq.peek()).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
