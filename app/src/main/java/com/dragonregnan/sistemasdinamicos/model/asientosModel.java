package com.dragonregnan.sistemasdinamicos.model;

/**
 * Created by laura on 05/01/2016.
 */
public class asientosModel {

    private int idAsiento;

    private int idEmpresa;

    private int idOperacion;

    private int idCargo;

    private int idAbono;

    public int getIdAsiento(){
        return idAsiento;
    }

    public int getIdEmpresa(){
        return idEmpresa;
    }

    public int getIdOperacion(){
        return idOperacion;
    }

    public int getIdCargo(){
        return  idCargo;
    }

    public int getIdAbono(){
        return idAbono;
    }

    public void setIdAsiento( int idAt){
        idAsiento = idAt;
    }

    public void setIdEmpresa( int idEs){
        idEmpresa = idEs;
    }

    public void setIdOperacion( int idOn){
        idOperacion = idOn;
    }

    public void setIdCargo( int idCg){
        idCargo = idCg;
    }

    public void setIdAbono( int idAn){
        idAbono = idAn;
    }


}
