package programmers;

import java.util.Stack;

public class Solution_표편집 {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> remove = new Stack<>();
        int size=n;

        for(int i=0; i<cmd.length; i++){
            char c = cmd[i].charAt(0);
            switch(c){
                case 'U':
                    k-=Integer.parseInt(cmd[i].substring(2));
                    break;
                    
                case 'D':
                    k+=Integer.parseInt(cmd[i].substring(2));
                    break;
                    
                case 'C':
                    remove.add(k);
                    size--;
                    if(k==size) k--;
                    break;
                    
                case 'Z':
                    if(remove.pop()<=k) k++;
                    size++;
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++){
            sb.append("O");
        }
        while(!remove.isEmpty()){
                sb.insert(remove.pop().intValue(),"X");
        }
        String answer=sb.toString();
        return answer;
    }
}
