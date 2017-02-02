package com.grayhatcorp.invetsa.invetsa;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.grayhatcorp.invetsa.invetsa.Base_de_datos.SQLite;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Principal extends AppCompatActivity implements View.OnClickListener {


    private Button SIM,HojaVerificacion,MaquinaTwinShot,MaquinaSpravac,actualizar,MaquinaZootec;
    Suceso suceso;
    ProgressDialog pDialog;
    JSONObject datos_necesarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        SIM=(Button)findViewById(R.id.SIM);
        HojaVerificacion=(Button)findViewById(R.id.HojaVerificacion);
        MaquinaTwinShot=(Button)findViewById(R.id.MaquinaTwinShot);
        MaquinaSpravac=(Button)findViewById(R.id.MaquinaSpravac);
        MaquinaZootec=(Button)findViewById(R.id.MaquinaZootec);
        actualizar=(Button)findViewById(R.id.Actualizar);

        SIM.setOnClickListener(this);
        HojaVerificacion.setOnClickListener(this);
        MaquinaTwinShot.setOnClickListener(this);
        MaquinaSpravac.setOnClickListener(this);
        MaquinaZootec.setOnClickListener(this);
        actualizar.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        Intent explicit_intent;//Declaro el Intent

        switch (v.getId()) {//Obtengo el ID del boton precionado

            case R.id.SIM://Si el ID es SIM
                explicit_intent = new Intent(this, SistemaIntegralMonitoreo.class);
                startActivity(explicit_intent);
                break;

            case R.id.HojaVerificacion://Si el ID es HojaVerificacion
                explicit_intent = new Intent(this, HojaDeVerificacion.class);
                startActivity(explicit_intent);
                break;
            case R.id.MaquinaSpravac:
                explicit_intent = new Intent(this, MaquinaSpravac.class);
                startActivity(explicit_intent);
                break;
            case R.id.Actualizar:
                Servicio hilo_pedido = new Servicio();
                String ip=getString(R.string.servidor);
                hilo_pedido.execute(ip+"frmDescargar_datos.php?opcion=get_empresa", "1");// parametro que recibe el doinbackground
                Log.i("Item", "actualizar!");
                break;
            case R.id.MaquinaZootec:
                explicit_intent = new Intent(this, Maquina_zootec.class);
                startActivity(explicit_intent);
                break;
            default:
                explicit_intent = new Intent(this, MaquinaTwinShot.class);
                startActivity(explicit_intent);
                break;
        }
    }

    public class Servicio extends AsyncTask<String,Integer,String> {


        @Override
        protected String doInBackground(String... params) {

            String cadena = params[0];
            URL url = null;  // url donde queremos obtener informacion
            String devuelve = "";

            if (params[1] == "1") {
                try {
                    HttpURLConnection urlConn;

                    url = new URL(cadena);
                    urlConn = (HttpURLConnection) url.openConnection();
                    urlConn.setDoInput(true);
                    urlConn.setDoOutput(true);
                    urlConn.setUseCaches(false);
                    urlConn.setRequestProperty("Content-Type", "application/json");
                    urlConn.setRequestProperty("Accept", "application/json");
                    urlConn.connect();

                    //se crea el objeto JSON
                    JSONObject jsonParam = new JSONObject();

                    //Envio los prametro por metodo post
                    OutputStream os = urlConn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                    writer.write(jsonParam.toString());
                    writer.flush();
                    writer.close();

                    int respuesta = urlConn.getResponseCode();

                    StringBuilder result = new StringBuilder();

                    if (respuesta == HttpURLConnection.HTTP_OK) {

                        String line;
                        BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                        while ((line = br.readLine()) != null) {
                            result.append(line);
                        }


                        JSONObject respuestaJSON = new JSONObject(result.toString());//Creo un JSONObject a partir del
                        suceso=new Suceso(respuestaJSON.getString("suceso"),respuestaJSON.getString("mensaje"));
                        // vacia los datos que estan registrados en nuestra base de datos SQLite..

                        if (suceso.getSuceso().equals("1")) {
                            datos_necesarios=new JSONObject(result.toString());
                            devuelve="1";
                        } else  {
                            devuelve = "2";
                        }

                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return devuelve;
        }


        @Override
        protected void onPreExecute() {
            //para el progres Dialog
            pDialog = new ProgressDialog(Principal.this);
            pDialog.setTitle("Invetsa");
            pDialog.setMessage("Autenticando ....");
            pDialog.setIndeterminate(true);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pDialog.dismiss();//ocultamos proggress dialog
            Log.e("onPostExcute=", "" + s);

            if (s.equals("1")) {
                cargar_datos_en_la_lista();
            }
            else if(s.equals("2"))
            {
                Toast.makeText(getApplicationContext(),suceso.getMensaje(),Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Error: Al conectar con el servidor.",Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }

    }

    private void cargar_datos_en_la_lista() {
        vaciar_datos();
        try {
            JSONArray empresa = datos_necesarios.getJSONArray("empresa");
            JSONArray tecnico = datos_necesarios.getJSONArray("tecnico");
            JSONArray compania = datos_necesarios.getJSONArray("compania");
            JSONArray galpon = datos_necesarios.getJSONArray("galpon");
            JSONArray granja = datos_necesarios.getJSONArray("granja");
            JSONArray maquina = datos_necesarios.getJSONArray("maquina");
            JSONArray vacunador = datos_necesarios.getJSONArray("vacunador");

            cargar_lista_en_empresa(empresa);
            cargar_lista_en_tecnico(tecnico);
            cargar_lista_en_compania(compania);
            cargar_lista_en_galpon(galpon);
            cargar_lista_en_granja(granja);
            cargar_lista_en_maquina(maquina);
            cargar_lista_en_vacunador(vacunador);
            Log.w("SQLite","Se completo de cargar a la base de datos.");
        }catch (Exception e)
        {
            Log.e("SQLite","error al carlar los datos en la base de datos.");
        }
    }

    private void vaciar_datos()
    {

        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        db.execSQL("delete from empresa");
        db.execSQL("delete from tecnico");
        db.execSQL("delete from compania");
        db.execSQL("delete from galpon");
        db.execSQL("delete from granja");
        db.execSQL("delete from maquina");
        db.execSQL("delete from vacunador");
        db.close();
        Log.e("sqlite ", "vaciar datos");
    }

    private void cargar_lista_en_empresa(JSONArray empresa)
    {

        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        for (int i=0;i<empresa.length();i++) {
            try {
                registro.put("id", empresa.getJSONObject(i).getString("id"));
                registro.put("nombre", empresa.getJSONObject(i).getString("nombre"));
                bd.insert("empresa", null, registro);
            }catch (Exception e)
            {

            }
        }
        bd.close();
    }
    private void cargar_lista_en_tecnico(JSONArray tecnico)
    {

        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        for (int i=0;i<tecnico.length();i++) {
            try {
                registro.put("id", tecnico.getJSONObject(i).getString("id"));
                registro.put("nombre", tecnico.getJSONObject(i).getString("nombre"));
                bd.insert("tecnico", null, registro);
            }
            catch (Exception e)
            {

            }
        }
        bd.close();
    }
    private void cargar_lista_en_compania(JSONArray compania)
    {

        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        for (int i=0;i<compania.length();i++) {
            try {
                registro.put("id", compania.getJSONObject(i).getString("id"));
                registro.put("nombre", compania.getJSONObject(i).getString("nombre"));
                bd.insert("compania", null, registro);
            }catch (Exception e)
            {

            }
        }
        bd.close();
    }
    private void cargar_lista_en_galpon(JSONArray galpon)
    {

        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        for (int i=0;i<galpon.length();i++) {
            try {
                registro.put("id", galpon.getJSONObject(i).getString("id"));
                registro.put("id_empresa", galpon.getJSONObject(i).getString("id_empresa"));
                registro.put("id_granja", galpon.getJSONObject(i).getString("id_granja"));
                registro.put("cantidad_pollo", galpon.getJSONObject(i).getString("cantidad_pollo"));
                bd.insert("galpon", null, registro);
            }catch (Exception e)
            {

            }
        }
        bd.close();
    }
    private void cargar_lista_en_granja(JSONArray granja)
    {

        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        for (int i=0;i<granja.length();i++) {
            try {
                registro.put("id", granja.getJSONObject(i).getString("id"));
                registro.put("id_empresa", granja.getJSONObject(i).getString("id_empresa"));
                registro.put("zona", granja.getJSONObject(i).getString("zona"));
                bd.insert("granja", null, registro);
            }catch (Exception e)
            {

            }
        }
        bd.close();
    }

    private void cargar_lista_en_maquina(JSONArray maquina)
    {

        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        for (int i=0;i<maquina.length();i++) {
            try {
                registro.put("id", maquina.getJSONObject(i).getString("id"));
                registro.put("codigo", maquina.getJSONObject(i).getString("codigo"));
                registro.put("nombre", maquina.getJSONObject(i).getString("nombre"));
                bd.insert("maquina", null, registro);
            }catch (Exception e)
            {
                Log.e("sql:","Error al cargar en la maquina.");
            }
        }
        bd.close();
    }
    private void cargar_lista_en_vacunador(JSONArray vacunador)
    {
        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        for (int i=0;i<vacunador.length();i++) {
            try {
                registro.put("id", vacunador.getJSONObject(i).getString("id"));
                registro.put("nombre", vacunador.getJSONObject(i).getString("nombre"));
                bd.insert("vacunador", null, registro);
            }catch (Exception e)
            {

            }
        }
        bd.close();
    }
}
