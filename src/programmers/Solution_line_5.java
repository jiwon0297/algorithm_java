package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution_line_5 {
	public static void main(String[] args) {
		int[] ab = {2, 8, 3, 6, 1, 9, 1, 9};
		int k = 2;
		System.out.println(solution(ab,k));
	}
	
	static PriorityQueue<Integer> ablist;
	static long answer;
	static ArrayList<Integer> arr;
	static int round;
	static int num;
	
	public static long solution(int[] abilities, int k) {
		ablist = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<abilities.length; i++) ablist.add(abilities[i]);
		
		arr=new ArrayList<Integer>();
        answer = Long.MIN_VALUE;
        round = (abilities.length)/2;
        num=abilities.length;
		dfs(0,0,k,0);
		
		return answer;
    }

	private static void dfs(int cnt, int pri ,int k, long sum) {
		System.out.println(sum);
		if(pri>k) return;
		if(cnt==round) {
			if(num%2==0) answer=Math.max(answer, sum);
			else if(num%2==1) {
				if(pri<k && !ablist.isEmpty()) answer=Math.max(answer, sum+ablist.poll());
				else answer=Math.max(answer, sum);
			}
			return;
		}
		
		//우선권사용
		int tmp=ablist.poll();
		int tmp2=ablist.poll();
		dfs(cnt+1, pri+1, k, sum+tmp);
		ablist.add(tmp);
		ablist.add(tmp2);
		
		//우선권사용안함
		int tmp3=ablist.poll();
		int tmp4=ablist.poll();
		dfs(cnt+1, pri, k, sum+tmp4);
		ablist.add(tmp3);
		ablist.add(tmp4);
	}
}
