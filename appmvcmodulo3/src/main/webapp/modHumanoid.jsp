<%-- 
    Document   : viewHumanoid
    Created on : 7 nov 2024, 13:48:56
    Author     : Rosita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Animales Fantásticos</title>
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
                    <h2 class="section-title">Actualizar Humanoide</h2> <!-- cambias actualizar por su función -->
                    <div class="form">
                        <form method="post" action="modcontroller">
                            
                             <input type="hidden" name="tipoEntidad" value="humanoide"> <!-- animal o humanoide segun convenga-->
                             
                            <label for="id" class="form-label">ID Humanoide:</label> <!--en add aqui va el nombre del nuevo animal o humanoide  -->
                            <input type="text" id="id" name="id" class="form-input" required>
                            <br>
                            <br>
                            <label for="Nombre" class="form-label">Nuevo nombre:</label><!--lo borras -->
                            <input type="text" id="nombre" name="nombre" class="form-input" required><!--lo borras -->
                            <br><!--lo borras -->
                            <br><!--lo borras -->
                            
                            <button type="submit" class="submit-btn">Actualiza el humanoide</button> <!-- o humanoide -->
                        </form>
                    </div>
                    <div class="res">
                        <p><strong>Nombre humanoide:</strong> ${nombreHumanoide}</p><!-- o humanoide. Si estas borrando quita este <p> -->
                    </div>
                </div>

                <!-- Columna derecha -->
                <div class="column cont-right">
                    <h2 class="section-title">Lista de Humanoides</h2>
                    <div class="lista">
                        <table>
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nombre</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="humanoide" items="${humanoideList}">
                                <tr>
                                    <td>${humanoide.id}</td>
                                    <td>${humanoide.nombre}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </main>

        <footer>
            <a id="return" href="http://localhost:8080/appmvcmodulo3">Volver</a>
        </footer>
    </body>
</html>

