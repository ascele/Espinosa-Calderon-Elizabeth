package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

/**
 * Created by laura on 05/01/2016.
 */
public class tiposOperacionesDAO {
    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String  TABLE_TIPOOPERACIONES = "tipooperaciones";
    public static final String  IDTIPOOPERACION = "idtipooperaciones";
    public static final String  NBTIPOOPERACION = "nbtipooperaciones";
}
