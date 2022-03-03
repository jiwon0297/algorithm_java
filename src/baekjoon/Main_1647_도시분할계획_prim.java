package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//prim 1848ms
public class Main_1647_도시분할계획_prim {
	static class City implements Comparable<City> {
		int to;
		int exp;
		
		public City(int to, int exp) {
			this.to = to;
			this.exp = exp;
		}

		@Override
		public int compareTo(City o) {
			return exp-o.exp;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<City>[] cityList = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			cityList[i]=new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			cityList[A].add(new City(B,C));
			cityList[B].add(new City(A,C));
		}
		
		boolean[] visited=new boolean[N+1];
		
		int cnt=0;
		int res=0;
		int max=0;
		
		PriorityQueue<City> pq = new PriorityQueue<>();
		pq.add(new City(1,0));
		
		while(true) {
			City cur = pq.poll();
			
			if(visited[cur.to]) continue;
			
			visited[cur.to]=true;
			res+=cur.exp;
			max=Math.max(max, cur.exp);
			cnt++;
			
			if(cnt==N) break;
			
			for(City c : cityList[cur.to]) {
				if(!visited[c.to]) pq.add(new City(c.to, c.exp));
			}
		}
		
		System.out.println(res-max);
	}
}
