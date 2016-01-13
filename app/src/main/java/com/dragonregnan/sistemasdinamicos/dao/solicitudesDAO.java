package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

/**
 * Created by laura on 04/01/2016.
 */
public class solicitudesDAO {

    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String  TABLE_SOLICITUDES = "solicitudes";
    public static final String  IDSOLICITUD = "idsolicitud";
    public static final String  IDINDUSTRIA = "idindustria";
    public static final String  FECENTREGASOL = "fecentregasol";
    public static final String  IDEMPRESACOMPRADORA = "idempresacompradora";
    public static final String  CANTSOLICITADA = "cantsolicitada";

}
