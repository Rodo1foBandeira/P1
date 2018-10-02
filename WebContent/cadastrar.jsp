<%@ page import="dados.CadastroDB"%>
<%@ page import="entidades.Cadastro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar</title>
</head>
<body>

	<% 
String id = request.getParameter("id");	
String nome = request.getParameter("nome");
Cadastro cadastro = new Cadastro();
cadastro.setNome(nome);
if (!(id.isEmpty() || id.equals(null))){
	cadastro.setId(Integer.parseInt(id));
	new CadastroDB().alterar(cadastro);
}else{
	new CadastroDB().inserir(cadastro);
}
response.sendRedirect("consultar.jsp");
%>
</body>
</html>