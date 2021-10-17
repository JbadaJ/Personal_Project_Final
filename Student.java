package p4;

import java.util.Scanner;

public class Student {
	
	public int menu() {
		Scanner sc = new Scanner(System.in);

		System.out.println("0.exit program");
		System.out.println("1.create data");
		System.out.println("2.show data");
		System.out.println("3.updata data");
		System.out.println("4.delete data");
		System.out.println("6 save data");
		System.out.println("7.load data");
		System.out.println("8.information");
		
		System.out.println("choose number");
		
		int a=0;
		a=sc.nextInt();
		
		return a;
	}
}
