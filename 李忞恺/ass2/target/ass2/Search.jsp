<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/9/27
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta name="viewport" content="initial-scale=1"><meta name="viewport" content="user-scalable=yes,width=device-width,initial-scale=1"><title>Astral by HTML5 UP</title>
    <title>Search</title>
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




<body id="top">
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
        <a href="#" class="image avatar"><img src="1.jpg" alt="" /></a>
        <h1><strong>I am Strata</strong>, a super simple<br />
            responsive site template freebie<br />
            crafted by <a href="http://html5up.net">HTML5 UP</a>.</h1>
    </div>
</header>

<div id="main">

    <%

        ServletContext servletContext = getServletConfig().getServletContext();

        int index = (int) servletContext.getAttribute("Index");
     %>
    <div class="col-center-block">
        <form action="SearchController" method="post">
            <%
                if(index!=1)
                {
            %>
            <button class="button" name="Ad" value="show_ad">Show Advance Search</button>
            <%
            }
            else
            {
            %>
            <button class="button"name="Ad" value="hide_ad">Hide Advance Search</button>
            <%
                }
            %>
        </form>
    </div>
        <br />
        <br />
    <%

        if(index==0)

        {

    %>
    <div class="col-center-block">
        <form action="" method="post">
            <div class="row uniform 50%">
                <label><h2><strong>Search with Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></h2></label>
                <div class="6u 12u$(xsmall)">
                    <input type="text" name="name_search" id="s-name" value="" placeholder="Name" />
                </div>
                <br />
                <br />
                <br />
                <br />
                <div class="12u$">
                    <ul class="actions">
                        <li><input type="reset" value="Reset" /></li>
                        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                        <li><input type="submit" value="Search" class="special" /></li>
                    </ul>
                </div>
            </div>
        </form>
    </div>
    <%

        }

        if(index==1)

        {

    %>
    <div class="col-center-block">
        <form action="" method="post">
            <div class="row uniform 50%">
                <label><h2><strong>Search with Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></h2></label>
                <div class="6u$ 12u$(xsmall)">
                    <input type="text" name="name_search" id="ad-name" value="" placeholder="Enter Name">
                </div>
                <label><h2><strong>Search with Gender&nbsp;&nbsp;&nbsp;</strong></h2></label>
                <div class="6u$ 12u$(xsmall)">
                    <input type="text" name="gender_search" id="ad-gender" value="" placeholder="Enter gender">
                </div>
                <label><h2><strong>Search with Birthday</strong></h2></label>
                <div class="6u$ 12u$(xsmall)">
                    <input type="text" name="bir_search" id="ad-bir" value="" placeholder="Enter Birthday">
                </div>
                <br />
                <br />
                <br />
                <div class="12u$">
                    <ul class="actions">
                        <li><input type="reset" value="Reset" /></li>
                        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                        <li><input type="submit" value="Search" class="special" /></li>
                    </ul>
                </div>
            </div>
        </form>
    </div>
    <%

        }

    %>
    <%--<form method="post" action="#">--%>
        <%--<div class="row uniform 50%">--%>
            <%--<div class="6u$ 12u$(xsmall)">--%>
                <%--<input type="email" name="demo-email" id="demo-email" value="" placeholder="Email" />--%>
            <%--</div>--%>
            <%--<div class="12u$">--%>
                <%--<div class="select-wrapper">--%>
                    <%--<select name="demo-category" id="demo-category">--%>
                        <%--<option value="">- Category -</option>--%>
                        <%--<option value="1">Manufacturing</option>--%>
                        <%--<option value="1">Shipping</option>--%>
                        <%--<option value="1">Administration</option>--%>
                        <%--<option value="1">Human Resources</option>--%>
                    <%--</select>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="4u 12u$(small)">--%>
                <%--<input type="radio" id="demo-priority-low" name="demo-priority" checked>--%>
                <%--<label for="demo-priority-low">Low Priority</label>--%>
            <%--</div>--%>
            <%--<div class="4u 12u$(small)">--%>
                <%--<input type="radio" id="demo-priority-normal" name="demo-priority">--%>
                <%--<label for="demo-priority-normal">Normal Priority</label>--%>
            <%--</div>--%>
            <%--<div class="4u$ 12u(small)">--%>
                <%--<input type="radio" id="demo-priority-high" name="demo-priority">--%>
                <%--<label for="demo-priority-high">High Priority</label>--%>
            <%--</div>--%>
            <%--<div class="6u 12u$(small)">--%>
                <%--<input type="checkbox" id="demo-copy" name="demo-copy">--%>
                <%--<label for="demo-copy">Email me a copy of this message</label>--%>
            <%--</div>--%>
            <%--<div class="6u$ 12u$(small)">--%>
                <%--<input type="checkbox" id="demo-human" name="demo-human" checked>--%>
                <%--<label for="demo-human">I am a human and not a robot</label>--%>
            <%--</div>--%>
            <%--<div class="12u$">--%>
                <%--<textarea name="demo-message" id="demo-message" placeholder="Enter your message" rows="6"></textarea>--%>
            <%--</div>--%>
            <%--<div class="12u$">--%>
                <%--<ul class="actions">--%>
                    <%--<li><input type="submit" value="Send Message" class="special" /></li>--%>
                    <%--<li><input type="reset" value="Reset" /></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</form>--%>
<%--</div>--%>
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
<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.poptrox.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
<script src="assets/js/main.js"></script>
</body>
</html>
