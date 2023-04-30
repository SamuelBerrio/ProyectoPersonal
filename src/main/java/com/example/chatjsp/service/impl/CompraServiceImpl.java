package com.example.chatjsp.service.impl;

import com.example.chatjsp.model.Cliente;
import com.example.chatjsp.model.Compra;
import com.example.chatjsp.persistence.Persistence;
import com.example.chatjsp.service.CompraService;
import com.example.chatjsp.servlet.ModelFactoryController;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import static java.sql.Types.NULL;

public class CompraServiceImpl implements CompraService {

    @Override
    public ArrayList<Compra> getCompraArrayList() {
        return null;
    }

    @Override
    public void addCompra(Compra compra) throws SQLException {

    }

    @Override
    public void loadCompraArrayList() throws SQLException {

    }
}
