package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2564_경비원 {

	static int C,R,N,sum;
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());		
		list= new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			switch(dir) {
				case 1:
					list.add(new int[] {0,dis});
					break;
				
				case 2:
					list.add(new int[] {C,dis});
					break;
				
				case 3:
					list.add(new int[] {dis,0});
					break;
				
				case 4:
					list.add(new int[] {dis,R});
					break;
			}
		}
		search();
		System.out.println(sum);
	}

	private static void search() {
		for(int i=0; i<N; i++) {
			if(Math.abs(list.get(N)[0]-list.get(i)[0])==C) {
				sum+=C;
				sum+=Math.min(list.get(N)[1]+list.get(i)[1], 2*R-list.get(N)[1]-list.get(i)[1]);
			} else if(Math.abs(list.get(N)[1]-list.get(i)[1])==R) {
				sum+=R;
				sum+=Math.min(list.get(N)[0]+list.get(i)[0], 2*C-list.get(N)[0]-list.get(i)[0]);
			} else {
				sum+=Math.abs(list.get(N)[0]-list.get(i)[0]);
				sum+=Math.abs(list.get(N)[1]-list.get(i)[1]);
			}
		}
	}

}
