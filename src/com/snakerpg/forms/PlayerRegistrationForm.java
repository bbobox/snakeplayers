package com.snakerpg.forms;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.snakerpg.beans.Player;
import com.sun.security.ntlm.Client;


public final class PlayerRegistrationForm {
	
	
	
	    private static final String CHAMP_EMAIL  = "email";
	    private static final String CHAMP_PASS   = "motdepasse";
	    private static final String CHAMP_CONF   = "confirmation";
	    private static final String CHAMP_NOM    = "nom";
	    
	    private String resultat;
	    private Map<String, String> erreurs      = new HashMap<String, String>();
	    
	    
	    

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

        validationEmail( email );

    } catch ( Exception e ) {

        setErreur( CHAMP_EMAIL, e.getMessage() );

    }

    utilisateur.setEmailadress( email );  System.out.println("creation de l'email:"+utilisateur.getEmailadress());


   // System.out.println("creation du mot de passe "+motDePasse);	
    
   // System.out.println("confirmation du mot de passe  "+confirmation);	
    
    
    try {

        validationMotsDePasse( motDePasse, confirmation );

    } catch ( Exception e ) {

        setErreur( CHAMP_PASS, e.getMessage() );

        setErreur( CHAMP_CONF, null );

    }

    utilisateur.setMdp( motDePasse );


    try {

        validationNom( nom );

    } catch ( Exception e ) {

        setErreur( CHAMP_NOM, e.getMessage() );

    }

    utilisateur.setName( nom ); System.out.println("creation du nom"+email);


    if ( erreurs.isEmpty() ) {

        resultat = "Succès de l'inscription.";

    } else {

        resultat = "Échec de l'inscription.";

    }


    return utilisateur;

}

// Mise en Place, Methdode de Validation


private void validationEmail( String email ) throws Exception {
    if ( email != null ) {
        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    } else {
        throw new Exception( "Merci de saisir une adresse mail." );
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


}
