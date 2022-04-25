package programmers;

import java.util.HashSet;

public class Solution_line_2 {
	public static void main(String[] args) {

	}
	
	public int solution(String[] sentences, int n) {
        int answer = -1;
        int[] score = new int[sentences.length];
        HashSet<Character>[] set = new HashSet[sentences.length];
        for(int i=0; i<sentences.length; i++){
        	set[i]=new HashSet<>();
            score[i]=makeScore(sentences[i]);
            for(int j=0; j<sentences[i].length(); j++) {
            	char ch = sentences[i].charAt(j);
            	set[i].add(ch);
            }
        }
        return answer;
    }

	private int makeScore(String s) {
		int sum=s.length();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)>='A' && s.charAt(i)<='Z') {
				sum+=1;
			}
		}
		return sum;
	}

	


}
