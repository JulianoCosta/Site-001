<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p><c:out value="${usuario.getId()}"/></p>
        <p><c:out value="${usuario.getLogin()}"/></p>
        <p><c:out value="${usuario.getNome()}"/></p>
        <p><c:out value="${usuario.getSenha()}"/></p>
        <p><c:out value="${usuario.getEmail()}"/></p>
    </body>
</html>
