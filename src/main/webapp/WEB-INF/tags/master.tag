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
        <script src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
        <script src="${pageContext.request.contextPath}/js/common.js"></script>
        <jsp:invoke fragment="additionalpageheaders"/>
    </head>
  <body>
    <header>
        <hgroup>
            <a href="${pageContext.request.contextPath}">
                <img style="float: left;" src="${pageContext.request.contextPath}/img/logo.png" />
            </a>
            <nav>
                <jsp:invoke fragment="topmenu"/><br/>
            </nav>
                        
            <!-- Login popup - hidden by default -->
            <div class="messagepop pop">
                <form method="post" id="new_message" action="login">
                    <p><label for="username">Användarnamn</label><input type="text" size="30" name="username" id="username" /></p>
                    <p><label for="password">Lösenord</label><input type="password" size="30" name="password" id="password" /></p>
                    <p class="center"><input type="submit" value="Logga in" name="commit" id="message_submit"/> eller <a class="close" href="#">Avbryt</a></p>
                    <p class="right"><a href="${pageContext.request.contextPath}/createuser">Nytt konto</a></p>
                </form>
            </div>
            
        </hgroup>
    </header> 
    <div class="searchbar">
        <div class="searchbar-left"></div>
        <div class="searchbar-right">
            <form method="post" id="search_box" action="search">
                <input type="text" size="60" name="searchfield" id="searchfield" />
                <label for="categories">inom</label>
                <select name="categories" id="catagories">
                    <option value="0">Alla kategorier</option>
                    <option value="1">Gröna badrumstillbehör</option>
                    <option value="2">Elektronik (halvtrasiga)</option>
                    <option value="3">Bilar</option>
                    <option value="4">Båtar (not literally)</option>
                </select>
                <input type="submit" value="Sök" name="commit" id="search_submit"/>
            </form>
        </div>
    </div>
    
    <article>       
        <aside>
            <jsp:invoke fragment="sidemenuheader"/>
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