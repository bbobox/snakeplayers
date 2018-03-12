package com.snakerpg.dao;

import com.snakerpg.beans.Player;

public interface UtilisateurDao {

    void creer( Player utilisateur ) throws DAOException;

   Player trouver( String email ) throws DAOException;

}