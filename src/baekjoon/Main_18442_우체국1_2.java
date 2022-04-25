package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18442_우체국1_2 {
	
	static int V,P;
	static long L,S;
	static long[] arr,res,pos;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		long beforeTime = System.currentTimeMillis();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		pos = new long[V];
		for(int i=0; i<V; i++) pos[i]=Long.parseLong(st.nextToken());
		
		S=Long.MAX_VALUE;
		arr=new long[P];
		res=new long[P];
		combi(0,0);
		sb.append(S).append("\n");
		for(long i : res) sb.append(i).append(" ");
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이 : "+secDiffTime+"ms");
	}
	
	private static void combi(int cnt, int idx) {
		if(cnt==P) {
			long dis = solve();
			if(dis<S) {
				S=dis;
				for(int i=0; i<P; i++) res[i]=arr[i];
			}
			return ;
		}
		
		for(int i=idx; i<V; i++) {
			arr[cnt]=pos[i];
			combi(cnt+1, i+1);
		}
	}

	private static long solve() {
		long sum=0;
		int left = P-1, right=0, mid=0;
		
		while(mid<V) {
			if(pos[mid]==arr[right]) {
				left = (left+1) % P;
				right = (right+1) % P;
			} else sum+=Math.min(getDist(arr[left], pos[mid]), getDist(pos[mid], arr[right]));
			mid++;
		}
		return sum;
	}

	private static long getDist(long x, long y) {
		return Math.min(Math.abs(x-y), L-Math.abs(x-y));
	}

}
