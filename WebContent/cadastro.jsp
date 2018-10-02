<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.css">

</head>
<body>

	<div align="center">
		<h1>Cadastro</h1>
		<form action="cadastrar.jsp" method="post">
           
            <input type="hidden" class="form-control" id="id" name="id" value="${param.id}">
			
			<div class="col-sm-6">

				<div class="form-group">
					<div class="row">
						<label for="nome">Nome</label> <input type="text"
							class="form-control" id="nome" name="nome" value="${param.nome}">

					</div>

				</div>				

				<input type="submit" value="Salvar" class="btn btn-primary" />
				<a href="consultar.jsp" class="btn btn-light">Cancelar</a>
			</div>
		</form>
	</div>

</body>
</html>