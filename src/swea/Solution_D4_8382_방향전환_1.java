package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_8382_방향전환_1 {

	static int x1,y1,x2,y2;
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for(int t=1; t<=T; t++) {
			st=new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			min=Integer.MAX_VALUE;
			move(true);
			move(false);
			
			System.out.println("#"+t+" "+min);
		}
	}

	private static void move(boolean flag) {
		int dx=x1, dy=y1, cnt=0;
		
		while(true) {
			if(dx==x2 && dy==y2) {
				if(min>cnt) min=cnt; 
				break;
			}
			
			//flag true : 가로 false: 세로 
			if(flag) {
				if(dy>y2) dy--;
				else dy++;
				flag=false;
			} else {
				if(dx>x2) dx--;
				else dx++;
				flag=true;
			}
			
			cnt++;
		}
	}

}
