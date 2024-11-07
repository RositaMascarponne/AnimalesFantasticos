/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Model.DAOAnimal;
import Model.Animal;
import Model.Humanoide;
import Model.DAOHumanoide;

import java.io.IOException;
import java.sql.SQLException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Rosita
 */
@WebServlet(name = "viewcontroller", urlPatterns = {"/viewcontroller"})
public class viewcontroller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private DAOAnimal daoAnimal = new DAOAnimal(); // Instanciamos el DAO para poder usarlo. No tocar esto
    private DAOHumanoide daoHumanoide = new DAOHumanoide();
    
    
    

    // DO GET: Redirige a la vista correspondiente según la entidad especificada
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipoEntidad = request.getParameter("tipoEntidad");

        if ("animal".equals(tipoEntidad)) {
            request.getRequestDispatcher("viewAnimal.jsp").forward(request, response);
        } else if ("humanoide".equals(tipoEntidad)) {
            request.getRequestDispatcher("viewHumanoid.jsp").forward(request, response);
        } else {
            // Si no se especifica, redirigir a una página de error o a una página por defecto
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tipo de entidad no especificado.");
        }
    }

    //DO POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. Obtener el ID del animal desde el formulario
        String idStr = request.getParameter("id"); //esto recoge la id del formulario. Ojo! Es String!
        int id = Integer.parseInt(idStr);  // Convertimos a int el ID que ingresa el usuario. Problema arregaldo

        String tipoEntidad = request.getParameter("tipoEntidad");  // Puede ser animal o humanoide

        // 2. Crear un objeto Animal o Humanoide con el ID ingresado. 
        try {
            if ("animal".equals(tipoEntidad)) {
                Animal animal = new Animal();
                animal.setId(id);

                // Lógica para obtener el nombre del animal
                String nombreAnimal = daoAnimal.mostrarAnimal(animal);
                request.setAttribute("nombreAnimal", nombreAnimal);
                request.getRequestDispatcher("viewAnimal.jsp").forward(request, response);

            } else if ("humanoide".equals(tipoEntidad)) {
                Humanoide humanoide = new Humanoide();
                humanoide.setId(id);

                // Lógica para obtener el nombre del humanoide
                String nombreHumanoide = daoHumanoide.mostrarHumanoide(humanoide);
                request.setAttribute("nombreHumanoide", nombreHumanoide);
                request.getRequestDispatcher("viewHumanoid.jsp").forward(request, response);

            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tipo de entidad no especificado o inválido. Yo me cago en tus muelas estúpido programa de las narices");
            }

        } catch (SQLException e) {
            // Manejo de excepciones SQL
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error de base de datos al intentar obtener la información.");
        } catch (NumberFormatException e) {
            // Manejo de errores de conversión de ID
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato de ID inválido.");
        }
    }

}
