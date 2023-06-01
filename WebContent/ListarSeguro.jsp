<%@page import="dominio.TipoSeguroDao"%>
<%@page import="dominio.SeguroDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dominio.TipoSeguro"%>
<%@page import="dominio.Seguro"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<br/>
<br/>

<b> Tipo de seguros de la Base de Datos </b>

<br/>
<br/>

<%
	String desc;
	int id;
	TipoSeguroDao dao = new TipoSeguroDao();
	ArrayList<TipoSeguro> lista = null; 
	lista = dao.obtenerTipoSeguros();
	
%>

Búsqueda por tipo de Seguros: 

<br/>
<br/>
<form action="servletSeguro" method="get">
<select name=tipoSeguro> 
	<% for(TipoSeguro ts : lista) { 
		id = ts.getIdTipo(); desc = ts.getDescripcion(); %> 
	<option value="<%= desc %>"> <%= desc %> </option>
	<% } %>
	</select>

	<input type="submit" name="btnFiltrar" value="Filtrar">
</form>


<%
	ArrayList<Seguro> listaSeguros;
 	ArrayList<Seguro> listaSegurosFiltrada = null;
 	SeguroDao sdao = new SeguroDao();
	
 	listaSeguros = sdao.listarSeguros();
 	
	
	if(request.getAttribute("listaSegurosFiltrada") != null)
	{
		listaSegurosFiltrada = (ArrayList<Seguro>)request.getAttribute("listaSegurosFiltrada");
	}
	%>

<table border="1">
	<tr> <th>ID</th> <th>Descripción seguro</th> <th>Descripción tipo seguro</th> <th>Costo contratación</th> <th>Costo máximo asegurado</th>
	
	<% if(listaSegurosFiltrada == null) {
		for(Seguro seguro : listaSeguros) {
			TipoSeguroDao tsdao = new TipoSeguroDao();
	%>
	<tr> 
		<td><%=seguro.getId() %></td>
		<td><%=seguro.getDescripcion() %></td>
		<td><%= tsdao.obtenerDescripcion(seguro.getTipo()) %></td>
		<td><%=seguro.getCosto() %></td>
		<td><%=seguro.getCostoMax() %></td>
	<%
		}
	}%>
		
	<%	
		if(listaSegurosFiltrada != null) {
		listaSeguros.clear();
		for(Seguro seguro : listaSegurosFiltrada) 
		{ TipoSeguroDao tsdao = new TipoSeguroDao();
	%>
	<tr> 
		<td><%=seguro.getId() %></td>
		<td><%=seguro.getDescripcion() %></td>
		<td><%= tsdao.obtenerDescripcion(seguro.getTipo()) %></td>
		<td><%=seguro.getCosto()%></td>
		<td><%=seguro.getCostoMax() %></td>
	<%
		}
	}
	%>
</table>


</body>
</html>