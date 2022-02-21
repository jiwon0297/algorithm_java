package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main_2108_통계학 {
	
	static int[] cnt = new int[8001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int sum=0;
		int[] num = new int[N];
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(br.readLine());
			sum+=a;
			cnt[a+4000]++;
			num[i]=a;
		}
		Arrays.sort(num);
	
		//산술평균
		System.out.println(Math.round((double)sum/(double)N));
		
		//중앙값
		System.out.println(num[N/2]);
		
		//cnt
		List<Integer> tmp = new ArrayList<>();
		int max=cnt[0];
		tmp.add(0-4000);
		for(int i=1; i<8001; i++) {
			if(cnt[i]==max) {
				tmp.add(i-4000);
			}
			
			if(cnt[i]>max){
				max=cnt[i];
				tmp.clear();
				tmp.add(i-4000);
			}
		}
		Collections.sort(tmp);
		if(tmp.size()>1) System.out.println(tmp.get(1));
		else System.out.println(tmp.get(0));
		
		//최대-최소
		System.out.println(num[N-1]-num[0]);
	}

}
