<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="<c:url value="/resources/css/materialize.min.css"/>" rel="stylesheet" type="text/css" media="screen,projection"/>
        <link href="<c:url value="/resources/css/principal.css"/>" rel="stylesheet" type="text/css"/>
        <title>Principal</title>
    </head>
    <body>

        <div class="row container">
            <nav class="grey">
                <div class="nav-wrapper">
                    <a class="brand-logo left">${usuarioLogado.getNome()}</a>
                    <ul id="nav-mobile" class="right">
                        <li><a href="<c:url value="/usuario/edicao"/>"><i class="material-icons">edit</i></a></li>
                        <li><a href="<c:url value="/usuario/exclusao"/>"><i class="material-icons">delete</i></a></li>
                        <li><a href="<c:url value="/logout"/>"><i class="material-icons">exit_to_app</i></a></li>
                    </ul>
                </div>
            </nav>
            <br>
            <br>
            <br>
            <div class="col s12">
                <h4>Usuários:</h4>
                <div class="row">
                    <c:forEach items="${usuarioList}" var="e">
                        <div class="col s12 m6 l4">
                        <div class="card green lighten-1 white-text">
                                <div class="card-content">
                                    <h5 class="card-title truncate">${e.getNome()}</h5>
                                    <p class="truncate">${e.getEmail()}</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/materialize.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/mensagens.js"/>" type="text/javascript"></script>

        <c:if test="${sucesso_edicao == true}">
            <script>msgSucessoEdicaoUsuario();</script>
        </c:if>
    </body>
</html>
