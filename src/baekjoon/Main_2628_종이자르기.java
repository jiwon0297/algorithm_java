package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2628_종이자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int g = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> garo = new ArrayList<>();
		garo.add(g);
		ArrayList<Integer> sero = new ArrayList<>();
		sero.add(s);
		
		garo.add(0);
		sero.add(0);
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(x==0) { //가로 
				sero.add(num);
			} else if(x==1) { //세로 
				garo.add(num);
			}
		}
		
		Collections.sort(garo);
		Collections.sort(sero);
		
		int wid=0;
		int hei=0;
		int max=0;
		
		for(int i=1; i<garo.size(); i++) {
			for(int j=1; j<sero.size(); j++) {
				wid=garo.get(i)-garo.get(i-1);
				hei=sero.get(j)-sero.get(j-1);
				max=Math.max(max, wid*hei);
			}
		}
		
		System.out.println(max);
	}

}
