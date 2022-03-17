package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1248_맞춰봐 {
	
	static int N,res;
	static int[] arr;
	static char[] A;
	static char[][] S;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A=br.readLine().toCharArray();
		
		S=new char[N][N];
		int idx=0;
		
		for(int i=0; i<N; i++) {
			for(int j=i; j<N; j++) {
				S[i][j]=A[idx++];
			}
		}
		
		arr=new int[N];
		dfs(0);
	}

	private static void dfs(int cnt) {
		if(cnt==N) {
			for(int i=0; i<N; i++) {
				System.out.print(arr[i]+" ");
			}
			System.exit(0);
			return ;
		}
		
		for(int i=-10; i<=10; i++) {
			arr[cnt]=i;
			if(chk(cnt)) dfs(cnt+1);
		}
	}

	private static boolean chk(int idx) {
		for(int i=0; i<=idx; i++) {
			int sum=0;
			for(int j=i; j<=idx; j++) {
				sum+=arr[j];	
				if(S[i][j]!=(sum==0? '0' : (sum>0? '+':'-'))) return false;
			}
		}
		return true;
	}

}
