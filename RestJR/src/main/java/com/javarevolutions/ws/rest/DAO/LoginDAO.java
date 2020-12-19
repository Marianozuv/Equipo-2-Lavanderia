package com.javarevolutions.ws.rest.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.javarevolutions.ws.rest.vo.VOUsuario;

public class LoginDAO {
	
//	public Boolean validarUsuario(VOUsuario datos) {
//		Boolean existe = false;
//		//ir a la base de datos 
//		
//		if(datos.getUsuario().equals("Java") && datos.getPassword().equals("Revolutions")){
//			existe = true;
//		}
//		return existe;
//	}
	
	private Connection connection;
    private PreparedStatement statement;

    public Boolean validarUsuario(VOUsuario datos) throws SQLException{
    	Boolean existe = false;
    	  connection=obtenerConnection();
          try{
          	Statement s = connection.createStatement();
          	String query = "SELECT * FROM `administrador` WHERE correoAdmin='"+datos.getUsuario()+"' AND password='"+datos.getPassword()+"'";
          	ResultSet rs = s.executeQuery (query);      	
          	// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
          	while (rs.next())
          	{
          		existe = true;
          	    System.out.println (rs.getString (1) + " " + rs.getString (2)+ " " + rs.getString(3));
          	}
              connection.close();
          } catch(SQLException e){
              connection.rollback();
              e.printStackTrace();
          }
          return existe;
    }
    
    //obtener conexion
    private Connection obtenerConnection(){
        return Conexion.geConnection();
    }

}
