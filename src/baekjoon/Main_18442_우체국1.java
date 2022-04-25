package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18442_우체국1 {
	
	static int V,P;
	static long L,S;
	static int[] arr, res;
	static long[] pos;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		pos = new long[V];
		for(int i=0; i<V; i++) pos[i]=Long.parseLong(st.nextToken());
		
		S=Long.MAX_VALUE;
		arr=new int[P];
		res=new int[P];
		select=new boolean[V];
		combi(0,0);
		System.out.println(S);
		for(int i : res) System.out.print(pos[i]+" ");
	}
	
	private static void combi(int cnt, int idx) {
		if(cnt==P) {
			long dis = solve();
			if(dis<S) {
				S=dis;
				res=arr.clone();
			}
			return ;
		}
		
		for(int i=idx; i<V; i++) {
			select[i]=true;
			arr[cnt]=i;
			combi(cnt+1, i+1);
			select[i]=false;
		}
	}

	private static long solve() {
		long sum=0;
		for(int i=0; i<V; i++) {
			if(select[i]) continue;
			long min=Long.MAX_VALUE;
			for(int j=0; j<P; j++) min=Math.min(min, getDist(pos[i],pos[arr[j]]));
			sum+=min;
		}
		return sum;
	}

	private static long getDist(long x, long y) {
		return Math.min(Math.abs(x-y), L-Math.abs(x-y));
	}

}
