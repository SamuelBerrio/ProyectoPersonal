package com.example.chatjsp.repository;

import com.example.chatjsp.model.Compra;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    void loadCompraArray() throws SQLException, ClassNotFoundException;
    List<T> listar() throws SQLException, ClassNotFoundException;
    T porId(int id) throws SQLException, ClassNotFoundException;
    void guardar(T t) throws SQLException, ClassNotFoundException;
    void eliminar(int id) throws SQLException, ClassNotFoundException;

    List<Compra> getCompraArrayList();
}
