package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		int sum=Integer.MAX_VALUE;
		String[] sub = line.split("-");
		
		for(int i=0; i<sub.length; i++) {
			int tmp=0;
			
			String[] add = sub[i].split("\\+");
			for(int j=0; j<add.length; j++) {
				tmp+=Integer.parseInt(add[j]);
			}
			
			if(sum==Integer.MAX_VALUE) sum=tmp;
			else sum-=tmp;
		}
		
		System.out.println(sum);
	}

}
