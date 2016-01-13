package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

/**
 * Created by laura on 05/01/2016.
 */
public class sesionDAO {

    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String TABLE_SESION = "sesion";
    public static final String IDSESION = "idsesion";
    public static final String IDUSUARIO = "idusuario";
    public static final String UBICACION = "UBICACION";
    public static final String FECSESION = "fecsesion";
    public static final String ACTIVA = "activa";
}
