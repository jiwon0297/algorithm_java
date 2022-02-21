package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {
	
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			int diff=this.end-o.end;
			if(diff==0) {
				return this.start-o.start;
			}
			return diff;
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i]=new Meeting(start,end);
		}
		Arrays.sort(meetings);
		
		int cnt=0;
		int endtime=0;
		for(int i=0; i<N; i++) {
			if(endtime<=meetings[i].start) {
				endtime=meetings[i].end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
