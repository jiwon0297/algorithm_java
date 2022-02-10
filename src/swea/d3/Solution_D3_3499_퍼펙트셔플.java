package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_3499_퍼펙트셔플 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Queue<String> frontq = new LinkedList<String>();
			Queue<String> backq = new LinkedList<String>();
			
			if(N%2==0) {
				for(int i=0; i<N/2; i++) {
					frontq.offer(st.nextToken());
				}
				
				for(int i=0; i<N/2; i++) {
					backq.offer(st.nextToken());
				}
			} else {
				for(int i=0; i<N/2+1; i++) {
					frontq.offer(st.nextToken());
				}
				
				for(int i=0; i<N/2; i++) {
					backq.offer(st.nextToken());
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t);
			while(!frontq.isEmpty()) {
				if(backq.isEmpty()) sb.append(" ").append(frontq.poll());
				else sb.append(" ").append(frontq.poll()).append(" ").append(backq.poll());
			}
			
			System.out.println(sb);
		}
	}

}
