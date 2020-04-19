<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<head>
	<title>Agregar Estudiante a curso</title>
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
	</head>

<body>
	<div class="container">
	<div id="wrapper">
		<div id="header">
			<h2>Agregar Estudiante</h2>
		</div>
	</div>

	<div id="container">

		<form:form action="AgregarAlCurso"  method="GET">

		    <input type="hidden" name="cursoId" value="${cursoId}" />	
			<table>
				<tbody>
					<tr>
						<td><label>Agregar Estudiante:</label></td>
					<!--  	<td><input type="text" name="estudianteId"/></td> -->
						<td>
						<select name="estudianteId " class="mdb-select md-form md-outline colorful-select dropdown-primary"  >
							<option value="" disabled selected>Choose student</option>
								<c:forEach var="entry" items="${StudentsList}"> 
									<option value="${entry.key}">${entry.value}</option>  
								 </c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>
				</tbody>
			</table>
		
		
		</form:form>
		

		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/curso/lista">Regresar a la lista de cursos</a>
		</p>

	</div>
</div>
</body>

</html>