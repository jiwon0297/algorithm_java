package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_1292_쉽게푸는문제 {

	public static void main(String[] args) {
		ArrayList<Integer> num = new ArrayList<>();
		for(int i=1; i<=1000; i++) {
			for(int j=1; j<=i; j++) {
				num.add(i);
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int sum=0;
		for(int i=A-1; i<B; i++) {
			sum+=num.get(i);
		}
		
		System.out.println(sum);
	}

}
