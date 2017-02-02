package com.grayhatcorp.invetsa.invetsa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class Login extends AppCompatActivity {
Suceso suceso;
    ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        SharedPreferences prefe=getSharedPreferences("perfil", Context.MODE_PRIVATE);
        String id=prefe.getString("id_usuario","");

        Servicio hilo_pedido = new Servicio();
        String ip=getString(R.string.servidor);
        hilo_pedido.execute(ip+"frmPedido.php?opcion=lista_pedido_por_id_usuario", "1",id);// parametro que recibe el doinbackground
        Log.i("Item", "actualizar!");
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
                    jsonParam.put("id_usuario", params[2]);

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
                        vaciar_historial();
                        if (suceso.getSuceso().equals("1")) {
                            JSONArray usu=respuestaJSON.getJSONArray("historial");
                            for (int i=0;i<usu.length();i++)
                            {
                                int id_usuario=Integer.parseInt(usu.getJSONObject(i).getString("id_usuario"));
                                int id_pedido=Integer.parseInt(usu.getJSONObject(i).getString("id"));
                                int id_moto=Integer.parseInt(usu.getJSONObject(i).getString("id_moto"));
                                int calificacion=Integer.parseInt(usu.getJSONObject(i).getString("calificacion"));
                                int tipo_pedido=Integer.parseInt(usu.getJSONObject(i).getString("tipo_pedido"));
                                String mensaje=usu.getJSONObject(i).getString("mensaje");
                                String fecha=usu.getJSONObject(i).getString("fecha");
                                String fecha_llegado=usu.getJSONObject(i).getString("fecha_llegado");
                                int estado=Integer.parseInt(usu.getJSONObject(i).getString("estado"));
                                double latitud=Double.parseDouble(usu.getJSONObject(i).getString("longitud"));
                                double longitud=Double.parseDouble(usu.getJSONObject(i).getString("longitud"));
                                String nombre=usu.getJSONObject(i).getString("nombre");
                                String apellido=usu.getJSONObject(i).getString("apellido");
                                String celular=usu.getJSONObject(i).getString("celular");
                                String marca=usu.getJSONObject(i).getString("marca");
                                String placa=usu.getJSONObject(i).getString("placa");
                                int estado_moto=Integer.parseInt(usu.getJSONObject(i).getString("estado_moto"));

                               // cargar_lista_en_historial(id_usuario,id_pedido,id_moto,calificacion,tipo_pedido,mensaje,fecha,fecha_llegado,estado,latitud,longitud,nombre,apellido,celular,marca, placa,estado_moto);
                            }

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
            pDialog = new ProgressDialog(Login.this);
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
              //  cargar_historial_en_la_lista();
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
/*
    private void cargar_historial_en_la_lista()
    {
        historial= new ArrayList<CHistorial>();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "easymoto", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select * from pedido ", null);

        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)

            do {

                int id_pedido=Integer.parseInt(fila.getString(0));
                int id_usuario=Integer.parseInt(fila.getString(1));
                int id_moto=Integer.parseInt(fila.getString(2));
                int calificacion=Integer.parseInt(fila.getString(3));
                int tipo_pedido=Integer.parseInt(fila.getString(4));
                String mensaje=fila.getString(5);
                String fecha=fila.getString(6);
                String fecha_llegado=fila.getString(7);
                int estado=Integer.parseInt(fila.getString(8));
                double latitud=Double.parseDouble(fila.getString(9));
                double longitud=Double.parseDouble(fila.getString(10));
                String nombre=fila.getString(11);
                String apellido=fila.getString(12);
                String celular=fila.getString(13);
                String marca=fila.getString(14);
                String placa=fila.getString(15);
                int estado_moto=Integer.parseInt(fila.getString(16));

                CHistorial hi =new CHistorial( id_usuario,id_pedido,id_moto,calificacion,tipo_pedido,mensaje,fecha,fecha_llegado,estado,latitud,longitud,nombre,apellido,celular,marca, placa,estado_moto);
                historial.add(hi);
            } while(fila.moveToNext());

        } else
            Toast.makeText(this, "No hay registrados" ,
                    Toast.LENGTH_SHORT).show();

        bd.close();
        actualizar_lista();
    }
    */

    private void vaciar_historial()
    {

        SQLite admin = new SQLite(this,
                "easymoto", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        db.execSQL("delete from pedido");
        db.close();
        Log.e("sqlite ", "vaciar historial");
    }

}

