package com.dragonregnan.sistemasdinamicos.model;

import java.sql.Date;

/**
 * Created by laura on 05/01/2016.
 */
public class pagosModel {

    private int idPago;

    private int idOperacion;

    private float cantidadPagada;

    private Date fecPago;

    public int getIdPago(){
        return idPago;
    }

    public int getIdOperacion(){
        return idOperacion;
    }

    public float getCantidadPagada(){
        return cantidadPagada;
    }

    public Date getFecPago(){
        return fecPago;
    }

    public void setIdPago( int idP){
        idPago = idP;
    }

    public void setIdOperacion( int idO){
        idOperacion = idO;
    }

    public void setCantidadPagada( float caPa){
        cantidadPagada = caPa;
    }

    public void setFecPago( Date fcP){
        fecPago = fcP;
    }
}
