package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9935_문자열폭발2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		
		String ans = replace(str,bomb);
		System.out.println(ans.length()==0? "FRULA":ans);
	}

	private static String replace(String str, String bomb) {
		char[] arr = new char[str.length()];
		int idx=0;
		
		for(int i=0; i<str.length(); i++) {
			arr[idx]=str.charAt(i);
			if(isBomb(arr,idx,bomb)) idx-=bomb.length();
			idx++;
		}
		
		return String.valueOf(arr,0,idx);
	}

	private static boolean isBomb(char[] arr, int idx, String bomb) {
		if(idx<bomb.length()-1) return false;
		
		for(int i=0; i<bomb.length(); i++) {
			if(bomb.charAt(i)!=arr[idx-bomb.length()+1+i]) return false;
		}
		return true;
	}

}
