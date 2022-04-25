package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11401_이항계수3 {
	
	static int mod = 1000000007;
	static long[] factorial;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		factorial=new long[N+1];
		factorial[0]=1;
        for(int i=1;i<=N;i++) factorial[i]=(factorial[i-1]*i)%mod; 
		
		long top = factorial[N]%mod;
        long bottom = ((factorial[N-R]%mod ) * (factorial[R]%mod))%mod;
        
        long moveToTop = powCalc(bottom,mod-2);
		
		
		System.out.println((top*moveToTop)%mod);
	}

	static long powCalc(long num,int p) {
        if(p==0) return 1;
        
        long half = powCalc(num, p/2);
        
        if(p%2==0) return ((half%mod) * (half%mod))%mod;
        else return (((half*num)%mod) * (half%mod))%mod;
    }
}
