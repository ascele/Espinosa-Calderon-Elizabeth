package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.database.Cursor;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;
import com.dragonregnan.sistemasdinamicos.model.solicitudesModel;

import java.sql.Date;
import java.sql.SQLException;
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

    public encadenamientosDAO(Context context) {
        this.context = context;
        db = new DataBaseSource(context);
    }

    public static ArrayList<Integer> getIndustriasVenden( int idIndustriaCompradora){
        String[] fields = {IDINDUSTRIAVENDEDORA};
        String condition = IDINDUSTRIACOMPRADORA + " = " + idIndustriaCompradora;

        try {
            db.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Cursor cursor = db.getDataRaw(condition, null);
        ArrayList<Integer> vendedoras = new ArrayList<>();
        vendedoras.clear();
        if (cursor != null && cursor.getCount() > 0){
            while(cursor.moveToNext()){
                solicitudesModel solicitud  = new solicitudesModel();

                int row_idsolicitud = cursor.getColumnIndex(IDINDUSTRIAVENDEDORA);

                vendedoras.add(cursor.getInt(row_idsolicitud));
            }
        }
        db.close();
        return vendedoras;
    }
}
