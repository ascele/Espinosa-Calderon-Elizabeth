package com.dragonregnan.sistemasdinamicos.dao;

import android.content.Context;
import android.location.Address;

import com.dragonregnan.sistemasdinamicos.db.DataBaseSource;

import java.util.ArrayList;

/**
 * Created by laura on 03/01/2016.
 */
public class industriasDAO {

    private Context context;
    private static DataBaseSource db;
    private ArrayList<Address> addresses;

    public static final String TABLE_INDUSTRIAS = "industrias";
    public static final String IDINDUSTRIA = "idindustria";
    public static final String NBINDUSTRIA = "nbindustria";

}
