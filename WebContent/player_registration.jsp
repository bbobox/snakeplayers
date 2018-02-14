<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <script src="bootstrap/js/bootstrap.js"></script>
          <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css" />
    </head>
    
    <body>
    
    <div >
        <form  class="form-horizontal" method="post" action="player_registration"> 
            
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
               
               <div class="form-group row">
                	<label class="col-sm-2 col-form-label col-form-label-lg" for="email">Adresse email </label>
                	<div class="control-sm-10">
                		<input class="form-control" type="email" id="email" name="email" value="<c:out value="${utilisateur.emailadress}"/>" size="20" maxlength="60" >
                	</div>
                	<span class="erreur">${form.erreurs['email']}</span>
               </div>

				<div class="form-group">
               		<label class="control-label col-sm-2" for="motdepasse">Mot de passe</label>
               		<div class="control-sm-10">
                		<input  class="form-control" type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                	</div>
                	<span class="erreur">${form.erreurs['motdepasse']}</span>
                
                </div>

				<div class="form-group">
               		<label  class="sr-only" for="confirmation">Confirmation du mot de passe</label>
               	 	<input class="form-control"  type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                	<span class="erreur">${form.erreurs['confirmation']}</span>
                </div>

				<div class="form-group">
                	<label for="nom">Nom d'utilisateur</label>
                	<input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.name}"/>" size="20" maxlength="20" />
                	<span class="erreur">${form.erreurs['nom']}</span>
                </div>

                <button type="submit" value="Inscription" class="btn btn-default" /> mon bouton </button>
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

        </form>
    </body>
</html>