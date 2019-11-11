
<%@page import="java.util.Calendar"%>

<%-- standard tag libraries --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="index.jsp"><img src="slike\logo.jpg" alt="LOGO"/></a>
        <h1>TITLE</h1>
        
        <table>
            <tr>
                <td><a href="index.jsp">index</a></td>
                <td><a href="multiArray.jsp">multi array</a></td>
                <td><a href="scriplett.jsp">scriplet</a></td>
                <td><a href="expressionLanguage.jsp">exp. lang.</a></td>
                <td><a href="javaStandardTagLibrary.jsp">JSTL</a></td>
                <td><a href="javaStandardTagLibraryCustomTags.jsp">JSTL-custom</a></td>
                <td><a href="regJSP.jsp">reg. to jsp</a></td>
                <td><a href="regServlet.jsp">reg. to servlet</a></td>
                <td><a href="regDB.jsp">reg. to db</a></td>
                <td><a href="accessRegOnly.jsp">acc. reg. only</a></td>
                <td><a href="accessRegOnlyAdv.jsp">acc. reg. only adv</a></td>
                <td><a href="xml/Lekari.xml">XML</a></td>
                <td>
                    <!--calling servlet-->
                    <!--<div class="container">-->
                    <form method="post" class="form-signin" role="form" action="Servlett">
                        <input type="submit" 
                               class="btn btn-lg btn-primary btn-block" 
                               value="servlett">
                    </form>
                    <!--</div>-->
                </td>
            </tr>
        </table>
        
        <%-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>

        <%-- jstl - java standard tag library --%>

        <%-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        <%-- <<<<< variables >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        
        <%--zadavanje varijable--%>
        <c:set var="fee" value="35050.1067"/>
        <c:set var="string1" value="first string JSTL Core Tags Primeri" />

        <%--uklanjanje vrednosti--%>
        <c:remove var="string1"/>

        <%-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        <%-- <<<<< math >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        
        <%--formatiranje brojeva--%>
        <fmt:formatNumber value="${fee}" type="currency"/> 
        
        <%-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        <%-- <<<<< strings >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        
        <%--contains string--%>
        <c:if test = "${fn:containsIgnoreCase(string1, 'first')}">
        <p>Found 'first' string<p>
        </c:if>
        <c:if test = "${fn:containsIgnoreCase(string1, 'FIRST')}">
        <p>Found 'FIRST' string<p>
        </c:if>

        <%--change case--%>
        <c:set var = "string3" value = "${fn:toUpperCase(string1)}" />
        
        <%-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        <%-- <<<<< output >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        
        <%-- output --%>
        <c:out value="Hello World!"/>
        <h1><c:out value="Hello World!"/></h1>
        <c:out value="${fee}"/>

        <%-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        <%-- <<<<< exceptions >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        
        <%--hvata izuzetak i smesta ga u promenljivu--%>
        <c:catch var="myException">
            <% int xy = 10/0; %>
        </c:catch>

        <%-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        <%-- <<<<< flow >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        
        <%--set choose otherwise isto kao i switch--%>
        <c:set value="<%= Calendar.getInstance().get(Calendar.SECOND)%>" var="seconds"/>
        <c:choose>
            <c:when test="${seconds le 30 }">
                <c:out value="${seconds} je manje od 30"/>
            </c:when>
            <c:when test="${seconds eq 30 }">
                <c:out value="${seconds} je jednako 30"/>
            </c:when>
            <c:otherwise>
                <c:out value="${seconds} je vece od 30"/>
            </c:otherwise>
        </c:choose>

        <%--if struktura--%>  
        <c:if test="${sessionScope.userid!=null}">
            <c:out value="You are loged in" />
        </c:if>

        <%--for petlja--%>
        <c:forEach begin="10" end="20" var="value">
            <c:out value="${value}"/>
        </c:forEach>

        <%--for each petlja--%>
        <c:forEach var = "i" items="1,4,5,6,7,8,9">
            Item <c:out value = "No. ${i}"/><p>
        </c:forEach>

        <%--for each with delimiter--%>
        <c:forTokens items = "Rade:Aca:Laza:Milan" delims = ":" var = "ime">
            <c:out value = "Ime ${ime}"/><p>
        </c:forTokens>

        <%-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        <%-- <<<<< time >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
            
        <c:set var="now" value="<%=new java.util.Date()%>" />  
        Bez formatiranja: <c:out value="${now}"/><br/>
        Danasnji datum: <fmt:formatDate value="${now}" type="date" /><br/>
        Trenutno vreme: <fmt:formatDate value="${now}" type="time" />
    </body>
</html>
