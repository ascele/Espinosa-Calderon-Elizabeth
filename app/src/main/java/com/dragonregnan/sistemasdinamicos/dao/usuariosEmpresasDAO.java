package com.dragonregnan.sistemasdinamicos.dao;

/**
 * Created by laura on 11/01/2016.
 */

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

public class usuariosEmpresasDAO {
    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String TABLE_UDUARIOSEMPRESAS = "usuariosempresas";
    public static final String IDUSUARIO = "idusuario";
    public static final String IDEMPRESA = "idempresa";
}

