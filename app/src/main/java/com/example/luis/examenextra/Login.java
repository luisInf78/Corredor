package com.example.luis.examenextra;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    RequestQueue rq;
    JsonRequest jrq;
    TextView txtUsuario;
    TextView txtPassword;
    Button btnAcceso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsuario = (TextView)findViewById(R.id.txtUsuario);
        txtPassword = (TextView)findViewById(R.id.txtPassword);
        btnAcceso = (Button)findViewById(R.id.btnAcceso);
        rq = Volley.newRequestQueue(this);
        btnAcceso.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });

    }

    public void registrarse(View v){

        Intent registro = new Intent(this, detalle_corredor.class);
        startActivity(registro);

    }

    public void acceder(View v){

        Intent acceso = new Intent(this,ListadosCorredores.class);
        startActivity(acceso);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,"El usuario ha sido encontrado",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this,"El usuario ha sido encontrado",Toast.LENGTH_LONG).show();
        Usuario usu = new Usuario();
        JSONArray jarr = response.optJSONArray("datos");
        JSONObject jobj = null;

        try {
            jobj = jarr.getJSONObject(0);
            usu.setUsuario(jobj.optString("usuario"));
            usu.setPassword(jobj.optString("password"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void iniciarSesion(){
        //String url = "http://192.168.43.128/login/sesion.php?user="+txtUsuario.toString()+"&pass="+txtPassword.toString();
        String url = "https://www.google.es";
        jrq = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        rq.add(jrq);
    }
}
