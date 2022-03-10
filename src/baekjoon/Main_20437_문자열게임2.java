package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_20437_문자열게임2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			
			if(K==1) {
				System.out.println("1 1");
				continue;
			}
			
			int[] alpha = new int[26];
			for(int i=0; i<W.length(); i++) {
				alpha[W.charAt(i)-'a']++;
			}
			
			int min=Integer.MAX_VALUE;
			int max=Integer.MIN_VALUE;
			
			for(int i=0; i<W.length(); i++){
				if(alpha[W.charAt(i)-'a']<K) continue;
				
				int cnt=1;
				for(int j=i+1; j<W.length(); j++) {
					if(W.charAt(i)==W.charAt(j)) cnt++;
					if(cnt==K) {
						min=Math.min(min, j-i+1);
						max=Math.max(max, j-i+1);
						break;
					}
				}
			}
			
			if(min==Integer.MAX_VALUE || max==Integer.MIN_VALUE) System.out.println("-1");
			else System.out.println(min+" "+max);
		}
	}

}
