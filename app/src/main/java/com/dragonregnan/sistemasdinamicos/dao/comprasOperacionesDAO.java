package com.dragonregnan.sistemasdinamicos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.location.Address;
import android.widget.Toast;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;
import com.dragonregnan.sistemasdinamicos.model.comprasModel;
import com.dragonregnan.sistemasdinamicos.model.comprasOperacionesModel;

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

    public comprasOperacionesDAO(Context context) {
        this.context = context;
        db = new DataBaseSource(context);
    }

    public int insertCompraOperacion(comprasOperacionesModel compOpe) {
        ContentValues cv = new ContentValues();


        cv.put(IDTIPOOPERACION, compOpe.getIdTipoOperacion());
        cv.put(IDCOMPRA, compOpe.getIdCompra());
        cv.put(IDEMPRESAVENDEDORA,compOpe.getIdEmpresaVendedora() );
        cv.put(IDEMPRESACOMPRADORA, compOpe.getIdEmpresaCompradora());
        int id = (int) db.insert(TABLE_COMPRASOPERACIONES, cv);

        Toast toast = Toast.makeText(context, "Operacion registrada con Exito", Toast.LENGTH_LONG);
        toast.show();
        db.close();

        return id;

    }

}
