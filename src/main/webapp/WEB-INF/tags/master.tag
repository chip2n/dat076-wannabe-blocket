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
            <h1>Title</h1>
            <h2>Description</h2>
        </hgroup>
    </header>
    <nav>
        <jsp:invoke fragment="topmenu"/>
    </nav>
    <!-- Login popup -->
    <div class="messagepop pop">
        <form method="post" id="new_message" action="/messages">
            <p><label for="username">Användarnamn</label><input type="text" size="30" name="email" id="email" /></p>
            <p><label for="password">Lösenord</label><input type="text" size="30" name="email" id="email" /></p>
            <p><input type="submit" value="Logga in" name="commit" id="message_submit"/> eller <a class="close" href="/">Avbryt</a></p>
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