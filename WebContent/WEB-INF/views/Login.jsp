<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Fazer login</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegacao -->
	<c:import url="Menu.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
       <h3 class="page-header">Fazer  Login</h3>
       <!-- Formulario de Login -->
        <form action=efetuarLogin method="post">
				<div class="row col-md-12">
				<div class="form-group">
					<div class="input-group col-md-4">
					   <div class="input-group-addon"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span></div> 
					   <input type="email" name="username" id="username" class="form-control" maxlength="60" placeholder="E-mail" required/>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group col-md-4">
					   <div class="input-group-addon"><span class="glyphicon glyphicon-option-horizontal" aria-hidden="true"></span></div> 
					   <input type="password" name="password" id="password" class="form-control" placeholder="Senha" required/>
					</div>
				</div>
				</div>
				<div class="row col-md-12">
					<button href="index.jsp" type="submit" class="btn btn-primary" name="login" value="FazerLogin"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Ok</button>
				</div>
			</form>    
			</div>
			<div class="container">
				<h5><a href="Cadastrar.jsp">Usuario não cadastrado</a></h5>
			</div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>