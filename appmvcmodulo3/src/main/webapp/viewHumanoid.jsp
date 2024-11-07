<%-- 
    Document   : viewHumanoid
    Created on : 7 nov 2024, 13:48:56
    Author     : Rosita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <p>Aquí se mostrará la lista de humanoides.</p>
                    </div>
                </div>
            </div>
        </main>
        
        <footer>
            <a id="return" href="http://localhost:8080/appmvcmodulo3">Volver</a>
        </footer>
    </body>
</html>

