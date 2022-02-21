package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1966_프린터큐 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> queue = new LinkedList<>();
			
			st=new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				queue.offer(new int[] {i, Integer.parseInt(st.nextToken())});
			}
			
			int cnt=0;
			while (!queue.isEmpty()) {
				int[] top = queue.poll();
				boolean isMax=true;
				
				for(int i=0; i<queue.size(); i++) {
					if(top[1]<queue.get(i)[1]) {
						queue.offer(top);
						for(int j=0; j<i; j++) {
							queue.offer(queue.poll());
						}
						
						isMax=false;
						break;
					}
				}
				
				if(!isMax) continue;
				
				cnt++;
				if(top[0]==M) break;
			}
			
			System.out.println(cnt);
		}
	}

}
