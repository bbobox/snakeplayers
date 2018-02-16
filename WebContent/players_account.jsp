<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
   <head>
        <meta charset="utf-8" />
        <title>Profile Client</title>
        <script src="bootstrap/js/bootstrap.js"></script>
          <script src="http://code.jquery.com/jquery-latest.min.js"></script>
          <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css" />
          <script src="bootstrap/js/bootstrap.js"></script>
		<script type="text/javascript">
		$('#myModal').on('shown.bs.modal', function () {
			  $('#myInput').trigger('focus')
			})
			
		</script>	
          
    </head>
	<body>
	
		<div>
		
		
			  <c:if test="${!empty sessionScope.sessionUtilisateur}">
			                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
			                   
			                    <div class="alert alert-primary" role="alert">
  									Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.emailadress}
								</div>			       
			  </c:if>
		</div>

	</body>
</html>