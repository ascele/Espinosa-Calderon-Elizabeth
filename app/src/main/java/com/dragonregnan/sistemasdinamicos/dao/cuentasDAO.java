package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

/**
 * Created by laura on 04/01/2016.
 */
public class cuentasDAO {
    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String TABLE_CUENTAS = "cuentas";
    public static final String IDCUENTA = "idcuenta";
    public static final String NBCUENTA = "nbcuenta";
    public static final String ACREEDORA = "acreedora";
}
