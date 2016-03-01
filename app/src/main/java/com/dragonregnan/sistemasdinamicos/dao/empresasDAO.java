package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.database.Cursor;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.sql.SQLException;
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

    public empresasDAO(Context context) {
        this.context = context;
        db = new DataBaseSource(context);
    }

    public static String getNombreEmpresa( int idEs) {
        String[] fields = {NBEMPRESA};
        String condition = IDEMPRESA + " = " + idEs;

        try {
            db.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Cursor cursor = db.getData(TABLE_EMPRESAS, fields, condition);
        if(cursor.getCount() >0){
            cursor.moveToFirst();
            int row_id_address = cursor.getColumnIndex(NBEMPRESA);
            db.close();
            return cursor.getString(row_id_address);
        }else{
            db.close();
           return null;
        }


    }

    public static int getIndustriaEmpresa( int idEs) {
        String[] fields = {IDINDUSTRIA};
        String condition = IDEMPRESA + " = " + idEs;

        try {
            db.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Cursor cursor = db.getData(TABLE_EMPRESAS, fields, condition);
        if(cursor.getCount() >0){
            cursor.moveToFirst();
            int row_id_address = cursor.getColumnIndex(NBEMPRESA);
            db.close();
            return cursor.getInt(row_id_address);
        }else{
            db.close();
            return 0;
        }

    }

}
