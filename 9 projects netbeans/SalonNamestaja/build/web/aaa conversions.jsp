
<%-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    redirect to anywhere (another server or domain)
    optionaly send data
        request.setAttribute("Request-Attribute", "Value of Attribute ");
    redirect
        response.sendRedirect("index.jsp");
    or
        response.sendRedirect("google.com");
--%>

<%-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    session: passing attribute into session & picking them up afterwards

    putting
        String var = "pera";
        session.setAttribute("var", var);

    getting
        String var = (String)session.getAttribute("var");
        out.println("<p>"+var+"</p>");
--%>

<%-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    forwarding request from jsp(html code) to html/jsp/servlet
    (put optional any variable you wish to pass)
        <jsp:forward page="message.jsp">
            <jsp:param name="message" value="Welcome!"/>
            <jsp:param name="message" value=${xxx}/>
        </jsp:forward>
    receive in destination jsp with
        <p>
            Message: ${param["message"]}
        </p>
    or in java code
        Object attributeValue = request.getParameter("message")
        String attributeValue = (String)request.getAttribute("message");
--%>

<%-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    redirect localy, forward request from servlet(java code) to servlet/jsp/html

    To send data from the servlet to the JSP page, first set attributes for the
    request object in the form of name-value. For example:
        String name = "John";
            request.setAttribute("name", name);
        Integer numberOfItems = 1000;
            request.setAttribute("itemCount", numberOfItems);
        List<String> fruits = Arrays.asList("Apple", "Banana", "Lemon");
            request.setAttribute("itemCount", numberOfItems);

    Then create requestDispatcher object
        RequestDispatcher requestDispatcher
            = request.getRequestDispatcher("result.jsp");
        or
            = getServletContext.getRequestDispatcher(“result.jsp”);

    Then call the forward() method on the RequestDispatcher() object
    This method should be called at last in a code block, because afterward
    the request has been forwarded
        requestDispatcher.forward(request, response);

    in the destination JSP page, you can use JSP Expression Language (EL)
    to read the values of the attributes stored in the request. For example:
        <p>Name: ${name} </p>
        <p>Number of items: ${itemCount} </p>
        <p>fruits: ${itemCount} </p>
        <c:forEach var="aFruit" items="${fruits}">
            <p> ${aFruit} </p>
        </c>
    or (with optional casting)
        Object attributeValue = request.getAttribute("name");
        String attributeValue = (String)request.getAttribute("name");
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
