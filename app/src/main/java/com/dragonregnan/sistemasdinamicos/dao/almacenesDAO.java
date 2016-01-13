package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

/**
 * Created by laura on 03/01/2016.
 */
public class almacenesDAO {
    private Context context;
    private static DataBaseSource db;

    public static final String TABLE_ALMACENES = "alamcenes";
    public static final String IDALMACEN = "idalmacen";
    public static final String IDEMPRESA = "idempresa";
    public static final String NBALMACEN = "nbalmacen";
    public static final String IDTIPOALMACEN = "idtipoalmacen";
    public static final String MAXALMACEN = "maxalamcen";


}
