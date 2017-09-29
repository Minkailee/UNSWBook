<%@ page import="ass2.User_Databean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ass2.Message_Databean" %><%--
  Created by IntelliJ IDEA.
  User: liupengcheng
  Date: 28/9/17
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1"><meta name="viewport" content="user-scalable=yes,width=device-width,initial-scale=1"><title>Astral by HTML5 UP</title>
    <title>My moments</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
    <link rel="stylesheet" href="assets/css/main.css" />
    <noscript>&lt;link rel="stylesheet" href="assets/css/noscript.css" /&gt;</noscript>
    <!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
    <style>
        .col-center-block {
            float: none;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
<%
    ServletContext servletContext = getServletConfig().getServletContext();
    ArrayList<User_Databean> userlist = (ArrayList<User_Databean>) servletContext.getAttribute("user_list");
    ArrayList<Message_Databean> message_list = (ArrayList<Message_Databean>) servletContext.getAttribute("message_list");
    String username = (String)servletContext.getAttribute("username");
    Integer user_id = (Integer)servletContext.getAttribute("user_id");
    User_Databean user = (User_Databean) servletContext.getAttribute("user");
    out.println("Hello " + user.getUsername());
%>
<header id="header">
    <div>
        <h1>
            <strong>
                <a href="/Homepage">Home</a>  |  <a href="/Homepage/Profile.jsp">Profile</a>  |  <a href="/Homepage/Search.jsp">Search</a>  |  <a href="/Homepage/Friends.jsp">Friends</a>
            </strong>
        </h1>
    </div>
    <br />
    <br />
    <div class="inner">
        <a href="01.jpg" class="image avatar"><img src="01.jpg" alt="" /></a>
        <h1><strong>I am <%out.println(username);%></strong>, a super simple<br />
            responsive site template freebie<br />
            crafted by <a href="http://html5up.net">HTML5 UP</a>.</h1>
    </div>
</header>
<div id="main">
    <h1>My moments</h1>
    <div class="row">
        <%
            for (Message_Databean message:message_list){
                if(message.getPublisher_user_id() == user.getUser_id()) {
                    out.println("<article class=\"6u 12u$(xsmall) work-item\">");
                    out.println("<br><h3>" + message.getPublisher_user_id()+"</h3>");
                    out.println("<br><p>" + message.getPublish_date()+"</p>");
                    out.println("</article>");
                    out.println("<article class=\"6u$ 12u$(xsmall) work-item\">");
                    out.println("<br>" + message.getContent());
                    out.println("<br>" + "<a href='" + message.getHref() + "'>" + message.getHref() + "</a>");
                    out.println("</article>");
                }
            }
        %>
    </div>
</div>
</div>
    <!-- Footer -->
<footer id="footer">
    <div class="inner">
        <ul class="icons">
            <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
            <li><a href="#" class="icon fa-github"><span class="label">Github</span></a></li>
            <li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
            <li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
        </ul>
        <ul class="copyright">
            <li>&copy; Untitled</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
        </ul>
    </div>
</footer>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.poptrox.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
<script src="assets/js/main.js"></script>
</body>
</html>

