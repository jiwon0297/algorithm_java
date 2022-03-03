package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_1744_수묶기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N==1) {
			System.out.println(Integer.parseInt(br.readLine()));
			return ;
		}
		
		ArrayList<Integer> pos = new ArrayList<>();
		ArrayList<Integer> neg = new ArrayList<>();

		for(int i=0; i<N; i++) {
			int x=Integer.parseInt(br.readLine());
			if(x>0) pos.add(x);
			else neg.add(x);
		}
		
		Collections.sort(pos, Collections.reverseOrder());
		Collections.sort(neg);
		
		int res=0;		
		for(int i=0; i<pos.size(); i++) {
			if((i+1)<pos.size() && pos.get(i)!=1 && pos.get(i+1)!=1) {
				res+=pos.get(i)*pos.get(i+1);
				i++;
			}
			else res+=pos.get(i);	
		}
		
		for(int i=0; i<neg.size(); i++) {
			if((i+1)<neg.size()) {
				res+=neg.get(i)*neg.get(i+1);
				i++;
			}
			else res+=neg.get(i);
		}
		
		System.out.println(res);
	}
}
