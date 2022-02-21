package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	
	static int L,C;
	static char[] ch;
	static char[] res;
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ch = new char[C];
		res = new char[L];
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			ch[i]=st.nextToken().charAt(0);
		}
		Arrays.sort(ch);

		combi(0,0);
		System.out.println(sb.toString());
	}

	private static void combi(int cnt, int start) {
		if(cnt==L) {
			if(isJaummoum()) return;
			if(!isSort()) return;
			for(int i=0; i<L; i++) {
				sb.append(res[i]);
			}
			sb.append('\n');
			return;
		}
		
		for(int i=start; i<C; i++) {
			res[cnt]=ch[i];
			combi(cnt+1, i+1);
		}
	}

	private static boolean isSort() {
		for(int i=0; i<L-1; i++) {
			if(res[i]>res[i+1]) return false;
		}
		return true;
	}

	private static boolean isJaummoum() {
		int count=0;
		for(int i=0; i<L; i++) {
			if(res[i]=='a' || res[i]=='e' || res[i]=='i' || res[i]=='o' || res[i]=='u') {
				count++;
			}
		}
		
		int jaum=L-count;
		
		return (count==0) || (jaum<2);
	}

}
