package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1654_랜선자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] line = new int[K];
		
		for(int i=0; i<K; i++) {
			line[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(line);
		
		long right = line[K-1];
		long left = 1;
		long mid = 0;
		
		//이분탐색
		while(left<=right) {
			mid=(right+left)/2;
			
			long cnt=0;
			
			for(int i=0; i<K; i++) {
				cnt+=line[i]/mid;
			}
			
			if(cnt>=N) left=mid+1;
			else if(cnt<N) right=mid-1;
		}
		
		System.out.println(right);
	}

}
