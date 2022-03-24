package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9663_NQueen {
	
	static int N, res=0;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr=new int[N];
		
		dfs(0);
		System.out.println(res);
	}

	private static void dfs(int cnt) {
		if(cnt==N) {
			res++;
			return ;
		}
		
		for(int i=0; i<N; i++) {
			arr[cnt]=i;
			if(isPos(cnt)) dfs(cnt+1);
		}
	}

	private static boolean isPos(int col) {
		for(int i=0; i<col; i++) {
			if(arr[col]==arr[i]) return false;
			else if(Math.abs(col-i)==Math.abs(arr[col]-arr[i])) return false;
		}
		return true;
	}

}
