package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5607_조합 {

	static int mod = 1234567891;
	static long factorial[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		factorial=new long[1000000+1];
		factorial[0]=1;
        for(int i=1;i<=1000000;i++) factorial[i]=(factorial[i-1]*i)%mod; 
        
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			st=new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			long top = factorial[N]%mod;
            long bottom = ((factorial[N-R]%mod ) * (factorial[R]%mod))%mod;
            
            long moveToTop = powCalc(bottom,mod-2);
			sb.append(((top*moveToTop)%mod)+"\n");
		}
		System.out.println(sb.toString());
	}

	static long powCalc(long num,int p) {
        if(p==0)
            return 1;
        
        long half = powCalc(num, p/2);
        
        if(p%2==0) {
            return ((half%mod) * (half%mod))%mod;
        }else
            return (((half*num)%mod) * (half%mod))%mod;
    }
}