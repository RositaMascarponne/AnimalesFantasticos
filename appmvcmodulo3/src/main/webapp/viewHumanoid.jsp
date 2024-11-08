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
                    <h2 class="section-title">Mostrar Humanoides</h2>
                    <div class="form">
                        
                        <form method="post" action="viewcontroller">
                            <label for="id" class="form-label">ID Humanoide:</label>
                            <input type="hidden" name="tipoEntidad" value="humanoide">
                            <input type="text" id="id" name="id" class="form-input" required>
                            <button type="submit" class="submit-btn">Busca el humanoide</button>
                        </form>
                        
                    </div>
                    <div class="res">
                        <p><strong>Nombre:</strong> ${nombreHumanoide}</p>
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
            </div> <!-- Hasta aqui -->
            <!-- Botón "Volver" centrado debajo de las columnas -->
            <div class="button-container">
                <a id="return" href="http://localhost:8080/appmvcmodulo3">Volver</a>
            </div> 

        </main>

        <footer>
            <div class="footer-content">
                <p>&copy; 2024 Rozzita Mascarpone & Jordi el Chupacabra. Todos los derechos reservados y todos los zurdos muy habladores.</p>
                <div class="footer-links">
                    <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ" target="_blank">Aviso Legal</a>
                    <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ" target="_blank">Contacto</a>
                    <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ" target="_blank">Política de Privacidad</a>
                    <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ" target="_blank">Política de Cookies</a>
                </div>
            </div>
        </footer>
    </body>
</html>


