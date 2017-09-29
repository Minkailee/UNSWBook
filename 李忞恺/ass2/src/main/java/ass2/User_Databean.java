package ass2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User_Databean {
    private Integer user_id;
    private String username;
    private String password;
    private String email_address;
    private String phone_number;
    private Date birthday;
    private Gender gender;
    private ArrayList<Integer> friend_list;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }


    public User_Databean(Integer user_id, String username, String password, String email_address, String phone_number, Date birthday, Gender gender, ArrayList<Integer> friend_list) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email_address = email_address;
        this.phone_number = phone_number;
        this.birthday = birthday;
        this.gender = gender;
        this.friend_list = friend_list;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List getFriend_list() {
        return friend_list;
    }

    public void setFriend_list(ArrayList<Integer> friend_list) {
        this.friend_list = friend_list;
    }
}
