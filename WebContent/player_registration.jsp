<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
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
    
<!--     Button trigger modal -->
<!-- 	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"> -->
<!-- 	 	 Forumlaire d'inscription  -->
<!-- 	</button> -->
	
<!-- 	<!-- Modal --> -->
<!-- 	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"> -->
<!-- 	  <div class="modal-dialog" role="document"> -->
<!-- 	    <div class="modal-content"> -->
<!-- 	      <div class="modal-header"> -->
<!-- 	        <h5 class="modal-title" >Modal title</h5> -->
<!-- 	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"> -->
<!-- 	          <span aria-hidden="true">&times;</span> -->
<!-- 	        </button> -->
<!-- 	      </div> -->
<!-- 	      <div class="modal-body"> -->
<!-- 	      		<div class="container"> -->
    <h1>Vous pouvez vous inscrire via ce formulaire.</h1>
        <form  class="form-horizontal" method="post" action="player_registration"> 
     
               
               <div class="form-group">
                	<label class="control-label col-sm-2" for="email">Email </label>
                	<div class="col-sm-10">
                		<input class="form-control" type="email" id="email" name="email" value="<c:out value="${utilisateur.emailadress}"/>" size="20" maxlength="60" >
                	</div>
                	<span class="erreur">${form.erreurs['email']}</span>
               </div>

				<div class="form-group">
               		<label class="control-label col-sm-2" for="motdepasse">Mot de passe</label>
               		<div class="col-sm-10">
                		<input  class="form-control" type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                	</div>
                	<span class="erreur">${form.erreurs['motdepasse']}</span>
                
                </div>

				<div class="form-group">
               		<label  class="control-label col-sm-2" for="confirmation">Confirmation du mot de passe</label>
               		<div class="col-sm-10">
               	 		<input class="form-control"  type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                		<span class="erreur">${form.erreurs['confirmation']}</span>
                	</div>
                </div>

				<div class="form-group">
                	<label class="control-label col-sm-2" class="control-label col-sm-2" for="nom">Nom</label>
                	<div class="col-sm-10">
                		<input class="form-control" type="text" id="nom" name="nom" value="<c:out value="${utilisateur.name}"/>" size="20" maxlength="20" />
                		<span class="erreur">${form.erreurs['nom']}</span>
                	</div>
                </div>
                
                <div class="form-group">
                	<label class="control-label col-sm-2" class="control-label col-sm-2" for="nom">Prenom</label>
                	<div class="col-sm-10">
                		<input class="form-control" type="text" id="prenom" name="prenom" value="<c:out value="${utilisateur.firstname}"/>" size="20" maxlength="20" />
                		<span class="erreur">${form.erreurs['prenom']}</span>
                	</div>
                </div>
               
               <div class="form-group">        
      				<div class="col-sm-offset-2 col-sm-10">
      	  				 <button type="submit" value="Inscription" class="btn btn-default" /> Valider </button>
      				</div>
   			 </div>
               
             <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

        </form>
       </div> 
<!-- 	      </div> -->
<!-- 	      <div class="modal-footer"> -->
<!-- 	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> -->
<!-- 	        <button type="button" class="btn btn-primary"> Valider</button> -->
<!-- 	      </div> -->
<!-- 	    </div> -->
<!-- 	  </div> -->
<!-- 	</div> -->
    
    
    </body>
</html>


