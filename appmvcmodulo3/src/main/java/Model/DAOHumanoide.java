/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Rosita
 */
public class DAOHumanoide { //DAOHumanoide
        //MOSTRAR Humanoide SEGUN ID----------------------------------------------------------------------------
    public String mostrarHumanoide(Humanoide humanoide) throws SQLException {
        String nombre = null;
        String sql = "SELECT humanoide Nombre FROM Humanoide WHERE HumanoideID = ?";
        
        // Intentamos obtener la conexión desde DatabaseConnection
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement st = conn.prepareStatement(sql)) {
            
            st.setInt(1, humanoide.getId());//humanoide.getId() para el señorito Jordi
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("humanoideNombre");//humanoideNombre
            }
        }
        return nombre;
    }
  /*  
    //Mostrar TODO-----------------------------------------------------------------------
    
public List<Personas> mostrarPersonaFull() throws SQLException {
    List<Personas> personasList = new ArrayList<>();
    String sql = "SELECT * FROM persona";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement st = conn.prepareStatement(sql)) {
         
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            String nombre = rs.getString("personaNombre");
            int id = rs.getInt("personaID"); // Asegúrate de obtener el ID también si es necesario
            personasList.add(new Personas(id, nombre)); // Debes tener un constructor que acepte ID y nombre
        }
    }
    return personasList;
}

        
        //ADD------------------------------------------------------------------
    public Personas crearPersona(String nombre) throws SQLException {
        String sql = "INSERT INTO persona(personaNombre) VALUES (?)";
        
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement st = conn.prepareStatement(sql)) {
            
            st.setString(1, nombre);
            st.executeUpdate();
        }
        // Retorna una nueva instancia de Personas con el nombre creado
        return new Personas(nombre);
    }
        
        //DELETE------------------------------------------------------------------
        public int borrarPersona(int id) throws SQLException {
       // String tipo = null;
        String sql = "DELETE FROM persona WHERE personaID = ?";
        
        // Intentamos obtener la conexión desde DatabaseConnection
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement st = conn.prepareStatement(sql)) {
            
            st.setInt(1, id);
            
            st.executeUpdate();

        }
        return id;
    } 
        
         //ACTUALIZAR------------------------------------------------------------------
public void actualizarPersona(int id, String nuevoNombre) throws SQLException {
    String sqlUpdate = "UPDATE persona SET personaNombre = ? WHERE personaID = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement st = conn.prepareStatement(sqlUpdate)) {
        
        st.setString(1, nuevoNombre); // Asigna el nuevo nombre
        st.setInt(2, id);             // Asigna el ID de la persona

        int rowsUpdated = st.executeUpdate(); // Ejecuta la actualización

        if (rowsUpdated > 0) {
            System.out.println("Persona actualizada con éxito.");
        } else {
            System.out.println("No se encontró ninguna persona con el ID especificado.");
        }
    }
}*/
}
