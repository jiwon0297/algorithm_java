package swea.d2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution_D2_1288_새로운불면증치료법 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			List<Integer> arr = new ArrayList<>();
			
			int N1=N;
			while(true) {
				String strN = Integer.toString(N1);
				
				for(int i=0; i<strN.length(); i++) {
					int num = strN.charAt(i)-'0';
					arr.add(num);
				}
				
				Set<Integer> set = new HashSet<Integer>(arr);
				List<Integer> res = new ArrayList<Integer>(set);
				if(res.size()==10) {
					System.out.println("#"+t+" "+N1);
					break;
				}
				else N1=N1+N;
			}
			
		}
	}
}
