package programmers;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Solution_line_1 {
	public static void main(String[] args) {
		String s = "team_name : db application_name : dbtest error_level : info message : test";
		System.out.println(isChk(s));
	}
	
	public int solution(String[] logs) {
        int answer = -1;
        
        int cnt=0;
        for(int i=0; i<logs.length; i++) {
        	if(!isChk(logs[i])) cnt++;
        }
        
        answer=cnt;
        return answer;
    }

	private static boolean isChk(String s) {
		int len = s.length();
		if(len>100) return false;
		if(!s.contains("team_name")) return false;
		if(!s.contains("application_name")) return false;
		if(!s.contains("error_level")) return false;
		if(!s.contains("message")) return false;
		
		String[] strarr = s.split(":| ");
		if(strarr.length!=16) return false;
		if(!strarr[0].equals("team_name") || !strarr[4].equals("application_name")
				|| !strarr[8].equals("error_level") || !strarr[12].equals("message")) return false;
		if(strarr[3].equals("team_name") || strarr[7].equals("application_name") ||
				strarr[13].equals("error_level") || strarr[15].equals("message") ) return false;
		
		boolean a = Pattern.matches("^[a-zA-Z]*$", strarr[3]);
		boolean b = Pattern.matches("^[a-zA-Z]*$", strarr[7]);
		boolean c = Pattern.matches("^[a-zA-Z]*$", strarr[11]);
		boolean d = Pattern.matches("^[a-zA-Z]*$", strarr[15]);
		
		if(!a || !b || !c || !d) return false;
		
		return true;
	}


}
