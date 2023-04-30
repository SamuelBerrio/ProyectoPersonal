package com.example.chatjsp.persistence;

import com.example.chatjsp.model.Cliente;
import com.example.chatjsp.model.Compra;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistence {
    public static final String RUTA_ARCHIVO_COMPRAS = "src/main/java/com/example/chatjsp/persistence/resources/compras.txt";

    public static void saveCompras(ArrayList<Compra> compraArrayList) throws IOException {

        String content = "";

        for(Compra compra: compraArrayList) {

            content+= compra.getProduct()+"~"+compra.getPrice()+"~"+compra.getCliente().getName()+
                    compra.getCliente().getLastname()+"~"+compra.getCliente().getUsername()+"~"+
                    compra.getCliente().getPassword()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_COMPRAS, content, false);
        System.out.println("Arreglo guardado");
    }

    public static ArrayList<Compra> loadCompras() throws FileNotFoundException, IOException {

        ArrayList<Compra> compraArrayList = new ArrayList<>();

        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_COMPRAS);

        for (String s : contenido) {
            Compra compra = new Compra();
            compra.setProduct(s.split("~")[0]);
            compra.setPrice(Double.parseDouble(s.split("~")[1]));
            String name = s.split("~")[2];
            String lastName = s.split("~")[3];
            String userName = s.split("~")[4];
            String password = s.split("~")[5];
            compra.setCliente(new Cliente(name,lastName,userName,password));
            compraArrayList.add(compra);
        }
        System.out.println("Arreglo cargado");
        return compraArrayList;
    }
}
