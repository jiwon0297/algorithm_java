package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Location implements Comparable<Location> {

	int x;
	int y;

	
	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	@Override
	public int compareTo(Location o) {
		if(this.x>o.x) return 1;
		else if(this.x==o.x) {
			if(this.y>o.y) return 1;
			else if(this.y==o.y) return 0;
			else return -1;
		}
		return -1;
	}
	
}

public class Main_11650_좌표정렬하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Location> loc = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			loc.add(new Location(x,y));
		}
		
		Collections.sort(loc);
		
		StringBuilder sb = new StringBuilder();
		
		for(Location i : loc) {
			sb.append(i.x).append(" ").append(i.y).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
