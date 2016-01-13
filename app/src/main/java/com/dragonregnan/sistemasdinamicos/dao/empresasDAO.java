package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

/**
 * Created by laura on 24/12/2015.
 */
public class empresasDAO {

    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String TABLE_EMPRESAS = "empresas";
    public static final String IDEMPRESA = "empresa";
    public static final String NBEMPRESA = "nbempresa";
    public static final String IDINDUSTRIA = "idindustria";
}
