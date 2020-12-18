package com.javarevolutions.ws.rest.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.javarevolutions.ws.rest.vo.VOUsuario;

public class AltaClienteDAO {
	
	private Connection connection;
    private PreparedStatement statement;
    private boolean estadoOperacion;

    public String altaCliente(Cliente datos) throws SQLException{
    	   String respuesta = "";
    	   estadoOperacion=false;
    	   String sql ="";
    	  connection=obtenerConnection();
          try{
        	  connection.setAutoCommit(false);
              sql = "INSERT INTO `usuario` (`nombreC`, `correo`, `telefono`) VALUES(?,?,?)";
              statement=connection.prepareStatement(sql);

              statement.setString(1, datos.getNombreC());
              statement.setString(2, datos.getCorreo());
              statement.setInt(3, datos.getTelefono());
                       
              estadoOperacion = statement.executeUpdate()>0;
              if(estadoOperacion) respuesta = "Se Guardo Correctamente";

              connection.commit();
              statement.close();
              connection.close();
          } catch(SQLException e){
              connection.rollback();
              e.printStackTrace();
          }
          return respuesta;
    }
    
    

    public ArrayList<Cliente> consultarClientes() throws SQLException{
      ArrayList<Cliente> arregloClientes = new ArrayList<Cliente>(); 
  	  connection=obtenerConnection();
        try{
        	Statement s = connection.createStatement();
        	String query = "SELECT folio, nombreC, correo, telefono FROM `usuario`";
        	ResultSet rs = s.executeQuery (query);      	
        	// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
        	while (rs.next())
        	{
        		Cliente cliente = new Cliente();
        		cliente.setFolio(rs.getInt (1));
        		cliente.setNombreC(rs.getString (2));
        		cliente.setCorreo(rs.getString(3));
        		cliente.setTelefono(rs.getInt(4));
        		
        		arregloClientes.add(cliente);
        		
//        	    System.out.println (rs.getInt (1) + " " + rs.getString (2)+ " " + rs.getString(3));
        	}
            connection.close();
        } catch(SQLException e){
            connection.rollback();
            e.printStackTrace();
        }
        return arregloClientes;
    }
    
    public String eliminarCliente(Cliente datos) throws SQLException{
 	   String respuesta = "";
 	   estadoOperacion=false;
 	   String sql ="";
 	  connection=obtenerConnection();
       try{
     	  connection.setAutoCommit(false);
           sql = "DELETE FROM `usuario` WHERE `usuario`.`folio` = ?";
           statement=connection.prepareStatement(sql);

           statement.setInt(1, datos.getFolio());
                    
           estadoOperacion = statement.executeUpdate()>0;
           if(estadoOperacion) respuesta = "Se Elimino Correctamente";

           connection.commit();
           statement.close();
           connection.close();
       } catch(SQLException e){
           connection.rollback();
           e.printStackTrace();
       }
       return respuesta;
 }
    
    //obtener conexion
    private Connection obtenerConnection(){
        return Conexion.geConnection();
    }

}
