package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10830_행렬제곱 {
	
	static int N;
	static int[][] matrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		matrix = new int[N][N];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				matrix[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] res = recur(matrix, B);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(res[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	//재귀
	private static int[][] recur(int[][] A, long B){
		if(B==1L) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					A[i][j]%=1000;
				}
			}
			return A;
		}
		
		//반씩
		int[][] tmp = recur(A,B/2);
		tmp=mul(tmp,tmp);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				tmp[i][j]%=1000;
			}
		}
		
		if(B%2==1L) {
			tmp=mul(tmp,matrix);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					tmp[i][j]%=1000;
				}
			}
		}
		
		return tmp;
	}
	
	//행렬 곱
	private static int[][] mul(int[][] A, int[][] B){
		int[][] res = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					res[i][j]+=A[i][k]*B[k][j];
					res[i][j]%=1000;
				}
			}
		}
		
		return res;
	}

}
