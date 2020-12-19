package com.javarevolutions.ws.rest.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url = "jdbc:mysql://127.0.0.1:3306/lavamattilavanderia?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
    private static String driverName = "com.mysql.jdbc.Driver";

    private static String user = "root";
    private static String password = "";
    private static Connection connection = null;
    
  

    public static void main( String[] args )   {
    	System.out.println("Hola mundo");
    	geConnection();
    	
    	
    }
    
    public static Connection geConnection(){
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Success connection!");

        } catch (SQLException e) {
            System.out.println("Falled to create the database connection!");
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Driver not found!");
        }
        return connection;
    }

}
