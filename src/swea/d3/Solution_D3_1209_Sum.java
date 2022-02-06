package swea.d3;

import java.util.Scanner;

public class Solution_D3_1209_Sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int T = sc.nextInt();
			int[][] arr = new int[100][100];
			
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			int rowsum=0;
			int colsum=0;
			int diasum=0;
			int max = -2147000000;
			for(int i=0; i<100; i++) {
				rowsum=0;
				colsum=0;
				diasum=0;
				for(int j=0; j<100; j++) {
					rowsum+=arr[i][j];
					colsum+=arr[j][i];
					if(i==j) diasum+=arr[i][j];
				}
				if(rowsum>max) max=rowsum;
				if(colsum>max) max=colsum;
				if(diasum>max) max=diasum;
			}
			
			diasum=0;
			for(int i=99, j=0; i>=0; i--, j++) {
				diasum+=arr[i][j];
			}
			if(diasum>max) max=diasum;
			
			System.out.println("#" + t+" "+max);
		}
	}

}
