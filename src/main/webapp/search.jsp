<%-- 
    Document   : search
    Created on : 2013-okt-16, 16:15:11
    Author     : Sebastian Lagerman
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
        <h1>Search Page oh yeah!</h1>
        <p>Bla bla bla...</p>
    </jsp:attribute>
    <jsp:attribute name="pagefooter">
        This is the footer.
    </jsp:attribute>
</t:master>
