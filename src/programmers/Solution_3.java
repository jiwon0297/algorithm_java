package programmers;

import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_3 {
	public static void main(String[] args) {
		String[] a = {"01/01 4 50000","01/11 6 3555","02/01 0 -23555","02/25 5 5000","03/25 0 -15000","06/09 8 43951","12/30 9 99999"};
		System.out.println(solution(a));
	}
	
	static class Yegeum {
        int mm,dd,r,money;

        public Yegeum(int mm, int dd, int r, int money){
            this.mm=mm;
            this.dd=dd;
            this.r=r;
            this.money=money;
        }
    }

    static int[] day = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    static Stack<Yegeum> s;
    static int answer;
 
    public static int solution(String[] ledgers) {
        answer = 0;

        s = new Stack<>();
        StringTokenizer st = null;
        for(int i=0; i<ledgers.length; i++){
            st=new StringTokenizer(ledgers[i]);
            String date = st.nextToken();
            int r = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            st=new StringTokenizer(date,"/");
            int mm = Integer.parseInt(st.nextToken());
            int dd = Integer.parseInt(st.nextToken());
            
            Yegeum now = new Yegeum(mm,dd,r,money);

            if(money<0) cal(now);
            else s.push(now);
        }
        
        while(!s.isEmpty()) {
        	Yegeum y = s.pop();
        	int isa = (int) ((datecal(y.mm, y.dd, 12, 31) / 365.0) * (y.money*y.r*0.01));
        	answer+=isa;
        }

        return answer;
    }

	private static void cal(Yegeum now) {
		Yegeum before = s.pop();
        if(before.money<=-now.money) {
        	answer+=(datecal(before.mm, before.dd, now.mm, now.dd) / 365.0) * (before.money*before.r*0.01);
        	now.money=now.money+before.money;
        	if(now.money==0) return;
        	else cal(now);
        } else if(before.money>-now.money) {
        	answer+=(datecal(before.mm, before.dd, now.mm, now.dd) / 365.0) * (-now.money*before.r*0.01);
        	before.money=before.money+now.money;
        	s.push(before);
        	return ;
        }
	}

	private static int datecal(int bm, int bd, int nm, int nd) {
		if(bm==nm) return nd-bd;
		else if(Math.abs(bm-nm)==1) return day[bm]-bd+nd;
		else {
			int sum=day[bm]-bd+nd;
			for(int i=bm+1; i<nm; i++) {
				sum+=day[i];
			}
			return sum;
		}
	}
}
