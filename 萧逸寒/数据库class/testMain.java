package ass2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class testMain {

	public static void main(String args[]){
		
		try {
			Connection c = DatabaseConnect.connect("postgres", "z5095946");
			int[] indexList = DatabaseConnect.getIndex(c);
			System.out.println(Arrays.toString(indexList));

			ArrayList<Student> userList = DatabaseConnect.getUser(c);
			for(int i=0; i<userList.size(); i++){
				userList.get(i).showStudent();
			}

			c.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
