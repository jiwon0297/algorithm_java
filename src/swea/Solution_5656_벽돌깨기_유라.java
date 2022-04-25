package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기_유라 {
	
	static class Point  {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	static int N,W,H,min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st=new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];			
			for(int i=0; i<H; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			min=Integer.MAX_VALUE;		
			go(map, 0);
			sb.append("#"+t+" "+min+"\n");
		}
		System.out.println(sb);
	}

	private static boolean go(int[][] map, int cnt) { //중복순열을 이용하여 구슬 던지기, 벽돌이 다 부서졌다면 true 아니면 false
		
		int result=getRemain(map);
		
		if(result==0) { //모든 벽돌이 다 부서졌다면
			min=0;
			return true;
		}
		
		if(cnt==N) { //모든 구슬을 다 던졌다면
			min=Math.min(min, result);
			return false;
		}

		int[][] newMap = new int[H][W];
		//0열부터 W-1열까지 구슬 던져보기
		for(int c=0; c<W; c++) {
			//구슬에 맞는 벽돌 찾기
			int r=0;
			while(r<H && map[r][c]==0) r++; //빈공간이면 계속해서 아래로
			
			//해당 열은 벽돌이 없음
			if(r==H) continue;
			
			//배열의 상태 백업
			copy(map,newMap);
			boom(newMap, r,c); //현재 벽돌 기준으로 주변의 가능한 모든 벽돌 함께 연쇄 처리
			down(newMap); //부서진 벽돌 정리
			
			if(go(newMap, cnt+1)) return true; //다음 구슬 던지러 go
		}
		
		return false;
	}

	private static void copy(int[][] map, int[][] newMap) {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				newMap[i][j]=map[i][j];
			}
		}
	}

	private static void boom(int[][] map, int r, int c) { //r,c 위치에서 주변의 가능한 모든 벽돌도 함께 부수는 처리
		Queue<Point> q = new LinkedList<>();
		if(map[r][c]>1) q.offer(new Point(r,c,map[r][c])); //벽돌 크기가 2 이상이면
		map[r][c]=0; //자신은 제거처리(빈 공간으로 ..) : visit 처리 역할
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int d=0; d<4; d++) {
				int nr=cur.r, nc=cur.c;
				
				for(int i=1; i<cur.cnt; i++) {
					nr+=dr[d];
					nc+=dc[d];
					
					if(!chk(nr,nc) || map[nr][nc]<=0) continue;
					if(map[nr][nc]>1) q.offer(new Point(nr,nc,map[nr][nc])); //주변 벽돌에 영향을 주는 벽돌이면
					map[nr][nc]=0;
				}
			}
		}		
	}
	
	private static boolean chk(int r, int c) {
		return r>=0 && r<H && c>=0 && c<W;
	}

	private static void down(int[][] map) { //부서진 벽돌 정리, 남은 벽돌 정리 !!
        for (int c = 0; c < W; c++) {
            int r = H - 1; // 밑에서 시작
            while (r > 0) {
                if (map[r][c] == 0) {
                    int nr = r - 1;
                    while (nr > 0 && map[nr][c] == 0) // 맨 윗행까지 가거나 내릴 벽돌 찾을때까지
                        nr--;
                    map[r][c] = map[nr][c];
                    map[nr][c] = 0;
                }
                r--;
            }
        }
    }
	
	private static int getRemain(int[][] map) { //남은 벽돌 수 리턴
		int sum=0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j]>0) sum++;
			}
		}
		return sum;
	}
}
