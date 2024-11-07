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
                    <h2 class="section-title">Mostrar Animales</h2>
                    <div class="form">
                        <form method="post" action="viewcontroller">
                            <label for="id" class="form-label">ID Animal:</label>
                            <input type="text" id="id" name="id" class="form-input" required>
                            <button type="submit" class="submit-btn">Busca el animal</button>
                        </form>
                    </div>
                    <div class="res">
                        <p><strong>Nombre:</strong> ${nombreAnimal}</p>
                    </div>
                </div>
                
                <!-- Columna derecha -->
                <div class="column cont-right">
                    <h2 class="section-title">Lista de Animales</h2>
                    <div class="lista">
                        <p>Aquí se mostrará la lista de animales.</p>
                    </div>
                </div>
            </div>
        </main>
        
        <footer>
            <a id="return" href="http://localhost:8080/appmvcmodulo3">Volver</a>
        </footer>
    </body>
</html>
