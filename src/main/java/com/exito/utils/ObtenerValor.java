package com.exito.utils;

public class ObtenerValor {

    public static String precio (String texto) {
        texto=texto.replaceAll("\\.","");
        texto=texto.replaceAll("\\$","");
        texto=texto.replaceAll(" ","");
        return texto;
    }
    public static String cantidad (String texto) {
        String[] parts = texto.split("\\s+");
        if (parts.length > 0) {
            return parts[0];
        } else {
            return texto;
        }
    }


}
