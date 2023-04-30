<%--
  Created by IntelliJ IDEA.
  User: Samuel
  Date: 25/04/2023
  Time: 12:39 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Editar Base de Datos</title>
    <style>
        header {
            background-color: #3b5998;
            color: white;
            padding: 10px;
            text-align: center;
        }
        .form-container {
            width: 50%;
            margin: 50px auto;
            background-color: #f2f2f2;
            padding: 20px;
        }
        input[type=text] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 2px solid #ccc;
            border-radius: 4px;
        }
        select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 2px solid #ccc;
            border-radius: 4px;
            background-color: white;
        }
        input[type=submit] {
            background-color: #3b5998;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            float: right;
        }
        input[type=submit]:hover {
            background-color: #2a4a77;
        }
    </style>
</head>
<body>
<header>
    <h1>Editar Base de Datos</h1>
</header>
<div class="form-container">
    <form action="${pageContext.request.contextPath}/editar-db" method="get">
        <label for="id">Ingresa la ID:</label>
        <input type="text" id="id" name="id" placeholder="Ingresar ID">
        <br>
        <label for="operation">Elige la Accion:</label>
        <select id="operation" name="operation">
            <option value="buscar">Buscar</option>
            <option value="eliminar">Eliminar</option>
        </select>
        <br>
        <input type="submit" value="Aceptar">
    </form>
</div>
</body>
</html>


