package com.dragonregnan.sistemasdinamicos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.location.Address;
import android.widget.Toast;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;
import com.dragonregnan.sistemasdinamicos.model.embarquesModel;
import com.dragonregnan.sistemasdinamicos.model.pagosModel;

import java.util.ArrayList;

/**
 * Created by laura on 05/01/2016.
 */
public class embarquesDAO {
    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String TABLE_EMBARQUES = "embarques";
    public static final String IDEMBARQUE = "idembarque";
    public static final String IDOPERACION = "idoperacion";
    public static final String CANTIDADEMBARCADA = "cantidadembarcada";
    public static final String FECEMBARQUE = "fecembarque";

    public embarquesDAO(Context context) {
        this.context = context;
        db = new DataBaseSource(context);
    }

    public int insertEmbarque(embarquesModel emb) {
        ContentValues cv = new ContentValues();

        cv.put(IDOPERACION, emb.getIdOperacion());
        cv.put(CANTIDADEMBARCADA, emb.getCantidadEmbarcada());
        cv.put(FECEMBARQUE,emb.getFecEmbarque().getTime() );
        int id = (int) db.insert(TABLE_EMBARQUES, cv);

        Toast toast = Toast.makeText(context, "Embarque registrado con Exito", Toast.LENGTH_LONG);
        toast.show();
        db.close();
        return id;

    }
}
