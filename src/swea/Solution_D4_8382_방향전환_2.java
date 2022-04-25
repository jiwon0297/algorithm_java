package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_8382_방향전환_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for(int t=1; t<=T; t++) {
			st=new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int dx=Math.abs(x1-x2);
			int dy=Math.abs(y1-y2);
			
			if((dx+dy)%2==0) System.out.println("#"+t+" "+Math.max(dx, dy)*2);
			if((dx+dy)%2==1) System.out.println("#"+t+" "+(Math.max(dx, dy)*2-1));
		}
	}

}
