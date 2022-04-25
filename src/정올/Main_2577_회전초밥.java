package 정올;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2577_회전초밥 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] sushi = new int[N];
		for(int i=0; i<N; i++) {
			sushi[i]=Integer.parseInt(br.readLine());
		}
		
		int[] eat = new int[d+1];
		int cnt=0;
		for(int i=0; i<k; i++) {
			if(eat[sushi[i]]==0) cnt++;
			eat[sushi[i]]++;
		}
		int max=cnt;
		
		for(int i=1; i<N; i++) {
			if(max<=cnt) {
				if(eat[c]==0) max=cnt+1;
				else max=cnt;
			}
			
			eat[sushi[i-1]]--;
			if(eat[sushi[i-1]]==0) cnt--;
			
			if(eat[sushi[(i+k-1)%N]]==0) cnt++;
			eat[sushi[(i+k-1)%N]]++;
		}
	
		System.out.println(max);
	}
}
