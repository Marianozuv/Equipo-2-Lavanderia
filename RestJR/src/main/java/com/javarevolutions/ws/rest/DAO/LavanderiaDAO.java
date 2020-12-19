package com.javarevolutions.ws.rest.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class LavanderiaDAO {
	
	private Connection connection;
    private PreparedStatement statement;
    private boolean estadoOperacion;

    public boolean guardar(Pedido pedido) throws SQLException{
        String sql =null;
        estadoOperacion=false;
        connection=obtenerConnection();

        try{
            connection.setAutoCommit(false);
            sql = "INSERT INTO pedido (idPedido, total_Kilo, total_Prenda, tipo_Ropa, tipo_Servicio, fechaP) VALUES(?,?,?,?,?,?)";
            statement=connection.prepareStatement(sql);

            statement.setString(1, null);
            statement.setFloat(2, pedido.getTotal_Kilo());
            statement.setInt(3, pedido.getTotal_Prenda());
            statement.setString(4, pedido.getTipo_Ropa());
            statement.setString(5, pedido.getTipo_Servicio());
            statement.setDate(6, (Date) pedido.getFechaP());
            
           
            estadoOperacion = statement.executeUpdate()>0;

            connection.commit();
            statement.close();
            connection.close();
        } catch(SQLException e){
            connection.rollback();
            e.printStackTrace();
        }
        return estadoOperacion;
    }

    public boolean editar(Pedido pedido){
        return true;
    }

    public boolean eliminar(int idPedido){
        return true;
    }

    //obtener todos los pedidos
    public List<Pedido> obtener(){
        return null;
    }

    //obtener un pedido
    public Pedido obtener(int idPedido){
        return null;
    }

    //obtener conexion
    private Connection obtenerConnection(){
        return Conexion.geConnection();
    }

}
