package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_로또 {

	static int k;
	static int[] nums;
	static int[] res;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			
			nums=new int[k];
			for(int i=0; i<k; i++) {
				nums[i]=Integer.parseInt(st.nextToken());
			}
			sb = new StringBuilder();
			res = new int[6];
			combi(0,0);
			System.out.println(sb);
		}
	}

	private static void combi(int cnt, int start) {
		if(cnt==6) {
			for(int i: res) {
				sb.append(i).append(" ");
			}
			sb.append('\n');
			return ;
		}
		
		for(int i=start; i<k; i++) {
			res[cnt]=nums[i];
			combi(cnt+1, i+1);
		}
	}

}
