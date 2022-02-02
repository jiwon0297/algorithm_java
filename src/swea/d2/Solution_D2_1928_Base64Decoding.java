package swea.d2;

import java.util.Base64;
import java.util.Scanner;

public class Solution_D2_1928_Base64Decoding {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String encoding = sc.next();
			byte[] result = Base64.getDecoder().decode(encoding);
			String resultString = new String(result);
			System.out.println("#"+t+" "+resultString);
		}
	}

}
