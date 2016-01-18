package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

/**
 * Created by laura on 05/01/2016.
 */
public class nivelesVariablesDAO {

    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String TABLE_NIVELESVARIABLES = "nivelesvariables";
    public static final String IDEMPRESA = "idempresa";
    public static final String IDALMACEN = "idalmacen";
    public static final String DESEADO = "deseado";
    public static final String ACTUAL = "actual";
    public static final String MINIMODESEADO = "minimodeseado";
}
