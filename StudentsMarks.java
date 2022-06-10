import java.util.*;
import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.sql.*;

public class StudentsMarks {

	public static void main(String[] args) {
		try {
			
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating a connection            
            String url = "jdbc:mysql://localhost:3306/student";
            String username = "root";
            String password = "Akash#123";
            Connection con = DriverManager.getConnection(url,username,password);
            
            //Creating Statement with create table in student database
//            String s = "create table student_marks(SN int(20) primary key auto_increment,Name varchar(200) not null,English int(20),Maths int(20),Science int(20),Computer int(20),Hindi int(20))";
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate(s);
//            System.out.println("Student Marks table created in database...");
            
            //Create a query and insert data into database
//            String s1 = "insert into student_marks(Name,English,Maths,Science,Computer,Hindi) values(?,?,?,?,?,?)";
//            PreparedStatement pmst = con.prepareStatement(s1);
//            
//            //For Dynamic inputs
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Enter your Name:");
//            String name = scanner.nextLine();
//            System.out.println("Enter marks of English:");
//            int eng = scanner.nextInt();scanner.nextLine();
//            System.out.println("Enter marks of Maths:");
//            int maths = scanner.nextInt();scanner.nextLine();
//            System.out.println("Enter marks of Science:");
//            int sc = scanner.nextInt();scanner.nextLine();
//            System.out.println("Enter marks of Computer:");
//            int com = scanner.nextInt();scanner.nextLine();
//            System.out.println("Enter marks of Hindi:");
//            int hindi = scanner.nextInt();scanner.nextLine();
//            //scanner.close();
//            pmst.setString(1, name);
//            pmst.setInt(2, eng);
//            pmst.setInt(3, maths);
//            pmst.setInt(4,sc);
//            pmst.setInt(5, com);
//            pmst.setInt(6, hindi);
//            pmst.executeUpdate();
//            System.out.println("Data inserted....");

            //Select all query from java
            String s = "select * from student_marks";
            Statement stmt = con.createStatement();
            ResultSet set =  stmt.executeQuery(s);
            while(set.next()) {
            	int sn = set.getInt(1);
            	String nme = set.getString(2);
            	int english = set.getInt(3);
            	int math = set.getInt(4);
            	int science = set.getInt(5);
            	int comt = set.getInt(6);
            	int hnd = set.getInt(7);
            	System.out.println(sn+"."+nme);
            	System.out.println("English:"+english);
            	System.out.println("Mathematics:"+math);
            	System.out.println("Science:"+science);
            	System.out.println("Computer:"+comt);
            	System.out.println("Hindi:"+hnd);
            	int totalM = english+math+science+comt+hnd;
            	System.out.println("Total Marks:"+totalM);
            	Double perDouble = totalM/5.0d;
            	System.out.println("Percenatage:"+perDouble+"%");
            	System.out.println();
            }
            con.close();
        } 
		catch (Exception e) {
            e.printStackTrace();
        }

	}

}
