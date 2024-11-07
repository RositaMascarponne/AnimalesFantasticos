/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rosita
 */
public class DatabaseConnection {
           // Método para obtener la conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Cargar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establecer la conexión
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/appmvcmodulo3?useSSL=false", // Desactivar SSL
                    "root", 
                    "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    } 
}
