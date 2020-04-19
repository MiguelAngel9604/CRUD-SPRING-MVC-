<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Estudiantes del curso</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Estudiantes del curso</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		Curso: ${curso.nombre}
		Descripcion: ${curso.descripcion}
		<br>
		<br>
		
			<c:url var="addLink" value="/curso_estudiante/formAddStudent">
						<c:param name="cursoId" value="${curso.id}" />
			</c:url>
				
			<a href="${addLink}">Agregar estudiante</a>
			
			<table>
				<tr>
					<th>Nombres</th>
					<th>Apellidos</th>
					<th>Opciones</th>
				</tr>
				
				<c:forEach var="tempEstudiante" items="${estudiantes}">
				
					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/curso_estudiante/delete_from_curso">
						<c:param name="estudianteId" value="${tempEstudiante.id}" />
						<c:param name="cursoId" value="${curso.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempEstudiante.nombre} </td>
						<td> ${tempEstudiante.apellido} </td>
						
						<td>
							
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Está seguro que desea eliminar al estudiante de este curso?'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
			<c:url var="menuLink" value="/curso/lista"></c:url>
			<a href="${menuLink}">Regresar</a>	
		</div>
	
	</div>
	

</body>

</html>
