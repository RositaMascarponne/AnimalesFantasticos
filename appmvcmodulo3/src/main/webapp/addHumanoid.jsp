<%-- 
    Document   : add
    Created on : 6 nov 2024, 12:13:30
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
                    <h2 class="section-title">Añadir Humanoide</h2> 
                    <div class="form">
                        <form method="post" action="addcontroller">
                            <input type="hidden" name="tipoEntidad" value="humanoide"> 
                            <label for="id" class="form-label">Añadir Humanoide:</label>
                            <input type="text" id="nombre" name="nombre" class="form-input" required>
                            <button type="submit" class="submit-btn">Añadir el humanoide</button>
                        </form>
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
