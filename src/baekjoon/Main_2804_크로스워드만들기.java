package baekjoon;

import java.util.Scanner;

public class Main_2804_크로스워드만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		char[] Ast = A.toCharArray();
		char[] Bst = B.toCharArray();
		
		int N = A.length();
		int M = B.length();
		
		int Aidx=0;
		int Bidx=0;
		boolean flag = true;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(Bst[j]==Ast[i]) {
					Aidx=j;
					Bidx=i;
					flag=false;
					break;
				}
			}
			
			if(flag==false) break;
		}
		
		char[][] arr = new char[M][N];
		int Bidx2=0;
		int Aidx2=0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(i==Aidx && j==Bidx) {
					arr[i][j]=Ast[Aidx2];
					Aidx2++;
					Bidx2++;
					continue;
				}
				
				if(i==Aidx) arr[i][j]=Ast[Aidx2++];
				else if (j==Bidx) arr[i][j]=Bst[Bidx2++];
				else arr[i][j]='.';
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
