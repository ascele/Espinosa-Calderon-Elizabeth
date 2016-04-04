package com.dragonregnan.sistemasdinamicos.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dragonregnan.sistemasdinamicos.JSON.JSONParser;
import com.dragonregnan.sistemasdinamicos.R;
import com.dragonregnan.sistemasdinamicos.dao.sesionDAO;
import com.dragonregnan.sistemasdinamicos.dao.ultimasincronizacionDAO;
import com.dragonregnan.sistemasdinamicos.dao.usuariosDAO;
import com.dragonregnan.sistemasdinamicos.dao.usuariosEmpresasDAO;
import com.dragonregnan.sistemasdinamicos.model.nivelesVariablesModel;
import com.dragonregnan.sistemasdinamicos.model.usuariosModel;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A login screen that offers login via email/password.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class LoginActivity extends AppCompatActivity {

    JSONParser jsonParser = new JSONParser();

    private static String url = "http://ultragalaxia.com/android/usuario_empresa.php";
    private static String url2 = "http://ultragalaxia.com/android/nuevaEmpresa.php";
    private static String url3 = "http://ultragalaxia.com/android/sincronizacion.php";


    private static final String TAG_SUCCESS = "success";
    private static final String TAG_EMPRESA = "empresa";
    private static final String TAG_USUARIO = "usuario";{}
    private static final String TAG_IDUSUARIO = "idusuario";
    private static final String TAG_NOBOLETA= "noboleta";
    private static final String TAG_CONTRASENA = "contrasena";
    private static final String TAG_NOMBRE = "nombre";
    private static final String TAG_APEPATERNO = "apepaterno";
    private static final String TAG_APEMATERNO = "apematerno";
    private static final String TAG_GRUPO = "grupo";
    private UserLoginTask mAuthTask = null;
    private AutoCompleteTextView mBoletaView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private usuariosDAO usuDAO;
    private sesionDAO sesDAO;
    private usuariosEmpresasDAO usuEmpDAO;
    private ultimasincronizacionDAO ultimaDAO;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //INSTANCIAR DAOS

        usuDAO = new usuariosDAO(this);
        sesDAO = new sesionDAO(this);
        ultimaDAO =new ultimasincronizacionDAO(this);

        int id_Logueado = sesDAO.getActiva();

        if(id_Logueado > 0){

        mBoletaView = (AutoCompleteTextView) findViewById(R.id.boleta);

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        }else{
            int empresa = usuEmpDAO.getEmpresa(id_Logueado);
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MisPreferencias", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putInt("idEmpresa", empresa);
            editor.putInt("idUsuario", id_Logueado);
            editor.commit();
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
            finish();
        }
    }

    public static boolean verificaConexion(Context ctx) {
        boolean bConectado = false;
        ConnectivityManager connec = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // No sólo wifi, también GPRS
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        // este bucle debería no ser tan ñapa
        for (int i = 0; i < 2; i++) {
            // ¿Tenemos conexión? ponemos a true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;
    }

    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }
        // VACIAR ERRORES
        mBoletaView.setError(null);
        mPasswordView.setError(null);
        // GUARDAR VALORES AL MISMO TIEMPO QUE SE TRATA DE LOGUEAR
        String boleta = mBoletaView.getText().toString();
        String password = mPasswordView.getText().toString();
        boolean cancel = true;
        View focusView = null;

        // CHECAR VALIDEZ DE DATOS DE ACCESO
        if (!TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_field_required));
            focusView = mPasswordView;
            cancel = true;
        }

        if (TextUtils.isEmpty(boleta)) {
            mBoletaView.setError(getString(R.string.error_field_required));
            focusView = mBoletaView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            //MUESTRA EL SPINNER DEL PROGRESO
            showProgress(true);
            mAuthTask = new UserLoginTask(boleta, password);
            mAuthTask.execute((Void) null);
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Login Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.dragonregnan.sistemasdinamicos.activity/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Login Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.dragonregnan.sistemasdinamicos.activity/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mBoleta;
        private final String mPassword;
        private int id_usuario;

        UserLoginTask(String boleta, String password) {
            mBoleta = boleta;
            mPassword = password;
            id_usuario = 0;
        }

        private int isPasswordValid(String password, String boleta) {
            String comparacion = usuDAO.getContraseña(boleta);
            if (comparacion.equals(null)) {
                return 0;
            }
            if (comparacion == password) {
                return 2;
            } else {
                return 1;
            }
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.
            boolean ret = false;

            int comprobacion = isPasswordValid(mPassword, mBoleta);

            if (comprobacion == 0) {

                if (!verificaConexion(LoginActivity.this)) {
                    Toast.makeText(getBaseContext(),
                            "Comprueba tu conexión a Internet", Toast.LENGTH_SHORT)
                            .show();
                }
                else {
                    List<NameValuePair> params1 = new ArrayList<NameValuePair>();
                    params1.add(new BasicNameValuePair("boleta", mBoleta));
                    params1.add(new BasicNameValuePair("password", mPassword));

                    JSONObject json = jsonParser.makeHttpRequest(url, "POST", params1);
                    Log.d("Create Response", json.toString());

                    try {
                        int success = json.getInt(TAG_SUCCESS);
                        if (success == 1) {

                            int empresa = json.getInt(TAG_EMPRESA);

                            JSONArray usuario;
                            usuario = json.getJSONArray(TAG_USUARIO);
                            usuariosModel usuarios = new usuariosModel();
                            for (int i = 0; i < usuario.length(); i++) {
                                JSONObject c = usuario.getJSONObject(i);
                                id_usuario=c.getInt(TAG_IDUSUARIO);
                                usuarios.setIdUsuario(c.getInt(TAG_IDUSUARIO));
                                usuarios.setNoBoleta(c.getString(TAG_NOBOLETA));
                                usuarios.setContrasena(c.getString(TAG_CONTRASENA));
                                usuarios.setNombre(c.getString(TAG_NOMBRE));
                                usuarios.setApePaterno(c.getString(TAG_APEPATERNO));
                                usuarios.setApeMaterno(c.getString(TAG_APEMATERNO));
                                usuarios.setGrupo(c.getString(TAG_GRUPO));

                                usuDAO.insertUsuario(usuarios);
                            }

                            if (empresa == 0) {
                                final Dialog dialog = new Dialog(LoginActivity.this);
                                dialog.setContentView(R.layout.dialog_nombre);
                                dialog.setTitle("Mi empresa");
                                dialog.show();
                                final EditText nombreEmpresa = (EditText) dialog.findViewById(R.id.edtxtnombre);
                                Button continuar = (Button) dialog.findViewById(R.id.btncontinuar);
                                continuar.setOnClickListener(new OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        List<NameValuePair> params2 = new ArrayList<NameValuePair>();

                                        params2.add(new BasicNameValuePair("idUsuario", String.valueOf(id_usuario)));
                                        params2.add(new BasicNameValuePair("empresa", nombreEmpresa.getText().toString()));

                                        jsonParser.makeHttpRequest(url2, "POST", params2);
                                        dialog.dismiss();
                                    }
                                });
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (ultimaDAO.getSincronizacion()== null){

                        JSONObject json3 = jsonParser.makeHttpRequest(url3, "POST", params1);
                        Log.d("Create Response", json.toString());

                        try {
                            int success = json.getInt(TAG_SUCCESS);
                            if (success == 1) {

                                int empresa = json.getInt(TAG_EMPRESA);

                                JSONArray usuario;
                                usuario = json.getJSONArray(TAG_USUARIO);

                                usuariosModel usuarios = new usuariosModel();
                                // looping through All Products
                                for (int i = 0; i < usuario.length(); i++) {
                                    JSONObject c = usuario.getJSONObject(i);
                                    id_usuario=c.getInt(TAG_IDUSUARIO);
                                    usuarios.setIdUsuario(c.getInt(TAG_IDUSUARIO));
                                    usuarios.setNoBoleta(c.getString(TAG_NOBOLETA));
                                    usuarios.setContrasena(c.getString(TAG_CONTRASENA));
                                    usuarios.setNombre(c.getString(TAG_NOMBRE));
                                    usuarios.setApePaterno(c.getString(TAG_APEPATERNO));
                                    usuarios.setApeMaterno(c.getString(TAG_APEMATERNO));
                                    usuarios.setGrupo(c.getString(TAG_GRUPO));

                                    usuDAO.insertUsuario(usuarios);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else if (comprobacion == 1) {
                ret = false;
            } else if (comprobacion == 2) {
                ret= true;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            return ret;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            if (success) {
                //SE CREAN LAS PREFERENCIAS
                int empresa = usuEmpDAO.getEmpresa(id_usuario);
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MisPreferencias", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("idEmpresa", empresa);
                editor.putInt("idUsuario", id_usuario);
                editor.commit();
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}

