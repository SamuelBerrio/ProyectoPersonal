package com.example.chatjsp.servlet;

import com.example.chatjsp.model.Compra;
import com.example.chatjsp.repository.Repository;
import com.example.chatjsp.service.impl.Negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class ModelFactoryController {

    Negocio negocio;
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    public ModelFactoryController() {
        System.out.println("invocación clase singleton");
        negocio = new Negocio();
    }

    //ArrayCompra

    public void addCompra(Compra compra) throws SQLException, ClassNotFoundException {
        negocio.getRepository().guardar(compra);
    }

    public Compra buscarPorID(int id) throws SQLException, ClassNotFoundException {
        return negocio.getRepository().porId(id);
    }

    public void eliminarPorID(int id) throws SQLException, ClassNotFoundException {
        negocio.getRepository().eliminar(id);
    }

    public ArrayList<Compra> getCompras(){
        return (ArrayList<Compra>) negocio.getRepository().getCompraArrayList();
    }

    public void initializeCompraList() throws SQLException, ClassNotFoundException {
        negocio.getRepository().loadCompraArray();
    }

    public Map<String,String> formValidation(String name , String lastName,String username,String password,String product,Double price){
        return negocio.getFormValidation().formValidation(name,lastName,username,password,product,price);
    }
}
