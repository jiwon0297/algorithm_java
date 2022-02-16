package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_13428_숫자조작 {
	
	static char[] num;
	static int min;
	static int max;
	static int maxidx;
	static int minidx;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			num = br.readLine().toCharArray();
			System.out.println("#"+t+" "+getMin(0)+" "+getMax(0));
		}
	}

	private static int getMax(int idx) {
		int max = Integer.MIN_VALUE;
		int maxidx=idx;
		int res=0;
		
		for(int i=idx; i<num.length; i++) {
			if((num[i]-'0')>=max) {
				max = num[i]-'0';
				maxidx=i;
			}
		}
		
		if(max==(num[idx]-'0') && idx+1<num.length) {
			return getMax(idx+1);
		}
		
		swap(idx, maxidx);
		res=Integer.parseInt(String.valueOf(num));
		swap(idx, maxidx);
		
		return res;
	}

	private static int getMin(int idx) {
		int min = Integer.MAX_VALUE;
		int minidx=idx;
		int res=0;
		
		for(int i=idx; i<num.length; i++) {
			if(idx==0) {
				if(num[i]=='0') continue;
			}
			
			if((num[i]-'0')<=min) {
				min=num[i]-'0';
				minidx=i;
			}
		}
		
		if(min==(num[idx]-'0') && idx+1<num.length) return getMin(idx+1);
		
		swap(idx,minidx);
		res=Integer.parseInt(String.valueOf(num));
		swap(idx,minidx);
		return res;
	}

	private static void swap(int a, int b) {
		char tmp;
		tmp=num[a];
		num[a]=num[b];
		num[b]=tmp;
	}
	

}
