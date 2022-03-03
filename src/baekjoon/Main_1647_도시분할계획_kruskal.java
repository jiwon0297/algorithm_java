package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//kruskal 1660ms
public class Main_1647_도시분할계획_kruskal {
	static class City implements Comparable<City> {
		int from;
		int to;
		int exp;
		
		public City(int from, int to, int exp) {
			this.from = from;
			this.to = to;
			this.exp = exp;
		}

		@Override
		public int compareTo(City o) {
			return exp-o.exp;
		}
	}

	static int[] parent;
	static ArrayList<City> cityList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		cityList = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			cityList.add(new City(A,B,C));
		}
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i]=i;
		}
		
		Collections.sort(cityList);
		
		int res=0;
		int max=0;
		
		for(int i=0; i<cityList.size(); i++) {
			City city = cityList.get(i);
			
			if(find(city.from)!=find(city.to)) {
				res+=city.exp;
				union(city.from, city.to);
				max=city.exp;
			}
		}
		
		System.out.println(res-max);
	}
	
	private static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x]=find(parent[x]);
	}
	
	private static void union(int x, int y) {
		x=find(x);
		y=find(y);
		if(x!=y) parent[y]=x;
	}

}
