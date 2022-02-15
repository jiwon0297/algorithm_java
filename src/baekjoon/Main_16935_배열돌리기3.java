package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3 {

	static int N;
	static int M;
	static int R;
	static int[][] arr;
	static int[][] res;
	static int Num;
	
	public static void main(String[] args) throws Exception{
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
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<R; i++) {
			Num=Integer.parseInt(st.nextToken());
			switch(Num) {
			case 1:
				one();
				break;
				
			case 2:
				two();
				break;
				
			case 3:
				three();
				break;
				
			case 4:
				four();
				break;
				
			case 5:
				five();
				break;
				
			case 6:
				six();
				break;
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static void six() {
		int[][] sub1 = new int[N/2][M/2];
		int[][] sub2 = new int[N/2][M/2];
		int[][] sub3 = new int[N/2][M/2];
		int[][] sub4 = new int[N/2][M/2];
		
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				sub1[i][j]=arr[i][j];
				sub2[i][j]=arr[i][j+M/2];
				sub3[i][j]=arr[i+N/2][j+M/2];
				sub4[i][j]=arr[i+N/2][j];
			}
		}
		
		res=new int[N][M];
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				res[i][j]=sub2[i][j];
				res[i][j+M/2]=sub3[i][j];
				res[i+N/2][j+M/2]=sub4[i][j];
				res[i+N/2][j]=sub1[i][j];
			}
		}
		
		arr=res;
	}

	private static void five() {
		int[][] sub1 = new int[N/2][M/2];
		int[][] sub2 = new int[N/2][M/2];
		int[][] sub3 = new int[N/2][M/2];
		int[][] sub4 = new int[N/2][M/2];
		
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				sub1[i][j]=arr[i][j];
				sub2[i][j]=arr[i][j+M/2];
				sub3[i][j]=arr[i+N/2][j+M/2];
				sub4[i][j]=arr[i+N/2][j];
			}
		}
		
		res=new int[N][M];
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				res[i][j]=sub4[i][j];
				res[i][j+M/2]=sub1[i][j];
				res[i+N/2][j+M/2]=sub2[i][j];
				res[i+N/2][j]=sub3[i][j];
			}
		}
		
		arr=res;
	}

	private static void four() {
		res = new int[M][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				res[M-j-1][i]=arr[i][j];
			}
		}
		
		int tmp=N;
		N=M;
		M=tmp;
		arr=res;
	}

	private static void three() {
		res = new int[M][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				res[j][N-i-1]=arr[i][j];
			}
		}
		
		int tmp=N;
		N=M;
		M=tmp;
		arr=res;
	}

	private static void two() {
		res = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				res[i][M-j-1]=arr[i][j];
			}
		}
		arr=res;
	}

	private static void one() {
		res = new int[N][M];
		for(int i=0; i<N; i++) {
			res[N-i-1]=arr[i];
		}
		arr=res;
	}

}
