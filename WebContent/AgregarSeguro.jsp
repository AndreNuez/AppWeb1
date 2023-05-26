<%@page import="dominio.TipoSeguro" %>
<%@page import="dominio.TipoSeguroDao" %>
<%@page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="Inicio.jsp"> Inicio</a> 
<a href="AgregarSeguro.jsp">Agregar seguro</a> 
<a href="ListarSeguros.jsp">Listar seguros</a>

	<h2>Agregar seguro</h2>
	<br>
	<%
		String descripcion = "";
		TipoSeguroDao dao = new TipoSeguroDao();
		ArrayList<TipoSeguro> lista = null;
		lista = dao.obtenerTipoSeguro();
		
		int filas = 0;
		if(request.getAttribute("cantFilas")!=null)
			{
				filas = (int)request.getAttribute("cantFilas");
			}		
	%>
	
	
	<form action="servletSeguro" method="get">
	
		ID Seguro:
		<br>
		Descripción: <input type="text" name="txtDescripcion" />
		<br>
		Tipo seguro: <select name="tiposSeguro">
					 <% for(TipoSeguro ts : lista) 
					 	{
						 descripcion = ts.getDescripcion();
					 %>
						<option> <%= descripcion %> </option>
					<% } %>
					</select>
		<br>
		Costo contratación: <input type="text" name="txtCosto" />
		<br>
		Costo máximo asegurado: <input type="text" name="txtCostoMax" />
		<br><br>
		<input type="submit" name="btnAceptar" value="Aceptar" />
	
	</form>
		
	<%
		if(filas == 1)
	{ %>
		Seguro agregado con éxito.
	
	<% } %>
</body>
</html>