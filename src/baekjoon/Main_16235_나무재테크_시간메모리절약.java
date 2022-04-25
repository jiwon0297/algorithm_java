package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//16488KB 468ms
public class Main_16235_나무재테크_시간메모리절약 {
	
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	
	static int[][] map, food;
	static ArrayList<Integer>[][] trees;
	static int N,M,K,answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		trees=new ArrayList[N][N];
		map = new int[N][N];
		food = new int[N][N];
		
		//input
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=5;
				trees[i][j]=new ArrayList<>();
				food[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			trees[x][y].add(z);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				Collections.sort(trees[i][j], Collections.reverseOrder());
			}
		}
		
		//solution
		while(K-->0) {
			ssw(); //spring & summer & winter
			fall();
		}
		
		answer=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				answer+=trees[i][j].size();
			}
		}
		System.out.println(answer);
	}
	
	private static void ssw() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				ArrayList<Integer> curr = trees[i][j];
				int oldfood = map[i][j];
				int newfood = 0;
				
				for(int idx=curr.size()-1; idx>=0; idx--) {
					int age = curr.get(idx);
					if(oldfood>=age) {
						oldfood-=age;
						curr.set(idx, age+1);
					} else {
						newfood+=age/2;
						curr.remove(idx);
					}
				}	
				map[i][j]=oldfood+newfood+food[i][j];
			}
		}
	}
	
	private static void fall() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				ArrayList<Integer> curr = trees[i][j];
				for(int age : curr) {
					if(age%5!=0) continue;
					
					for(int d=0; d<8; d++) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						if(!chk(nr,nc)) continue;
						trees[nr][nc].add(1);
					}
				}
			}
		}
	}
	
	private static boolean chk(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
