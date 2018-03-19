<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div class="row cadastro">
            <form class="col s12" action="<c:url value="/usuario/cadastro"/>" method="POST">
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">account_circle</i>
                        <input name="nome" id="nome" type="text" class="validate" required="required">
                        <label for="nome">Nome</label>
                    </div>

                    <div class="input-field col s12">
                        <i class="material-icons prefix">mood</i>
                        <input name="login" id="login" type="text" class="validate" required="required">
                        <label for="login">Login</label>
                    </div>

                    <div class="input-field col s12">
                        <i class="material-icons prefix">mail</i>
                        <input name="email" id="email" type="email" class="validate" required="required">
                        <label for="email">Email</label>
                    </div>

                    <div class="input-field col s12">
                        <i class="material-icons prefix">keyboard</i>
                        <input name="senha" id="senha" type="password" class="validate" required="required">
                        <label for="senha">Senha</label>
                    </div>

                    <div class="btn_ok_cancel">
                        <button type="submit" class="waves-effect waves-light btn" id="btn_ok">OK</button>
                        <a href="<c:url value="/login"/>" class="waves-effect waves-light btn" id="btn_cancelar">Cancelar</a>
                    </div>
                </div>
            </form>
        </div>

        <script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/materialize.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/mensagens.js"/>" type="text/javascript"></script>
        <c:if test="${sucesso == false}">
            <script>exibirMensagemDeErroCadastro();</script>
        </c:if>
    </body>
</html>
