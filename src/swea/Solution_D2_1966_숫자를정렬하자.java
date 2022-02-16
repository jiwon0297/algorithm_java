package swea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution_D2_1966_숫자를정렬하자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			List<Integer> num = new ArrayList<>();
			int N= sc.nextInt();
			
			for(int i=0; i<N; i++) {
				num.add(sc.nextInt());
			}
			
			Collections.sort(num);
			
			System.out.print("#"+t+" ");
			for(int a : num) {
				System.out.print(a+" ");
			}
			System.out.println();
			
		}
	}

}
