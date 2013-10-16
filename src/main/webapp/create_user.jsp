<%-- 
    Document   : main
    Created on : Sep 25, 2013, 6:31:29 PM
    Author     : Aram Timofeitchik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
    <jsp:attribute name="pagetitle">Main</jsp:attribute>
    <jsp:attribute name="additionalpageheaders">
    </jsp:attribute>
    <jsp:attribute name="topmenu">
        ${topMenu}
    </jsp:attribute>

    <jsp:attribute name="maincontent">
        <h1>Skapa konto</h1>
        <form method="post" id="new_user" action="createuser">
            <section>
                <div style="float:left;margin-right:20px;">
                    <label style="display:block;" for="title">Användarnamn</label>
                    <input style="display:block;" type="text" size="30" name="title" id="title" />
                    <label style="display:block;" for="password">Lösenord</label>
                    <input style="display:block;" type="password" size="30" name="password" id="password" />
                    <label style="display:block;" for="password2">Lösenord (igen)</label>
                    <input style="display:block;" type="password" size="30" name="password2" id="password2" />
                    <label style="display:block;" for="email">Email</label>
                    <input style="display:block;" type="text" size="30" name="email" id="email" />
                </div>
            </section>
            <br style="clear:both;" />
            <section>
                <br style="clear:both;" />
                <input type="submit" value="Posta" name="commit" id="message_submit"/> eller <a class="close" href="#">Avbryt</a>
            </section>
        </form>
    </jsp:attribute>
    <jsp:attribute name="pagefooter">
        This is the footer.
    </jsp:attribute>
</t:master>
