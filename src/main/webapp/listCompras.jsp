<%@ page import="com.example.chatjsp.model.Compra" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Samuel
  Date: 5/03/2023
  Time: 9:35 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Compras</title>
    <style>
        .my-table {
            border-collapse: collapse;
            width: 100%;
        }

        .my-table th, .my-table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        .my-table th {
            background-color: #f2f2f2;
            color: #333;
        }

        .my-table tbody tr:nth-child(even) {
            background-color: #f2f2f2;
            color: #333;
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

        body {
            background-color: #2196F3;
        }
    </style>
</head>
<body>
<div>
    <table class="my-table">
        <thead>
        <tr>
            <th>Name</th>
            <th>UserName</th>
            <th>Product</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Compra> employeeList = (List)request.getSession().getAttribute("compraList");
            int cont=1;
            for (Compra compra : employeeList){

        %>
        <tr>
            <td><%=compra.getCliente().getName()%></td>
            <td><%=compra.getCliente().getUsername()%></td>
            <td><%=compra.getProduct()%></td>
            <td>$<%=String.valueOf(compra.getPrice())%></td>
        </tr>
        <%cont=cont+1;%>
        <%}%>
        </tbody>
    </table>
</div>
<form action="/lista-compras" method="get" style="padding-top: 20px">
    <input type="submit" value="Volver a Registrar Compras">
</form>
</body>
</html>
