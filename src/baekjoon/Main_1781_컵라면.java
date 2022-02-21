package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1781_컵라면 {
	
	static class Problem implements Comparable<Problem>{
		int num;
		int deadline;
		int ramen;
				
		public Problem(int num, int deadline, int ramen) {
			this.num = num;
			this.deadline = deadline;
			this.ramen = ramen;
		}

		@Override
		public int compareTo(Problem o) {
			return Integer.compare(this.deadline, o.deadline);
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Problem[] probs = new Problem[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int deadline =Integer.parseInt(st.nextToken());
			int ramen = Integer.parseInt(st.nextToken());
			probs[i]=new Problem(i+1,deadline,ramen);
		}
		Arrays.sort(probs);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			pq.offer(probs[i].ramen);
			while(pq.size()>probs[i].deadline) pq.poll();
		}
		
		int cnt=0;
		while(!pq.isEmpty()) {
			cnt+=pq.poll();
		}
		
		System.out.println(cnt);
	}

}
