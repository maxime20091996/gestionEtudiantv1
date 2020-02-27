<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
  <%@include file="../css/style.css" %>
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script></script>
<meta charset="ISO-8859-1">
<title>AUTHENTIFICATION</title>
</head>
<body>
	<h1>AUTHENTIFICATION</h1>
	
	<!-- On intègre un formulaire à la page HTML -->
	<form id="test" action="login" method="post">
		<div class="login">
			<p for="login">login :</p> <input type="text" id="login"
				name="login" required>

			<p for="password">password :</p> <input type="password" id="password"
				name="password" required>
		<input type="submit" value="Envoyer">
		</div>
	</form>
	<form  action="login" method="post">
	  <div class="form-group">
	    <label for="login">Login</label>
	    <input type="text" class="form-control" id="login" placeholder="login" name="login">
	  </div>
	  <div class="form-group">
	    <label for="password">Password</label>
	    <input type="password" class="form-control" id="password" placeholder="Password" name="password">
	  </div>
	  <button type="submit" class="btn btn-primary">Envoyer</button>
	</form>
</body>
</html>