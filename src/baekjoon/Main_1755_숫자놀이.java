package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class NumClass implements Comparable<NumClass> {

	int num;
	String engnum;
	
	public NumClass(int num, String engnum) {
		super();
		this.num = num;
		this.engnum = engnum;
	}

	@Override
	public int compareTo(NumClass o) {
		if(this.engnum.compareTo(o.engnum)<0) return -1;
		else return 1;
	}
	
}

public class Main_1755_숫자놀이 {

	public static void main(String[] args) {
		String[] num = {"zero", "one", "two", "three","four","five","six","seven","eight","nine"};
	
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		ArrayList<NumClass> arr = new ArrayList<>();
		for(int i=M; i<=N; i++) {
			String number = Integer.toString(i);
			String str="";

			for(int j=0; j<number.length(); j++) {
				str+=num[number.charAt(j)-'0'];
				str+=" ";
			}
			arr.add(new NumClass(i,str));
		}
		
		Collections.sort(arr);
		
		for(int i=0; i<arr.size(); i++) {
			if(i%10==9) {
				System.out.println(arr.get(i).num);
			} else {
				System.out.print(arr.get(i).num+" ");
			}
		}
		
	}

}
