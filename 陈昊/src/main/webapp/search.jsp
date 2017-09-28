<html>
<head>
    <title>Search</title>
</head>

<body>
<%
    ServletContext servletContext = getServletConfig().getServletContext();
    int index = (int) servletContext.getAttribute("Index");
    if(index==0)
    {
%>
        <div>
            <form action="/SearchResult" method="post">
                <label>Search for Name</label>
                <input name="name_search" placeholder="Enter Name">
                <button value="search">Search</button>
            </form>
        </div>
<%
    }
    if(index==1)
    {
%>
        <div>
            <form action="/SearchResult" method="post">
                <label>Search for Name</label>
                <input name="name_search" placeholder="Enter Name">

                <label>Search for Sex</label>
                <input name="sex_search" placeholder="Enter Sex">

                <label>Search for Birthday</label>
                <input name="bir_search" placeholder="Enter Birthday">

                <button value="search">Search</button>
            </form>
        </div>
<%
    }
%>



<div>
    <form action="\SearchController" method="post">
        <button name="Ad" value="show_ad">Show Advance Search</button>
        <button name="Ad" value="hide_ad">Hide Advance Search</button>
    </form>
</div>

</body>
</html>
