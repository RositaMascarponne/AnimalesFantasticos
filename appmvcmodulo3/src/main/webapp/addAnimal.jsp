<%-- 
    Document   : add
    Created on : 6 nov 2024, 12:13:30
    Author     : Rosita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <h2 class="section-title">Añadir Animales</h2> <!-- cambias actualizar por su función -->
                    <div class="form">
                        <form method="post" action="modcontroller">

                            <input type="hidden" name="tipoEntidad" value="animal"> <!-- animal o humanoide segun convenga-->

                            <label for="id" class="form-label">Añadir Animal:</label> <!--en add aqui va el nombre del nuevo animal o humanoide  -->
                            <input type="text" id="nombre" name="nombre" class="form-input" required>
                            <button type="submit" class="submit-btn">Añadir el animal</button> <!-- o humanoide -->
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
            </div>
            <div>
            <a  id='return' href='http://localhost:8080/appmvcmodulo3'>Volver</a>
        </div> <!-- Hasta aqui -->
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
