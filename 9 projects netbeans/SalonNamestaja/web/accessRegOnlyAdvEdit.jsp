
<%@page import="database.CrudUserListQueries"%>
<%@page import="model.User"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="database.CrudAdvancedQueries"%>
<%@page import="model.CrudAdvancedData"%>
<%@page import="database.DBAccount"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h1>CONGRATULATIONS YOU ARE LOGGED IN</h1>
        
        <%-- receive parameter from jsp page, or attribute from servlet page--%>
        <%
            String id = null;
            if (request.getParameter("id") != null) {
                id = request.getParameter("id");
            } else if ((String) request.getAttribute("id") != null) {
                id = (String) request.getAttribute("id");
            }

            // retrive object for editing
            CrudAdvancedData data = CrudAdvancedQueries.advancedGetId(Integer.parseInt(id));
            request.setAttribute("data", data);
        %>

        <div class="displaydiv">
            <table class="displaytable">
                <caption class="displaycaption"><b>advanced data</b></caption>
                <tr>
                    <th>id</th>
                    <th>message</th>
                    <th>username id</th>
                    <th>username string</th>
                    <th>city string</th>
                </tr>
                <tr>
                    <td>${data.id}</td>
                    <td>${data.message}</td>
                    <td>${data.fk_user}</td>
                    <td>${data.user}</td>
                    <td>${data.city}</td>
                </tr>
            </table>
        </div>

        <%-- update with prepopulate --%>
        <%
            ArrayList<User> users = CrudUserListQueries.userGet();
            request.setAttribute("users", users);
        %>
        <div class="formdiv">
            <form class="formform" name="ins" action="UpdateeAdv" method="post">
                <fieldset class="formset">
                    <legend>edit form</legend>
                    <input type="hidden" name="idForUpdate" value="${data.id}">

                    <label>message: </label><input type="text" name="message" value="${data.message}"/><br/>
                    
                    <label class="dd">user: </label>
                    <select name="user">
                        <c:forEach var="item" items="${users}">
                            <option value="${item.id}" ${item.id == data.fk_user ? 'selected="selected"' : ''}>${item.username}</option>
                        </c:forEach>
                    </select><br/>

                    <input class="button" type="submit" name="update" value="update">
                </fieldset>
            </form>
        </div>
        
    </body>
</html>
