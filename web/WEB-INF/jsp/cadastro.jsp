<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="<c:url value="resources/css/materialize.min.css"/>" rel="stylesheet" type="text/css" media="screen,projection"/>
        <link href="<c:url value="resources/css/cadastro.css"/>" rel="stylesheet" type="text/css"/>
        <title>Cadastro</title>
    </head>
    <body>

        <div class="row cadastro">
            <form class="col s12" action="cadastro" method="POST">
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">account_circle</i>
                        <input name="nome" id="icon_prefix" type="text" class="validate" required="required">
                        <label for="icon_prefix">Nome</label>
                    </div>

                    <div class="input-field col s12">
                        <i class="material-icons prefix">mood</i>
                        <input name="login" id="icon_prefix" type="text" class="validate" required="required">
                        <label for="icon_prefix">Login</label>
                    </div>

                    <div class="input-field col s12">
                        <i class="material-icons prefix">mail</i>
                        <input name="email" id="icon_mail" type="email" class="validate" required="required">
                        <label for="icon_mail">Email</label>
                    </div>

                    <div class="input-field col s12">
                        <i class="material-icons prefix">keyboard</i>
                        <input name="senha" id="icon_prefix" type="password" class="validate" required="required">
                        <label for="icon_prefix">Senha</label>
                    </div>

                    <div class="btn_ok_cancel">
                        <button type="submit" class="waves-effect waves-light btn" id="btn_ok" name="action">OK</button>
                        <a href="login" class="waves-effect waves-light btn" id="btn_cancelar">Cancelar</a>
                    </div>
                </div>
            </form>
        </div>

        <script src="resources/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="resources/js/materialize.min.js" type="text/javascript"></script>
        <script src="resources/js/mensagens.js" type="text/javascript"></script>
        <c:if test="${sucesso == false}">
            <script>exibirMensagemDeErroCadastro();</script>
        </c:if>
    </body>
</html>
