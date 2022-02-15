package 정올;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class C implements Comparable<C> {
	int x;
	int y;
	
	public C(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(C o) {
		int diff=this.y-o.y;
		return diff!=0 ? diff:this.x-o.x;
	}
	
}

public class Main_1828_냉장고 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		C[] cs = new C[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			cs[i]=new C(x,y);
		}
		
		int res=N;
		Arrays.sort(cs);
		
		int maxNum=cs[0].y;
		for(int i=0; i<N-1; i++) {
			if(maxNum>=cs[i+1].x) res--;
			else maxNum=cs[i+1].y;
		}
		
		System.out.println(res);
	}

}
