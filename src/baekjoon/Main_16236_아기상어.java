package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {

	static int N;
	static int[][] map;
	static int[] dr= {1,0,-1,0};
	static int[] dc= {0,1,0,-1};
	static int sr,sc;
	static int minr,minc,mindist;
	static int[][] dist;
	static int eat, size, cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map=new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					sr=i;
					sc=j;
					map[i][j]=0;
				}
			}
		}
		
		cnt=0;
		eat=0;
		size=2;
		while(true) {
			//init
			dist=new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					dist[i][j]=-1;
				}
			}
			minr=Integer.MAX_VALUE;
			minc=Integer.MAX_VALUE;
			mindist=Integer.MAX_VALUE;
			
			bfs(sr,sc);
			
			//minr과 minc가 있을 때
			if(minr!=Integer.MAX_VALUE && minc!=Integer.MAX_VALUE) {
				eat++; //먹은 cnt++
				cnt+=dist[minr][minc]; //한칸에 1초씩이니까 cnt(답)에 +=
				
				if(eat==size) {
					size++;
					eat=0;
				}
				
				map[minr][minc]=0;
				sr=minr;
				sc=minc;
				
			} else break;
		}
		
		System.out.println(cnt);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		dist[r][c]=0;
		q.offer(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int[] cur=q.poll();
			int cr=cur[0];
			int cc=cur[1];
			
			for(int i=0; i<4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc)) continue;
				if(dist[nr][nc]!=-1 || map[nr][nc]>size) continue;
				
				dist[nr][nc]=dist[cr][cc]+1; //거리
				
				if(map[nr][nc]!=0 && map[nr][nc]<size) { //먹을 수 있을 때
					if(mindist>dist[nr][nc]) { //최소거리 구하기
						minr=nr;
						minc=nc;
						mindist=dist[nr][nc];
					}
					
					else if(mindist==dist[nr][nc]) { //가까운 거리가 많으면
						if(minr==nr) { //위부터인데 위도 많으면
							if(minc>nc) { //왼쪽
								minr=nr;
								minc=nc;
							}
						} else if(minr>nr) { //위부터
							minr=nr;
							minc=nc;
						}
					}
				}
				q.offer(new int[] {nr,nc}); //크기가같을때도 지나가야하니까 바깥에서 offer
			}
		}
	}

	private static boolean chk(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<N;
	}

}
