package com.example.chatjsp.service.impl;

import com.example.chatjsp.service.FormValidation;

import java.util.HashMap;
import java.util.Map;

public class FormValidationImpl implements FormValidation {
    @Override
    public Map<String, String> formValidation(String name, String lastName, String username, String password, String product, Double price) {
        Map<String,String> errores = new HashMap<>();
        if (name == null || name.isBlank()){
            errores.put("name","Porfavor ingresar el nombre para continuar el registro");
        }
        if (lastName == null || lastName.isBlank()){
            errores.put("lastname","Porfavor ingresar el apellido para continuar el registro");
        }
        if (username == null || username.isBlank()){
            errores.put("username","Porfavor ingresar el username para continuar el registro");
        }
        if (password == null || password.isBlank()){
            errores.put("password","Porfavor ingresar la contraseña para continuar el registro");
        }
        if (product == null || product.isBlank()){
            errores.put("product","Porfavor ingresar el producto para continuar el registro");
        }
        if (price == null || price.isNaN()){
            errores.put("price","Porfavor ingresar el precio para continuar el registro");
        }
        return errores;
    }
}
