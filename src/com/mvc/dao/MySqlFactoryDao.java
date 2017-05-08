package com.mvc.dao;

import com.mvc.app.UsuarioDao;
import com.mvc.util.FactoryDao;

public class MySqlFactoryDao extends FactoryDao {
	@Override
    public UsuarioDao getUsuarioDao() {
        return new UsuarioMySqlFactoryDao();
    }
}
