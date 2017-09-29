<%--
  Created by IntelliJ IDEA.
  User: liupengcheng
  Date: 28/9/17
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1"><meta name="viewport" content="user-scalable=yes,width=device-width,initial-scale=1"><title>Astral by HTML5 UP</title>
    <title>Create new moments</title>
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
        <a href="#" class="image avatar"><img src="01.jpg" alt="" /></a>
        <h1><strong>I am Strata</strong>, a super simple<br />
            responsive site template freebie<br />
            crafted by <a href="http://html5up.net">HTML5 UP</a>.</h1>
    </div>
</header>
<div id="main">
    <form action="create_new_message" method="post">
        <div class="row uniform 50%">
            <label><h2><strong>Content:</strong></h2></label>
            <div class="6u$ 12u$(xsmall)" align="center">
                <textarea name="content" style="width: 600px;height: 200px;"></textarea><br>
            </div>
            <label><h2><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Href:</strong></h2></label>
            <div class="6u$ 12u$(xsmall)" align="center">
                <textarea name="href" style="width: 600px;height: 50px;"></textarea><br><br><br>
            </div>
        </div>
        <div class="12u$" align="center">
            <ul class="actions">
                <li><input type="submit" value="Create" class="special fit"></li>
            </ul>
        </div>
    </form>
</div>
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
