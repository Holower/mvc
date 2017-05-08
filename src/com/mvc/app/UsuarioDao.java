package com.mvc.app;

import com.mvc.bean.Usuario;

public interface UsuarioDao {
	
	Usuario buscarUsuario(String nombre);
    void insertarUsuario(Usuario usuario);
    void modificarUsuario(Usuario usuario);
		
}
