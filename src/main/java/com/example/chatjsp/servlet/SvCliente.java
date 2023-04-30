package com.example.chatjsp.servlet;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.chatjsp.model.Cliente;
import com.example.chatjsp.model.Compra;
import com.example.chatjsp.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SvCliente", urlPatterns = "/register-clientes")
public class SvCliente extends HttpServlet{
    ModelFactoryController mfc = ModelFactoryController.getInstance();

    Persistence persistence = new Persistence();
    private List<Compra> compraList = new ArrayList<>();

    public List<Compra> getCompraList() {
        return compraList;
    }

    public void init() {
        System.out.println("inicie");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            mfc.initializeCompraList();
            HttpSession session = request.getSession();
            session.setAttribute("compraList", mfc.getCompras());
            response.sendRedirect("listCompras.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name = req.getParameter("name");
            String lastName = req.getParameter("lastname");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String product = req.getParameter("product");
            Double price = Double.parseDouble(req.getParameter("price"));

            Map<String,String> errores = mfc.formValidation(name,lastName,username,password,product,price);
            try {
                if (errores.isEmpty() || errores == null){
                    Compra compra = new Compra(product,price,
                            new Cliente(name,lastName,username,password));

                    mfc.addCompra(compra);


                    System.out.println("name: " + name);
                    System.out.println("lastname: " + lastName);
                    System.out.println("username: " + username);
                    System.out.println("password " + password);
                    System.out.println("product " + product);
                    System.out.println("price " + price);

                    HttpSession session = req.getSession();
                    session.setAttribute("compraList",mfc.getCompras());
                    resp.sendRedirect("index.jsp");
                }else {
                    req.setAttribute("errores",errores);
                    getServletContext().getRequestDispatcher("index.jsp").forward(req,resp);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
    }
}
