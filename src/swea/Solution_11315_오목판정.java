package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_11315_오목판정 {

	static char[][] omok;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			omok = new char[N][N];
			
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0; j<N; j++) {
					omok[i][j]=s.charAt(j);
				}
			}
			
			boolean flag = false;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(omok[i][j]=='o' && isWin(i,j)) {
						flag=true;
						break;
					}
				}
				if(flag) break;
			}
			if(flag) System.out.println("#"+t+" YES");
			else System.out.println("#"+t+" NO");
		}
	}
	
	public static boolean isWin(int r, int c) {
		int cnt=1;
		
		for(int i=1; i<5; i++) {
			if(!chk(r+i,c)) continue;
			if(omok[r+i][c]=='o') cnt++;
		}
		
		if(cnt>=5) return true;
		else cnt=1;
		
		for(int i=1; i<5; i++) {
			if(!chk(r,c+i)) continue;
			if(omok[r][c+i]=='o') cnt++;
		}
		
		if(cnt>=5) return true;
		else cnt=1;
		
		for(int i=1; i<5; i++) {
			if(!chk(r+i,c+i)) continue;
			if(omok[r+i][c+i]=='o') cnt++;
		}
		
		if(cnt>=5) return true;
		else cnt=1;
		
		for(int i=1; i<5; i++) {
			if(!chk(r-i, c+i)) continue;
			if(omok[r-i][c+i]=='o') cnt++;
		}
		
		if(cnt>=5) return true;
		else return false;
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
