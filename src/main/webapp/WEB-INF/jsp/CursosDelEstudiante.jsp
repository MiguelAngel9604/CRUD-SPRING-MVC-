<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
			<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
		crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
<head>
	<title>Estudiantes del curso</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>
<div class="container">
	<div id="wrapper">
		<div id="header">
			<h2>Estudiantes del curso</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		<br>
		<br>
		
			 <table class="table">
    <thead>
				<tr>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Accion</th>
				</tr>
				</thead>
    <tbody>
				<c:forEach var="tempEstudiante" items="${cursos}">
				
					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/curso_estudiante/eliminarCursoDeEstudiante">
						<c:param name="cursoId" value="${tempEstudiante.id}" />
						<c:param name="estudianteId" value="${estudiante.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempEstudiante.nombre} </td>
						<td> ${tempEstudiante.descripcion} </td>
						
						<td>
							
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Está seguro que desea eliminar al estudiante de este curso?'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
				</tbody>
  </table>
			<c:url var="menuLink" value="/estudiante/lista"></c:url>
			<a href="${menuLink}">Regresar</a>	
		</div>
	
	</div>
	
</div>
</body>

</html>