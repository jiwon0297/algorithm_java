package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//크루스칼
public class Main_1922_네트워크연결 {
	
	//network 클래스
	static class Network implements Comparable<Network> {
		int computer1;
		int computer2;
		int exp;
		
		public Network(int computer1, int computer2, int exp) {
			super();
			this.computer1 = computer1;
			this.computer2 = computer2;
			this.exp = exp;
		}

		@Override
		public int compareTo(Network o) {
			return this.exp-o.exp;
		}
	}

	static int N,M;
	static Network[] netList;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		netList = new Network[M];
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			netList[i]=new Network(a,b,c);
		}
		Arrays.sort(netList); //정렬
		//makeset
		parents=new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i]=i;
		}
		
		//크루스칼
		int res=0, cnt=0;
		for(Network net : netList) {
			if(union(net.computer1, net.computer2)) {
				res+=net.exp;
				if(++cnt==N-1) break;
			}
		}
		
		System.out.println(res);
	}
	
	//union
	public static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa==pb) return false;
		parents[pb]=pa;
		return true;
	}

	//조상찾기
	private static int find(int x) {
		if(x==parents[x]) return x;
		return parents[x]=find(parents[x]);
	}

}
