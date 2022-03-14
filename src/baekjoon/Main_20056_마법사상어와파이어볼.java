package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//시간복잡도 O(KM)
public class Main_20056_마법사상어와파이어볼 {

	static class Fireball {
		int r,c,m,s,d;

		public Fireball(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static int N,M,K;
	static ArrayList<Fireball>[][] map;
	static ArrayList<Fireball> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map=new ArrayList[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=new ArrayList<>();
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list.add(new Fireball(r,c,m,s,d));
		}
		
		for(int i=0; i<K; i++) {
			move();
			chk();
		}
		
		int res=0;
		for(Fireball ball:list) res+=ball.m;
		System.out.println(res);
	}

	//2개 이상인 파이어볼 나누기 
	private static void chk() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].size()==1) map[i][j].clear();
				if(map[i][j].size()<2) continue;
				
				int msum=0;
				int ssum=0;				
				boolean isEven = map[i][j].get(0).d % 2==0? true:false;
				boolean isOdd = map[i][j].get(0).d % 2==1? true:false;
				
				for(Fireball cur : map[i][j]) {
					msum+=cur.m;
					ssum+=cur.s;
					isEven=isEven & cur.d % 2==0? true:false;
					isOdd=isOdd & cur.d % 2==1? true:false;
					list.remove(cur);
				}
				
				int nm = msum/5;
				int size=map[i][j].size();
				map[i][j].clear();
				if(nm==0) continue;
				
				int ns=ssum/size;
				if(isEven | isOdd) { //다 홀수거나 다 짝수거나 
					for(int k=0; k<8; k+=2) list.add(new Fireball(i,j,nm,ns,k));
				} else { //홀짝 섞여있을때 
					for(int k=1; k<8; k+=2) list.add(new Fireball(i,j,nm,ns,k));
				}
				
			}
		}
	}

	static int[] dr= {-1,-1,0,1,1,1,0,-1};
	static int[] dc= {0,1,1,1,0,-1,-1,-1};
	
	private static void move() {
		for(Fireball ball : list) {
			int nr=(ball.r + N + dr[ball.d] * (ball.s % N)) % N;
			int nc=(ball.c + N + dc[ball.d] * (ball.s % N)) % N;
			
			ball.r=nr;
			ball.c=nc;
			map[nr][nc].add(ball);
		}
	}

}