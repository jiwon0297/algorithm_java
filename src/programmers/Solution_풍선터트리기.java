package programmers;

public class Solution_풍선터트리기 {
	public static void main(String[] args) {
		
	}
	
	public int solution(int[] a) {
		int answer=0;
		int left=1000000000;
		int right=1000000000;
		
		int size=a.length;
		for(int i=0; i<size; i++) {
			if(a[i]<left) {
				answer++;
				left=a[i];
			}
			
			if(a[size-1-i]<right) {
				answer++;
				right=a[size-1-i];
			}
			
			if(left==right) break;
		}
		
		if(left==right) answer--;
        return answer;
    }
}
