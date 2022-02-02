package baekjoon;

public class Main_4673_셀프넘버 {

	public static void main(String[] args) {
		int[] arr = new int[10001];
		
		int n = 1;
		while(n<100001) {
			if(n<10) {
				int dn=n+n;
				if(dn<10001) {
					arr[dn]++;
				}
				n++;
			}else if(n<100) {
				int a1=n/10;
				int a2=n%10;
				int dn=n+a1+a2;
				if(dn<10001) {
					arr[dn]++;
				}
				n++;
			}else if(n<1000) {
				int a1=n/100;
				int a2=(n/10)%10;
				int a3=n%10;
				int dn=n+a1+a2+a3;
				if(dn<10001) {
					arr[dn]++;
				}
				n++;
			} else {
				int a1=n/1000;
				int a2=(n/100)%10;
				int a3=(n/10)%10;
				int a4=n%10;
				int dn=n+a1+a2+a3+a4;
				if(dn<10001) {
					arr[dn]++;
				}
				n++;
			}
		}
		
		for(int i=1; i<=10000; i++) {
			if(arr[i]==0) System.out.println(i);
		}
	}

}
