<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Compras</title>
    <style>
        body {
            background-color: #2196F3;
        }

        form {
            background-color: #ffffff;
            width: 500px;
            margin: 50px auto;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #555;
            font-size: 18px;
        }

        input[type="text"],
        input[type="password"],
        input[type="number"] {
            display: block;
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            margin-bottom: 20px;
            font-size: 16px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #3e8e41;
        }
        button{
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #3e8e41;
        }
        .error-list {
            color: red;
            font-weight: bold;
            font-size: 1.2em;
        }

        .error-list li {
            padding: 5px;
            margin: 5px 0;
        }
    </style>
</head>
<body>
<div>
<form action="/register-clientes" method="post">
    <label for="name">Nombre:</label>
    <input type="text" id="name" name="name" required>

    <label for="lastname">Apellido:</label>
    <input type="text" id="lastname" name="lastname" required>

    <label for="username">Nombre de usuario:</label>
    <input type="text" id="username" name="username" required>

    <label for="password">Contraseña:</label>
    <input type="password" id="password" name="password" required>

    <label for="product">Producto:</label>
    <input type="text" id="product" name="product" required>

    <label for="price">Precio:</label>
    <input type="number" id="price" name="price" required>

    <input type="submit" value="Enviar">
</form>
</div>
<div>
<form action="${pageContext.request.contextPath}/register-clientes" method="get">
    <label>Dirigirse a la Lista de Compras</label>
    <input type="submit" value="Lista de Compras">
</form>
    <form action="${pageContext.request.contextPath}/edit.jsp">
        <label>Editar Base de Datos</label>
        <input type="submit" value="Ir a editar">
    </form>
</div>
<a href="listCompras.jsp">Dirigirse a la Lista de Compras</a>
</body>
</html>