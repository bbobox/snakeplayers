package com.snakerpg.servlets;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.snakerpg.beans.Player;
import com.snakerpg.dao.DAOFactory;
import com.snakerpg.dao.UtilisateurDao;
import com.snakerpg.forms.PlayerRegistrationForm;



public class PlayerRegistration  extends HttpServlet{
	
	
	 public static final String CONF_DAO_FACTORY = "daofactory"; 
	 public static final String ATT_USER = "utilisateur";
	 public static final String ATT_FORM = "form";
	 public static final String VUE = "/WEB-INF/player_registration.jsp";
	 
	 private UtilisateurDao     utilisateurDao;
	 
	 
	   public void init() throws ServletException {
	        /* Récupération d'une instance de notre DAO Utilisateur */
	        this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();
	    }
	 
	 
	
	    
	    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	        /* Affichage de la page d'inscription */
	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	    }

	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	        /* Préparation de l'objet formulaire */
	        PlayerRegistrationForm form = new PlayerRegistrationForm( utilisateurDao );

	        /* Traitement de la requête et récupération du bean en résultant */
	        Player utilisateur = form.inscrireUtilisateur( request );

	        /* Stockage du formulaire et du bean dans l'objet request */
	        request.setAttribute( ATT_FORM, form );
	        request.setAttribute( ATT_USER, utilisateur );

	        RequestDispatcher rd = request.getRequestDispatcher("/player_registration.jsp") ;	    
		     // redirection de la requête vers cette ressource
		    rd.forward(request, response) ;
	    }

	
}
