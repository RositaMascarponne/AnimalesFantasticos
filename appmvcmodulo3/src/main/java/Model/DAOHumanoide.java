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
    //MOSTRAR HUMANOIDE SEGUN ID----------------------------------------------------------------------------

    public String mostrarHumanoide(Humanoide humanoide) throws SQLException {
        String nombre = null;
        String sql = "SELECT humanoidenombre FROM humanoide WHERE humanoideid = ?";

        // Intentamos obtener la conexión desde DatabaseConnection
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

            st.setInt(1, humanoide.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("humanoidenombre");
            }
        }
        return nombre;
    }

    //Mostrar TODO-----------------------------------------------------------------------
    public List<Humanoide> mostrarHumanoideFull() throws SQLException {

        List<Humanoide> humanoideList = new ArrayList<>();
        String sql = "SELECT * FROM humanoide";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("humanoidenombre");
                int id = rs.getInt("humanoideid"); 
                humanoideList.add(new Humanoide(id, nombre)); 
            }
        }
        return humanoideList;
    }

    //ADD------------------------------------------------------------------
    public Humanoide crearHumanoide(Humanoide humanoide) throws SQLException {
        String sql = "INSERT INTO humanoide(humanoidenombre) VALUES (?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement st = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Establecer el nombre del humanoide que se recibe como parámetro
            st.setString(1, humanoide.getNombre());

            // Ejecutar la inserción
            int rowsAffected = st.executeUpdate();

            // Si se insertaron filas, obtener el ID generado
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        // Obtener el ID generado y asignarlo al humanoide
                        int idGenerado = generatedKeys.getInt(1); // Primer columna, el ID
                        humanoide.setId(idGenerado); // Asignar el ID al objeto humanoide
                    }
                }
            }
        }

        // Retornar el objeto humanoide con el ID asignado
        return humanoide;
    }

    //DELETE-------------------------------------¿Qué voy a devolver si lo he borrao?
    public void borrarHumanoide(Humanoide humanoide) throws SQLException {

        String sql = "DELETE FROM humanoide WHERE humanoideid = ?";

        // Intentamos obtener la conexión desde DatabaseConnection
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

            st.setInt(1, humanoide.getId());

            st.executeUpdate();

        }

    }

    //ACTUALIZAR------------------------------------------------------------------
    public void actualizarHumanoide(Humanoide humanoide) throws SQLException {
        String sqlUpdate = "UPDATE humanoide SET humanoidenombre= ? WHERE humanoideid = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement st = conn.prepareStatement(sqlUpdate)) {

            st.setString(1, humanoide.getNombre()); // Asigna el nuevo nombre
            st.setInt(2, humanoide.getId());             // Asigna el ID de la persona

            int rowsUpdated = st.executeUpdate(); // Ejecuta la actualización

            if (rowsUpdated > 0) {
                System.out.println("Humanoide actualizado con éxito.");
            } else {
                System.out.println("No se encontró ningun humanoide con el ID especificado.");
            }
        }
    }
}
