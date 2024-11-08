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
import java.util.List;

/**
 *
 * @author Rosita
 */
@WebServlet(name = "modcontroller", urlPatterns = {"/modcontroller"})
public class modcontroller extends HttpServlet {

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
    
    // DO GET: Redirige a la vista correspondiente según la entidad especificada y muestra la lista completa
    
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String tipoEntidad = request.getParameter("tipoEntidad");

    try {//INICIO DE LAS LISTAS, SE COPIA Y PEGA PERO NO SE TOCA-----V-V-V------------------
        
    //ANIMAL---------------------------------------------------------------------------------------------------------------------------------------------
        if ("animal".equals(tipoEntidad)) {
            // Obtener la lista completa de animales. 
            List<Animal> animalList = daoAnimal.mostrarAnimalFull();//LISTA, no toques esto
            request.setAttribute("animalList", animalList);  // Atributo para la lista completa
            request.getRequestDispatcher("modAnimal.jsp").forward(request, response);//<<<<-------------------REQUESTDISPATCHER!!!
            
     //HUMANOIDE---------------------------------------------------------------------------------------------------------------------------------------------
        } else if ("humanoide".equals(tipoEntidad)) {
            
            List<Humanoide> humanoideList = daoHumanoide.mostrarHumanoideFull();
            request.setAttribute("humanoideList", humanoideList);  // Atributo para la lista completa
            request.getRequestDispatcher("modHumanoid.jsp").forward(request, response);//<<<<-------------------REQUESTDISPATCHER!!!
            
            
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tipo de entidad no especificado.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error de base de datos al intentar obtener la información.");
    }
}  // FIN DE LAS LISTAS, SE COPIA Y PEGA PERO NO SE TOCA-----^-^-^------------------
    
    

    //DO POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. Obtener el ID del animal desde el formulario (para los servelts del, view y mod)
        // Para el servlet de add necesitamos el nombre
        
        String idStr = request.getParameter("id"); //esto recoge la id del formulario. Ojo! Es String!
        int id = Integer.parseInt(idStr);  // Convertimos a int el ID que ingresa el usuario. Problema arregaldo. Borrar esta linea en add
        
        
        

        String tipoEntidad = request.getParameter("tipoEntidad");  // Puede ser animal o humanoide. No tocar en ningun servlet, es general esto

        // 2. Crear un objeto Animal o Humanoide con el ID ingresado. 
    try {
        
 //ANIMAL---------------------------------------------------------------------------------------------------------------------------------------------
        if ("animal".equals(tipoEntidad)) {
            // Crear y configurar el objeto Animal para actualizar.
            String nombreAnimal=request.getParameter("nombre");
            Animal animal = new Animal();
            animal.setId(id);
            animal.setNombre(nombreAnimal);  // Asigna el nuevo nombre ingresado

            // Llama al método de actualización en el DAO.
            daoAnimal.actualizarAnimal(animal);

            // Obtener la lista completa de animales. No tocar, esto es fijo en todos los servlets
            List<Animal> animalList = daoAnimal.mostrarAnimalFull();
            request.setAttribute("animalList", animalList);  // Pasamos la lista completa al JSP

            request.getRequestDispatcher("modAnimal.jsp").forward(request, response);//<<<<-------------------REQUESTDISPATCHER!!!
            
//HUMANOIDE---------------------------------------------------------------------------------------------------------------------------------------------
        } else if ("humanoide".equals(tipoEntidad)) {
            String nombreHumanoide=request.getParameter("nombre");
            Humanoide humanoide = new Humanoide();
            humanoide.setId(id);

            humanoide.setNombre(nombreHumanoide);  // Asigna el nuevo nombre ingresado

            // Llama al método de actualización en el DAO.
            daoHumanoide.actualizarHumanoide(humanoide);
            
            
            // Obtener la lista completa de humanoides 
            List<Humanoide> humanoideList = daoHumanoide.mostrarHumanoideFull();
            request.setAttribute("humanoideList", humanoideList);  // Pasamos la lista completa al JSP

            request.getRequestDispatcher("modHumanoid.jsp").forward(request, response);//<<<<-------------------REQUESTDISPATCHER!!!
//-----------------------------------------------------------------------------------------------------------------------------------------
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
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
