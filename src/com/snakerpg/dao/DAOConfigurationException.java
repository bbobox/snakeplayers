package com.snakerpg.dao;
/**
 *Gestion des exceptions des la configuration
 * @author etudiant
 *
 */

public class DAOConfigurationException extends RuntimeException {
    /*
     * Constructeurs 
     */
    public DAOConfigurationException( String message ) {
        super( message );
    }

    public DAOConfigurationException( String message, Throwable cause ) {
        super( message, cause );
    }

    public DAOConfigurationException( Throwable cause ) {
        super( cause );
    }
    
}