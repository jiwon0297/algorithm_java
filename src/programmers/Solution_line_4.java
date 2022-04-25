package programmers;

public class Solution_line_4 {
	public static void main(String[] args) {
		int[] arr = {6, 2, 2, 6};
		int[] brr = {4, 4, 4, 4};
		System.out.println(solution(arr,brr));
	}
	
	static int answer;
	public static int solution(int[] arr, int[] brr) {
		answer=0;
		rec(arr,brr);
        return answer;
    }
	
	public static void rec(int[] arr, int[] brr) {
		int n = arr.length;
		
		if(arr[0]<brr[0]) {
			answer++;
			int a = Math.abs(brr[0]-arr[0]);
			arr[0]+=a;
			arr[1]-=a;
		} else if(arr[0]>brr[0]) {
			answer++;
			int a = Math.abs(brr[0]-arr[0]);
			arr[0]-=a;
			arr[1]+=a;
		}
		
		if(arr[n-1]<brr[n-1]) {
			answer++;
			int a = Math.abs(brr[n-1]-arr[n-1]);
			arr[n-1]+=a;
			arr[n-2]-=a;
		} else if(arr[n-1]>brr[n-1]) {
			answer++;
			int a = Math.abs(brr[n-1]-arr[n-1]);
			arr[n-1]-=a;
			arr[n-2]+=a;
		}
		
		boolean flag = true;
		for(int i=0; i<n; i++) {
			if(arr[i]!=brr[i]) {
				System.out.println(i);
				flag=false;
				break;
			}
		}
		if(flag) return ;
		
		if(n-2==1 || n-2==0) return;

		int[] narr = new int[n-2];
		int[] nbrr = new int[n-2];
		
		for(int i=1; i<n-1; i++) {
			narr[i-1]=arr[i];
			nbrr[i-1]=brr[i];
		}
		
		rec(narr,nbrr);
	}
}
