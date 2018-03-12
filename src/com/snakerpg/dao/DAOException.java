package com.snakerpg.dao;

/**
 * Creation des Execption DAO pour cacher la nature du mode de stockage
 * ce qui permet de masquer les execption specifique qui survienne lors de l'execution
 * 
 * @author etudiant
 *
 */

public class DAOException extends RuntimeException {
    /*
     * Constructeurs
     */
    public DAOException( String message ) {
        super( message );
    }

    public DAOException( String message, Throwable cause ) {
        super( message, cause );
    }

    public DAOException( Throwable cause ) {
        super( cause );
    }
}