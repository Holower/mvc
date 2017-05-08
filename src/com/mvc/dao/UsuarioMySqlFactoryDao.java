package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.app.UsuarioDao;
import com.mvc.bean.Usuario;
import com.mvc.util.DBConnection;

public class UsuarioMySqlFactoryDao implements UsuarioDao{

	private Connection cn;

    public UsuarioMySqlFactoryDao() {
        cn = DBConnection.getInstance();
    }

    public Usuario buscarUsuario(String usuarioTxt) {
        //throw new UnsupportedOperationException("Not supported yet.");
        try {
        	   PreparedStatement consulta = cn.prepareStatement("SELECT * FROM usuario where usuario = ? ");
        	   consulta.setString(1, usuarioTxt);
        	   ResultSet res = consulta.executeQuery();
        	   while(res.next()){
	        	    Usuario usuario = new Usuario();
	        	    usuario.setUsuario(res.getString("usuario"));
	        	    usuario.setClave(res.getString("clave"));
	        	    usuario.setNombre(res.getString("nombre"));
	        	    usuario.setCorreo(res.getString("correo"));
	        	    usuario.setDireccion(res.getString("direccion"));
	        	    usuario.setTelefono(res.getString("telefono"));
	        	    return usuario;
        	   }
	          res.close();
	          consulta.close();
	          cn.close();
        	  
        	  } catch (Exception e) {
        		  System.out.println(e.getMessage());
        	   //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
        	  }
        return null;
    }

    public void insertarUsuario(Usuario usuario) {
        //throw new UnsupportedOperationException("Not supported yet.");
    	try {
    		   Statement estatuto = cn.createStatement();
    		   estatuto.executeUpdate("INSERT INTO usuario (usuario, nombre, correo, direccion, telefono, clave) VALUES ('"+usuario.getUsuario()+"', "+ 
    			"'" +usuario.getNombre()+"','" +usuario.getCorreo()+"', '"+usuario.getDireccion()+"', '"
    		     +usuario.getTelefono()+"', '"+usuario.getClave()+"')");
    		   //JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
    		   estatuto.close();
    		   cn.close();
    		    
    		  } catch (SQLException e) {
    		            System.out.println(e.getMessage());
    		   //JOptionPane.showMessageDialog(null, "No se Registro la persona");
    		  }
    }

    public void modificarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

	
	
}
