package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

/**
 * Created by laura on 04/01/2016.
 */
public class cotizacionesDAO {
    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String TABLE_COTIZACIONES = "cotizaciones";
    public static final String IDCOTIZACION = "idcotizacion";
    public static final String IDSOLICITUD = "idsolicitud";
    public static final String CANTOFRECIDA = "cantofrecida";
    public static final String PRECIO = "precio";
    public static final String FECEXPIRACION = "fecexpiracion";
    public static final String FECENTREGA = "fecentrega";
    public static final String IDEMPRESAVENDEDORA = "idempresavendedora";

}
