package com.exito.utils;

import org.json.JSONObject;

public class Constantes {
    public static final String CORREO;

    static {
        LeerJson.on("resources/datadriven/data.json");
        LeerJson.getGlobalJSONObject();
        JSONObject datosRegistro = LeerJson.getGlobalJSONObject().getJSONObject("DatosRegistro");

        CORREO = datosRegistro.getString("Correo");
    }
}