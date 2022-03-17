package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_10800_컬러볼 {
	
	static class Ball implements Comparable<Ball> {
		int idx, color, size;

		public Ball(int idx, int color, int size) {
			super();
			this.idx = idx;
			this.color = color;
			this.size = size;
		}

		@Override
		public int compareTo(Ball o) {
			return this.size-o.size;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		ArrayList<Ball> balls = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			balls.add(new Ball(i, color, size));
		}
		
		Collections.sort(balls);
		int[] answer = new int[N];
		int[] color = new int[N+1];
		int sum=0;
		int idx=0;
		for(int i=0; i<N; i++) {
			Ball cur = balls.get(i);
			while(balls.get(idx).size < cur.size) {
				sum+=balls.get(idx).size;
				color[balls.get(idx).color] += balls.get(idx).size;
				idx++;
			}
			answer[cur.idx]=sum-color[cur.color];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : answer) {
			sb.append(i).append('\n');
		}
		System.out.println(sb);
	}

}
