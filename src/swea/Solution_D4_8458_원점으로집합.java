package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_8458_원점으로집합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(0);
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			int N = Integer.parseInt(br.readLine());
			int[] dist=new int[N];
			st=new StringTokenizer(br.readLine());
			dist[0]=(Math.abs(Integer.parseInt(st.nextToken()))+Math.abs(Integer.parseInt(st.nextToken())));
			int max=dist[0];
			int cnt=0;
			for(int i=1; i<N; i++) {
				st=new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				dist[i]=(Math.abs(x)+Math.abs(y));
				max=Math.max(max, dist[i]);
				if(dist[i]%2 != dist[i-1]%2) cnt=-1;
			}
			if(cnt==-1) {sb.append("-1\n"); continue;}
			
			int sum=0;
			while(true) {
				if(sum>=max && (max-sum)%2==0) break;
				sum+=++cnt;
			}
			
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString());
	}

}
