package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

/**
 * Created by laura on 04/01/2016.
 */
public class comprasOperacionesDAO {

    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String TABLE_COMPRASOPERACIONES = "comprasoperaciones";
    public static final String IDOPERACION = "idoperacion";
    public static final String IDTIPOOPERACION = "idtipooperacion";
    public static final String IDCOMPRA = "idcompra";
    public static final String IDEMPRESACOMPRADORA = "idempresacompradora";
    public static final String IDEMPRESAVENDEDORA = "idempresavendedora";

}
