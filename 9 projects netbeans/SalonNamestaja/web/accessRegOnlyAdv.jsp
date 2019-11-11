
<%@page import="utility.ComparatorForCrudAdvanced"%>
<%@page import="database.CrudUserListQueries"%>
<%@page import="model.User"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.CrudAdvancedData"%>
<%@page import="database.CrudAdvancedQueries"%>
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
        
        <%-- reading data from itself --%>
        <%
            String presentation_ID = request.getParameter("presentation_ID");
            String presentation_message = request.getParameter("presentation_message");
            String presentation_Adv_fk_username_id 
                    = request.getParameter("presentation_adv_fk_username_id");
            String presentation_userlist_username = request.getParameter("presentation_userlist_username");
            String presentation_city_name = request.getParameter("presentation_city_name");

            if(presentation_ID==null){

            }else{
                out.print("<div class='presentation'>");
                out.print("<p>");
                out.print("my id is " + presentation_ID + " and my user id is " + presentation_Adv_fk_username_id + "<br/>");
                out.print("my name is " + presentation_userlist_username + " and my city is " + presentation_city_name + "<br/>");
                out.print("</p>");
                out.print("</div>");
            }
        %>
        
        <%-- crud basic read jstl --%>
        <%
            // retrive list of objects
            ArrayList<CrudAdvancedData> dataList = CrudAdvancedQueries.advancedGet();
            
            // custom comparable sort example
            Collections.sort(dataList);
            
            // custom comparator sort example
            ComparatorForCrudAdvanced comparator = new ComparatorForCrudAdvanced();
            Collections.sort(dataList, comparator);
            
            request.setAttribute("dataList", dataList);
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

                    <th>edit</th>
                    <th>delete</th>

                    <th>presentation</th>
                </tr>
            <%-- looping throught arraylist of results --%>
            <c:forEach var="element" items="${dataList}">
                <tr>
                    <td>${element.id}</td>
                    <td>${element.message}</td>
                    <td>${element.fk_user}</td>
                    <td>${element.user}</td>
                    <td>${element.city}</td>

                    <%-- forwarding to jsp & servlet with parameters --%>
                    <td><a href="accessRegOnlyAdvEdit.jsp?id=${element.id}"><button>edit</button></a></td>  
                    <td><a href="DeleteeAdv?idForDelete=${element.id}"><button>delete</button></a></td>
                    
                    <%-- presentation form.. returns data to itself --%>
                    <td>
                        <form name="formForPresentation" action="accessRegOnlyAdv.jsp" method="post">
                            <input type="hidden" name="presentation_ID" value="${element.id}">
                            <input type="hidden" name="presentation_message" value="${element.message}">
                            <input type="hidden" name="presentation_adv_fk_username_id" value="${element.fk_user}">
                            <input type="hidden" name="presentation_userlist_username" value="${element.user}">
                            <input type="hidden" name="presentation_city_name" value="${element.city}">
                            <input class="presentbutton" type="submit" name="presentation" value="presentation">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </table>
        </div>

        <%-- insert --%>
        <%
            // retriving data for dropdown lists
            ArrayList<User> users = CrudUserListQueries.userGet();
            request.setAttribute("users", users);
        %>
        <form name="ins" action="InserttAdv" method="post">
            <label>message: </label><input type="text" name="message"/><br/>
            <label>user: </label>
            <select name="user">
                <c:forEach var="item" items="${users}">
                    <option value="${item.id}">${item.username}</option>
                </c:forEach>
            </select><br/>
            <input type="submit" name="insert" value="insert">
        </form>
    </body>
</html>
