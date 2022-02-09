package swea.d3;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution_D3_1228_암호문1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int codeN = sc.nextInt();
			LinkedList<Integer> code = new LinkedList<>();
			
			for(int i=0; i<codeN; i++) {
				code.add(sc.nextInt());
			}
			
			int commN = sc.nextInt();
			
			for(int i=0; i<commN; i++) {
				String st = sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				for(int j=0; j<y; j++) {
					code.add(x, sc.nextInt());
					x++;
				}
			}
			
			System.out.print("#"+t);
			for(int i=0; i<10; i++) {
				System.out.print(" "+code.get(i));
			}
			System.out.println();
		}
	}

}
