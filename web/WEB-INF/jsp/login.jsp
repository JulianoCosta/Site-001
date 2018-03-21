<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="<c:url value="/resources/css/materialize.min.css"/>" rel="stylesheet" type="text/css" media="screen,projection"/>
        <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>

        <div class="row container">
            <div class="col s12 m6 l6 center-align push-l3 push-m3">
                <nav class="grey">
                    <div class="nav-wrapper">
                        <h5 class="brand-logo center">Login</h5>
                    </div>
                </nav>
                <form  action="<c:url value="/login"/>" method="POST">
                    <div class="input-field">
                        <i class="material-icons prefix">mood</i>
                        <input name="login" id="login" type="text" class="validate" required="required" value="${usuario.getLogin()}">
                        <label for="login">Usuário</label>
                    </div>
                    <div class="input-field">
                        <i class="material-icons prefix">keyboard</i>
                        <input name="senha" id="senha" type="password" class="validate" required="required">
                        <label for="senha">Senha</label>
                    </div>
                    <div>
                        <button class="btn waves-effect green" type="submit">Logar
                            <i class="material-icons right">send</i>
                        </button>
                        <a href="<c:url value="/usuario/cadastro"/>" class="btn waves-effect green">
                            <i class="material-icons">person_add</i>
                        </a>
                    </div>
                </form>
            </div>
        </div>

        <script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/materialize.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/mensagens.js"/>" type="text/javascript"></script>

        <c:if test="${sucesso_cadastro == true}">
            <script>msgSucessoCadastroUsuario();</script>
        </c:if>
        <c:if test="${sucesso_login == false}">
            <script>msgErroLogin();</script>
        </c:if>
        <c:if test="${sucesso_exclusao == true}">
            <script>msgSucessoExclusaoUsuario();</script>
        </c:if>
    </body>

</html>
