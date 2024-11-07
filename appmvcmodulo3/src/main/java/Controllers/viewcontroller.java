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
     
     //DO GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Si quieres redirigir a alguna página al hacer una solicitud GET, puedes hacerlo aquí
        request.getRequestDispatcher("viewAnimal.jsp").forward(request, response); //cambiar a add.jsp, del.jsp o mod.jsp segun convenga
    }
    
    
    //DO POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 1. Obtener el ID del animal desde el formulario
        String idStr = request.getParameter("id"); //esto recoge la id del formulario. Ojo! Es String!
        int id = Integer.parseInt(idStr);  // Convertimos a int el ID que ingresa el usuario. Problema arregaldo
    
        // 2. Crear un objeto Animal con el ID ingresado. O humanoide
        Animal animal = new Animal();
        animal.setId(id);//Supongo que en delete tambien hay que ponerlo

        String nombre = null;
        
        try {
            // 3. Llamamos al método del DAO para obtener el nombre según el ID
            nombre = daoAnimal.mostrarAnimal(animal);//LLamar funcion aqui eh? Ya sabes, quieres añadir, borrar y esas cositas del CRUD
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 4. Pasamos el nombre obtenido como atributo al JSP para mostrarlo
        request.setAttribute("nombreAnimal", nombre);
        
        // 5. Redireccionamos al JSP donde se mostrará el resultado
        request.getRequestDispatcher("viewAnimal.jsp").forward(request, response); //No te me olvides de apuntar al jsp correcto
    }



}
