package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11279_최대힙 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x>0) pq.offer(x);
			if(x==0) {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			}
		}
	}

}
