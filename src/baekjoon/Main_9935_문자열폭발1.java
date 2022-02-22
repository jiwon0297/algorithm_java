package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//메모리초과...
public class Main_9935_문자열폭발1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		
		while(str.contains(bomb)) {
			str=str.replaceAll(bomb, "");
		}
		
		if(str.length()==0) System.out.println("FRULA");
		else System.out.println(str);
	}

}
