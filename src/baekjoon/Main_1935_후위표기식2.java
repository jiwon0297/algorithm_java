package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_1935_후위표기식2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Double> stack = new Stack<Double>();
		
		//후위표기식
		String form = sc.next();
		
		//숫자입력
		double[] nums = new double[27];
		for(int i=0; i<N; i++) {
			nums[i]=sc.nextDouble();
		}
		
		for(int i=0; i<form.length(); i++) {
			int ch = (int)form.charAt(i);
			
			if(ch>=65 && ch<=90) {
				stack.push(nums[ch-65]);
			} else {
				double num2 = stack.pop();
				double num1 = stack.pop();
				
				switch(form.charAt(i)) {
				case '*' :
					stack.push(num1*num2);
					break;
					
				case '+' :
					stack.push(num1+num2);
					break;
					
				case '-' : 
					stack.push(num1-num2);
					break;
					
				case '/' :
					stack.push(num1/num2);
					break;
					
				default :
					break;
				}
			}
		}
		
		System.out.printf("%.2f\n",stack.pop());
	}

}
