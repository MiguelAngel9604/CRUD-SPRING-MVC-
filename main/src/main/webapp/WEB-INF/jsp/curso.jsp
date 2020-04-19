<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" 
    xmlns:th="http://www.thymeleaf.org" 
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
	
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>LISTA DE CURSOS </title>	
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body >
		<div id="wrapper">
		<div id="header">
			<h2>RELACION DE CURSOS</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
					<input type="button" value="Agregar Curso"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			<table>
				<tr>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Alumnos</th>
					<th>Acción</th>

				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempAlumno" items="${listaCurso}">	
				
						
					<c:url var="updateLink" value="/curso/showFormForUpdate">
						<c:param name="cursoId" value="${tempAlumno.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/curso/delete">
						<c:param name="cursoId" value="${tempAlumno.id}" />
					</c:url>
					
					<c:url var="detalle" value="/curso_estudiante/estudiantesDeCurso">
						<c:param name="cursoId" value="${tempAlumno.id}" />
					</c:url>
					<tr>
						<td> ${tempAlumno.nombre} </td>
						<td> ${tempAlumno.descripcion} </td>
						<td>
							<a href="${detalle}">Alumnos inscritos a este curso</a>		
						</td>	
							<td>
							<a href="${updateLink}">Actualizar</a>
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Estas seguro que quieres eliminar a este cliente?'))) return false">Eliminar</a>
						</td>			
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
			<p>
			<a href="${pageContext.request.contextPath}/estudiante/lista">Ir a la lista de estudiantes</a>
		</p>
			
	</div>
	

</body>

</html>