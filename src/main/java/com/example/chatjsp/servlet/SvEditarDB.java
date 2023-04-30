package com.example.chatjsp.servlet;

import com.example.chatjsp.model.Compra;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "SvEditarDB", urlPatterns = "/editar-db")
public class SvEditarDB extends HttpServlet {

    ModelFactoryController mfc = ModelFactoryController.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String accion = req.getParameter("operation");

        if (accion.equals("buscar")) {
            try {
                if (mfc.buscarPorID(id) != null){
                    System.out.println(mfc.buscarPorID(id).getCliente());
                    resp.setContentType("text/html");
                    try(PrintWriter out = resp.getWriter()){
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Resultado</title>");
                        out.println("<style>");
                        out.println(".rectangulo {\n" +
                                "  background-color: #f7f7f7;\n" +
                                "  color: #333;\n" +
                                "  width: 80%;\n" +
                                "  max-width: 600px;\n" +
                                "  margin: 50px auto;\n" +
                                "  border: 1px solid #ddd;\n" +
                                "  padding: 20px;\n" +
                                "  font-size: 18px;\n" +
                                "  font-family: Arial, sans-serif;\n" +
                                "  text-align: center;\n" +
                                "}");
                        out.println("</style>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<div class=\"rectangulo\">");
                        out.println("  Se encontró la venta según el ID de el Producto "
                                + mfc.buscarPorID(id).getProduct() + " de el Cliente " + mfc.buscarPorID(id).getCliente().getUsername());
                        out.println("</div>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }else {
                    System.out.println("No se encontro la venta con esta ID");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (accion.equals("eliminar")) {
            try {
                if (mfc.buscarPorID(id) != null){
                    Compra compra = mfc.buscarPorID(id);
                    System.out.println(compra.getCliente());
                    mfc.eliminarPorID(id);
                    resp.setContentType("text/html");
                    try(PrintWriter out = resp.getWriter()){
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Resultado</title>");
                        out.println("<style>");
                        out.println(".rectangulo {\n" +
                                "  background-color: #f7f7f7;\n" +
                                "  color: #333;\n" +
                                "  width: 80%;\n" +
                                "  max-width: 600px;\n" +
                                "  margin: 50px auto;\n" +
                                "  border: 1px solid #ddd;\n" +
                                "  padding: 20px;\n" +
                                "  font-size: 18px;\n" +
                                "  font-family: Arial, sans-serif;\n" +
                                "  text-align: center;\n" +
                                "}");
                        out.println("</style>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<div class=\"rectangulo\">");
                        out.println("  Se encontró y se elimino la venta según el ID de el Producto "
                                + compra.getProduct() + " de el Cliente " + compra.getCliente().getUsername());
                        out.println("</div>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }else {
                    System.out.println("No se pudo eliminar dado que no se encontro la venta con esta ID");
                }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
