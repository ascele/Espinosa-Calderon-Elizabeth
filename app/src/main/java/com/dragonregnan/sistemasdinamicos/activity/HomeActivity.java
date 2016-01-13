package com.dragonregnan.sistemasdinamicos.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dragonregnan.sistemasdinamicos.R;

/**
 * Created by laura on 07/12/2015.
 */
public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private int int_mat1_nvl_max= 10;
    private int int_mat1_nvl_min= 10;
    private View nvl_max_1 ;
    private View nvl_min_1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /** FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });**/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        final TextView material1_superior = (TextView) findViewById(R.id.material1_superior);
        final TextView material1_inferior = (TextView) findViewById(R.id.material1_inferior);
        nvl_max_1 =  findViewById(R.id.nvl_max_1);
        nvl_min_1 = findViewById(R.id.nvl_min_1);

        material1_superior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(HomeActivity.this);
                dialog.setContentView(R.layout.dialog);
                dialog.setTitle("Almacen");
                dialog.show();
                SeekBar seekBar =(SeekBar) dialog.findViewById(R.id.seekBar);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    int progressChanged = 0;

                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progressChanged = progress;
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // TODO Auto-generated method stub
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                        TextView textView = (TextView) dialog.findViewById(R.id.txtvw_estado);
                        textView.setText(String.valueOf(seekBar.getProgress()));
                        int_mat1_nvl_max = seekBar.getProgress();
                    }
                });
                SeekBar seekBar2 =(SeekBar) dialog.findViewById(R.id.seekBar2);
                seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    int progressChanged = 0;

                    public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                        progressChanged = progress;
                    }

                    public void onStartTrackingTouch(SeekBar seekBar2) {
                        // TODO Auto-generated method stub
                    }

                    public void onStopTrackingTouch(SeekBar seekBar2) {
                        TextView textView2 = (TextView) dialog.findViewById(R.id.txtvw_estado2);
                        textView2.setText(String.valueOf(seekBar2.getProgress()));
                        int_mat1_nvl_min = seekBar2.getProgress();
                    }
                });

                //Log.d("mat1", String.valueOf(int_mat1));
                Button dialogAceptar = (Button) dialog.findViewById(R.id.btn_aceptar);
                dialogAceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(int_mat1_nvl_max>0){
                        int margin = int_mat1_nvl_max * 10;

                        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) nvl_max_1.getLayoutParams();
                        relativeParams.setMargins(0, margin, 0, 0);
                        nvl_max_1.setLayoutParams(relativeParams);
                        }
                        if(int_mat1_nvl_max==0){
                            RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) nvl_max_1.getLayoutParams();
                            relativeParams.setMargins(0, 95, 0, 0);
                            nvl_max_1.setLayoutParams(relativeParams);
                        }

                        if(int_mat1_nvl_min>0){
                            int margin1 =100-(int_mat1_nvl_min * 10);

                            RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) nvl_min_1.getLayoutParams();
                            relativeParams.setMargins(0, margin1, 0, 0);
                            nvl_min_1.setLayoutParams(relativeParams);}
                        if(int_mat1_nvl_min==0){
                            RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) nvl_min_1.getLayoutParams();
                            relativeParams.setMargins(0, 0, 0, 0);
                            nvl_min_1.setLayoutParams(relativeParams);
                        }

                        dialog.dismiss();
                    }
                });
                Button dialogCancelar = (Button) dialog.findViewById(R.id.btn_cancelar);
                dialogCancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

            }
        });



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

