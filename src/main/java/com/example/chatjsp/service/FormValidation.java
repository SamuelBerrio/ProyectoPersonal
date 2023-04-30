package com.example.chatjsp.service;

import java.util.HashMap;
import java.util.Map;

public interface FormValidation {
    Map<String,String> formValidation(String name,String lastName,String username,String password,String product,Double price);
}
