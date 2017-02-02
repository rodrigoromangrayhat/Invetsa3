package com.grayhatcorp.invetsa.invetsa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class SistemaIntegralMonitoreo extends AppCompatActivity {
    String[] language ={"Gray Hat Corp","Invetsa","Sofia","Delicia"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_integral_monitoreo);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,language);
        AutoCompleteTextView actv= (AutoCompleteTextView)findViewById(R.id.autoEmpresa);
        actv.setThreshold(1);
        actv.setAdapter(adapter);
    }
}
