package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1493_수의새로운연산2 {
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for(int t=1; t<=T; t++) {
			st=new StringTokenizer(br.readLine());
			int p=Integer.parseInt(st.nextToken());
			int q=Integer.parseInt(st.nextToken());
			
			Point pp = find(p);
			Point qp = find(q);
			
			Point res = new Point(pp.x+qp.x, pp.y+qp.y);
			
			int x=1; 
			int y=1;
			int cnt=1;
			int idx=1;
			while(true) {
				if(x==res.x && y==res.y) {
					System.out.println("#"+t+" "+cnt);
					break;
				}
				
				int nx=x+1;
				int ny=y-1;
				if(ny==0) {
					idx++;
					y=idx;
					x=1;
					cnt++;
					continue;
				}
				
				x=nx;
				y=ny;
				cnt++;
			}
		}
	}

	private static Point find(int p) {
		int x=1;
		int y=1;
		int cnt=1;
		int idx=1;
		Point xy;
		while(true) {
			if(cnt==p) {
				xy=new Point(x,y);
				break;
			}
			
			int nx=x+1;
			int ny=y-1;
			
			if(ny==0) {
				idx++;
				y=idx;
				x=1;
				cnt++;
				continue;
			} 
			
			x=nx;
			y=ny;
			cnt++;
		}
		
		return xy;
	}
}
