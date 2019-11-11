
<%--put any value in prefix--%>
<%@taglib prefix="randomtag1" uri="/WEB-INF/tlds/newTag1.tld"%>
<%@taglib prefix="randomtag2" uri="/WEB-INF/tlds/newTag2.tld"%>

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
        
        <%--tag library descriptors & tag handlers
        treba postaviti tag handlere u poseban paket--%>

        <randomtag1:TagHandler1>
        </randomtag1:TagHandler1>  

        <h1 style="color: darkgreen">Hello World!</h1>
        <randomtag2:TagHandler2 color="blueviolet"/>
    </body>
</html>
