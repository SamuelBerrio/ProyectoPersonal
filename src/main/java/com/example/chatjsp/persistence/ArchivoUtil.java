package com.example.chatjsp.persistence;

import java.io.*;
import java.util.ArrayList;

public class ArchivoUtil {
    public static ArrayList<String> leerArchivo(String ruta) throws IOException {

        ArrayList<String> content = new ArrayList<>();
        FileReader fr = new FileReader(ruta);
        BufferedReader bfr = new BufferedReader(fr);
        String linea = "";
        while((linea = bfr.readLine())!= null) {
            content.add(linea);
        }
        bfr.close();
        fr.close();
        return content;
    }
    public static void guardarArchivo(String ruta, String contenido, boolean b) throws IOException {
        FileWriter fw = new FileWriter(ruta, b);
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(contenido);
        bfw.close();
        fw.close();

    }
}
