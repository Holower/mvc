package com.mvc.negocio;

import com.mvc.bean.Usuario;
import com.mvc.dao.UsuarioMySqlFactoryDao;

public class LoginDao {
	public String authenticateUser(Usuario usuario){
		
		UsuarioMySqlFactoryDao usuarioDao = new UsuarioMySqlFactoryDao();
		
		Usuario u = usuarioDao.buscarUsuario(usuario.getUsuario());
		
		if (u != null) {
			if (u.getClave().contentEquals(usuario.getClave())) {
				return "SUCCESS";
			}
		}
		
		return "ERROR";
		
	}
}
