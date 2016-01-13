package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

/**
 * Created by laura on 03/01/2016.
 */
public class encadenamientosDAO {
    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String TABLE_ENCADENAMIENTOS = "encadenamientos";
    public static final String IDINDUSTRIACOMPRADORA = "idindustriacompradora";
    public static final String IDINDUSTRIAVENDEDORA = "idindustriavendedora";
    public static final String COEFICIENTE = "coeficiente";
}
