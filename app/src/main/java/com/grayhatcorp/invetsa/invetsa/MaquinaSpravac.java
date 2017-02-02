package com.grayhatcorp.invetsa.invetsa;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.grayhatcorp.invetsa.invetsa.Base_de_datos.SQLite;

public class MaquinaSpravac extends AppCompatActivity implements View.OnClickListener {
    ArrayAdapter<String> adapter;

    AutoCompleteTextView autoCompania,autoMaquina,autoDireccion;
    EditText encargador,hora_ingreso,hora_salida,ultima_visita,fecha;
    EditText observacion_inspeccion,piezas_cambiadas_inspeccion,observacion_funcionamiento,frecuencia_uso_funcionamiento,observacion_desinfeccion,cantidad_aves_desinfeccion;


    RadioButton bueno_cubierta,regular_cubierta,malo_cubierta;
    RadioButton bueno_foski,regular_foski,malo_foski;
    RadioButton bueno_seguro_foski,regular_seguro_foski,malo_seguro_foski;
    RadioButton bueno_mesa,regular_mesa,malo_mesa;
    RadioButton bueno_seguro,regular_seguro,malo_seguro;
    RadioButton bueno_garruchas,regular_garruchas,malo_garruchas;
    RadioButton bueno_ensamblaje,regular_ensamblaje,malo_ensamblaje;
    RadioButton bueno_regulador_aire,regular_regulador_aire,malo_regulador_aire;
    RadioButton bueno_ensamblaje_jeringa,regular_ensamblaje_jeringa,malo_ensamblaje_jeringa;
    RadioButton bueno_manometro,regular_manometro,malo_manometro;
    RadioButton bueno_base_aluminio,regular_base_aluminio,malo_base_aluminio;
    RadioButton bueno_conector_rapido_5,regular_conector_rapido_5,malo_conector_rapido_5;
    RadioButton bueno_valvula_control,regular_valvula_control,malo_valvula_control;
    RadioButton bueno_conector_hembra,regular_conector_hembra,malo_conector_hembra;
    RadioButton bueno_repuesto_valvula,regular_repuesto_valvula,malo_repuesto_valvula;
    RadioButton bueno_conector_macho,regular_conector_macho,malo_conector_macho;
    RadioButton bueno_acopladura_rapida,regular_acopladura_rapida,malo_acopladura_rapida;
    RadioButton bueno_meniscos_calibradores,regular_meniscos_calibradores,malo_meniscos_calibradores;
    RadioButton bueno_seguro_estructura,regular_seguro_estructura,malo_seguro_estructura;
    RadioButton bueno_cilindro_fuerza,regular_cilindro_fuerza,malo_cilindro_fuerza;
    RadioButton bueno_jeringa_descartables,regular_jeringa_descartables,malo_jeringa_descartables;
    RadioButton bueno_sub_placa_asociable,regular_sub_placa_asociable,malo_sub_placa_asociable;
    RadioButton bueno_tuberia_polyvinico,regular_tuberia_polyvinico,malo_tuberia_polyvinico;
    RadioButton bueno_sub_placa_sencilla,regular_sub_placa_sencilla,malo_sub_placa_sencilla;
    RadioButton bueno_tuberia_pequeña,regular_tuberia_pequeña,malo_tuberia_pequeña;
    RadioButton bueno_frasco_nalgene,regular_frasco_nalgene,malo_frasco_nalgene;
    RadioButton bueno_tuberia_teflon,regular_tuberia_teflon,malo_tuberia_teflon;
    RadioButton bueno_acrilico_fijadores,regular_acrilico_fijadores,malo_acrilico_fijadores;
    RadioButton bueno_tuberia_latex,regular_tuberia_latex,malo_tuberia_latex;
    RadioButton bueno_ensamblaje_boquilla,regular_ensamblaje_boquilla,malo_ensamblaje_boquilla;
    RadioButton bueno_acopladora_90,regular_acopladora_90,malo_acopladora_90;
    RadioButton bueno_motor,regular_motor,malo_motor;
    RadioButton bueno_acopladora_tee,regular_acopladora_tee,malo_acopladora_tee;
    RadioButton bueno_boquilla,regular_boquilla,malo_boquilla;
    RadioButton bueno_reguladora_aire_compresora,regular_reguladora_aire_compresora,malo_reguladora_aire_compresora;
    RadioButton bueno_sostenedor_boquilla,regular_sostenedor_boquilla,malo_sostenedor_boquilla;
    RadioButton bueno_tanque_compresora,regular_tanque_compresora,malo_tanque_compresora;
    RadioButton bueno_clan_adhesivo,regular_clan_adhesivo,malo_clan_adhesivo;
    RadioButton bueno_ruedas,regular_ruedas,malo_ruedas;
    RadioButton bueno_logo_spravac,regular_logo_spravac,malo_logo_spravac;
    RadioButton bueno_cables_electricos,regular_cables_electricos,malo_cables_electricos;
    RadioButton bueno_cortinas,regular_cortinas,malo_cortinas;
    RadioButton bueno_valvula_purgar,regular_valvula_purgar,malo_valvula_purgar;
    RadioButton bueno_varillas,regular_varillas,malo_varillas;
    RadioButton bueno_manguera,regular_manguera,malo_manguera;
    RadioButton bueno_nivelacion,malo_nivelacion;
    RadioButton bueno_presion_compresora,malo_presion_compresora;
    RadioButton bueno_presion_maquina,malo_presion_maquina;
    RadioButton bueno_retiro_cajas,malo_retiro_cajas;
    RadioButton bueno_activacion_foski,malo_activacion_foski;
    RadioButton bueno_boquillas,malo_boquillas;
    RadioButton bueno_dispersion,malo_dispersion;
    RadioButton bueno_calibracion,malo_calibracion;
    RadioButton bueno_materiales_utlizados,malo_materiales_utlizados;
    RadioButton bueno_cambio,malo_cambio;
    RadioButton bueno_enjuague,malo_enjuague;
    RadioButton bueno_esterilizado,malo_esterilizado;
    RadioButton bueno_esterilizado_tuberia,malo_esterilizado_tuberia;
    RadioButton bueno_esterilizado_boquilla,malo_esterilizado_boquilla;
    RadioButton bueno_secado,malo_secado;
    RadioButton bueno_proteccion,malo_proteccion;

    Button guardar,cancelar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maquina_spravac);
        autoCompania = (AutoCompleteTextView)findViewById(R.id.autoCompania);
        autoMaquina = (AutoCompleteTextView)findViewById(R.id.autoMaquina);
        autoDireccion=(AutoCompleteTextView)findViewById(R.id.autoDireccion);
        encargador=(EditText)findViewById(R.id.TextViewEncargado);
        hora_ingreso=(EditText)findViewById(R.id.TextViewHoradeIngreso);
        hora_salida=(EditText)findViewById(R.id.TextViewHoradeSalida);
        ultima_visita=(EditText)findViewById(R.id.TextViewUltimaVisita);
        fecha=(EditText)findViewById(R.id.TextViewFecha);

        observacion_inspeccion=(EditText)findViewById(R.id.txtObservaciones_inspeccion);
        piezas_cambiadas_inspeccion=(EditText)findViewById(R.id.txtPiezasCambiadas_inspeccion);
        observacion_funcionamiento=(EditText)findViewById(R.id.txtObservaciones_funcionamiento);
        frecuencia_uso_funcionamiento=(EditText)findViewById(R.id.txtPiezasFrecuenciadeUso_funcionamiento);
        observacion_desinfeccion=(EditText)findViewById(R.id.txtObservaciones_desinfeccion);
        cantidad_aves_desinfeccion=(EditText)findViewById(R.id.txtAvesVacunadas_desinfeccion);



        bueno_cubierta=(RadioButton)findViewById(R.id.BuenoCubierta);
        regular_cubierta=(RadioButton)findViewById(R.id.Regularcubierta);
        malo_cubierta=(RadioButton)findViewById(R.id.Malocubierta);

        bueno_foski=(RadioButton)findViewById(R.id.BuenoFoski);
        regular_foski=(RadioButton)findViewById(R.id.RegularFoski);
        malo_foski=(RadioButton)findViewById(R.id.MaloFoski);

        bueno_mesa=(RadioButton)findViewById(R.id.BuenoMesa);
        regular_mesa=(RadioButton)findViewById(R.id.RegularMesa);
        malo_mesa=(RadioButton)findViewById(R.id.MaloMesa);

        bueno_seguro=(RadioButton)findViewById(R.id.BuenoSeguroEstructura);
        regular_seguro=(RadioButton)findViewById(R.id.RegularSeguroEstructura);
        malo_seguro=(RadioButton)findViewById(R.id.MaloSeguroEstructura);

        bueno_seguro_foski=(RadioButton)findViewById(R.id.BuenoSeguro_foski);
        regular_seguro_foski=(RadioButton)findViewById(R.id.RegularSeguro_foski);
        malo_seguro_foski=(RadioButton)findViewById(R.id.MaloSeguro_foski);

        bueno_garruchas=(RadioButton)findViewById(R.id.BuenoGarruchas);
        regular_garruchas=(RadioButton)findViewById(R.id.RegularGarruchas);
        malo_garruchas=(RadioButton)findViewById(R.id.MaloGarruchas);

        bueno_ensamblaje=(RadioButton)findViewById(R.id.BuenoEnsamblaje);
        regular_ensamblaje=(RadioButton)findViewById(R.id.RegularEnsamblaje);
        malo_ensamblaje=(RadioButton)findViewById(R.id.MaloEnsamblaje);

        bueno_regulador_aire=(RadioButton)findViewById(R.id.BuenoReguladorAire);
        regular_regulador_aire=(RadioButton)findViewById(R.id.RegularReguladorAire);
        malo_regulador_aire=(RadioButton)findViewById(R.id.MaloReguladorAire);

        bueno_ensamblaje_jeringa=(RadioButton)findViewById(R.id.BuenoEmsanblajeJeringa);
        regular_ensamblaje_jeringa=(RadioButton)findViewById(R.id.RegularEmsanblajeJeringa);
        malo_ensamblaje_jeringa=(RadioButton)findViewById(R.id.MaloEmsanblajeJeringa);

        bueno_manometro=(RadioButton)findViewById(R.id.BuenoManometro);
        regular_manometro=(RadioButton)findViewById(R.id.RegularManometro);
        malo_manometro=(RadioButton)findViewById(R.id.MaloMAnometro);

        bueno_base_aluminio=(RadioButton)findViewById(R.id.BuenoBaseAluminio);
        regular_base_aluminio=(RadioButton)findViewById(R.id.RegularBaseAluminio);
        malo_base_aluminio=(RadioButton)findViewById(R.id.MaloBaseAluminio);

        bueno_conector_rapido_5=(RadioButton)findViewById(R.id.BuenoConectorRapido5);
        regular_conector_rapido_5=(RadioButton)findViewById(R.id.RegularConectorRapido5);
        malo_conector_rapido_5=(RadioButton)findViewById(R.id.MaloConectorRapido5);

        bueno_valvula_control=(RadioButton)findViewById(R.id.BuenoValvuladeControl);
        regular_valvula_control=(RadioButton)findViewById(R.id.RegularValvuladeControl);
        malo_valvula_control=(RadioButton)findViewById(R.id.MaloValvuladeControl);

        bueno_conector_hembra=(RadioButton)findViewById(R.id.BuenoConectorHembra);
        regular_conector_hembra=(RadioButton)findViewById(R.id.RegularConectorHembra);
        malo_conector_hembra=(RadioButton)findViewById(R.id.MaloConectorHembra);

        bueno_repuesto_valvula=(RadioButton)findViewById(R.id.BuenoRepuestodeValvula);
        regular_repuesto_valvula=(RadioButton)findViewById(R.id.RegularRepuestodeValvula);
        malo_repuesto_valvula=(RadioButton)findViewById(R.id.MaloRepuestodeValvula);

        bueno_repuesto_valvula=(RadioButton)findViewById(R.id.BuenoRepuestodeValvula);
        regular_repuesto_valvula=(RadioButton)findViewById(R.id.RegularRepuestodeValvula);
        malo_repuesto_valvula=(RadioButton)findViewById(R.id.MaloRepuestodeValvula);

        bueno_conector_macho=(RadioButton)findViewById(R.id.BuenoConectorMacho);
        regular_conector_macho=(RadioButton)findViewById(R.id.RegularConectorMacho);
        malo_conector_macho=(RadioButton)findViewById(R.id.MaloConectorMacho);

        bueno_acopladura_rapida=(RadioButton)findViewById(R.id.BuenoAcopladuraRapida);
        regular_acopladura_rapida=(RadioButton)findViewById(R.id.RegularAcopladuraRapida);
        malo_acopladura_rapida=(RadioButton)findViewById(R.id.MaloAcopladuraRapida);

        bueno_meniscos_calibradores=(RadioButton)findViewById(R.id.BuenoMeniscosCalibradores);
        regular_meniscos_calibradores=(RadioButton)findViewById(R.id.RegularMeniscosCalibradores);
        malo_meniscos_calibradores=(RadioButton)findViewById(R.id.MaloMeniscosCalibradores);

        bueno_seguro_estructura=(RadioButton)findViewById(R.id.BuenoSeguroEstructura);
        regular_seguro_estructura=(RadioButton)findViewById(R.id.RegularSeguroEstructura);
        malo_seguro_estructura=(RadioButton)findViewById(R.id.MaloSeguroEstructura);

        bueno_cilindro_fuerza=(RadioButton)findViewById(R.id.BuenoCilindroFuerza);
        regular_cilindro_fuerza=(RadioButton)findViewById(R.id.RegularCilindroFuerza);
        malo_cilindro_fuerza=(RadioButton)findViewById(R.id.MaloCilindroFuerza);

        bueno_jeringa_descartables=(RadioButton)findViewById(R.id.BuenoJeringasDescartables);
        regular_jeringa_descartables=(RadioButton)findViewById(R.id.RegularJeringasDescartables);
        malo_jeringa_descartables=(RadioButton)findViewById(R.id.MaloJeringasDescartables);

        bueno_sub_placa_asociable=(RadioButton)findViewById(R.id.BuenoSUBPLACAASOCIABLE);
        regular_sub_placa_asociable=(RadioButton)findViewById(R.id.RegularSUBPLACAASOCIABLE);
        malo_sub_placa_asociable=(RadioButton)findViewById(R.id.MaloSUBPLACAASOCIABLE);

        bueno_tuberia_polyvinico=(RadioButton)findViewById(R.id.BuenoTUBERIADEPOLYVINICO);
        regular_tuberia_polyvinico=(RadioButton)findViewById(R.id.RegularTUBERIADEPOLYVINICO);
        malo_tuberia_polyvinico=(RadioButton)findViewById(R.id.MaloTUBERIADEPOLYVINICO);

        bueno_sub_placa_sencilla=(RadioButton)findViewById(R.id.BuenoSUBPLACASENCILLA);
        regular_sub_placa_sencilla=(RadioButton)findViewById(R.id.RegularSUBPLACASENCILLA);
        malo_sub_placa_sencilla=(RadioButton)findViewById(R.id.MaloSUBPLACASENCILLA);

        bueno_tuberia_pequeña=(RadioButton)findViewById(R.id.BuenoTUBERIAPEQUEÑA);
        regular_tuberia_pequeña=(RadioButton)findViewById(R.id.RegularTUBERIAPEQUEÑA);
        malo_tuberia_pequeña=(RadioButton)findViewById(R.id.MaloTUBERIAPEQUEÑA);

        bueno_frasco_nalgene=(RadioButton)findViewById(R.id.BuenoFRASCONALGENE);
        regular_frasco_nalgene=(RadioButton)findViewById(R.id.RegularFRASCONALGENE);
        malo_frasco_nalgene=(RadioButton)findViewById(R.id.MaloFRASCONALGENE);

        bueno_tuberia_teflon=(RadioButton)findViewById(R.id.BuenoTUBERIATEFLON);
        regular_tuberia_teflon=(RadioButton)findViewById(R.id.RegularTUBERIATEFLON);
        malo_tuberia_teflon=(RadioButton)findViewById(R.id.MaloTUBERIATEFLON);

        bueno_acrilico_fijadores=(RadioButton)findViewById(R.id.BuenoACRILICOSFIJADORES);
        regular_acrilico_fijadores=(RadioButton)findViewById(R.id.RegularACRILICOSFIJADORES);
        malo_acrilico_fijadores=(RadioButton)findViewById(R.id.MaloACRILICOSFIJADORES);

        bueno_tuberia_latex=(RadioButton)findViewById(R.id.BuenoTUBERIALATEX);
        regular_tuberia_latex=(RadioButton)findViewById(R.id.RegularTUBERIALATEX);
        malo_tuberia_latex=(RadioButton)findViewById(R.id.MaloTUBERIALATEX);

        bueno_ensamblaje_boquilla=(RadioButton)findViewById(R.id.BuenoENSAMBLAJEDEBOQUILLA);
        regular_ensamblaje_boquilla=(RadioButton)findViewById(R.id.RegularENSAMBLAJEDEBOQUILLA);
        malo_ensamblaje_boquilla=(RadioButton)findViewById(R.id.MaloENSAMBLAJEDEBOQUILLA);

        bueno_acopladora_90=(RadioButton)findViewById(R.id.BuenoACOPLADORA90);
        regular_acopladora_90=(RadioButton)findViewById(R.id.RegularACOPLADORA90);
        malo_acopladora_90=(RadioButton)findViewById(R.id.MaloACOPLADORA90);

        bueno_motor=(RadioButton)findViewById(R.id.BuenoMOTOR);
        regular_motor=(RadioButton)findViewById(R.id.RegularMOTOR);
        malo_motor=(RadioButton)findViewById(R.id.MaloMOTOR);

        bueno_acopladora_tee=(RadioButton)findViewById(R.id.BuenoACOPLADORATEE);
        regular_acopladora_tee=(RadioButton)findViewById(R.id.RegularACOPLADORATEE);
        malo_acopladora_tee=(RadioButton)findViewById(R.id.MaloACOPLADORATEE);


        bueno_boquilla=(RadioButton)findViewById(R.id.BuenoBOQUILLA);
        regular_boquilla=(RadioButton)findViewById(R.id.RegularBOQUILLA);
        malo_boquilla=(RadioButton)findViewById(R.id.MaloBOQUILLA);

        bueno_reguladora_aire_compresora=(RadioButton)findViewById(R.id.BuenoREGULADORDEAIRECOMPRESORA);
        regular_reguladora_aire_compresora=(RadioButton)findViewById(R.id.RegularREGULADORDEAIRECOMPRESORA);
        malo_reguladora_aire_compresora=(RadioButton)findViewById(R.id.MaloREGULADORDEAIRECOMPRESORA);

        bueno_sostenedor_boquilla=(RadioButton)findViewById(R.id.BuenoSOSTENEDORDEBOQUILLA);
        regular_sostenedor_boquilla=(RadioButton)findViewById(R.id.RegularSOSTENEDORDEBOQUILLA);
        malo_sostenedor_boquilla=(RadioButton)findViewById(R.id.MaloSOSTENEDORDEBOQUILLA);

        bueno_tanque_compresora=(RadioButton)findViewById(R.id.BuenoTANQUECOMPRESORA);
        regular_tanque_compresora=(RadioButton)findViewById(R.id.RegularTANQUECOMPRESORA);
        malo_tanque_compresora=(RadioButton)findViewById(R.id.MaloTANQUECOMPRESORA);

        bueno_clan_adhesivo=(RadioButton)findViewById(R.id.BuenoClanAdhesivo);
        regular_clan_adhesivo=(RadioButton)findViewById(R.id.RegularClanAdhesivo);
        malo_clan_adhesivo=(RadioButton)findViewById(R.id.MaloClanAdhesivo);

        bueno_ruedas=(RadioButton)findViewById(R.id.BuenoRUEDAS);
        regular_ruedas=(RadioButton)findViewById(R.id.RegularRUEDAS);
        malo_ruedas=(RadioButton)findViewById(R.id.MaloRUEDAS);

        bueno_logo_spravac=(RadioButton)findViewById(R.id.BuenoLogoSpravac);
        regular_logo_spravac=(RadioButton)findViewById(R.id.RegularLogoSpravac);
        malo_logo_spravac=(RadioButton)findViewById(R.id.MaloLogoSpravac);

        bueno_cables_electricos=(RadioButton)findViewById(R.id.BuenoCableselectricos);
        regular_cables_electricos=(RadioButton)findViewById(R.id.RegularCableselectricos);
        malo_cables_electricos=(RadioButton)findViewById(R.id.MaloCableselectricos);

        bueno_cortinas=(RadioButton)findViewById(R.id.BuenoCORTINAS);
        regular_cortinas=(RadioButton)findViewById(R.id.RegularCORTINAS);
        malo_cortinas=(RadioButton)findViewById(R.id.MaloCORTINAS);

        bueno_valvula_purgar=(RadioButton)findViewById(R.id.BuenoValvulaPurgar);
        regular_valvula_purgar=(RadioButton)findViewById(R.id.RegularValvulaPurgar);
        malo_valvula_purgar=(RadioButton)findViewById(R.id.MaloValvulaPurgar);

        bueno_varillas=(RadioButton)findViewById(R.id.BuenoVARILLAS);
        regular_varillas=(RadioButton)findViewById(R.id.RegularVARILLAS);
        malo_varillas=(RadioButton)findViewById(R.id.MaloVARILLAS);

        bueno_manguera=(RadioButton)findViewById(R.id.BuenoMANGUERA);
        regular_manguera=(RadioButton)findViewById(R.id.RegularMANGUERA);
        malo_manguera=(RadioButton)findViewById(R.id.MaloMANGUERA);

        bueno_nivelacion=(RadioButton)findViewById(R.id.BuenoNivelacion);
        malo_nivelacion=(RadioButton)findViewById(R.id.MaloNivelacion);

        bueno_presion_compresora=(RadioButton)findViewById(R.id.BuenoPRESIONDECOMPRESORA);
        malo_presion_compresora=(RadioButton)findViewById(R.id.MaloPRESIONDECOMPRESORA);

        bueno_presion_maquina=(RadioButton)findViewById(R.id.BuenoPRESIONDEMAQUINA);
        malo_presion_maquina=(RadioButton)findViewById(R.id.MaloPRESIONDEMAQUINA);

        bueno_retiro_cajas=(RadioButton)findViewById(R.id.BuenoRetirodeCajas);
        malo_retiro_cajas=(RadioButton)findViewById(R.id.MaloRetirodeCajas);

        bueno_activacion_foski=(RadioButton)findViewById(R.id.BuenoACTIVACIONDEFOSKI);
        malo_activacion_foski=(RadioButton)findViewById(R.id.MaloACTIVACIONDEFOSKI);

        bueno_boquillas=(RadioButton)findViewById(R.id.BuenoBOQUILLAS);
        malo_boquillas=(RadioButton)findViewById(R.id.MaloBOQUILLAS);

        bueno_dispersion=(RadioButton)findViewById(R.id.BuenoDISPERSION);
        malo_dispersion=(RadioButton)findViewById(R.id.MaloDISPERSION);

        bueno_calibracion=(RadioButton)findViewById(R.id.BuenoCALIBRACION);
        malo_calibracion=(RadioButton)findViewById(R.id.MaloCALIBRACION);

        bueno_materiales_utlizados=(RadioButton)findViewById(R.id.BuenoMATERIALESUTILIZADOS);
        malo_materiales_utlizados=(RadioButton)findViewById(R.id.MaloMATERIALESUTILIZADOS);

        bueno_cambio=(RadioButton)findViewById(R.id.BuenoCAMBIO);
        malo_cambio=(RadioButton)findViewById(R.id.MaloCAMBIO);

        bueno_enjuague=(RadioButton)findViewById(R.id.BuenoEnjuague);
        malo_enjuague=(RadioButton)findViewById(R.id.MaloEnjuague);

        bueno_esterilizado=(RadioButton)findViewById(R.id.BuenoEsterilizado);
        malo_esterilizado=(RadioButton)findViewById(R.id.MaloEsterilizado);

        bueno_esterilizado_tuberia=(RadioButton)findViewById(R.id.BuenoESTERILIZADODETUBERIAS);
        malo_esterilizado_tuberia=(RadioButton)findViewById(R.id.MaloESTERILIZADODETUBERIAS);

        bueno_esterilizado_boquilla=(RadioButton)findViewById(R.id.BuenoESTERILIZADODEBOQUILLAS);
        malo_esterilizado_boquilla=(RadioButton)findViewById(R.id.MaloESTERILIZADODEBOQUILLAS);

        bueno_secado=(RadioButton)findViewById(R.id.BuenoSECADO);
        malo_secado=(RadioButton)findViewById(R.id.MaloSECADO);

        bueno_proteccion=(RadioButton)findViewById(R.id.BuenoPROTECCION);
        malo_proteccion=(RadioButton)findViewById(R.id.MaloPROTECCION);

        guardar=(Button)findViewById(R.id.Guardar);
        cancelar=(Button)findViewById(R.id.Cancelar);


        cargar_compania_en_la_lista();
        cargar_maquina_en_la_lista();

        guardar.setOnClickListener(this);
        cancelar.setOnClickListener(this);
    }

    private void cargar_compania_en_la_lista()
    {
        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select * from compania ", null);
        String []companias=new String[fila.getCount()];
        int i=0;
        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)

            do {

                String id=fila.getString(0);
                String nombre=fila.getString(1);
                companias[i]=nombre;
                i++;
            } while(fila.moveToNext());

        } else
        {

        }
        bd.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, companias);
        autoCompania.setAdapter(adapter);
    }
    private void cargar_maquina_en_la_lista()
    {
        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select * from maquina ", null);
        String []maquina=new String[fila.getCount()];
        int i=0;
        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)

            do {
                String codigo=fila.getString(1);
                maquina[i]=codigo;
                i++;
            } while(fila.moveToNext());

        } else
        {

        }
        bd.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, maquina);
        autoMaquina.setAdapter(adapter);
    }


    private int id_maquina_ultimo()
    {int id=-1;
        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select max(id) from maquina ", null);
        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)


            String codigo= fila.getString(0);
            if(codigo.equals("")==false && codigo.equals("0")==false )
            {
                id=Integer.parseInt(codigo);
            }

        }
        bd.close();
        return id;
    }
    private int id_maquina_por_codigo(String texto)
    {int id=-1;
        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select id from maquina where codigo='"+texto+"'", null);
        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)


            String codigo= fila.getString(0);
            if(codigo.equals("")==false && codigo.equals("0")==false )
            {
                id=Integer.parseInt(codigo);
            }

        }
        bd.close();
        return id;
    }
    private int id_compania_por_nombre(String texto)
    {int id=-1;
        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select id from compania where nombre='"+texto+"'", null);
        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)


            String codigo= fila.getString(0);
            if(codigo.equals("")==false && codigo.equals("0")==false )
            {
                id=Integer.parseInt(codigo);
            }

        }
        bd.close();
        return id;
    }
    private int id_inspeccion_visual()
    {int id=0;
        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select max(id) from inspeccion_visual ", null);
        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)


            String codigo= fila.getString(0);
            try {
                if (codigo.equals("") == false && codigo.equals("0") == false) {
                    id = Integer.parseInt(codigo);
                }
            }catch (Exception e)
            {
                Log.e("id inspeccion visual",""+e);
            }

        }
        bd.close();
        return id;
    }
    private int id_inspeccion_funcionamiento()
    {int id=0;
        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select max(id) from inspeccion_funcionamiento ", null);
        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)


            String codigo= fila.getString(0);
            try{
                if(codigo.equals("")==false && codigo.equals("0")==false )
                {
                    id=Integer.parseInt(codigo);
                }
            }catch (Exception e)
            {
                Log.e("id inspeccion",""+e);
            }

        }
        bd.close();
        return id;
    }
    private int id_servicio_mantenimiento()
    {int id=0;
        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select id from servicio_mantenimiento order by id desc ", null);
        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)


            String codigo= fila.getString(0);
            try {
                if (codigo.equals("") == false && codigo.equals("0") == false && codigo.equals("null") == false) {
                    id = Integer.parseInt(codigo);
                }
            }catch (Exception e)
            {
                Log.e("id mantenimiento",""+e);
            }

        }
        bd.close();
        return id;
    }
    public void guardar_servicio_mantenimiento(int id,String fecha,String hora_ingreso,String hora_salida,String codigo,String revision,String firma_jefe,String firma_invetsa,String id_maquina,String id_tecnico,String id_compania)
    {


        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        try {
            registro.put("id", String.valueOf(id));
            registro.put("fecha", fecha);
            registro.put("hora_ingreso", hora_ingreso);
            registro.put("hora_salidas", hora_salida);
            registro.put("codigo", codigo);
            registro.put("revision", revision);
            registro.put("firma_jefe_planta", firma_jefe);
            registro.put("firma_invetsa", firma_invetsa);
            registro.put("id_maquina", id_maquina);
            registro.put("id_tecnico", id_tecnico);
            registro.put("id_compania", id_compania);
            bd.insert("servicio_mantenimiento", null, registro);

        }catch (Exception e)
        {
            Log.e("sql",""+e);
        }

        bd.close();
    }

    public void guardar_inspeccion_visual(int id,String observaciones,String piesas_cambiadas,int id_servicio)
    {


        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();

        registro.put("id",String.valueOf(id));
        registro.put("observaciones", observaciones);
        registro.put("piesas_cambiadas", piesas_cambiadas);
        registro.put("id_servicio", String.valueOf(id_servicio));
        bd.insert("inspeccion_visual", null, registro);

        bd.close();
    }

    public void guardar_detalle_inspeccion_visual(int id,int id_inspeccion, String codigo,String descripcion,int estado)
    {
        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();

        registro.put("id",String.valueOf(id));
        registro.put("id_inspeccion", String.valueOf(id_inspeccion));
        registro.put("codigo", codigo);
        registro.put("descripcion", descripcion);
        registro.put("estado",String.valueOf(estado));
        bd.insert("detalle_inspeccion_visual", null, registro);

        bd.close();
    }

    public void guardar_inspeccion_funcionamiento(int id,String observaciones,String frecuencia,int id_servicio)
    {
        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();

        registro.put("id",String.valueOf(id));
        registro.put("observaciones", observaciones);
        registro.put("frecuencia_de_uso", frecuencia);
        registro.put("id_servicio", String.valueOf(id_servicio));
        bd.insert("inspeccion_funcionamiento", null, registro);

        bd.close();
    }

    public void guardar_detalle_inspeccion_funcionamiento(int id,int id_inspeccion, String criterio_evaluacion,int estado)
    {
        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();

        registro.put("id",String.valueOf(id));
        registro.put("id_inspeccion", String.valueOf(id_inspeccion));
        registro.put("criterio_evaluacion", criterio_evaluacion);
        registro.put("estado",String.valueOf(estado));
        bd.insert("detalle_inspeccion_funcionamiento", null, registro);
        bd.close();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.Guardar:
                int id_servicio=id_servicio_mantenimiento()+1;
                int id_maquina=id_maquina_por_codigo(autoMaquina.getText().toString());

                int id_compania=id_compania_por_nombre(autoCompania.getText().toString());

                //id TECNICO...
                int id_tecnico=1;
                if(id_servicio != -1 && id_maquina!=-1 && id_compania!=-1 && id_tecnico!=-1)
                {

                    guardar_servicio_mantenimiento(id_servicio,fecha.getText().toString(),hora_ingreso.getText().toString(),hora_salida.getText().toString(),"P50","1","firmas_jefe","firma_invetsa",String.valueOf(id_maquina),String.valueOf(id_tecnico),String.valueOf(id_compania));

                    int id_inspeccion=id_inspeccion_visual()+1;
                    guardar_inspeccion_visual(id_inspeccion,observacion_inspeccion.getText().toString(),piezas_cambiadas_inspeccion.getText().toString(),id_servicio);

                    guardar_detalle_inspeccion_visual(1,id_inspeccion,"SV-2001","CUBIERTA DE ACRILICO",get_estado(bueno_cubierta.isChecked(),regular_cubierta.isChecked(),malo_cubierta.isChecked()));
                    guardar_detalle_inspeccion_visual(2,id_inspeccion,"SV-602","MESA DE METAL",get_estado(bueno_mesa.isChecked(),regular_mesa.isChecked(),malo_mesa.isChecked()));
                    guardar_detalle_inspeccion_visual(3,id_inspeccion,"S/CODIGO","GARRUCHAS",get_estado(bueno_garruchas.isChecked(),regular_garruchas.isChecked(),malo_garruchas.isChecked()));
                    guardar_detalle_inspeccion_visual(4,id_inspeccion,"SV-100","ENSAMBLAJE DE JERINGA",get_estado(bueno_ensamblaje_jeringa.isChecked(),regular_ensamblaje_jeringa.isChecked(),malo_ensamblaje_jeringa.isChecked()));
                    guardar_detalle_inspeccion_visual(5,id_inspeccion,"SV-101","BASE DE ALUMINIO",get_estado(bueno_base_aluminio.isChecked(),regular_base_aluminio.isChecked(),malo_base_aluminio.isChecked()));
                    guardar_detalle_inspeccion_visual(6,id_inspeccion,"SV-106","VALVULA DE CONTROL",get_estado(bueno_valvula_control.isChecked(),regular_valvula_control.isChecked(),malo_valvula_control.isChecked()));
                    guardar_detalle_inspeccion_visual(7,id_inspeccion,"SV-1378","REPTS. DE VALVULA DE CONTROL",get_estado(bueno_repuesto_valvula.isChecked(),regular_repuesto_valvula.isChecked(),malo_repuesto_valvula.isChecked()));
                    guardar_detalle_inspeccion_visual(8,id_inspeccion,"SV-934","ACOPLADURA RAPIDA DE VALVULA",get_estado(bueno_acopladura_rapida.isChecked(),regular_acopladura_rapida.isChecked(),malo_acopladura_rapida.isChecked()));
                    guardar_detalle_inspeccion_visual(9,id_inspeccion,"SV-104","SEGURO",get_estado(bueno_seguro.isChecked(),regular_seguro.isChecked(),malo_seguro.isChecked()));
                    guardar_detalle_inspeccion_visual(10,id_inspeccion,"SV-1344","CILINDRO DE FUERZA",get_estado(bueno_cilindro_fuerza.isChecked(),regular_cilindro_fuerza.isChecked(),malo_cilindro_fuerza.isChecked()));
                    guardar_detalle_inspeccion_visual(11,id_inspeccion,"5708","SUBPLACA ASOCIABLE",get_estado(bueno_sub_placa_asociable.isChecked(),regular_sub_placa_asociable.isChecked(),malo_sub_placa_asociable.isChecked()));
                    guardar_detalle_inspeccion_visual(12,id_inspeccion,"5709","SUBPLACA SENCILLA",get_estado(bueno_sub_placa_sencilla.isChecked(),regular_sub_placa_sencilla.isChecked(),malo_sub_placa_sencilla.isChecked()));
                    guardar_detalle_inspeccion_visual(13,id_inspeccion,"SV-2008","FRASCO NALGENE",get_estado(bueno_frasco_nalgene.isChecked(),regular_frasco_nalgene.isChecked(),malo_frasco_nalgene.isChecked()));
                    guardar_detalle_inspeccion_visual(14,id_inspeccion,"SV-607","ACRILICOS FIJADORES DE FRASCOS",get_estado(bueno_acrilico_fijadores.isChecked(),regular_acrilico_fijadores.isChecked(),malo_acrilico_fijadores.isChecked()));
                    guardar_detalle_inspeccion_visual(15,id_inspeccion,"SV-2002","ENSAMBLAJE DE BOQUILLAS",get_estado(bueno_ensamblaje_boquilla.isChecked(),regular_ensamblaje_boquilla.isChecked(),malo_ensamblaje_boquilla.isChecked()));
                    guardar_detalle_inspeccion_visual(16,id_inspeccion,"SV-1030","ACOPLADORA 90",get_estado(bueno_acopladora_90.isChecked(),regular_acopladora_90.isChecked(),malo_acopladora_90.isChecked()));
                    guardar_detalle_inspeccion_visual(17,id_inspeccion,"SV-933","ACOPLADORA TEE",get_estado(bueno_acopladora_tee.isChecked(),regular_acopladora_tee.isChecked(),malo_acopladora_tee.isChecked()));
                    guardar_detalle_inspeccion_visual(18,id_inspeccion,"SV-936","BOQUILLAS",get_estado(bueno_boquilla.isChecked(),regular_boquilla.isChecked(),malo_boquilla.isChecked()));
                    guardar_detalle_inspeccion_visual(19,id_inspeccion,"SV-611","SOSTENEDOR DE BOQUILLA",get_estado(bueno_sostenedor_boquilla.isChecked(),regular_sostenedor_boquilla.isChecked(),malo_sostenedor_boquilla.isChecked()));
                    guardar_detalle_inspeccion_visual(20,id_inspeccion,"SV-608","CLAMP. ADHESIVOS DE 1/4",get_estado(bueno_clan_adhesivo.isChecked(),regular_clan_adhesivo.isChecked(),malo_clan_adhesivo.isChecked()));
                    guardar_detalle_inspeccion_visual(21,id_inspeccion,"SV-609","LOGO DE SPRA-VAC",get_estado(bueno_logo_spravac.isChecked(),regular_logo_spravac.isChecked(),malo_logo_spravac.isChecked()));
                    guardar_detalle_inspeccion_visual(22,id_inspeccion,"SV-605","CORTINAS",get_estado(bueno_cortinas.isChecked(),regular_cortinas.isChecked(),malo_cortinas.isChecked()));
                    guardar_detalle_inspeccion_visual(23,id_inspeccion,"SV-606","VARILLAS",get_estado(bueno_varillas.isChecked(),regular_varillas.isChecked(),malo_varillas.isChecked()));
                    guardar_detalle_inspeccion_visual(24,id_inspeccion,"SV-2011","FOSKI SWITCH",get_estado(bueno_foski.isChecked(),regular_foski.isChecked(),malo_foski.isChecked()));
                    guardar_detalle_inspeccion_visual(25,id_inspeccion,"SV-1139","SEGURO DE FOSKI",get_estado(bueno_seguro_foski.isChecked(),regular_seguro_foski.isChecked(),malo_seguro_foski.isChecked()));
                    guardar_detalle_inspeccion_visual(26,id_inspeccion,"SV-2004","ENSAMBLAJE FILTRO REGULADOR",get_estado(bueno_ensamblaje.isChecked(),regular_ensamblaje.isChecked(),malo_ensamblaje.isChecked()));
                    guardar_detalle_inspeccion_visual(27,id_inspeccion,"SV-809","REGULADOR DE AIRE",get_estado(bueno_regulador_aire.isChecked(),regular_regulador_aire.isChecked(),malo_regulador_aire.isChecked()));
                    guardar_detalle_inspeccion_visual(28,id_inspeccion,"SV-810","MANOMETRO",get_estado(bueno_manometro.isChecked(),regular_manometro.isChecked(),malo_manometro.isChecked()));
                    guardar_detalle_inspeccion_visual(29,id_inspeccion,"S720","CONECTOR RAPIDO 5/32",get_estado(bueno_conector_rapido_5.isChecked(),regular_conector_rapido_5.isChecked(),malo_conector_rapido_5.isChecked()));
                    guardar_detalle_inspeccion_visual(30,id_inspeccion,"SV-817","CONECTOR RAPIDO HEMBRA",get_estado(bueno_conector_hembra.isChecked(),regular_conector_hembra.isChecked(),malo_conector_hembra.isChecked()));
                    guardar_detalle_inspeccion_visual(31,id_inspeccion,"SV-818","CONECTOR RAPIDO MACHO",get_estado(bueno_conector_macho.isChecked(),regular_conector_macho.isChecked(),malo_conector_macho.isChecked()));
                    guardar_detalle_inspeccion_visual(32,id_inspeccion,"SV-1163","MENISCO CALIBRADOR",get_estado(bueno_meniscos_calibradores.isChecked(),regular_meniscos_calibradores.isChecked(),malo_meniscos_calibradores.isChecked()));
                    guardar_detalle_inspeccion_visual(33,id_inspeccion,"5083","JERINGA DESCARTABLE",get_estado(bueno_jeringa_descartables.isChecked(),regular_jeringa_descartables.isChecked(),malo_jeringa_descartables.isChecked()));
                    guardar_detalle_inspeccion_visual(34,id_inspeccion,"5441","TUBERIA DE POLYVINILO",get_estado(bueno_tuberia_polyvinico.isChecked(),regular_tuberia_polyvinico.isChecked(),malo_tuberia_polyvinico.isChecked()));
                    guardar_detalle_inspeccion_visual(35,id_inspeccion,"3520","TUBERIA PEQUEÑA",get_estado(bueno_tuberia_pequeña.isChecked(),regular_tuberia_pequeña.isChecked(),malo_tuberia_pequeña.isChecked()));
                    guardar_detalle_inspeccion_visual(36,id_inspeccion,"SV-1110","TUBERIA DE TEFLON",get_estado(bueno_tuberia_teflon.isChecked(),regular_tuberia_teflon.isChecked(),malo_tuberia_teflon.isChecked()));
                    guardar_detalle_inspeccion_visual(37,id_inspeccion,"SV-1115","TUBERIA LATEX",get_estado(bueno_tuberia_latex.isChecked(),regular_tuberia_latex.isChecked(),malo_tuberia_latex.isChecked()));
                    guardar_detalle_inspeccion_visual(38,id_inspeccion,"","MOTOR",get_estado(bueno_motor.isChecked(),regular_motor.isChecked(),malo_motor.isChecked()));
                    guardar_detalle_inspeccion_visual(39,id_inspeccion,"","MANOMETRO",get_estado(bueno_manometro.isChecked(),regular_manometro.isChecked(),malo_manometro.isChecked()));
                    guardar_detalle_inspeccion_visual(40,id_inspeccion,"","REGULADOR DE AIRE",get_estado(bueno_reguladora_aire_compresora.isChecked(),regular_reguladora_aire_compresora.isChecked(),malo_reguladora_aire_compresora.isChecked()));
                    guardar_detalle_inspeccion_visual(41,id_inspeccion,"","TANQUE DE COMPRESORA",get_estado(bueno_tanque_compresora.isChecked(),regular_tanque_compresora.isChecked(),malo_tanque_compresora.isChecked()));
                    guardar_detalle_inspeccion_visual(42,id_inspeccion,"","RUEDAS",get_estado(bueno_ruedas.isChecked(),regular_ruedas.isChecked(),malo_ruedas.isChecked()));
                    guardar_detalle_inspeccion_visual(43,id_inspeccion,"","CABLES ELECTRICOS",get_estado(bueno_cables_electricos.isChecked(),regular_cables_electricos.isChecked(),malo_cables_electricos.isChecked()));
                    guardar_detalle_inspeccion_visual(44,id_inspeccion,"","VALVULA DE PURGAR",get_estado(bueno_valvula_purgar.isChecked(),regular_valvula_purgar.isChecked(),malo_valvula_purgar.isChecked()));
                    guardar_detalle_inspeccion_visual(45,id_inspeccion,"","MANGUERA",get_estado(bueno_manguera.isChecked(),regular_manguera.isChecked(),malo_manguera.isChecked()));


                    ///REGISTRO DE INSPECCION E FUNCIONAMIENTO
                    int id_funcionamiento=id_inspeccion_funcionamiento()+1;
                    guardar_inspeccion_funcionamiento(id_funcionamiento,observacion_funcionamiento.getText().toString(),frecuencia_uso_funcionamiento.getText().toString(),id_servicio);

                    //REGISTO DE LOS DETALLES DE INSPECCION EL  FUNCIONAMIENTO,
                    guardar_detalle_inspeccion_funcionamiento(1,id_funcionamiento,"NIVELACION DE LA MAQUINA",get_estado(bueno_nivelacion.isChecked(),false,malo_nivelacion.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(2,id_funcionamiento,"PRESION DE COMPRESORA",get_estado(bueno_presion_compresora.isChecked(),false,malo_presion_compresora.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(3,id_funcionamiento,"PRESION DE MAQUINA",get_estado(bueno_presion_maquina.isChecked(),false,malo_presion_maquina.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(4,id_funcionamiento,"RETIRO DE CAJAS",get_estado(bueno_retiro_cajas.isChecked(),false,malo_retiro_cajas.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(5,id_funcionamiento,"ACTIVACION DE FOSKI",get_estado(bueno_activacion_foski.isChecked(),false,malo_activacion_foski.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(6,id_funcionamiento,"BOQUILLAS",get_estado(bueno_boquillas.isChecked(),false,malo_boquillas.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(7,id_funcionamiento,"DISPERSION DE SOLUCION VACUNAL",get_estado(bueno_dispersion.isChecked(),false,malo_dispersion.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(8,id_funcionamiento,"CALIBRACION",get_estado(bueno_calibracion.isChecked(),false,malo_calibracion.isChecked()));

                    ///REGISTRO DE LIMPIEZA Y DESINFECCION
                    id_funcionamiento++;
                    guardar_inspeccion_funcionamiento(id_funcionamiento,observacion_desinfeccion.getText().toString(),cantidad_aves_desinfeccion.getText().toString(),id_servicio);

                    //REGISTO DETALLE DE LIMPIEZA Y DESINFECCION,
                    guardar_detalle_inspeccion_funcionamiento(1,id_funcionamiento,"MATERIALES UTILIZADOS",get_estado(bueno_materiales_utlizados.isChecked(),false,malo_materiales_utlizados.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(2,id_funcionamiento,"CAMBIO DE PIEZAS DESCARTABLES",get_estado(bueno_cambio.isChecked(),false,malo_cambio.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(3,id_funcionamiento,"ENJUAGUE DE TUBERIAS",get_estado(bueno_enjuague.isChecked(),false,malo_enjuague.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(4,id_funcionamiento,"ESTERILIZADO DE VALVULAS",get_estado(bueno_esterilizado.isChecked(),false,malo_esterilizado.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(5,id_funcionamiento,"ESTERILIZADO DE TUBERIAS",get_estado(bueno_esterilizado_tuberia.isChecked(),false,malo_esterilizado_tuberia.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(6,id_funcionamiento,"ESTERILIZADO DE BOUILLAS",get_estado(bueno_esterilizado_boquilla.isChecked(),false,malo_esterilizado_boquilla.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(7,id_funcionamiento,"SECADO",get_estado(bueno_secado.isChecked(),false,malo_secado.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(8,id_funcionamiento,"PROTECCION",get_estado(bueno_proteccion.isChecked(),false,malo_proteccion.isChecked()));




/*
 registro.put("id",String.valueOf(id));
        registro.put("observaciones", observaciones);
        registro.put("frecuencia", frecuencia);
        registro.put("id_servicio", String.valueOf(id_servicio));
        bd.insert("inspeccion_funcionamiento", null, registro);
*/
                    Log.w("Spravac","Se registro correctamente.");
                }
                else
                {
                    Log.e("Spravac","Error al registrar un servicio de mantenimiento de la maquina Spravac");
                }

                break;
            case R.id.Cancelar:

                break;
        }
    }

    public int get_estado(boolean bueno,boolean regular,boolean malo)
    {
        int estado=0;
        if(bueno==true)
        {
            estado=1;
        }else if(regular==true)
        {
            estado=2;
        }else if(malo==true)
        {
            estado=3;
        }
        return estado;
    }
}
