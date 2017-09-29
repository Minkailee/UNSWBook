<%@ page import="ass2.User_Databean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ass2.Message_Databean" %>
<html>
<body>
<a href="my_message.jsp">My message</a>
<a href="add_message.jsp">Create message</a><br>

<img src="/01.jpg"/>
<%
    ServletContext servletContext = getServletConfig().getServletContext();
    ArrayList<User_Databean> userlist = (ArrayList<User_Databean>) servletContext.getAttribute("user_list");
    ArrayList<Message_Databean> message_list = (ArrayList<Message_Databean>) servletContext.getAttribute("message_list");
    String username = (String)servletContext.getAttribute("username");
    User_Databean user = (User_Databean) servletContext.getAttribute("user");
%>
<%
    out.println("Hello " + username);
    for (Message_Databean message:message_list){
        if(user.getFriend_list().contains(message.getPublisher_user_id()) || message.getPublisher_user_id() == user.getUser_id()) {
            out.println("<br>" + message.getPublisher_user_id());
            out.println("<br>" + message.getPublish_date());
            out.println("<br>" + message.getContent());
            out.println("<br>" + "<a href='" + message.getHref() + "'>" + message.getHref() + "</a>");
            out.println("<br>" + "<a href='/send_email?value="+ message.getPublisher_user_id()+ "'>" + "Like" +"</a>");

            out.println("<br><form action=\"send_email\">\n" +
                    "    <input type=\"submit\"  value=\"Unlike\">\n" +
                    "</form>");
        }
    }
%>
</body>
</html>
