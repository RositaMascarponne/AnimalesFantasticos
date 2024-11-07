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
public class DAOAnimal { //DAOHumanoide
    //MOSTRAR ANIMAL SEGUN ID----------------------------------------------------------------------------

    public String mostrarAnimal(Animal animal) throws SQLException {//mostrarHumanoide (Humanoide humanoide)
        String nombre = null;
        String sql = "SELECT animalnombre FROM animales WHERE animalid = ?";//Cambia animal por Humanoide

        // Intentamos obtener la conexión desde DatabaseConnection
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

            st.setInt(1, animal.getId());//humanoide.getId() para el señorito Jordi
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("animalnombre");//humanoideNombre
            }
        }
        return nombre;
    }

    //Mostrar TODO-----------------------------------------------------------------------
    public List<Animal> mostrarAnimalFull() throws SQLException {

        List<Animal> animalList = new ArrayList<>();
        String sql = "SELECT * FROM animales";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("animalnombre");
                int id = rs.getInt("animalid"); 
                animalList.add(new Animal(id, nombre)); 
            }
        }
        return animalList;
    }

    //ADD------------------------------------------------------------------
    public Animal crearAnimal(Animal animal) throws SQLException {
        String sql = "INSERT INTO animales(animalnombre) VALUES (?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement st = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Establecer el nombre del animal que se recibe como parámetro
            st.setString(1, animal.getNombre());

            // Ejecutar la inserción
            int rowsAffected = st.executeUpdate();

            // Si se insertaron filas, obtener el ID generado
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        // Obtener el ID generado y asignarlo al animal
                        int idGenerado = generatedKeys.getInt(1); // Primer columna, el ID
                        animal.setId(idGenerado); // Asignar el ID al objeto animal
                    }
                }
            }
        }

        // Retornar el objeto animal con el ID asignado
        return animal;
    }

    //DELETE-------------------------------------¿Qué voy a devolver si lo he borrao?
    public void borrarAnimal(Animal animal) throws SQLException {

        String sql = "DELETE FROM animales WHERE animalid = ?";

        // Intentamos obtener la conexión desde DatabaseConnection
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

            st.setInt(1, animal.getId());

            st.executeUpdate();

        }

    }

    //ACTUALIZAR------------------------------------------------------------------
    public void actualizarAnimal(Animal animal) throws SQLException {
        String sqlUpdate = "UPDATE animales SET animalnombre= ? WHERE animalid = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement st = conn.prepareStatement(sqlUpdate)) {

            st.setString(1, animal.getNombre()); // Asigna el nuevo nombre
            st.setInt(2, animal.getId());             // Asigna el ID de la persona

            int rowsUpdated = st.executeUpdate(); // Ejecuta la actualización

            if (rowsUpdated > 0) {
                System.out.println("Animal actualizado con éxito.");
            } else {
                System.out.println("No se encontró ningun animal con el ID especificado.");
            }
        }
    }
}
