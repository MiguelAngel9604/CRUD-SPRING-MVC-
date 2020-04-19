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
	<title>Guardar Curso</title>
		
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>RELACION DE CURSOS</h2>
		</div>
	</div>

	<div id="container">
		<h3>GUARDAR CURSO</h3>
	
		<form:form action="saveCurso" modelAttribute="curso" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre(*):</label></td>
						<td><form:input path="nombre" /></td>
					</tr>
					<tr>
						<td><label>Descripcion(*):</label></td>
						<td><form:input path="descripcion" /></td>
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
			<a href="${pageContext.request.contextPath}/curso/lista">Regresar a la lista</a>
		</p>
	
	</div>

</body>

</html>
