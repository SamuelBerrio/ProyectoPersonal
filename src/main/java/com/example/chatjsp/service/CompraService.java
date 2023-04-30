package com.example.chatjsp.service;

import com.example.chatjsp.model.Compra;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CompraService {
    ArrayList<Compra> getCompraArrayList();
    void addCompra(Compra compra) throws SQLException;
    void loadCompraArrayList() throws SQLException;
}
