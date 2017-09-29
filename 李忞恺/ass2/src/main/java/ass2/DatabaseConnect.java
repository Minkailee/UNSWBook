package ass2;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

// ��������Ҫ���Jdbc4

public class DatabaseConnect {
	

	
	 public static Connection connect(String user, String password) {
	      Connection c = null;
	      
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/First_db",
	            user, password);
	         System.out.println("Opened database successfully");
 
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	     
	      return c;
	  }
	 
	 public static ArrayList<Student> getUser(Connection c) throws SQLException{
		 
		 ArrayList<Student> userList = new ArrayList<Student>();
		 
		 
			Statement stat = c.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * from public.\"Student\";");
			while(rs.next()){
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				java.util.Date birth = new java.util.Date(rs.getDate("birth").getTime());
				String gender = rs.getString("gender");
				int index = rs.getInt("index");
				
				
				// ��ú����б�
				java.sql.Array obj = rs.getArray("friends");
				Integer[] dataArray = (Integer[])obj.getArray();
				ArrayList<Integer> friendList = new ArrayList<Integer>(Arrays.asList(dataArray));
				// �����־�б�
				obj = rs.getArray("posts");
				dataArray = (Integer[])obj.getArray();
				ArrayList<Integer> postList = new ArrayList<Integer>(Arrays.asList(dataArray));
			/*	System.out.println("Name: "+name);
				System.out.println("Email: "+email);
				System.out.println("Phone: "+phone);
				System.out.println("Birth: "+birth);
				System.out.println("Gender: "+gender);
				System.out.println("----------------");*/
				
				Student s = new Student(name, password, email, phone, birth, gender);
				s.setFriends(friendList);
				s.setPosts(postList);
				s.setIndex(index);
				// ������û����û�����
				userList.add(s);
				
			}
			rs.close();
			stat.close();
			
		 return userList;
	 }
	 
	 public static void saveUser(Connection c, Student s) throws SQLException{
		 
		 Statement stat = c.createStatement();
		 // �����ʷ����
		 int student_index = getIndex(c)[0];
		 student_index++;
		 
		 Object[] postArr = {};
		 Object[] friendArr = {}; 
		 
		 java.sql.Array defaultFriendArr = c.createArrayOf("integer", friendArr);
		 java.sql.Array defaultPostArr = c.createArrayOf("integer", postArr);
		 
		 java.sql.Date sqlDate = new java.sql.Date(s.getBirth().getTime());
		 
		 stat.executeUpdate(
		"INSERT INTO public.\"Student\"(name, password, email, phone, birth, gender, friends, posts, index) " +
		 "VALUES ('" + s.getName() + "','" + s.getPassword() + "','" + s.getEmail() +"','" + s.getPhone() 
		 + "','" + sqlDate + "','" + s.getGender() + "','" + defaultFriendArr + "','" 
		 + defaultPostArr + "'," + student_index + ");");
		 
		 //Ϊ�û��������
		 s.setIndex(student_index);
		 //���ݿ���������
		 setIndex(c, 0, student_index++);
		 
		 stat.close();
		 
	 }
	 
	 public static void updateUser(Connection c, Student s) throws SQLException{
		 Statement stat = c.createStatement();
		 
		 Object[] postArr = s.getPosts().toArray();
		 Object[] friendArr = s.getFriends().toArray();; 
		 
		 java.sql.Array defaultFriendArr = c.createArrayOf("integer", friendArr);
		 java.sql.Array defaultPostArr = c.createArrayOf("integer", postArr);
		 
		 java.sql.Date sqlDate = new java.sql.Date(s.getBirth().getTime());
		 
		 stat.executeUpdate(
		"UPDATE public.\"Student\" SET " +
		 "name='" + s.getName() + "',password='" + s.getPassword() + "',email='" + s.getEmail() +"',phone='" + s.getPhone() 
		 + "',birth='" + sqlDate + "',gender='" + s.getGender() + "',friends='" + defaultFriendArr + "',posts='" 
		 + defaultPostArr + "');");
		 
		 stat.close();
		 
	 }
	 
	 public static int[] getIndex(Connection c) throws SQLException{
		int[] indexList = new int[3];
		 
		Statement stat = c.createStatement();
		ResultSet rs = stat.executeQuery("SELECT * FROM public.\"Record_Index\";");
		while(rs.next()){
			int student_index = rs.getInt(1);
			int image_index = rs.getInt(2);
			int post_index = rs.getInt(3);
			
			indexList[0] = student_index;
			indexList[1] = image_index;
			indexList[2] = post_index;
			
		/*	System.out.println("student_index: "+student_index);
			System.out.println("image_index: "+image_index);
			System.out.println("post_index: "+post_index);*/
		}
		rs.close();
		stat.close();
		
		return indexList;
	 }
	 
	 public static void setIndex(Connection c, int type, int index) throws SQLException{
		 Statement stat = c.createStatement();
		 if(type == 0){ stat.executeUpdate(
		 "UPDATE public.\"Record_Index\" SET student_index=" + index + ";");
		 }
		 else if(type == 0){ stat.executeUpdate(
		 "UPDATE public.\"Record_Index\" SET image_index=" + index + ";");
		 }
		 else if(type == 0){ stat.executeUpdate(
		 "UPDATE public.\"Record_Index\" SET post_index=" + index + ";");
		 }
	 }
	 
	 public static void uploadImg(Connection c, int index, String dataPath) throws Exception{
		
		// ���浽���ݿ�
		Statement stat = c.createStatement();
        stat.executeUpdate("UPDATE public.\"Record_Index\" SET image_index = "
        				+ index + ";");
        // ����ͼƬ����
        stat.executeUpdate("INSERT INTO public.\"Image\"(index, address) VALUES (" 
        				+ index + ",'" + dataPath + "');");
        
        stat.close();

	 }
	 
	 
}
