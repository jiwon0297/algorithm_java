package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_13038_교환학생 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] a = new int[7];
			int classday=0;
			int week=0;
			int min=Integer.MAX_VALUE;
			int sum=0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			//0:일 1:월 2:화 3:수 4:목 5:금 6:토
			for(int i=0; i<7; i++) {
				a[i]=Integer.parseInt(st.nextToken());
				if(a[i]==1) classday++;
			}
			
			if(N==1) sum=1;
			else {
				if(N%classday==0) week=N/classday-1;
				else week=N/classday;
				
				int diff=N-week*classday;
				for(int i=0; i<7; i++) {
					int cnt=0;
					int total=0;
					
					if(a[i]==1) {
						cnt++;
						total++;
						int idx=i;
						while(cnt<diff) {
							idx=(idx+1)%7;
							total++;
							if(a[idx]==1) cnt++;
						}
						min=Math.min(min, total);
					}
				}
				sum=week*7+min;
			}
			System.out.println("#"+t+" "+sum);
		}
	}

}
