package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_8911_거북이 {
	
	static int x,y,d;
	static int minX, maxX, minY, maxY;
	static int[] dx = {0,-1,0,1}; 
	static int[] dy = {1,0,-1,0}; //상, 좌, 하, 우 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String line=br.readLine();
			x=y=d=0;
			minX=maxX=minY=maxY=0;
			
			for(int i=0; i<line.length(); i++) {
				char comm = line.charAt(i);
				switch(comm) {
				case 'F' :
					x+=dx[d];
					y+=dy[d];
					update();
					break;
					
				case 'B' :
					x-=dx[d];
					y-=dy[d];
					update();
					break;
					
				case 'L' :
					d=(d+1)%4;
					break;
				
				case 'R' :
					d=(d+3)%4;
					break;
				}
			}
			
			int res = Math.abs(maxX-minX) * Math.abs(maxY-minY);
			sb.append(res+"\n");
		}
		System.out.println(sb);
	}

	private static void update() {
		minX=Math.min(minX, x);
		maxX=Math.max(maxX, x);
		minY=Math.min(minY, y);
		maxY=Math.max(maxY, y);
	}

}
