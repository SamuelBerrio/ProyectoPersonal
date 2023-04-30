package com.example.chatjsp.service.impl;

import com.example.chatjsp.model.Compra;
import com.example.chatjsp.repository.ProductoRepositoryImpl;
import com.example.chatjsp.repository.Repository;
import com.example.chatjsp.service.CompraService;
import com.example.chatjsp.service.FormValidation;

public class Negocio {
    private final CompraService compraService;

    private final FormValidation formValidation;

    private final Repository<Compra> repository;

    public Negocio(){
        compraService = new CompraServiceImpl();
        formValidation = new FormValidationImpl();
        repository = new ProductoRepositoryImpl();
    }

    public CompraService getCompraService() {
        return compraService;
    }

    public FormValidation getFormValidation() {
        return formValidation;
    }

    public Repository<Compra> getRepository(){return repository;}
}
