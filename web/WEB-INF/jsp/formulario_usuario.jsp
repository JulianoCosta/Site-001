<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="<c:url value="/resources/css/materialize.min.css"/>" rel="stylesheet" type="text/css" media="screen,projection"/>
        <link href="<c:url value="/resources/css/cadastro.css"/>" rel="stylesheet" type="text/css"/>
        <title>Cadastro</title>
    </head>
    <body>
        <div class="row container">
            <div class="col s12 m6 l6 center-align push-l3 push-m3">
                <nav class="grey">
                    <div class="nav-wrapper">
                        <h5 class="brand-logo center">
                            <c:if test="${edicao != true}">Cadastro</c:if>
                            <c:if test="${edicao == true}">Edição</c:if>
                            </h5>
                        </div>
                    </nav>
                    <form id="formulario" action="<c:url value="/usuario/cadastro"/>" method="POST">
                    <div class="input-field">
                        <i class="material-icons prefix">account_circle</i>
                        <input name="nome" id="nome" type="text" class="validate" required="required">
                        <label for="nome">Nome</label>
                    </div>
                    <div class="input-field">
                        <i class="material-icons prefix">mood</i>
                        <input name="login" id="login" type="text" class="validate" required="required">
                        <label for="login">Login</label>
                    </div>
                    <div class="input-field">
                        <i class="material-icons prefix">mail</i>
                        <input name="email" id="email" type="email" class="validate" required="required">
                        <label for="email">Email</label>
                    </div>
                    <div class="input-field">
                        <i class="material-icons prefix">keyboard</i>
                        <input name="senha" id="senha" type="password" class="validate" required="required">
                        <label for="senha">Senha</label>
                    </div>
                    <div>
                        <button type="submit" class="waves-effect waves-light btn green">
                            <i class="material-icons">done</i>
                        </button>
                        <a id="btn_cancelar" href="<c:url value="/login"/>" class="waves-effect waves-light btn red">
                            <i class="material-icons">clear</i>
                        </a>
                    </div>
                </form>
            </div>
        </div>

        <script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/materialize.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/mensagens.js"/>" type="text/javascript"></script>
        <c:if test="${edicao == true}">
            <script>
                $("#formulario").attr("action", "<c:url value="/usuario/edicao"/>");
                $("#nome").val("${usuarioLogado.getNome()}");
                $("#login").val("${usuarioLogado.getLogin()}");
                $("#email").val("${usuarioLogado.getEmail()}");
                $("#btn_cancelar").attr("href", "<c:url value="/principal"/>");
            </script>
        </c:if>
        <c:if test="${sucesso_cadastro == false}">
            <script>msgErroCadastroUsuario();</script>
        </c:if>
        <c:if test="${sucesso_edicao == false}">
            <script>msgErroEdicaoUsuario();</script>
        </c:if>
    </body>
</html>
