<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" 
    xmlns:th="http://www.thymeleaf.org" 
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
	
<head>
<head>
	<title>Guardar Estudiante</title>
		
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>RELACION DE ESTUDIANTES</h2>
		</div>
	</div>

	<div id="container">
		<h3>GUARDAR ESTUDIANTES</h3>
	
		<form:form action="saveEstudiante" modelAttribute="estudiante" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre(*):</label></td>
						<td><form:input path="nombre" /></td>
					</tr>
					<tr>
						<td><label>Apellido(*):</label></td>
						<td><form:input path="apellido" /></td>
					</tr>

					<tr>
						<td><label>Correo(*):</label></td>
						<td><form:input path="correo" placeholder ="usuario@dominio.com" /></td>					
					</tr>
					<tr>
						<td><label>Cumpleaños(*):</label></td>
						<td><form:input path="fechaNacimiento" placeholder ="aaaa-mm-dd"/></td>						
					</tr>
					<tr>
						<td><label>Mayor de edad(*):</label></td>
						<td><form:input path="mayoriaEdad" placeholder ="True/False"/></td>						
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="Guardar" /></td>
					</tr>
					

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/estudiante/lista">Regresar a la lista</a>
		</p>
	
	</div>

</body>

</html>

