package com.dragonregnan.sistemasdinamicos.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dragonregnan.sistemasdinamicos.R;
import com.dragonregnan.sistemasdinamicos.adapters.SolicitudesAdapter;
import com.dragonregnan.sistemasdinamicos.dao.solicitudesDAO;
import com.dragonregnan.sistemasdinamicos.detalles.DetalleMisSolicitudesActivity;
import com.dragonregnan.sistemasdinamicos.detalles.DetalleSolicitudesActivity;
import com.dragonregnan.sistemasdinamicos.model.solicitudesModel;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by laura on 03/02/2016.
 */
public class FragmentMisSolicitudes extends Fragment {
    public static ArrayList<solicitudesModel> MisSolicitudes = new ArrayList<>();
    private View rootView;
    private solicitudesDAO solDAO;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        solDAO = new solicitudesDAO(this.getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_mis_solicitudes, container, false);
        solicitudesModel soli = new solicitudesModel();

        MisSolicitudes.clear();
        MisSolicitudes = solDAO.getMisSolicitudes(1);

        final SolicitudesAdapter adapter = new SolicitudesAdapter(this.getContext(), MisSolicitudes);
        ListView listView = (ListView) rootView.findViewById(R.id.listViewMiSolicitud);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int item = (int) adapter.getItemId(position);
                int idsol= MisSolicitudes.get(item).getIdSolicitud();
                int idempcompradora = MisSolicitudes.get(item).getIdEmpresaCompradora();
                int cantidad = MisSolicitudes.get(item).getCantSolicitada();
                String fecha = String.valueOf(MisSolicitudes.get(item).getFecEntregaSol());

                Intent i = new Intent(getActivity(), DetalleMisSolicitudesActivity.class);
                i.putExtra("idSol",idsol);
                i.putExtra("idEmpCompradora",idempcompradora);
                i.putExtra("Cantidad",cantidad);
                i.putExtra("Fecha",fecha);
                startActivity(i);
            }

        });
        return rootView;

    }


}
