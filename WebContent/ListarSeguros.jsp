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

	<h2>"Tipo de seguros de la base de datos"</h2>
	<br>
	Búsqueda por tipo de seguros: <select name="tipoSeguro"></select>
								  <input type="submit" name="btnFiltrar" value="Filtrar" />
	<br><br>
	
	<table border="1">
		<tr><th> ID </th> <th> Descripción seguro </th> <th> Descripción tipo de seguro </th> 
		    <th> Costo contratación </th> <th> Costo máximo asegurado </th> </tr>
	
		<%
			//For para recorrer lista con seguros
		 %>
		 
		 <tr>
		 	<td> ID </td>
		 	<th> Descripción seguro </th>
		 	<th> Descripción tipo de seguro </th>
		 	<th> Costo contratación </th>
		 	<th> Costo máximo asegurado </th>
		 </tr>
		
		<%
			//Cierre del if que ponga arriba
		 %>
	</table>

</body>
</html>