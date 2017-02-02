package com.grayhatcorp.invetsa.invetsa;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import com.grayhatcorp.invetsa.invetsa.Base_de_datos.SQLite;

public class HojaDeVerificacion extends AppCompatActivity {
    String[] language ={"Gray Hat Corp","Invetsa","Sofia","Delicia"};
    String[] TemperaturaVacunacion={"24,1°C","24,2°C","24,3°C","27,1°C"};
    String[]HumedadVacunacion={"60,1°C","60,2°C","65,3°C","68,8°C"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoja_de_verificacion);

        //llenar el AutoCompletar
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,language);
        AutoCompleteTextView actv= (AutoCompleteTextView)findViewById(R.id.autoEmpresa);
        actv.setThreshold(1);
        actv.setAdapter(adapter);

        ArrayAdapter<String> vacunacion = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,TemperaturaVacunacion);
        AutoCompleteTextView actv2= (AutoCompleteTextView)findViewById(R.id.autoTemperaturaVacunacion);
        actv2.setThreshold(1);
        actv2.setAdapter(vacunacion);

        ArrayAdapter<String> Humedad = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,HumedadVacunacion);
        AutoCompleteTextView actv3= (AutoCompleteTextView)findViewById(R.id.autoHumedadVacunacion);
        actv3.setThreshold(1);
        actv3.setAdapter(Humedad);
    }



     public void guardar(String title, String message, String cliente, String id_pedido, String nombre, String latitud, String longitud, String tipo, String fecha, String hora) {
        SQLite admin = new SQLite(this, "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("titulo", title);
        registro.put("mensaje", message);
        registro.put("cliente", cliente);
        registro.put("nombre", nombre);
        registro.put("tipo", tipo);
        registro.put("fecha", fecha);
        registro.put("hora", hora);
        registro.put("latitud", latitud);
        registro.put("longitud", longitud);
        registro.put("id_pedido", id_pedido);
        bd.insert("notificacion", null, registro);
        bd.close();

    }
}
