package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_1213_String {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int T = Integer.parseInt(br.readLine());
			String word= br.readLine();
			String str= br.readLine();
			
			int cnt=-1;
			int ans=0;
			while((cnt=str.indexOf(word,cnt+1))>=0) {
				ans++;
			}
			
			System.out.println("#"+t+" "+ans);
		}
	}

}
