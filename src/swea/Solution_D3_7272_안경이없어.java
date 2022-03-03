package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_7272_안경이없어 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			boolean isSame=true;
			
			if(str1.length()!=str2.length()) {
				isSame=false;
			} else {
				for(int i=0; i<str1.length(); i++) {
					if((isOne(str1.charAt(i)) && !isOne(str2.charAt(i)))
							|| (!isOne(str1.charAt(i)) && isOne(str2.charAt(i)))) {
						isSame=false;
						break;
					}
					
					if((str1.charAt(i)=='B' && str2.charAt(i)!='B')
							|| (str2.charAt(i)=='B' && str1.charAt(i)!='B')) {
						isSame=false;
						break;
					}
				}
			}
			
			if(isSame) System.out.println("#"+t+" "+"SAME");
			else System.out.println("#"+t+" "+"DIFF");
		}
	}

	private static boolean isOne(char ch) {
		return ch=='A' || ch=='P' || ch=='Q' || ch=='O' || ch=='D' || ch=='R';
	} 
}
