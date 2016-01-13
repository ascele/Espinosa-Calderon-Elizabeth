package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

/**
 * Created by laura on 05/01/2016.
 */
public class usuariosDAO {
    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String TABLE_UDUARIOS = "usuarios";
    public static final String IDUSUARIO = "idusuario";
    public static final String NOBOLETA = "noboleta";
    public static final String CONTRASENA = "contrasena";
    public static final String NOMBRE = "nombre";
    public static final String APEPATERNO = "apepaterno";
    public static final String APEMATERNO = "apematerno";
    public static final String GRUPO = "grupo";
}
