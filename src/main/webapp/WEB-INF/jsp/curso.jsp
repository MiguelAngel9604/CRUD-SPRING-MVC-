<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" 
    xmlns:th="http://www.thymeleaf.org" 
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	   		
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
<div class="container">
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
			 <table class="table">
    <thead>
				<tr>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Alumnos</th>
					<th>Acción</th>

				</tr>
				    </thead>
    <tbody>
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
					</tbody>
  </table>
				
				
		</div>
			<p>
			<a href="${pageContext.request.contextPath}/estudiante/lista?cursoId=${cursoId}">Ir a la lista de estudiantes</a>
		</p>
			
	</div>
	
</div>
</body>

</html>