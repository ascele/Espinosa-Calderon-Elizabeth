package com.dragonregnan.sistemasdinamicos.model;

import java.sql.Date;

/**
 * Created by laura on 05/01/2016.
 */
public class sesionModel {

    private int idSesion;

    private int idUsuario;

    private String ubicacion;

    private Date fecSesion;

    private Boolean activa;

    public int getIdSesion(){
        return idSesion;
    }

    public int getIdUsuario(){
        return idUsuario;
    }

    public String getUbicacion(){
        return ubicacion;
    }

    public Date getFecSesion(){
        return fecSesion;
    }

    public Boolean getActiva(){
        return activa;
    }

    public void setIdSesion( int idSn){
        idSesion = idSn;
    }

    public void setIdUsuario( int idUr){
        idUsuario = idUr;
    }

    public void setUbicacion( String un){
        ubicacion = un;
    }

    public void setFecSesion( Date fecSn){
        fecSesion = fecSn;
    }

    public void setActiva( Boolean av){
        activa = av;
    }
}
