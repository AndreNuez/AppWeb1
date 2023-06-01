<%@page import="dominio.TipoSeguroDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dominio.TipoSeguro"%>
<%@page import="dominio.TipoSeguroDao"%>
<%@page import="dominio.Seguro"%>
<%@page import="dominio.SeguroDao"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="Inicio.jsp"> Inicio </a>
<a href="AgregarSeguro.jsp"> Agregar seguro </a>
<a href="ListarSeguro.jsp"> Listar seguros </a>

<h1> Agregar seguros</h1>

<% 
	String desc;

	TipoSeguroDao dao = new TipoSeguroDao();
	
	SeguroDao segDao = new SeguroDao();
	
	ArrayList<TipoSeguro> lista = null; 
	lista = dao.obtenerTipoSeguros();
	
	int filas = 0;
	if(request.getAttribute("cantFilas")!=null)
		{
			filas = (int)request.getAttribute("cantFilas");
		}	

%>

	<form action="servletSeguro" method="get">
	
	IdSeguro			<%=segDao.obtenerUltimoId()%><br><br>
	Descripcion			<input type="text" name="txtDescripcion"><br><br>
	Tipo de Seguro		<select name="tipoSeguro"> 
	
						<% for(TipoSeguro ts : lista) { desc = ts.getDescripcion(); %> 
						
						<option> <%= desc %> </option>
						
						<% } %>
						</select> <br><br>
	Costo contratación	<input type="text" name="txtCostoContratacion"><br><br>
	Costo Maximo Asegurado	<input type="text" name="txtCostoMax"><br><br>
	<input type="submit" name="btnAceptar" value="Aceptar">
	
	</form>
	
	<%
		if(filas == 1)
	{ %>
		<br>
		<h4>Seguro agregado con éxito.</h4>
	
	<% } 
		if(filas == 2) {
	%>
		<br>
		<h4>Revise los campos.</h4><br>
		Descripción debe completarse.<br>
		Solo números para campos de costos.
	<%} %>
	
</body>
</html>