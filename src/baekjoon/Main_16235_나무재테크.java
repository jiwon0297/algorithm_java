package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16235_나무재테크 {
	
	static class Tree implements Comparable<Tree> {
		int x,y,age;

		public Tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age-o.age;
		}
	}
	
	static LinkedList<Tree> tree;
	static Queue<Tree> dtree;
	static int N;
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j]=5;
			}
		}
		
		int[][] A = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		tree = new LinkedList<>();
		dtree = new LinkedList<>();
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			tree.add(new Tree(x,y,z));
		}
		
		while(K-->0) {	
			//spring
			Iterator<Tree> iterator = tree.iterator();
			while(iterator.hasNext()) {
				Tree t = iterator.next();
				int r = t.x;
				int c = t.y;
				int age = t.age;
				if(map[r][c]>=age) {
					map[r][c]-=age;
					t.age++;
				} else {
					dtree.add(t);
					iterator.remove();
				}
			}
			
			//summer
			while(!dtree.isEmpty()) {
				Tree t = dtree.poll();
				map[t.x][t.y]+=t.age/2;
			}
			
			//fall
			LinkedList<Tree> baby = new LinkedList<>();
			for(Tree t : tree) {
				int r = t.x;
				int c = t.y;
				if(t.age%5!=0) continue;
				for(int i=0; i<8; i++) {
					int nr=r+dr[i];
					int nc=c+dc[i];
					
					if(!chk(nr,nc)) continue;
					baby.add(new Tree(nr,nc,1));
				}
			}
			tree.addAll(0,baby);
			
/*			for(int i=0; i<tree.size(); i++) {
				int r = tree.get(i).x;
				int c = tree.get(i).y;
				int age = tree.get(i).age;
				
				if(age%5!=0) continue;
				for(int j=0; j<8; j++) {
					int nr=r+dr[j];
					int nc=c+dc[j];
						
					if(!chk(nr,nc)) continue;
					tree.add(new Tree(nr,nc,1));
				}
			}
*/			
			//winter
			add(map,A);
		}
		System.out.println(tree.size());
	}
	
	private static boolean chk(int r, int c) {
		return r>=1 && r<=N && c>=1 && c<=N;
	}

	private static int[][] add(int[][] map, int[][] A){
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j]+=A[i][j];
			}
		}
		return map;
	}
}
