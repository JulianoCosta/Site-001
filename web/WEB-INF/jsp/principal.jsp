<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="<c:url value="/resources/css/materialize.min.css"/>" rel="stylesheet" type="text/css" media="screen,projection"/>
        <link href="<c:url value="/resources/css/padroes_gerais.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/css/principal.css"/>" rel="stylesheet" type="text/css"/>
        <title>Principal</title>
    </head>
    <body>

        <header>
            <nav>
                <div class="container">
                    <div class="nav-wrapper">
                        <a href="#!" class="brand-logo left">${usuarioLogado.getNome()}</a>
                        <ul class="right">
                            <li><a href="<c:url value="/usuario/edicao"/>"><i class="material-icons">edit</i></a></li>
                            <li><a href="#modal_exclusao_usuario" class="modal-trigger"><i class="material-icons">delete</i></a></li>
                            <li><a href="<c:url value="/logout"/>"><i class="material-icons">exit_to_app</i></a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>

        <main>
            <div class="row container">
                <div class="col s12">
                    <h4>Usuários:</h4>
                    <div class="row">
                        <c:forEach items="${usuarioList}" var="e">
                            <div class="col s12 m6 l4">
                                <div class="card">
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
        </main>

        <div id="modal_exclusao_usuario" class="modal">
            <div class="modal-content">
                <h4>Deseja excluir sua conta mesmo?</h4>
            </div>
            <div class="modal-footer">
                <a href="<c:url value="/usuario/exclusao"/>" class="modal-action modal-close waves-effect btn">Sim</a>
                <a href="#!" class="modal-action modal-close waves-effect btn">Não</a>
            </div>
        </div>

        <c:import url="rodape.jsp"/>

        <script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/materialize.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/mensagens.js"/>" type="text/javascript"></script>
        <script>
            $(document).ready(function () {
                $('.modal').modal();
                $('.sidenav').sidenav();
            });
        </script>
        <c:if test="${sucesso_edicao == true}">
            <script>msgSucessoEdicaoUsuario();</script>
        </c:if>
    </body>
</html>
