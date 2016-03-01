package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

/**
 * Created by laura on 05/01/2016.
 */
public class asientosDAO {
    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String TABLE_ASIENTOS = "asientos";
    public static final String IDASIENTO = "idasiento";
    public static final String IDEMPRESA = "idempresa";
    public static final String IDOPERACION = "idoperacion";
    public static final String IDCARGO = "idcargo";
    public static final String IDABONO = "idabono";

}
