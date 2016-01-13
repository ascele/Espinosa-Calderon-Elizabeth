package com.dragonregnan.sistemasdinamicos.model;

/**
 * Created by laura on 05/01/2016.
 */
public class nivelesVariablesModel {

    private int idEmpresa;

    private int idAlmacen;

    private int deseado;

    private int actual;

    public int getIdEmpresa(){
        return idEmpresa;
    }

    public int getIdAlmacen(){
        return idAlmacen;
    }

    public int getDeseado(){
        return deseado;
    }

    public int getActual(){
        return actual;
    }

    public void setIdEmpresa( int idEs){
        idEmpresa= idEs;
    }

    public void setIdAlmacen( int idAm){
        idAlmacen = idAm;
    }

    public void setDeseado( int ds){
        deseado = ds;
    }

    public void setActual( int at){
        actual = at;
    }
}
