<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layout.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>
        <div id="main">
            <jsp:directive.include file="menu.jspx"/>
            <div style="float: left; display: inline;">
                <jsp:directive.include file="sideMenu.jspx"/>
            </div>
            <section id="content">
                <h1>Hello World!</h1>
            </section>
        </div>
    </body>
</html>
