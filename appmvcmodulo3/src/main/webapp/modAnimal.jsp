<%-- 
    Document   : mod
    Created on : 6 nov 2024, 12:13:57
    Author     : Rosita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="icon" href="" type="image/png">
        <link rel="stylesheet" href="css/viewcss.css">
    </head>
 <body>
        <header>
            
            <h1>Animales <span class="app">Fantásticos</span></h1>
            
        </header>
        <main>
            <div class="container">
                <!-- Columna izquierda -->
                <div class="column cont-left">
                    <h2 class="section-title">Actualizar Animales</h2> <!-- cambias actualizar por su función -->
                    <div class="form">
                        <form method="post" action="modcontroller">
                            
                             <input type="hidden" name="tipoEntidad" value="animal"> <!-- animal o humanoide segun convenga-->
                             
                            <label for="id" class="form-label">ID Animal:</label> <!--en add aqui va el nombre del nuevo animal o humanoide  -->
                            <input type="text" id="id" name="id" class="form-input" required>
                            <br>
                            <br>
                            <label for="Nombre" class="form-label">Nuevo nombre:</label><!--lo borras -->
                            <input type="text" id="nombre" name="nombre" class="form-input" required><!--lo borras -->
                            <br><!--lo borras -->
                            <br><!--lo borras -->
                            
                            <button type="submit" class="submit-btn">Actualiza el animal</button> <!-- o humanoide -->
                        </form>
                    </div>
                    <div class="res">
                        <p><strong>Nombre animal:</strong> ${nombreAnimal}</p><!-- o humanoide. Si estas borrando quita este <p> -->
                    </div>
                </div>
                
                <!-- Columna derecha -->
                <div class="column cont-right"><!-- No tocar la lista, para humanoide, copia pega de viewHumanoid -->
                    <h2 class="section-title">Lista de Animales</h2> 
                    <div class="lista">
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="animal" items="${animalList}">
                                <tr>
                                    <td>${animal.id}</td>
                                    <td>${animal.nombre}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    </div>
                </div>
            </div> <!-- Hasta aqui -->
        </main>
        <footer>
                <a  id='return' href='http://localhost:8080/appmvcmodulo3'>Volver</a>
         </footer>   
       

    </body>
</html>
