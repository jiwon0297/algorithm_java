package swea;

import java.util.Scanner;

public class Solution_D2_1961_숫자배열회전 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[][] matrix = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					matrix[i][j]=sc.nextInt();
				}
			}
			
			int[][] a = rotation(matrix);
			int[][] b = rotation(a);
			int[][] c = rotation(b);
			
			System.out.println("#"+t);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(a[i][j]);
				}
				System.out.print(" ");
				for(int j=0; j<N; j++) {
					System.out.print(b[i][j]);
				}
				System.out.print(" ");
				for(int j=0; j<N; j++) {
					System.out.print(c[i][j]);
				}
				System.out.println();
			}
		}
	}

	private static int[][] rotation(int[][] matrix) {
		int[][] result = new int[matrix.length][matrix.length];
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				result[i][j]=matrix[matrix.length-j-1][i];
			}
		}
		return result;
	}

}
