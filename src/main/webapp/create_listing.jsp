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
        <h1>Skapa annons</h1>
        <form method="post" id="new_listing" action="add">
            <section>
                <div style="float:left;margin-right:20px;">
                    <label style="display:block;" for="title">Titel</label>
                    <input style="display:block;" type="text" size="60" name="title" id="title" />
                </div>
                <div style="float:left;margin-right:20px;">
                    <label style="display:block;" for="categories">Kategori</label>
                    <select style="display:block;" name="categories">
                        <option value="0">Alla kategorier</option>
                        <option value="1">Gröna badrumstillbehör</option>
                        <option value="2">Elektronik (halvtrasiga)</option>
                        <option value="3">Bilar</option>
                        <option value="4">Båtar (not literally)</option>
                    </select>
                </div>
            </section>
            <br style="clear:both;" />
            <section>
                <div style="float:left;margin-right:20px;">
                    <label style="display:block;" for="description">Beskrivning</label>
                    <textarea style="display:block;" cols="70" rows="20" name="description" id="description"></textarea>
                </div>
                <br style="clear:both;" />
                <input type="submit" value="Posta" name="commit" id="message_submit"/> eller <a class="close" href="#">Avbryt</a>
            </section>
        </form>
    </jsp:attribute>
    <jsp:attribute name="pagefooter">
        This is the footer.
    </jsp:attribute>
</t:master>
