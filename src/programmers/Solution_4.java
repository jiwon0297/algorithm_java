package programmers;

import java.util.StringTokenizer;

public class Solution_4 {
	
	public static void main(String[] args) {
		String s = "2021:04:12:16:08:35";
		String[] a = {"01:06:30:00", "01:01:12:00", "00:00:09:25"};
		int[] res = solution(s,a);
		System.out.println(res[0]+" "+res[1]);
	}
	
	static class Date {
		int yy,mm,dd,hour,min,sec;

		public Date(int yy, int mm, int dd, int hour, int min, int sec) {
			super();
			this.yy = yy;
			this.mm = mm;
			this.dd = dd;
			this.hour = hour;
			this.min = min;
			this.sec = sec;
		}
	}
	public static int[] solution(String s, String[] times) {
        StringTokenizer st = new StringTokenizer(s,":");
        int yy = Integer.parseInt(st.nextToken());
        int mm = Integer.parseInt(st.nextToken());
        int dd = Integer.parseInt(st.nextToken());
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());
        Date now = new Date(yy,mm,dd,hour,min,sec);
        Date start = new Date(yy,mm,dd,hour,min,sec);
        
        int[] answer = new int[2];
        
        if(times.length==0) {
        	answer[0]=1;
        	answer[1]=1;
        } else {
        	int cnt=0;
            boolean flag=true;
            for(int i=0; i<times.length; i++) {
            	st = new StringTokenizer(times[i],":");
            	int day=Integer.parseInt(st.nextToken());
            	int si = Integer.parseInt(st.nextToken());
            	int bun = Integer.parseInt(st.nextToken());
            	int cho = Integer.parseInt(st.nextToken());
            	Date nd = addDate(now,day,si,bun,cho);
            	
            	if(cal(now.yy, now.mm, now.dd, nd.yy, nd.mm, nd.dd)>1) flag=false;
            	now=nd;

            	if(i==times.length-1) cnt=cal(start.yy, start.mm, start.dd, nd.yy, nd.mm, nd.dd)+1;
            }
            
            answer[1]=cnt;
            if(flag) answer[0]=1;
            else answer[0]=0;
        }
        
        return answer;
    }
	
	private static int cal(int by, int bm, int bd, int ny, int nm, int nd) {
		int cnt=0;
		int YYYY = 0;
		int MM = 0;
		int DD = 0;

		if(nd>=bd) DD=nd-bd;
		else {
			nm--;
			DD=30+nd-bd;
		}
		
		if(nm>=bm) MM=nm-bm;
		else {
			ny--;
			MM=12+nm-bm;
		}
		
		YYYY=ny-by;
		cnt=(YYYY*360)+(MM)*30+DD;
		return cnt;
	}
	
	private static Date addDate(Date now, int day, int si, int bun, int cho) {
		int YYYY = now.yy;
		int MM = now.mm;
		int DD = now.dd;
		int HH = now.hour;
		int mm = now.min;
		int SS = now.sec;
		
		SS+=cho;
		if(SS>=60) {
			mm+=SS/60;
			SS%=60;
		}
		
		mm+=bun;
		if(mm>=60) {
			HH+=mm/60;
			mm%=60;
		}
		
		HH+=si;
		if(HH>=24) {
			DD+=HH/24;
			HH%=24;
		}
		
		DD+=day;
		if(DD>30) {
			MM+=(DD/30);
			DD%=30;
			if(DD==0) {
				DD=30;
				MM-=1;
			}
		}
		
		if(MM>12) {
			YYYY+=(MM/12);
			MM%=12;
			if(MM==0) {
				MM=12;
				YYYY-=1;
			}
		}

		return new Date(YYYY,MM,DD,HH,mm,SS);
	}
}
