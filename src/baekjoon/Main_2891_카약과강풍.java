package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2891_카약과강풍 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[] kayak = new int[N+1];
		Arrays.fill(kayak, 1);
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<S; i++) {
			kayak[Integer.parseInt(st.nextToken())]--;
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<R; i++) {
			kayak[Integer.parseInt(st.nextToken())]++;
		}
		
		for(int i=1; i<=N; i++) {
			if(i==1) {
				if(kayak[1]==2 && kayak[2]==0) kayak[1]=kayak[2]=1;
			} else if(i==N) {
				if(kayak[N]==2 && kayak[N-1]==0) kayak[N]=kayak[N-1]=1;
			} else {
				if(kayak[i]==2) {
					if(kayak[i-1]==0) kayak[i]=kayak[i-1]=1;
					else if(kayak[i+1]==0) kayak[i]=kayak[i+1]=1;
				}
			}
		}
		
		int cnt=0;
		for(int i:kayak) {
			if(i==0) cnt++;
		}
		
		System.out.println(cnt);
	}

}
