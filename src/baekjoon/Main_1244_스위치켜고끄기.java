package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] light = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			light[i]=Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int location = Integer.parseInt(st.nextToken());
			
			if(gender==1) {
				for(int j=location; j<=N; j+=location) {
					if(light[j]==1) light[j]=0;
					else if(light[j]==0) light[j]=1;
				}
			} else if(gender==2) {
				if(light[location]==1) light[location]=0;
				else if(light[location]==0) light[location]=1;
				
				for(int j=1; j<=N; j++) {
					int right=location+j;
					int left=location-j;
					
					if(left<1 || right>N) continue;
					if(light[left]==light[right]) {
						if(light[left]==1) light[left]=0;
						else if(light[left]==0) light[left]=1;
						
						if(light[right]==1) light[right]=0;
						else if(light[right]==0) light[right]=1;
					} else break;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(light[i]).append(' ');
			if(i%20==0) sb.append('\n');
		}
		
		sb.setLength(sb.length()-1);
		
		System.out.println(sb);
	}

}
