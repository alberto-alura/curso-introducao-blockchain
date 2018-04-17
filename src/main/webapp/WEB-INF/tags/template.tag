<%@attribute name="titulo"  required="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/style.css">
</head>
<body>


    <!-- Menu -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Electio</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
            	<sec:authorize access="isAuthenticated()">
	                <li class="nav-item active">
	                    <a class="nav-link" href="/logout">Sair</a>
	                </li>
	                <li class="nav-item active">
	                    <a class="nav-link" href="/ellections/form">Nova eleição</a>
	                </li>                
	                <li class="nav-item active">
	                    <a class="nav-link" href="/candidates/form">Cadastro de candidatos</a>
	                </li>                
	                <li class="nav-item active">
	                    <a class="nav-link" href="/registered">Liberação de eleitores</a>
	                </li>
	             </sec:authorize>
	             
	            <sec:authorize access="not isAuthenticated()">
	                <li class="nav-item active">
	                    <a class="nav-link" href="/login">Login</a>
	                </li>
	            </sec:authorize>	                                             
                <li class="nav-item active">
                    <a class="nav-link" href="/voters/form">Novo eleitor</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/votingbooth/code/form">Gerar número de participação</a>
                </li>                                
                <li class="nav-item active">
                    <a class="nav-link" href="/votingbooth/choose/ellection/form">Votar</a>
                </li>                                
            </ul>
        </div>
    </nav>
    <!-- ./Menu -->

    <!-- Cabecalho -->
    <div class="jumbotron">
        <h1 class="text-center">
            ${titulo}
        </h1>
    </div>
    <!-- ./Cabecalho -->
    
	<div class="container">
		<jsp:doBody/>
	</div>    
	
    <script src="/assets/js/jquery-3.2.1.slim.min.js"></script>
    <script src="/assets/js/popper.min.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
</body>
</html>	
