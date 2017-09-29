package ass2;


import java.util.ArrayList;
import java.util.Date;

public class Student {
	
	private String name;
	private String password;
	private String email;
	private String phone;
	private Date birth;
	private String gender;
	private int index;
	
	private ArrayList<Integer> friends;
	private ArrayList<Integer> posts;
	
	public Student(String name, String password, String email, String phone, Date birth,
			String gender){
		
		this.setName(name);
		this.setPassword(password);
		this.setEmail(email);
		this.setPhone(phone);
		this.setBirth(birth);
		this.setGender(gender);
		
	}
	// ���չʾ
	public void showStudent(){
		System.out.println(this.name);
		System.out.println(this.email);
		System.out.println(this.phone);
		System.out.println(this.birth);
		System.out.println(this.gender);
		
	}
	// ���ú����б�
	public void setFriends(ArrayList<Integer> friends){
		
		this.friends = friends;
		
	}
	public ArrayList<Integer> getFriends(){
		
		return this.friends;
		
	}
	// ������־�б�
	public void setPosts(ArrayList<Integer> posts){
		
		this.posts = posts;
		
	}
	public ArrayList<Integer> getPosts(){
		
		return this.posts;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	

}
