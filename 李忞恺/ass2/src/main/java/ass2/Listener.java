package ass2;

import javax.servlet.ServletContext;

import javax.servlet.ServletContextEvent;

import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.Date;


public class Listener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent)

    {    Date date = new Date();
        ArrayList<Integer> friend_list = new ArrayList<Integer>();
        ArrayList<User_Databean> user_list = new ArrayList<User_Databean>();
        ArrayList<Message_Databean> message_list = new ArrayList<Message_Databean>();
        ArrayList<Integer> liked_by = new ArrayList<Integer>();
        message_list.add(new Message_Databean(date,1,"balabalabala","http://www.aaa.com", liked_by));
        message_list.add(new Message_Databean(date,2,"balabalabala222","http://www.bbb.com", liked_by));
        message_list.add(new Message_Databean(date,3,"balabalabala333","http://www.qq.com", liked_by));
        friend_list.add(2);
        User_Databean user1 = new User_Databean(1,"Pengcheng","940125","751409272@qq.com,",
                "0451673003",date,Gender.Male,friend_list);
        User_Databean user2 = new User_Databean(2,"Xiaogui","940330","88940125@qq.com,",
                "18646001937",date,Gender.Female,friend_list);
        User_Databean user3 = new User_Databean(3,"Chesong","930611","519066408@qq.com,",
                "15114510303",date,Gender.Female,friend_list);
        user_list.add(user1);
        user_list.add(user2);
        user_list.add(user3);
        //System.out.println(date);
        ServletContext context = servletContextEvent.getServletContext();
        context.setAttribute("user_list",user_list);
        context.setAttribute("message_list",message_list);
        context.setAttribute("user",user1);
        context.setAttribute("username",user1.getUsername());
        context.setAttribute("user_id",user1.getUser_id());
        context.setAttribute("Index",0);

    }



    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
