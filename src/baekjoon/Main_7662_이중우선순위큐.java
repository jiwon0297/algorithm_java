package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main_7662_이중우선순위큐 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> q = new TreeMap<>();
			
			for(int i=0; i<k; i++) {
				String str= br.readLine();
				String[] operator = str.split(" ");
				String comm = operator[0];
				int num = Integer.parseInt(operator[1]);
				
				switch(comm) {
					case "I":
						q.put(num, q.getOrDefault(num, 0)+1);
						break;
					
					case "D":
						if(q.isEmpty()) continue;
						if(num==1) {
							num=q.lastKey();
						} else if(num==-1) {
							num=q.firstKey();
						}
						if(q.get(num)==1) q.remove(num);
						else q.put(num, q.get(num)-1);
						break;
				}
			}
			
			if(q.isEmpty()) System.out.println("EMPTY");
			else {
				System.out.println(q.lastKey()+" "+q.firstKey());
			}
		}
	}

}
