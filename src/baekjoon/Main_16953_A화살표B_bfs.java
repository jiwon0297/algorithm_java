package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_16953_A화살표B_bfs {

	static boolean[] visited;
	static long A,B;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		visited=new boolean[(int)B+1];
		System.out.println(bfs());
	}

	private static long bfs() {
		Queue<long[]> q = new LinkedList<>();
		q.offer(new long[] {A,0});
		visited[(int)A]=true;
		
		while(!q.isEmpty()) {
			long[] cur = q.poll();
			long num = cur[0];
			long cnt = cur[1];
			
			if(num==B) return cnt+1;
			
			long next = num*2;
			if(next>B) continue;
			if(!visited[(int)next]) {
				visited[(int)next]=true;
				q.offer(new long[] {next,cnt+1});
			}
				
			next=num*10+1;
			if(next>B) continue;
			if(!visited[(int)next]) {
				visited[(int)next]=true;
				q.offer(new long[] {next,cnt+1});
			}
		}
		
		return -1;
	}

}
