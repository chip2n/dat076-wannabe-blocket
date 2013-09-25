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
        <script>alert('This script is added in AdditionalPageHeaders');</script>
    </jsp:attribute>
    <jsp:attribute name="sidemenuheader">Side Menu Header</jsp:attribute>
    <jsp:attribute name="maincontent">
        <h1>Main content</h1>
        <p>Bla bla bla...</p>
    </jsp:attribute>
    <jsp:attribute name="pagefooter">
        This is the footer.
    </jsp:attribute>
    
</t:master>
