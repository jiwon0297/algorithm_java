package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Solution_D2_2007_패턴마디의길이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String st = br.readLine();

			int idx = 0;
			for(int i=1; i<st.length(); i++) {
				String a = st.substring(0, i);
				String b = st.substring(i, i+i);
				
				if(a.equals(b)){
					System.out.println("#"+t+" "+a.length());
					break;
				}
			}
		}
	}

}
