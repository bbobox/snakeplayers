package com.snakerpg.forms;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import com.snakerpg.beans.Player;
import com.snakerpg.dao.DAOException;
import com.snakerpg.dao.UtilisateurDao;
import com.sun.security.ntlm.Client;


public final class PlayerRegistrationForm {
	
	
	
	    private static final String CHAMP_EMAIL  = "email";
	    private static final String CHAMP_PASS   = "motdepasse";
	    private static final String CHAMP_CONF   = "confirmation";
	    private static final String CHAMP_NOM    = "nom";
	    
	    private String resultat;
	    private Map<String, String> erreurs      = new HashMap<String, String>();
	    
	    private UtilisateurDao      utilisateurDao;
	    
	    public PlayerRegistrationForm( UtilisateurDao utilisateurDao ) {
	        this.utilisateurDao = utilisateurDao;
	    }
	    
	    

	    public String getResultat() {
	        return resultat;
	    }

	    public Map<String, String> getErreurs() {
	        return erreurs;
	    }
	    
	    
	    // 3. Nous ajoutons alors la méthode principale, contenant la logique de validation :
	    
	    
	    

	    public Player inscrireUtilisateur( HttpServletRequest request ) {

	        String email = getValeurChamp( request, CHAMP_EMAIL );

	        String motDePasse = getValeurChamp( request, CHAMP_PASS );

	        String confirmation = getValeurChamp( request, CHAMP_CONF );

	        String nom = getValeurChamp( request, CHAMP_NOM );


	        Player utilisateur = new Player();
	        try {
	        
	        	traiterEmail(email,utilisateur);
	        	traiterMotsDePasse(motDePasse, confirmation, utilisateur);
	        	traiterNom(nom, utilisateur);
	        
	    	    if ( erreurs.isEmpty() ) {
	    	    	
	    	    	// creation de l'utilisateur DAO si pas d'erreurs
	    	    	
	    	    	 utilisateurDao.creer( utilisateur );
	    	
	    	        resultat = "Succès de l'inscription.";
	    	
	    	    } else {
	    	
	    	        resultat = "Échec de l'inscription.";
	    	
	    	    }
	        }catch (DAOException e) {
	        	
	        	resultat = "Échec de l'inscription : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
	            e.printStackTrace();
	        }


	        return utilisateur;

	    }

	    // Mise en Place, Methdode de Validation


	    /* Validation de l'adresse email */
	    private void validationEmail( String email ) throws FormValidationException {
	        if ( email != null ) {
	            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	                throw new FormValidationException( "Merci de saisir une adresse mail valide." );
	            } else if ( utilisateurDao.trouver( email ) != null ) {
	                throw new FormValidationException( "Cette adresse email est déjà utilisée, merci d'en choisir une autre." );
	            }
	        } else {
	            throw new FormValidationException( "Merci de saisir une adresse mail." );
	        }
	    }

	    private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception {
	        if ( motDePasse != null && confirmation != null ) {
	            if ( !motDePasse.equals( confirmation ) ) {
	                throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
	            } else if ( motDePasse.length() < 3 ) {
	                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
	            }
	        } else {
	            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
	        }
	    }

	    private void validationNom( String nom ) throws Exception {
	        if ( nom != null && nom.length() < 3 ) {
	            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
	        }
	    }

	    /*
	     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	     */
	    private void setErreur( String champ, String message ) {
	        erreurs.put( champ, message );
	    }

	    /*
	     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	     * sinon.
	     */
	    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
	        String valeur = request.getParameter( nomChamp );
	        if ( valeur == null || valeur.trim().length() == 0 ) {
	            return null;
	        } else {
	            return valeur.trim();
	        }
	    }


	    public void traiterEmail(String email, Player utilisateur) {
	    	
	    	 try {

	             validationEmail( email );


	        } catch ( Exception e ) {

	            setErreur( CHAMP_EMAIL, e.getMessage() );

	        }
	    	 
	    	 utilisateur.setEmailadress(email);
	    }


	    private void traiterMotsDePasse( String motDePasse, String confirmation, Player utilisateur ) {
	    	try {

	            validationMotsDePasse( motDePasse, confirmation );

	        } catch ( Exception e ) {

	            setErreur( CHAMP_PASS, e.getMessage() );

	            setErreur( CHAMP_CONF, null );

	        }

	        utilisateur.setMdp( motDePasse );
	    	
	    }


	    public void traiterNom(String nom, Player utilisateur) {
	    	
	    	 try {

	    	        validationNom( nom );

	    	    } catch ( Exception e ) {

	    	        setErreur( CHAMP_NOM, e.getMessage() );

	    	    }

	    	    utilisateur.setName( nom );
	    	
	    	
	    }


}
