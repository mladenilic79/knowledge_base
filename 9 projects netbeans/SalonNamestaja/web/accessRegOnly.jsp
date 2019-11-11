
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.CrudBasicData"%>
<%@page import="database.CrudBasicQueries"%>
<%@page import="java.sql.ResultSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="database.DBAccount"%>
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
        <<<<< redirection >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        
        <%-- redirection using jstl in scriplet --%>
        <%if (DBAccount.logon == 0) {
            {%>
                <jsp:forward page = "regDB.jsp"/>;
            <%}
        }%>
        
        <%--
        redirection using jstl, this doesn't work at the moment
        <%
            request.setAttribute("logon", DBaccount.logon);
        %>
        <c:if test="${DBaccount.logon == 0}">
            <jsp:forward page = "regDB.jsp"/>;
        </c:if>
        --%>
 
        <h1>CONGRATULATIONS YOU ARE LOGGED IN</h1>
        
        <%-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        <<<<< insert >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        
        <%-- crud basic insert --%>
        <form name="c" action="Insertt" method="post">
            text for insert: <input type="text" name="textForInsert"/>
            <input type="submit" name="insert" value="insert">
        </form>
        
        <%-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        <<<<< read >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        
        <%-- variable used for reading results --%>
        <%
            ArrayList<CrudBasicData> dataList = CrudBasicQueries.basicGet();
            request.setAttribute("resultSet", dataList);
        %>
        
        <%-- crud basic read jstl --%>
        <table>
            <tr>
                <th>id</th>
                <th>data</th>
            </tr>
            <c:forEach var="element" items="${resultSet}">
                <tr>
                    <td>${element.id}</td>
                    <td>${element.message}</td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        
        <%-- read with search (for specific records) --%>
        <%--
        <form name="d" action="Vieww" method="post">
            search text field: <input type="text" name="searchTextField"/>
            search id field: <input type="number" name="searchIdField"/>
            <input type="submit" name="search" value="search">
        </form>
        --%>
        
        <%-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        <<<<< update >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        
        <%-- crud basic update --%>
        <form name="e" action="Updatee" method="post">
            id for update: <input type="number" name="idForUpdate"/>
            text for update: <input type="text" name="textForUpdate"/>
            <input type="submit" name="update" value="update">
        </form>
        
        <%-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        <<<<< delete >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        
        <%-- crud basic delete --%>
        <form name="f" action="Deletee" method="post">
            id for delete: <input type="number" name="idForDelete"/>
            <input type="submit" name="delete" value="delete">
        </form>
</body>
</html>
