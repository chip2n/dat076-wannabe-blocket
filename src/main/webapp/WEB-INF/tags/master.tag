<%-- 
    Document   : master
    Created on : Sep 25, 2013, 5:43:19 PM
    Author     : Aram Timofeitchik
--%>

<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="pagetitle" fragment="true" %>
<%@attribute name="additionalpageheaders" fragment="true" %>
<%@attribute name="sidemenuheader" fragment="true" %>
<%@attribute name="maincontent" fragment="true" %>
<%@attribute name="pagefooter" fragment="true" %>
<%@attribute name="topmenu" fragment="true" %>
<%@attribute name="sidemenu" fragment="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><jsp:invoke fragment="pagetitle"/></title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/layout.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/style.css" />
        <jsp:invoke fragment="additionalpageheaders"/>
    </head>
  <body>
    <header>
        <hgroup>
            <img src="${pageContext.request.contextPath}/img/logo.png" />
        </hgroup>
    </header>
    <nav id="top-menu">
        <jsp:invoke fragment="topmenu"/>
    </nav>
    <!-- Login popup - hidden by default -->
    <div class="messagepop pop">
        <form method="post" id="new_message" action="login">
            <p><label for="username">Användarnamn</label><input type="text" size="30" name="username" id="username" /></p>
            <p><label for="password">Lösenord</label><input type="password" size="30" name="password" id="password" /></p>
            <p class="center"><input type="submit" value="Logga in" name="commit" id="message_submit"/> eller <a class="close" href="#">Avbryt</a></p>
        </form>
    </div>
    
    <article>       
        <aside>
            <h1><jsp:invoke fragment="sidemenuheader"/></h1>
            <jsp:invoke fragment="sidemenu"/>     
        </aside>
        <section id="maincontent">
            <jsp:invoke fragment="maincontent"/>
        </section>
    </article>
    <footer>
        <jsp:invoke fragment="pagefooter"/>
    </footer>
  </body>
</html>