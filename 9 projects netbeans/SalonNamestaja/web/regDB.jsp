
<%-- concerning drop down menu for cities --%>
<%@page import="database.DBAccount"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.City"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% ArrayList<City> cities = DBAccount.getAllCities(); %>

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
        
        <%--forma submit to servlet--%>

        <form name="b" action="RegDBoutput" method="post">
            Username: <input type="text" name="User"/><br/>
            Password: <input type="password" name="Pass"/><br/>
            
            <%--radio control--%>
            <fieldset>
                <input checked type="radio" value="male" name="RadioGroup">
                <input type="radio" value="female" name="RadioGroup">
            </fieldset>
            
            <%--multiple select option linked to external class--%>
            <select name="city">
                <% for(int i = 0; i<cities.size(); i++){ %>  
                    <%=cities.get(i)%>
                <% } %>
            </select><br/>
            
            <input type="submit" name="register" value="register">
            <input type="submit" name="login" value="login">
            <input type="submit" name="logout" value="logout">
        </form>
    </body>
</html>
