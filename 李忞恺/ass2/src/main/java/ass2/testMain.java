package ass2;

import java.sql.Connection;
import java.sql.SQLException;

public class testMain {

	public static void main(String args[]){
		
		try {
			Connection c = DatabaseConnect.connect("postgres", "Fresh-2017");
			
			java.util.Date dt = new java.util.Date();
			System.out.println(dt);
			
			Student s = new Student("Mike Ky", "12344", "mike@unsw.edu.au", "0402002002", 
					dt, "male");
			
			DatabaseConnect.saveUser(c, s);
			//DatabaseConnect.updateUser(c, s);
			c.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
