package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Birthday implements Comparable<Birthday> {

	String name;
	int day;
	int month;
	int year;

	public Birthday(String name, int day, int month, int year) {
		super();
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public int compareTo(Birthday o) {
		if(this.year<o.year) {
			return -1;
		} else if(this.year==o.year) {
			if(this.month<o.month) {
				return -1;
			} else if(this.month==o.month) {
				if(this.day<o.day) return 0;
			}
		}
		return 1;
	}
	
}

public class Main_5635_생일 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		ArrayList<Birthday> birth = new ArrayList<Birthday>();
		
		for(int i=0; i<N; i++) {
			String name = sc.next();
			int day = sc.nextInt();
			int month = sc.nextInt();
			int year = sc.nextInt();
			
			birth.add(new Birthday(name, day, month, year));
		}
		
		Collections.sort(birth);
		
		System.out.println(birth.get(birth.size()-1).name);
		System.out.println(birth.get(0).name);
	}

}
