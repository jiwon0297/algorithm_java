package baekjoon;

import java.util.Scanner;

public class Main_1592_영식이와친구들 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] map = new int[N+1];
		
		int idx=1;
		map[1]=1;
		int res=0;
		while(true) {
			if(map[idx]==M) break;
			else {
				if(map[idx]%2==1) {
					res++;
					idx=(idx+L)%N;
					if(idx==0) idx=N;
					map[idx]++;
				} else if(map[idx]%2==0) {
					res++;
					idx=(idx+N-L)%N;
					if(idx==0) idx=N;
					map[idx]++;
				}
			}
		}
		
		System.out.println(res);
	}

}
