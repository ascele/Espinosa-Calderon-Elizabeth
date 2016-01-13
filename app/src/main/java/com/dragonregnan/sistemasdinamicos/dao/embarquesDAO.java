package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

/**
 * Created by laura on 05/01/2016.
 */
public class embarquesDAO {
    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String TABLE_EMBARQUES = "embarques";
    public static final String IDEMBARQUE = "idembarque";
    public static final String IDOPERACION = "idoperacion";
    public static final String CANTIDADEMBARCADA = "cantidadembarcada";
    public static final String FECEMBARQUE = "fecembarque";
}
