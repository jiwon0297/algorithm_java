package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {

	static int N;
	static int M;
	static int R;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] res=arr;
		for(int i=0; i<R; i++) {
			res=rotation(res);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(res[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	private static int[][] rotation(int[][] arr) {
		int[][] map = new int[N][M];
		
		int cnt=Math.min(N, M)/2;
		for(int i=0; i<cnt; i++) {	
			for(int j=i+1; j<M-i; j++) {
				map[i][j-1]=arr[i][j];
			}
			
			for(int j=i; j<M-i-1; j++) {
				map[N-i-1][j+1]=arr[N-i-1][j];
			}
			
			for(int j=i+1; j<N-i; j++) {
				map[j-1][M-i-1]=arr[j][M-i-1];
			}
			
			for(int j=i; j<N-i-1; j++) {
				map[j+1][i]=arr[j][i];
			}
		}
		
		return map;
	}

}
