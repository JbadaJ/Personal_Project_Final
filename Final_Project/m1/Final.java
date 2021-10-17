package m1;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

public class Final {

	
	
	String title;
	String cate;
	String desc;
	String due_date;
	String current_date;
	static Connection conn;
	

	
	static List<Final> al=new ArrayList<Final>();
	public static int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("0.���� �մϴ�.");
		System.out.println("1.���ο� ������ �Է��մϴ�");
		System.out.println("2.��� ������ �����ݴϴ�.");
		System.out.println("3.������ �����մϴ�.");
		System.out.println("4.������ �����մϴ�.");
		System.out.println("5.������ �˻��մϴ�.");
		System.out.println("6 ������ �����մϴ�.");
		System.out.println("7.������ �ҷ��ɴϴ�.");
		System.out.println("8.����");
		System.out.println("9.�߰����");
		System.out.println("���ϴ� ��ȣ�� ���ÿ�: ");
		int a=0;
		a=sc.nextInt();
		return a;
	}
	public static int choose_number() {
		Scanner sc= new Scanner(System.in);
		show();
		System.out.println("Choose number: ");
		int a=sc.nextInt();
		return a;
		
	}
	public static void show() {
		System.out.println("[��ü ���, �� "+al.size()+" ��]");
		for (int i=0; i<al.size();i++) {
			System.out.println(i+1+": "+al.get(i).toString());
		}
	}
	public String toString() {
		return "["+due_date+"] "+title+" - "+cate+" - "+current_date+" - "+desc+" ";
	}
	public void set_cate(String cate) {
		this.cate=cate;
	}
	public void set_due_date(String due_date) {
		this.due_date=due_date;
	}
	public void set_title(String title) {
		this.title=title;
	}
	public void set_desc(String desc){
		this.desc=desc;
	}
	public void set_current_date(String current_date) {
		this.current_date=current_date;
	}
	public String get_title() {
		return title;
	}
	public String get_desc() {
		return desc;
	}
	public  String get_current_date(){
		return current_date;
	}
	public  String get_cate() {
		return cate;
	}
	public  String get_due_date() {
		return due_date;
	}
	public Final(String title,String cate,String desc,String due_date,String current_date) {
		set_cate(cate);
		set_title(title);
		set_desc(desc);
		set_due_date(due_date);
		set_current_date(current_date);
	}
	public static void inputdata() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� : ");
		String title;
		title=sc.nextLine();
		
		System.out.println("ī�װ� : ");
		String cate;
		cate=sc.nextLine();
		
		System.out.println("���� : ");
		String desc = sc.nextLine();
		
		System.out.println("�������� : ");
		String due_date;
		due_date=sc.nextLine();
		
		SimpleDateFormat form = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String time1 = form.format(time);
		Final s1 = new Final(title,desc,time1,cate,due_date);
		
		al.add(s1);
	}
	public static void update() {
		int update_num=choose_number();
		if(update_num>al.size()) {
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		}
		Scanner sc = new Scanner(System.in);

		System.out.println("�� ����:");
		String title;
		title=sc.nextLine();
		
		System.out.println("�� ī�װ�:");
		String cate;
		cate=sc.nextLine();

		System.out.println("�� ����:");
		String desc = sc.nextLine();
		
		System.out.println("�� ��������:");
		String due_date;
		due_date=sc.nextLine();

		String time1=al.get(update_num-1).get_current_date();
		Final s1 = new Final(title,desc,time1,cate,due_date);
		
		al.set(update_num-1,s1);
		System.out.println("�����Ǿ����ϴ�.");
	}
	public static void delete() {
		Scanner sc = new Scanner(System.in);
		int delete_num=choose_number();
		if(delete_num>al.size()) {
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		}
		String check;
		System.out.println("�� �׸��� �����Ͻðڽ��ϱ�? y/n : ");
		check=sc.nextLine();
		if(check.equals("y")) {
			al.remove(delete_num-1);
		}
		
	}
	public static void help() {
		System.out.println("���ϴ� ������ �����ϰ� �����ϰų� �����Ҽ� �ִ� ��ȹǥ �Դϴ�.");
	}
	public static void write() {
		try {
			Writer w = new FileWriter("todo.txt");
			
			for(int i=0;i<al.size();i++) {
				Final a = al.get(i);
				
				String to_title=a.title;
				String to_cate=a.cate;
				String to_due_date=a.due_date;
				String to_current_date=a.current_date;
				String to_desc=a.desc;
			
				w.write(to_title);
				w.write("##");
				w.write(to_cate);
				w.write("##");
				w.write(to_desc);
				w.write("##");
				w.write(to_due_date);
				w.write("##");
				w.write(to_current_date);
				w.write("##");
					
			}
			w.write("&&##");
			w.close();
			System.out.println("���� ���� �Ϸ�!!!");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void read() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("todo.txt"));
			String s;
			int count=0;
			String to_title;
			String to_cate;
			String to_due_date;
			String to_current_date;
			String to_desc;
			
			while ((s = in.readLine()) != null) {
				while(true) {
					
					String[] split = new String[500];
					split = s.split("##");

					if(split[count].equals("&&")) {
						break;
					}
					to_title=split[count];
					split = s.split("##");
					
					to_cate=split[count+1];
					split = s.split("##");
					
					to_desc=split[count+2];
					split=s.split("##");
					
					to_due_date=split[count+3];
					split = s.split("##");
					
					to_current_date=split[count+4];
					
					Final s1 = new Final(to_title,to_cate,to_desc,to_due_date,to_current_date);
					al.add(s1);
					
					count=count+5;	
				}
				
				
			}
				 
			in.close();
			
			System.out.println("\n���� �������� �Ϸ�!!!");
		} catch (FileNotFoundException q) {
			q.printStackTrace();
		} catch(IOException a) {
			a.printStackTrace();
		}
	}
	public static void find(String key) {
		int count=0;
		for(int i=0;i<al.size();i++) {
			if(al.get(i).get_title().contains(key) || al.get(i).get_desc().contains(key)) {
				System.out.println((i+1)+". "+al.get(i).toString());
				count++;
			}
		}
		System.out.printf("�� %d���� �׸��� ã�ҽ��ϴ�.\n", count);
	}
	public static int random() {
		double ran=Math.random();
		int random=(int)(ran*100);
		random=random%al.size();
		return random;
	}
	public static void recommend() {
		
		System.out.println("���� ��õ�ϴ� ������=>"+al.get(random()).toString());
	}
	public static void sql() {
		try {
		
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+"data.db");

			String sql = "INSERT INTO list (title,memo,category,current_date,due_date)"+" values(?,?,?,?,?);";
			for(int i=0;i<al.size();i++) {				
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, al.get(i).get_title());
				pstmt.setString(2, al.get(i).get_desc());
				pstmt.setString(3, al.get(i).get_cate());
				pstmt.setString(4, al.get(i).get_current_date());
				pstmt.setString(5, al.get(i).get_due_date());
				pstmt.executeUpdate();
				pstmt.close();
				
			}
		
		}
		catch(Exception e) {
				e.printStackTrace();
			}
		
	}

}
	
