package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_11656_접미사배열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		
		ArrayList<String> strs = new ArrayList<>();
		strs.add(S);
		
		for(int i=1; i<S.length(); i++) {
			String st = S.substring(i);
			strs.add(st);
		}
		
		Collections.sort(strs);
		
		for(String st : strs) {
			System.out.println(st);
		}
	}

}
