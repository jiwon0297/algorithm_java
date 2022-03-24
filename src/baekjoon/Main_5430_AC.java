package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_5430_AC {

	public static void main(String[] args) throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arrstr = br.readLine();
			StringTokenizer st = new StringTokenizer(arrstr,"[],");
			Deque<Integer> dq = new ArrayDeque<>();
			for(int i=0; i<n; i++) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			
			int idx=0;
			int len = p.length();
			boolean reverse=false;
			boolean flag=true;
			while(idx<len) {		
				char AC = p.charAt(idx);
				if(AC=='R') {
					reverse= !reverse;
				} else if(AC=='D') {
					if(dq.isEmpty()) {
						flag=false;
						break;
					}
					if(reverse) dq.pollLast();
					else dq.pollFirst();
				}
				idx++;
			}
			
			if(flag) {
				StringBuilder sb = new StringBuilder("[");
				while(!dq.isEmpty()) {
					sb.append(reverse? dq.pollLast():dq.pollFirst());
					if(dq.size()!=0) sb.append(',');
				}
				sb.append(']');
				System.out.println(sb);
			} else System.out.println("error");
		}

	}

}
