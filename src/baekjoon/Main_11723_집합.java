package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_11723_집합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String[] command = br.readLine().split(" ");
			
			String comm = command[0];
			if(command.length!=1) {
				int x = Integer.parseInt(command[1]);
				switch(comm) {
				case "add" :
					set.add(x);
					break;
				
				case "remove":
					if(set.contains(x)) set.remove(x);
					break;
				
				case "check":
					if(set.contains(x)) sb.append(1+"\n");
					else sb.append(0+"\n");
					break;
				
				case "toggle":
					if(set.contains(x)) set.remove(x);
					else set.add(x);
					break;
				}
			} else {
				switch(comm) {
					case "all" :
						set.clear();
						for(int j=1; j<=20; j++) set.add(j);
						break;
			
					case "empty":
						set.clear();
						break;
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}
