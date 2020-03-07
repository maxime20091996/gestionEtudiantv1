<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/style.css">
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<meta charset="ISO-8859-1">
	<title>Rechercher un étudiant</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="accueil.jsp">Gestion Etudiants</a>
	  	<div class="collapse navbar-collapse" id="navbarNavDropdown">
    		<ul class="navbar-nav">
    			<li class="nav-item dropdown">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          Menu étudiant
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
			          <a class="dropdown-item" href="liste-etudiants">Lister étudiants</a>
			          <a class="dropdown-item" href="recherche-detail-etudiant">Info étudiant</a>
			          <a class="dropdown-item" href="supprimer-etudiant">Supprimer un étudiant</a>
			          <a class="dropdown-item" href="recherche-modifier-etudiant">Modifier un étudiant</a>
			          <a class="dropdown-item" href="ajouter-etudiant">Ajouter un étudiant</a>
			          <a class="dropdown-item" href="ajouter-etudiant-cours">Rajouter un étudiant à un cours</a>
			        </div>
			    </li>
				<li class="nav-item active" style="padding-right: 10px">
		       		<a class="nav-link" href="index.jsp">Déconnexion <span class="sr-only">(current)</span></a>
		   		</li>
    		</ul>
  		</div>
	</nav>
	<div class="jumbotron">
	  <h1>Ajouter un étudiant à un cours</h1>
	</div>
	<div class="container">
        <div class="card card-container">
            <p id="profile-name" class="profile-name-card">Formulaire d'ajout d'étudiant</p>
            <form action="ajouter-etudiant-cours" method="post">
	            <select name="etudiant" class="form-control">
	              <c:forEach var="listeEtudiant" items="${listeEtudiant}">
	                <option>
	                	<c:out value="${listeEtudiant.id}" />	           
	                </option>
	              </c:forEach>
	            </select>
	            <select name="cours" class="form-control">
	              <c:forEach var="listeCours" items="${listeCours}">
	                <option>
	                  <c:out value="${listeCours.idCours}" />
	                </option>
	              </c:forEach>
	            </select>
	            <input type="submit" name="add" value="Add" />
            </form>
        </div><!-- /card-container -->
    </div><!-- /container -->
	
	<div class="container">		
		
	</div>
</body>
</html>