package biblioteca_mvc;

import java.sql.*;

public class Conexion {

    Connection conectar;
    String bd = "bd_bibliotecas";
    String url = "jdbc:mysql://localhost/" + bd;
    String user = "root";
    String pass = "";

    public Connection Conectar() {
        try {
            
             Class.forName("com.mysql.jdbc.Driver");
             conectar =DriverManager.getConnection(url,user,pass);
             System.out.println("Se conecto");
             
         } catch (ClassNotFoundException |SQLException ex) {
            System.out.println(" no se conecto");  
         } 
        return conectar;
    }
 public void desconectar(){
     
     
     try {
         conectar.close();
         System.out.println("Se desconecto");
     } catch (SQLException ex) {
         System.out.println("no se pudo cerrar conexion");
     }
     
 }

}
