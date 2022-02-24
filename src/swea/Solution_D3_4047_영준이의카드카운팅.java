package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_4047_영준이의카드카운팅 {

	static int[][] cardMap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String s = br.readLine();
			int len = s.length();
			cardMap=new int[5][14]; //suit4+1 value13+1
			
			for(int i=0; i<len; i+=3) {
				String cs=s.substring(i,i+3);
				char cc = cs.charAt(0);
				int val=Integer.parseInt(cs.substring(1));
				
				switch(cc) {
					case 'S':
						cardMap[1][val]++;
						break;
					
					case 'D':
						cardMap[2][val]++;
						break;
					
					case 'H' :
						cardMap[3][val]++;
						break;
						
					case 'C' :
						cardMap[4][val]++;
						break;
				}
			}
			
			int[] cnt=new int[5];
			StringBuilder sb = new StringBuilder();
			boolean isP = false;
			sb.append("#").append(t).append(" ");
			
			for(int i=1; i<=4; i++) {
				for(int j=1; j<=13; j++) {
					if(cardMap[i][j]>1) {
						isP=true;
						break;
					}
					
					else {
						cnt[i]+=cardMap[i][j];
					}
				}
			}
			
			if(isP) sb.append("ERROR");
			else {
				for(int i=1; i<=4; i++) {
					sb.append(13-cnt[i]).append(" ");
				}
			}
			
			System.out.println(sb.toString());
		}
	}

}
