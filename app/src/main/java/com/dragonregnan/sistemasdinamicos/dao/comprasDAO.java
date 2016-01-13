package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

/**
 * Created by laura on 04/01/2016.
 */
public class comprasDAO {
    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String TABLE_COMPRAS = "compras";
    public static final String IDCOMPRA = "idcompa";
    public static final String IDCOTIZACION = "idcotizacion";
    public static final String FECCOMPRA = "feccompra";
    public static final String LIQUIDADA = "liquidada";
    public static final String ENTREGADA = "entregada";
}
