
<%-- 
    !!! DON'T DELETE THIS COMMENT !!!
    !!! DON'T DELETE THIS COMMENT !!!
    !!! DON'T DELETE THIS COMMENT !!!

    http example
    http://www.yourbookstore.com:80/bookstore/bookServlet?action=bookDetails
    http - scheme
    www.yourbookstore.com - host name
    80 - port number
    bookstore - path
    bookServlet - resource
    action=bookDetails - queryString
    
    home page (html or jsp) must be called index

    put servlet in welcome file list in web.xml if needed to be open first,
    see web.xml for example
    <!--
    put servlet in welcome file list if needed to be open first
    <welcome-file-list>
        <welcome-file>servletName</welcome-file>
    </welcome-file-list>
    -->
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.time.LocalDateTime"%>

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
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --%>
        
        <p>
            "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accu
        </p>

        <%--
        el - expression language
        param returns parameters from address
        this variant must be on index page
        http://localhost:8080/SalonNamestaja/?a=10&b=12
        --%>
        Sum of ${param["a"]} and ${param["b"]} is: ${param["a"]+param["b"]}

        <br/>
        
        <%--google map.. just paste it from somewhere--%>
        <iframe width="600" height="500" src="https://maps.google.com/maps?q=Belgrade&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe>

        <p>designed by m</p>
        <% out.println("current server time is " + LocalDateTime.now());%>
    </body>
</html>
