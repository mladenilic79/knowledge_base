
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

        <%--el expression language--%> 

        <%--receiving numbers from input, processing them & returning back --%>
        <form>
            Prvi broj:<input type="text" name="a" value=${param["a"]}><br>
            Drugi broj:<input type="text" name="b" value=${param["b"]}><br>
            <input type="submit" name="zbir" value="Zbir"><br>
            <input type="submit" name="razlika" value="Razlika"><br>
        </form>
        <%
            try {
                String zb = request.getParameter("zbir");
                String rz = request.getParameter("razlika");
                int aBr = Integer.parseInt(request.getParameter("a"));
                int bBr = Integer.parseInt(request.getParameter("b"));
                if (zb != null) {
                    int rezultat = aBr + bBr;
                    request.setAttribute("rez", "Zbir je " + rezultat);
                }
                if (rz != null) {
                    int rezultat = aBr - bBr;
                    request.setAttribute("rez", "Razlika je " + rezultat);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        %>
        ${rez}

        <br/>

        <%--attributes--%>
        <%
            int x = 10;
            // vezuje varijablu iz java koda za naziv iste van java koda
            request.setAttribute("x", x);
        %>
        <%--momentalna evaluacija zajedno sa izvrsavanjem stranice--%>
        number is: ${x}
        <%--odlozena evaluacija do momenta kada je ova vrednost potrebna--%>
        <%--number is: #{x}--%>

        <br/>
        
        <%--objects--%>
        <%!
            public class Person {

                private String name = "petar";

                public String getName() {
                    return this.name;
                }
            }
        %>
        <%
            Person p = new Person();
            // vezuje naziv objekta iz java koda za naziv iste van java koda
            request.setAttribute("p", p);
        %>
        Person is: ${p.name}
        <%--same as--%>
        Person is: ${p['name']}
    </body>
</html>
