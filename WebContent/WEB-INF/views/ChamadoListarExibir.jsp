<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Chamados</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Consultar Chamados</h3>
			<div class="row">
				<div class="table-responsive col-md-12">
					<table class="table table-striped" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th>ID_Chamado</th>
								<th>Descricao</th>
								<th>Status</th>
								<th>Data de Abertura</th>
								<th>Data de Fechamento</th>
								<th>Fila</th>
								<th class="actions">Ações</th>
							</tr>
						</thead>
							<tbody>
								<c:forEach var="chamado" items="${chamados}">
									<tr>
										<td>${chamado.idChamado}</td>
										<td>${chamado.descricao}</td>
										<td>${chamado.status}</td>
										<td>${chamado.dtAbertura}</td>
										<td>${chamado.dtFechamento}</td>
										<td>${chamado.fila.id}</td>
										<td class="actions"><a class="btn btn-success btn-xs"
										href="Agenda.do?acao=Visualizar&id=${chamado.idChamado }">Visualizar</a>
										<a class="btn btn-warning btn-xs"
										href="Agenda.do?acao=Editar&id=${chamado.idChamado }">Editar</a>
										<button id="btn${chamado.idChamado }%>" type="button"
											class="btn btn-danger btn-xs" data-toggle="modal"
											data-target="#delete-modal" data-cliente="${chamado.idChamado }">Excluir</button>
									</td>
										
									</tr>
								</c:forEach>
							</tbody>
					</table>
				</div>
			</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>