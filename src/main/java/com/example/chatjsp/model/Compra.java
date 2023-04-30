package com.example.chatjsp.model;

public class Compra {
    private String product;

    private Double price;

    private Cliente cliente;

    public Compra(String product, Double price, Cliente cliente) {
        this.product = product;
        this.price = price;
        this.cliente = cliente;
    }

    public Compra() {

    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
