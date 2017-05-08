package com.mvc.util;

import com.mvc.app.UsuarioDao;
import com.mvc.dao.MySqlFactoryDao;

public abstract class FactoryDao {
	
	public static final int TXT_FACTORY = 1;
    public static final int MYSQL_FACTORY = 2;

    public abstract UsuarioDao getUsuarioDao();

    public static FactoryDao getFactory(int claveFactory){
        switch(claveFactory){
            case TXT_FACTORY:
                //return new TxtFactoryDao();
            case MYSQL_FACTORY:
                return new MySqlFactoryDao();
            default:
                throw new IllegalArgumentException();
        }
    }

}
