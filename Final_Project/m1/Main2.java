package m1;

import java.util.Scanner;
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int a= Final.menu();

			if(a==1) {
				Final.inputdata();
			}
			else if(a==2) {
				Final.show();
			}
			else if(a==3) {
				Final.update();
			}
			else if(a==4) {
				Final.delete();
			}
			else if(a==5) {
				String key;
				System.out.println("찾고 싶은 단어를 입력하시오: ");
				key=sc.nextLine();
				Final.find(key);
			}
			else if(a==0) {
				Final.sql();
				break;
			}
			else if(a==6) {
				Final.write();
			}
			else if(a==7) {
				Final.read();
			}
			else if(a==8) {
				Final.help();
			}
			else if(a==9) {
				System.out.println("1. 랜덤추천");
				System.out.println("고르시오: ");
				int check=sc.nextInt();
				if(check==1) {
					Final.recommend();
				}
				else {
					
				}
			}
		}
		sc.close();
	}
}
