package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1085_직사각형에서탈출 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x= Integer.parseInt(st.nextToken());
		int y= Integer.parseInt(st.nextToken());
		int w= Integer.parseInt(st.nextToken());
		int h= Integer.parseInt(st.nextToken());
		
		int res=0;
		int a =Math.min(Math.abs(x-w), Math.abs(y-h));
		int b= Math.min(x, y);
		res=Math.min(a, b);
		
		System.out.println(res);
		
	}

}
