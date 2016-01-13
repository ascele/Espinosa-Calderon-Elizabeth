package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

/**
 * Created by laura on 03/01/2016.
 */
public class tipoAlmacenDAO {

    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String  TABLE_TIPOALMACEN = "tipoalmacen";
    public static final String  IDTIPOALMACEN = "idtipoalmacen";
    public static final String  NBTIPOALMACEN = "nbtipoalmacen";
}
