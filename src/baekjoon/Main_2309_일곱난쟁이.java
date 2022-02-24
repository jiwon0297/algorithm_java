package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309_일곱난쟁이 {

	static int[] dwarf;
	static int[] res;
	static StringBuilder sb;
	static boolean isDwarf=false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dwarf=new int[9];
		for(int i=0; i<9; i++) {
			dwarf[i]=Integer.parseInt(br.readLine());
		}
		
		res=new int[7];
		sb=new StringBuilder();
		Arrays.sort(dwarf);
		combi(0,0,0);
		
		System.out.println(sb.toString());
	}

	private static void combi(int start, int cnt, int sum) {
		if(isDwarf) return;
		if(cnt==7) {
			if(sum==100) {
				for(int i:res) {
					sb.append(i).append('\n');
				}
				isDwarf=true;
				
			}
			return;
		}
		
		for(int i=start; i<9; i++) {
			res[cnt]=dwarf[i];
			combi(i+1, cnt+1, sum+dwarf[i]);
		}
	}

}
