<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <div class="row login">
            <form class="col s12" action="<c:url value="/login"/>" method="POST">
                <div class="row">
                    <div class="input-field col s12">
                        <input name="login" id="usuario" type="text" class="validate" required="required">
                        <label for="usuario">Usuário</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input name="senha" id="password" type="password" class="validate" required="required">
                        <label for="password">Senha</label>
                    </div>
                </div>

                <button id="btn_enviar" class="btn waves-effect waves-light" type="submit">Logar
                    <i class="material-icons right">send</i>
                </button>
            </form>
            <br>
            <a id="link_cadastrar" href="<c:url value="/usuario/cadastro"/>">cadastrar - se</a>
        </div>

        <script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/materialize.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/mensagens.js"/>" type="text/javascript"></script>

        <c:if test="${sucesso_cadastro == true}">
            <script>exibirMensagemDeSucessoCadastro();</script>
            <%--<c:set var="sucesso_cadastro" value="${null}"/>--%>
        </c:if>
        <c:if test="${sucesso_login == false}">
            <script>exibirMensagemDeErroLogin();</script>
            <%--<c:set var="sucesso_login" value="${null}"/>--%>
        </c:if>
    </body>

</html>
