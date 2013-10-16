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
    <jsp:attribute name="sidemenuheader"><h1>Side Menu Header</h1></jsp:attribute>
    <jsp:attribute name="sidemenu">
        ${sideMenu}
    </jsp:attribute>
    <jsp:attribute name="maincontent">
        <h1>Main content</h1>
        <p>Bla bla bla...</p>
    </jsp:attribute>
    <jsp:attribute name="pagefooter">
        This is the footer.
    </jsp:attribute>
</t:master>
