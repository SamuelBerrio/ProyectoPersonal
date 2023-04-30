package com.example.chatjsp.repository;

import com.example.chatjsp.basedatos.Conexion;
import com.example.chatjsp.model.Cliente;
import com.example.chatjsp.model.Compra;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.NULL;

public class ProductoRepositoryImpl implements Repository<Compra> {

    List<Compra> compras = new ArrayList<>();
    private Connection conn;

    public void ProductoRepositoryJdbcImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void loadCompraArray() throws SQLException, ClassNotFoundException {
        this.compras = listar();
    }
    @Override
    public List<Compra> listar() throws SQLException, ClassNotFoundException {
        List<Compra> compras = new ArrayList<>();
        conn = Conexion.getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM compras")) {
            while (rs.next()) {
                compras.add(new Compra(rs.getString("product"),Double.parseDouble(rs.getString("price")),
                        new Cliente(rs.getString("name"),rs.getString("lastname"),rs.getString("username"),
                                rs.getString("password"))));
            }
            return compras;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Compra porId(int id) throws SQLException, ClassNotFoundException {
        conn = Conexion.getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM compras")) {
            Compra compra = null;
            while (rs.next()) {
                if (id == rs.getInt("id")){
                    compra = new Compra(rs.getString("product"), Double.parseDouble(rs.getString("price")),
                            new Cliente(rs.getString("name"), rs.getString("lastname"), rs.getString("username"),
                                    rs.getString("password")));
                }
            }
            return compra;
            }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guardar(Compra compra) throws SQLException, ClassNotFoundException {
        conn = Conexion.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO compras VALUES (?,?,?,?,?,?,?)");) {
            stmt.setInt(1, NULL);
            stmt.setString(2, compra.getCliente().getName());
            stmt.setString(3, compra.getCliente().getLastname());
            stmt.setString(4, compra.getCliente().getUsername());
            stmt.setString(5, compra.getCliente().getPassword());
            stmt.setString(6, compra.getProduct());
            stmt.setString(7, String.valueOf(compra.getPrice()));
            stmt.executeUpdate();
            System.out.println("Conexion realizada con exito");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(int id) throws SQLException, ClassNotFoundException {
        conn = Conexion.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM compras WHERE id ="+ id);) {
            stmt.executeUpdate();
            System.out.println("Eliminado con exito");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Compra> getCompraArrayList(){
        return compras;
    }
}