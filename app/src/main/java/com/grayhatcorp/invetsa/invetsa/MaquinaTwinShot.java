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

public class MaquinaTwinShot extends AppCompatActivity implements View.OnClickListener {//implements View.OnClickListener
    ArrayAdapter<String> adapter;
    //Spinner scompania;

    AutoCompleteTextView autoCompania,autoMaquina,autoDireccion,autoPlantaEncubacion;
    EditText HoraIngreso,HoraSalida,UltimaVisita,EncargadoMaquinas,JefePlanta,fecha;
    EditText Observacion_InspecionVisual,Piezas_Cambiadas_Inspeccion,Observaciones_Funcionamiento,Frecuencia_de_Uso,Observaciones_Limpieza,CantidadAvesVacunadas;
    EditText bueno_bolas_acero,regular_bolas_acero,malo_bolas_acero;
    EditText bueno_resortes,regular_resortes,malo_resortes;
    EditText bueno_bolitas_teflon,regular_bolitas_teflon,malo_bolitas_teflon;
    EditText bueno_tuercas_b_aluminio,regular_tuercas_b_aluminio,malo_tuercas_b_aluminio;
    EditText bueno_tuerca_collarin,regular_tuerca_collarin,malo_tuerca_collarin;
    EditText bueno_empaque_asiento,regular_empaque_asiento,malo_empaque_asiento;
    EditText bueno_empaque_captura,regular_empaque_captura,malo_empaque_captura;
    EditText bueno_tuberia_pequena,regular_tuberia_pequena,malo_tuberia_pequena;
    EditText bueno_tuberia_latex,regular_tuberia_latex,malo_tuberia_latex;

    RadioButton bueno_base_aluminio,regular_base_aluminio,malo_base_aluminio;
    RadioButton bueno_bloque_posterior,regular_bloque_posterior,malo_bloque_posterior;
    RadioButton bueno_bloque_cilindro,regular_bloque_cilindro,malo_bloque_cilindro;
    RadioButton bueno_reguladores_salida,regular_reguladores_salida,malo_reguladores_salida;
    RadioButton bueno_bloque_jeringa,regular_bloque_jeringa,malo_bloque_jeringa;
    RadioButton bueno_acopladura_colder_hembra,regular_acopladura_colder_hembra,malo_acopladura_colder_hembra;
    RadioButton bueno_bloque_delantero,regular_bloque_delantero,malo_bloque_delantero;
    RadioButton bueno_distribuidor_aire,regular_distribuidor_aire,malo_distribuidor_aire;
    RadioButton bueno_valvula_control,regular_valvula_control,malo_valvula_control;
    RadioButton bueno_conector_r_entrada,regular_conector_r_entrada,malo_conector_r_entrada;
    RadioButton bueno_repts_valvula_control,regular_repts_valvula_control,malo_repts_valvula_control;
    RadioButton bueno_silbato,regular_silbato,malo_silbato;
    RadioButton bueno_placa_twin,regular_placa_twin,malo_placa_twin;
    RadioButton bueno_conector_r_hembra,regular_conector_r_hembra,malo_conector_r_hembra;
    RadioButton bueno_conector_r_macho,regular_conector_r_macho,malo_conector_r_macho;
    RadioButton bueno_conector_aire_twin,regular_conector_aire_twin,malo_conector_aire_twin;
    RadioButton bueno_valvula_4salidas,regular_valvula_4salidas,malo_valvula_4salidas;
    RadioButton bueno_seguro_tapa,regular_seguro_tapa,malo_seguro_tapa;
    RadioButton bueno_valvula_1salida,regular_valvula_1salida,malo_valvula_1salida;
    RadioButton bueno_subplaca_sencilla,regular_subplaca_sencilla,malo_subplaca_sencilla;
    RadioButton bueno_seguro_valvula,regular_seguro_valvula,malo_seguro_valvula;
    RadioButton bueno_relay_sensor,regular_relay_sensor,malo_relay_sensor;
    RadioButton bueno_clamp_tuberia12,regular_clamp_tuberia12,malo_clamp_tuberia12;
    RadioButton bueno_celula_negativa,regular_celula_negativa,malo_celula_negativa;
    RadioButton bueno_clamp_tuberia516,regular_clamp_tuberia516,malo_clamp_tuberia516;
    RadioButton bueno_valvula_aguja,regular_valvula_aguja,malo_valvula_aguja;
    RadioButton bueno_detector_posicion,regular_detector_posicion,malo_detector_posicion;
    RadioButton bueno_valvula_impulso,regular_valvula_impulso,malo_valvula_impulso;
    RadioButton bueno_conector532,regular_conector532,malo_conector532;
    RadioButton bueno_patas_caucho,regular_patas_caucho,malo_patas_caucho;
    RadioButton bueno_acopladura_colder,regular_acopladura_colder,malo_acopladura_colder;
    RadioButton bueno_detertor_posiciones,regular_detertor_posiciones,malo_detertor_posiciones;
    RadioButton bueno_switch_3posiciones,regular_switch_3posiciones,malo_switch_3posiciones;
    RadioButton bueno_cilindro_fuerza,regular_cilindro_fuerza,malo_cilindro_fuerza;
    RadioButton bueno_regulador_aire,regular_regulador_aire,malo_regulador_aire;
    RadioButton bueno_cilindro_ajuste,regular_cilindro_ajuste,malo_cilindro_ajuste;
    RadioButton bueno_manometro,regular_manometro,malo_manometro;
    RadioButton bueno_conector_r_532,regular_conector_r_532,malo_conector_r_532;
    RadioButton bueno_contador_total,regular_contador_total,malo_contador_total;
    RadioButton bueno_conector_aire_bronce,regular_conector_aire_bronce,malo_conector_aire_bronce;
    RadioButton bueno_protector_cont_total,regular_protector_cont_total,malo_protector_cont_total;
    RadioButton bueno_sello_cilindro,regular_sello_cilindro,malo_sello_cilindro;
    RadioButton bueno_contador_prefijado,regular_contador_prefijado,malo_contador_prefijado;
    RadioButton bueno_retenedor_jeringa,regular_retenedor_jeringa,malo_retenedor_jeringa;
    RadioButton bueno_protector_cont_prefijado,regular_protector_cont_prefijado,malo_protector_cont_prefijado;
    RadioButton bueno_sostenedor_aguja,regular_sostenedor_aguja,malo_sostenedor_aguja;
    RadioButton bueno_reestablecedor_contador,regular_reestablecedor_contador,malo_reestablecedor_contador;
    RadioButton bueno_jeringa_descartable,regular_jeringa_descartable,malo_jeringa_descartable;
    RadioButton bueno_ubicacion_maquina,malo_ubicacion_maquina;
    RadioButton bueno_presion_compresora,malo_presion_compresora;
    RadioButton bueno_presion_maquina,malo_presion_maquina;
    RadioButton bueno_activacion,malo_activacion;
    RadioButton bueno_funcionamiento_contadores,malo_funcionamiento_contadores;
    RadioButton bueno_funcionamiento_silbato,malo_funcionamiento_silbato;
    RadioButton bueno_salida_aguja,malo_salida_aguja;
    RadioButton bueno_calibracion,malo_calibracion;
    RadioButton bueno_materiales_utilizados,malo_materiales_utilizados;
    RadioButton bueno_cambio_piezas,malo_cambio_piezas;
    RadioButton bueno_limpieza_placa,malo_limpieza_placa;
    RadioButton bueno_esterilizado_valvula,malo_esterilizado_valvula;
    RadioButton bueno_limpieza_modulo,malo_limpieza_modulo;
    RadioButton bueno_limpieza_cerebro,malo_limpieza_cerebro;
    RadioButton bueno_secado,malo_secado;
    RadioButton bueno_proteccion,malo_proteccion;

    Button guardar,cancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maquina_twin_shot);


        autoCompania=(AutoCompleteTextView)findViewById(R.id.autoCompania);
        autoMaquina=(AutoCompleteTextView)findViewById(R.id.autoMaquina);
        autoDireccion=(AutoCompleteTextView)findViewById(R.id.autoDireccion);
        autoPlantaEncubacion=(AutoCompleteTextView)findViewById(R.id.autoPlantaEncubacion);
        EncargadoMaquinas=(EditText)findViewById(R.id.TextViewEncargado);
        HoraIngreso=(EditText)findViewById(R.id.TextViewHoradeIngreso);
        HoraSalida=(EditText)findViewById(R.id.TextViewHoradeSalida);
        UltimaVisita=(EditText)findViewById(R.id.TextViewUltimaVisita);
        fecha=(EditText)findViewById(R.id.TextViewFecha);

        Observacion_InspecionVisual=(EditText)findViewById(R.id.txtObservacionesInspeccionVisual);
        Piezas_Cambiadas_Inspeccion=(EditText)findViewById(R.id.txtPiezasCambiadasInspeccionVisual);
        Observaciones_Funcionamiento=(EditText)findViewById(R.id.txtObservacionesInspeccionFuncionamiento);
        Frecuencia_de_Uso=(EditText)findViewById(R.id.txtPiezasFrecuenciadeUsoInspeccionFuncionamiento);
        Observaciones_Limpieza=(EditText)findViewById(R.id.txtObservacionesLimpiezaDesinfeccion);
        CantidadAvesVacunadas=(EditText)findViewById(R.id.txtAvesVacunadasLimpiezaDesinfeccion);


        bueno_base_aluminio=(RadioButton)findViewById(R.id.BuenoBaseAluminio);
        regular_base_aluminio=(RadioButton)findViewById(R.id.RegularBaseAluminio);
        malo_base_aluminio=(RadioButton)findViewById(R.id.MaloBaseAluminio);
        bueno_bolas_acero=(EditText)findViewById(R.id.BuenoBolitasAcero);
        regular_bolas_acero=(EditText)findViewById(R.id.RegularBolitasAcero);
        malo_bolas_acero=(EditText)findViewById(R.id.MaloBolitasAcero);
        bueno_bloque_posterior=(RadioButton)findViewById(R.id.BuenoBloquePosteriror);
        regular_bloque_posterior=(RadioButton)findViewById(R.id.RegularBloquePosteriror);
        malo_bloque_posterior=(RadioButton)findViewById(R.id.MaloBloquePosteriror);
        bueno_resortes=(EditText)findViewById(R.id.BuenoResortes);
        regular_resortes=(EditText)findViewById(R.id.RegularResortes);
        malo_resortes=(EditText)findViewById(R.id.MaloResortes);
        bueno_bloque_cilindro=(RadioButton)findViewById(R.id.BuenoBloqueCilindro);
        regular_bloque_cilindro=(RadioButton)findViewById(R.id.RegularBloqueCilindro);
        malo_bloque_cilindro=(RadioButton)findViewById(R.id.MaloBloqueCilindro);
        bueno_reguladores_salida=(RadioButton)findViewById(R.id.BuenoReguladoresdesalida);
        regular_reguladores_salida=(RadioButton)findViewById(R.id.RegularReguladoresdesalida);
        malo_reguladores_salida=(RadioButton)findViewById(R.id.MaloReguladoresdesalida);
        bueno_bloque_jeringa=(RadioButton)findViewById(R.id.BuenoBloquedeJeringa);
        regular_bloque_jeringa=(RadioButton)findViewById(R.id.RegularBloquedeJeringa);
        malo_bloque_jeringa=(RadioButton)findViewById(R.id.MaloBloquedeJeringa);
        bueno_bloque_delantero=(RadioButton)findViewById(R.id.BuenoBoqueDelantero);
        regular_bloque_delantero=(RadioButton)findViewById(R.id.RegularBoqueDelantero);
        malo_bloque_delantero=(RadioButton)findViewById(R.id.MaloBoqueDelantero);
        bueno_distribuidor_aire=(RadioButton)findViewById(R.id.BuenoDistribuidorAire);
        regular_distribuidor_aire=(RadioButton)findViewById(R.id.RegularDistribuidorAire);
        malo_distribuidor_aire=(RadioButton)findViewById(R.id.MaloDistribuidorAire);
        bueno_valvula_control=(RadioButton)findViewById(R.id.BuenoValuvulaControl);
        regular_valvula_control=(RadioButton)findViewById(R.id.RegularValuvulaControl);
        malo_valvula_control=(RadioButton)findViewById(R.id.MaloValuvulaControl);
        bueno_conector_r_entrada=(RadioButton)findViewById(R.id.BuenoConectorRapidodeEntrada);
        regular_conector_r_entrada=(RadioButton)findViewById(R.id.RegularConectorRapidodeEntrada);
        malo_conector_r_entrada=(RadioButton)findViewById(R.id.MaloConectorRapidodeEntrada);
        bueno_silbato=(RadioButton)findViewById(R.id.BuenoSilbato);
        regular_silbato=(RadioButton)findViewById(R.id.RegularSilbato);
        malo_silbato=(RadioButton)findViewById(R.id.MaloSilbato);
        bueno_repts_valvula_control=(RadioButton)findViewById(R.id.BuenoRPTOValvuladeControl);
        regular_repts_valvula_control=(RadioButton)findViewById(R.id.RegularRPTOValvuladeControl);
        malo_repts_valvula_control=(RadioButton)findViewById(R.id.MaloRPTOValvuladeControl);
        bueno_conector_r_hembra=(RadioButton)findViewById(R.id.BuenoConectorRapidoHembra);
        regular_conector_r_hembra=(RadioButton)findViewById(R.id.RegularConectorRapidoHembra);
        malo_conector_r_hembra=(RadioButton)findViewById(R.id.RegularConectorRapidoHembra);
        bueno_placa_twin=(RadioButton)findViewById(R.id.BuenoPlacaTwinTouch);
        regular_placa_twin=(RadioButton)findViewById(R.id.RegularPlacaTwinTouch);
        malo_placa_twin=(RadioButton)findViewById(R.id.MaloPlacaTwinTouch);
        bueno_conector_r_macho=(RadioButton)findViewById(R.id.BuenoConectorMacho);
        regular_conector_r_macho=(RadioButton)findViewById(R.id.RegularConectorMacho);
        malo_conector_r_macho=(RadioButton)findViewById(R.id.MaloConectorMacho);
        bueno_bolitas_teflon=(EditText)findViewById(R.id.BuenoBolitasdeTeflon);
        regular_bolitas_teflon=(EditText)findViewById(R.id.RegularBolitasdeTeflon);
        malo_bolitas_teflon=(EditText)findViewById(R.id.MaloBolitasdeTeflon);
        bueno_valvula_4salidas=(RadioButton)findViewById(R.id.BuenoValvula4Salidas);
        regular_valvula_4salidas=(RadioButton)findViewById(R.id.RegularValvula4Salidas);
        malo_valvula_4salidas=(RadioButton)findViewById(R.id.MaloValvula4Salidas);
        bueno_conector_aire_twin=(RadioButton)findViewById(R.id.BuenoConectordeAireTwinShot);
        regular_conector_aire_twin=(RadioButton)findViewById(R.id.RegularConectordeAireTwinShot);
        malo_conector_aire_twin=(RadioButton)findViewById(R.id.MaloConectordeAireTwinShot);
        bueno_valvula_1salida=(RadioButton)findViewById(R.id.BuenoValvulade1Salida);
        regular_valvula_1salida=(RadioButton)findViewById(R.id.RegularValvulade1Salida);
        malo_valvula_1salida=(RadioButton)findViewById(R.id.MaloValvulade1Salida);
        bueno_seguro_tapa=(RadioButton)findViewById(R.id.BuenoSegurodeTapa);
        regular_seguro_tapa=(RadioButton)findViewById(R.id.RegularSegurodeTapa);
        malo_seguro_tapa=(RadioButton)findViewById(R.id.MaloSegurodeTapa);
        bueno_subplaca_sencilla=(RadioButton)findViewById(R.id.BuenoSUBPLACASENCILLA);
        regular_subplaca_sencilla=(RadioButton)findViewById(R.id.RegularSUBPLACASENCILLA);
        malo_subplaca_sencilla=(RadioButton)findViewById(R.id.MaloSUBPLACASENCILLA);
        bueno_tuercas_b_aluminio=(EditText)findViewById(R.id.BuenoTuercasBaseAluminio);
        regular_tuercas_b_aluminio=(EditText)findViewById(R.id.RegularTuercasBaseAluminio);
        malo_tuercas_b_aluminio=(EditText)findViewById(R.id.RegularTuercasBaseAluminio);
        bueno_relay_sensor=(RadioButton)findViewById(R.id.BuenoRelaySensor);
        regular_relay_sensor=(RadioButton)findViewById(R.id.RegularRelaySensor);
        malo_relay_sensor=(RadioButton)findViewById(R.id.MaloRelaySensor);
        bueno_seguro_valvula=(RadioButton)findViewById(R.id.BuenoSegurodeValvula);
        regular_seguro_valvula=(RadioButton)findViewById(R.id.RegularSegurodeValvula);
        malo_seguro_valvula=(RadioButton)findViewById(R.id.MaloSegurodeValvula);
        bueno_celula_negativa=(RadioButton)findViewById(R.id.BuenoCelulaNegativa);
        regular_celula_negativa=(RadioButton)findViewById(R.id.RegularCelulaNegativa);
        malo_celula_negativa=(RadioButton)findViewById(R.id.MaloCelulaNegativa);
        bueno_clamp_tuberia12=(RadioButton)findViewById(R.id.BuenoClamTuberia);
        regular_clamp_tuberia12=(RadioButton)findViewById(R.id.RegularClamTuberia);
        malo_clamp_tuberia12=(RadioButton)findViewById(R.id.MaloClamTuberia);
        bueno_clamp_tuberia516=(RadioButton)findViewById(R.id.BuenoClamTuberia516);
        regular_clamp_tuberia516=(RadioButton)findViewById(R.id.RegularClamTuberia516);
        malo_clamp_tuberia516=(RadioButton)findViewById(R.id.MaloClamTuberia516);
        bueno_valvula_aguja=(RadioButton)findViewById(R.id.BuenoValvuladelaAguja);
        regular_valvula_aguja=(RadioButton)findViewById(R.id.RegularValvuladelaAguja);
        malo_valvula_aguja=(RadioButton)findViewById(R.id.MaloValvuladelaAguja);
        bueno_detector_posicion=(RadioButton)findViewById(R.id.BuenoDetectordePosicion);
        regular_detector_posicion=(RadioButton)findViewById(R.id.RegularDetectordePosicion);
        malo_detector_posicion=(RadioButton)findViewById(R.id.MaloDetectordePosicion);
        bueno_valvula_impulso=(RadioButton)findViewById(R.id.BuenoValvuladeImpulso);
        regular_valvula_impulso=(RadioButton)findViewById(R.id.RegularValvuladeImpulso);
        malo_valvula_impulso=(RadioButton)findViewById(R.id.MaloValvuladeImpulso);
        bueno_conector532=(RadioButton)findViewById(R.id.BuenoConector532);
        regular_conector532=(RadioButton)findViewById(R.id.RegularConector532);
        malo_conector532=(RadioButton)findViewById(R.id.MaloConector532);
        bueno_patas_caucho=(RadioButton)findViewById(R.id.BuenoPatasdeCaucho);
        regular_patas_caucho=(RadioButton)findViewById(R.id.RegularPatasdeCaucho);
        malo_patas_caucho=(RadioButton)findViewById(R.id.MaloPatasdeCaucho);
        bueno_detertor_posiciones=(RadioButton)findViewById(R.id.BuenoDetectordePosicion);
        regular_detertor_posiciones=(RadioButton)findViewById(R.id.RegularDetectordePosicion);
        malo_detertor_posiciones=(RadioButton)findViewById(R.id.MaloDetectordePosicion);
        bueno_acopladura_colder=(RadioButton)findViewById(R.id.BuenoAcopladuraColderMacho);
        regular_acopladura_colder=(RadioButton)findViewById(R.id.RegularAcopladuraColderMacho);
        malo_acopladura_colder=(RadioButton)findViewById(R.id.MaloAcopladuraColderMacho);
        bueno_switch_3posiciones=(RadioButton)findViewById(R.id.BuenoSwitchTresPosiciones);
        regular_switch_3posiciones=(RadioButton)findViewById(R.id.RegularSwitchTresPosiciones);
        malo_switch_3posiciones=(RadioButton)findViewById(R.id.MaloSwitchTresPosiciones);
        bueno_cilindro_fuerza=(RadioButton)findViewById(R.id.BuenoCilindrodeFuerza);
        regular_cilindro_fuerza=(RadioButton)findViewById(R.id.RegularCilindrodeFuerza);
        malo_cilindro_fuerza=(RadioButton)findViewById(R.id.MaloCilindrodeFuerza);
        bueno_regulador_aire=(RadioButton)findViewById(R.id.BuenoReguladorAire);
        regular_regulador_aire=(RadioButton)findViewById(R.id.RegularReguladorAire);
        malo_regulador_aire=(RadioButton)findViewById(R.id.MaloReguladorAire);
        bueno_cilindro_ajuste=(RadioButton)findViewById(R.id.BuenoCilindrodeAjuste);
        regular_cilindro_ajuste=(RadioButton)findViewById(R.id.RegularCilindrodeAjuste);
        malo_cilindro_ajuste=(RadioButton)findViewById(R.id.MaloCilindrodeAjuste);
        bueno_manometro=(RadioButton)findViewById(R.id.BuenoManometro);
        regular_manometro=(RadioButton)findViewById(R.id.RegularManometro);
        malo_manometro=(RadioButton)findViewById(R.id.MaloManometro);
        bueno_conector_r_532=(RadioButton)findViewById(R.id.BuenoConector532);
        regular_conector_r_532=(RadioButton)findViewById(R.id.RegularConector532);
        malo_conector_r_532=(RadioButton)findViewById(R.id.MaloConector532);
        bueno_contador_total=(RadioButton)findViewById(R.id.BuenoContadorTotal);
        regular_contador_total=(RadioButton)findViewById(R.id.RegularContadorTotal);
        malo_contador_total=(RadioButton)findViewById(R.id.MaloContadorTotal);
        bueno_conector_aire_bronce=(RadioButton)findViewById(R.id.BuenoConectordeAiredeBronce);
        regular_conector_aire_bronce=(RadioButton)findViewById(R.id.RegularConectordeAiredeBronce);
        malo_conector_aire_bronce=(RadioButton)findViewById(R.id.MaloConectordeAiredeBronce);
        bueno_protector_cont_total=(RadioButton)findViewById(R.id.BuenoProtectorContadorTotal);
        regular_protector_cont_total=(RadioButton)findViewById(R.id.RegularProtectorContadorTotal);
        malo_protector_cont_total=(RadioButton)findViewById(R.id.MaloProtectorContadorTotal);
        bueno_sello_cilindro=(RadioButton)findViewById(R.id.BuenoSellodeCilindrodeFuerza);
        regular_sello_cilindro=(RadioButton)findViewById(R.id.RegularSellodeCilindrodeFuerza);
        malo_sello_cilindro=(RadioButton)findViewById(R.id.MaloSellodeCilindrodeFuerza);
        bueno_contador_prefijado=(RadioButton)findViewById(R.id.BuenoContadorPrefijado);
        regular_contador_prefijado=(RadioButton)findViewById(R.id.RegularContadorPrefijado);
        malo_contador_prefijado=(RadioButton)findViewById(R.id.MaloContadorPrefijado);
        bueno_retenedor_jeringa=(RadioButton)findViewById(R.id.BuenoRetenedordeJeringa);
        regular_retenedor_jeringa=(RadioButton)findViewById(R.id.RegularRetenedordeJeringa);
        malo_retenedor_jeringa=(RadioButton)findViewById(R.id.MaloRetenedordeJeringa);
        bueno_protector_cont_prefijado=(RadioButton)findViewById(R.id.BuenoProtectorContadorPrefijado);
        regular_protector_cont_prefijado=(RadioButton)findViewById(R.id.RegularProtectorContadorPrefijado);
        malo_protector_cont_prefijado=(RadioButton)findViewById(R.id.MaloProtectorContadorPrefijado);
        bueno_sostenedor_aguja=(RadioButton)findViewById(R.id.BuenoSostenedorDelaAguja);
        regular_sostenedor_aguja=(RadioButton)findViewById(R.id.RegularSostenedorDelaAguja);
        malo_sostenedor_aguja=(RadioButton)findViewById(R.id.RegularSostenedorDelaAguja);
        bueno_reestablecedor_contador=(RadioButton)findViewById(R.id.BuenoRestablecedordeContador);
        regular_reestablecedor_contador=(RadioButton)findViewById(R.id.RegularRestablecedordeContador);
        malo_reestablecedor_contador=(RadioButton)findViewById(R.id.MaloRestablecedordeContador);
        bueno_jeringa_descartable=(RadioButton)findViewById(R.id.BuenoJeringaDescartable);
        regular_jeringa_descartable=(RadioButton)findViewById(R.id.RegularJeringaDescartable);
        malo_jeringa_descartable=(RadioButton)findViewById(R.id.MaloJeringaDescartable);
        bueno_tuerca_collarin=(EditText)findViewById(R.id.BuenoTuercaCollarindeAguja);
        regular_tuerca_collarin=(EditText)findViewById(R.id.RegularTuercaCollarindeAguja);
        malo_tuerca_collarin=(EditText)findViewById(R.id.MaloTuercaCollarindeAguja);
        bueno_empaque_asiento=(EditText)findViewById(R.id.BuenoEmpaqueoAsiento);
        regular_empaque_asiento=(EditText)findViewById(R.id.RegularEmpaqueoAsiento);
        malo_empaque_asiento=(EditText)findViewById(R.id.MaloEmpaqueoAsiento);
        bueno_empaque_captura=(EditText)findViewById(R.id.BuenoEmpaqueoCaptura);
        regular_empaque_captura=(EditText)findViewById(R.id.RegularEmpaqueoCaptura);
        malo_empaque_captura=(EditText)findViewById(R.id.MaloEmpaqueoCaptura);
        bueno_tuberia_pequena=(EditText)findViewById(R.id.BuenoTuberiaPequena);
        regular_tuberia_pequena=(EditText)findViewById(R.id.RegularTuberiaPequena);
        malo_tuberia_pequena=(EditText)findViewById(R.id.MaloTuberiaPequena);
        bueno_tuberia_latex=(EditText)findViewById(R.id.BuenoTuberiaLatex);
        regular_tuberia_latex=(EditText)findViewById(R.id.RegularTuberiaLatex);
        malo_tuberia_latex=(EditText)findViewById(R.id.MaloTuberiaLatex);
        bueno_ubicacion_maquina=(RadioButton)findViewById(R.id.BuenoUbicaciondelaMAquina);
        malo_ubicacion_maquina=(RadioButton)findViewById(R.id.MaloUbicaciondelaMAquina);
        bueno_presion_compresora=(RadioButton)findViewById(R.id.BuenoPresionCompresora);
        malo_presion_compresora=(RadioButton)findViewById(R.id.MaloPresionCompresora);
        bueno_presion_maquina=(RadioButton)findViewById(R.id.BuenoPresionMAquina);
        malo_presion_maquina=(RadioButton)findViewById(R.id.MaloPresionMAquina);
        bueno_activacion=(RadioButton)findViewById(R.id.BuenoActivacion);
        malo_activacion=(RadioButton)findViewById(R.id.MaloActivacion);
        bueno_funcionamiento_contadores=(RadioButton)findViewById(R.id.BuenoFuncionesDeContadores);
        malo_funcionamiento_contadores=(RadioButton)findViewById(R.id.MaloFuncionesDeContadores);
        bueno_funcionamiento_silbato=(RadioButton)findViewById(R.id.BuenoSilbato);
        malo_funcionamiento_silbato=(RadioButton)findViewById(R.id.MaloSilbato);
        bueno_salida_aguja=(RadioButton)findViewById(R.id.BuenoSalidadeAguja);
        malo_salida_aguja=(RadioButton)findViewById(R.id.MaloSalidadeAguja);
        bueno_calibracion=(RadioButton)findViewById(R.id.BuenoCalibracion);
        malo_calibracion=(RadioButton)findViewById(R.id.MaloCalibracion);
        bueno_materiales_utilizados=(RadioButton)findViewById(R.id.BuenoMaterialesUtilizados);
        malo_materiales_utilizados=(RadioButton)findViewById(R.id.MaloMaterialesUtilizados);
        bueno_cambio_piezas=(RadioButton)findViewById(R.id.BuenoCambioPiezasDescartables);
        malo_cambio_piezas=(RadioButton)findViewById(R.id.MaloCambioPiezasDescartables);
        bueno_limpieza_placa=(RadioButton)findViewById(R.id.BuenoLimpiezadePlacaTwin);
        malo_limpieza_placa=(RadioButton)findViewById(R.id.MaloLimpiezadePlacaTwin);
        bueno_esterilizado_valvula=(RadioButton)findViewById(R.id.BuenoEsterilizadodeValvula);
        malo_esterilizado_valvula=(RadioButton)findViewById(R.id.MaloEsterilizadodeValvula);
        bueno_limpieza_modulo=(RadioButton)findViewById(R.id.BuenoLimpiezaModuloInyector);
        malo_limpieza_modulo=(RadioButton)findViewById(R.id.MaloLimpiezaModuloInyector);
        bueno_limpieza_cerebro=(RadioButton)findViewById(R.id.BuenoLimpiezadelCerebro);
        malo_limpieza_cerebro=(RadioButton)findViewById(R.id.MaloLimpiezadelCerebro);
        bueno_secado=(RadioButton)findViewById(R.id.BuenoSecado);
        malo_secado=(RadioButton)findViewById(R.id.MaloSecado);
        bueno_proteccion=(RadioButton)findViewById(R.id.BuenoProteccion);
        malo_proteccion=(RadioButton)findViewById(R.id.MaloProteccion);


        // scompania=(Spinner)findViewById(R.id.compania);
      //  cargar_compania_en_la_lista();
        //cargar_maquina_en_la_lista();

//        guardar.setOnClickListener(this);
  //      cancelar.setOnClickListener(this);
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

                    guardar_servicio_mantenimiento(id_servicio,fecha.getText().toString(),HoraIngreso.getText().toString(),HoraSalida.getText().toString(),"P50","1","firmas_jefe","firma_invetsa",String.valueOf(id_maquina),String.valueOf(id_tecnico),String.valueOf(id_compania));

                    int id_inspeccion=id_inspeccion_visual()+1;
                    guardar_inspeccion_visual(id_inspeccion,Observacion_InspecionVisual.getText().toString(),Piezas_Cambiadas_Inspeccion.getText().toString(),id_servicio);

                    guardar_detalle_inspeccion_visual(1,id_inspeccion,"AV-131","BASE DE ALUMINIO",get_estado(bueno_base_aluminio.isChecked(),regular_base_aluminio.isChecked(),malo_base_aluminio.isChecked()));
                    guardar_detalle_inspeccion_visual(2,id_inspeccion,"AV-1331","BLOQUE POSTERIOR",get_estado(bueno_bloque_posterior.isChecked(),regular_bloque_posterior.isChecked(),malo_bloque_posterior.isChecked()));
                    guardar_detalle_inspeccion_visual(3,id_inspeccion,"AV-13413","BLOQUE DE CILINDRO DE FUERZA",get_estado(bueno_bloque_cilindro.isChecked(),regular_bloque_cilindro.isChecked(),malo_bloque_cilindro.isChecked()));
                    guardar_detalle_inspeccion_visual(4,id_inspeccion,"AV-13421","BLOQUE DE JERINGA",get_estado(bueno_bloque_jeringa.isChecked(),regular_bloque_jeringa.isChecked(),malo_bloque_jeringa.isChecked()));
                    guardar_detalle_inspeccion_visual(5,id_inspeccion,"AV-13511","BLOQUE DELANTERO GUIA",get_estado(bueno_bloque_delantero.isChecked(),regular_bloque_delantero.isChecked(),malo_bloque_delantero.isChecked()));
                    guardar_detalle_inspeccion_visual(6,id_inspeccion,"AV-137","VALVULA DE CONTROL",get_estado(bueno_valvula_control.isChecked(),regular_valvula_control.isChecked(),malo_valvula_control.isChecked()));
                    guardar_detalle_inspeccion_visual(7,id_inspeccion,"AV-1378","REPTS. DE VALVULA DE CONTROL",get_estado(bueno_repts_valvula_control.isChecked(),regular_repts_valvula_control.isChecked(),malo_repts_valvula_control.isChecked()));
                    guardar_detalle_inspeccion_visual(8,id_inspeccion,"AV-111","PLACA TWIN TOUCH",get_estado(bueno_placa_twin.isChecked(),regular_placa_twin.isChecked(),malo_placa_twin.isChecked()));
                    //guardar_detalle_inspeccion_visual(9,id_inspeccion,"AV-114","BOLITAS DE TEFLON",get_estado(bueno_bolitas_teflon.getText().toString(),regular_bolitas_teflon.getText().toString(),malo_bolitas_teflon.getText().toString()));
                    guardar_detalle_inspeccion_visual(10,id_inspeccion,"AV-117","CONECTOR DE AIRE DE TWIN SHOT",get_estado(bueno_conector_aire_twin.isChecked(),regular_conector_aire_twin.isChecked(),malo_conector_aire_twin.isChecked()));
                    guardar_detalle_inspeccion_visual(11,id_inspeccion,"AV-121","SEGURO DE TAPA",get_estado(bueno_seguro_tapa.isChecked(),regular_seguro_tapa.isChecked(),malo_seguro_tapa.isChecked()));
                    //guardar_detalle_inspeccion_visual(12,id_inspeccion,"AV-118","TUERCAS DE BASE DE ALUMINIO",get_estado(bueno_tuercas_b_aluminio.getText().toString(),regular_tuercas_b_aluminio.getText().toString(),malo_tuercas_b_aluminio.getText().toString()));
                    guardar_detalle_inspeccion_visual(13,id_inspeccion,"AV-1357","SEGURO DE VALVULA",get_estado(bueno_seguro_valvula.isChecked(),regular_seguro_valvula.isChecked(),malo_seguro_valvula.isChecked()));
                    guardar_detalle_inspeccion_visual(14,id_inspeccion,"5647","CLAMP DE TUBERIA DE 1/2",get_estado(bueno_clamp_tuberia12.isChecked(),regular_clamp_tuberia12.isChecked(),malo_clamp_tuberia12.isChecked()));
                    guardar_detalle_inspeccion_visual(15,id_inspeccion,"5548","CLAMP DE TUBERIA DE 5/16",get_estado(bueno_clamp_tuberia516.isChecked(),regular_clamp_tuberia516.isChecked(),malo_clamp_tuberia516.isChecked()));
                    guardar_detalle_inspeccion_visual(16,id_inspeccion,"5732","DETECTOR DE POSICION",get_estado(bueno_detector_posicion.isChecked(),regular_detector_posicion.isChecked(),malo_detector_posicion.isChecked()));
                    guardar_detalle_inspeccion_visual(17,id_inspeccion,"3543","CONECTOR DE 5/32",get_estado(bueno_conector532.isChecked(),regular_conector532.isChecked(),malo_conector532.isChecked()));
                    guardar_detalle_inspeccion_visual(18,id_inspeccion,"AV-1346","ACOPLADURA COLDER MACHO",get_estado(bueno_acopladura_colder.isChecked(),regular_acopladura_colder.isChecked(),malo_acopladura_colder.isChecked()));
                    guardar_detalle_inspeccion_visual(19,id_inspeccion,"AV-1344","CILINDRO DE FUERZA",get_estado(bueno_cilindro_fuerza.isChecked(),regular_cilindro_fuerza.isChecked(),malo_cilindro_fuerza.isChecked()));
                    guardar_detalle_inspeccion_visual(20,id_inspeccion,"AV-1345","CILINDRO DE AJUSTE",get_estado(bueno_cilindro_ajuste.isChecked(),regular_cilindro_ajuste.isChecked(),malo_cilindro_ajuste.isChecked()));
                    guardar_detalle_inspeccion_visual(21,id_inspeccion,"5720","CONECTOR RAPIDO 5/32",get_estado(bueno_conector_r_532.isChecked(),regular_conector_r_532.isChecked(),malo_conector_r_532.isChecked()));
                    guardar_detalle_inspeccion_visual(22,id_inspeccion,"5641","CONECTOR DE AIRE DE BRONCE",get_estado(bueno_conector_aire_bronce.isChecked(),regular_conector_aire_bronce.isChecked(),malo_conector_aire_bronce.isChecked()));
                    guardar_detalle_inspeccion_visual(23,id_inspeccion,"AV-13411","SELLO DE CILINDRO DE FUERZA",get_estado(bueno_sello_cilindro.isChecked(),regular_sello_cilindro.isChecked(),malo_sello_cilindro.isChecked()));
                    guardar_detalle_inspeccion_visual(24,id_inspeccion,"AV-13422","RETENEDOR DE JERINGA",get_estado(bueno_retenedor_jeringa.isChecked(),regular_retenedor_jeringa.isChecked(),malo_retenedor_jeringa.isChecked()));
                    guardar_detalle_inspeccion_visual(25,id_inspeccion,"AV-13521","SOSTENEDOR DE LA AGUJA",get_estado(bueno_sostenedor_aguja.isChecked(),regular_sostenedor_aguja.isChecked(),malo_sostenedor_aguja.isChecked()));
                    guardar_detalle_inspeccion_visual(26,id_inspeccion,"AV-13522","TUERCA COLLARIN DE LA AGUJA",get_estadoNumero(bueno_tuerca_collarin.getText().toString(),regular_tuerca_collarin.getText().toString(),malo_tuerca_collarin.getText().toString()));
                    guardar_detalle_inspeccion_visual(27,id_inspeccion,"AV-1374","EMPAQUE O ASIENTO",get_estadoNumero(bueno_empaque_asiento.getText().toString(),regular_empaque_asiento.getText().toString(),malo_empaque_asiento.getText().toString()));
                    guardar_detalle_inspeccion_visual(28,id_inspeccion,"AV-1375","EMPAQUE O CAPTURA",get_estadoNumero(bueno_empaque_captura.getText().toString(),regular_empaque_captura.getText().toString(),malo_empaque_captura.getText().toString()));
                    guardar_detalle_inspeccion_visual(29,id_inspeccion,"AV-1377","BOLITAS DE ACERO",get_estadoNumero(bueno_bolas_acero.getText().toString(),regular_bolas_acero.getText().toString(),malo_bolas_acero.getText().toString()));
                    guardar_detalle_inspeccion_visual(30,id_inspeccion,"AV-1376","RESORTES",get_estadoNumero(bueno_resortes.getText().toString(),regular_resortes.getText().toString(),malo_resortes.getText().toString()));
                    guardar_detalle_inspeccion_visual(31,id_inspeccion,"AV-13523","REGULADORES SALIDA DE AGUJA",get_estado(bueno_reguladores_salida.isChecked(),regular_reguladores_salida.isChecked(),malo_reguladores_salida.isChecked()));
                    guardar_detalle_inspeccion_visual(32,id_inspeccion,"AV-1347","ACOPLADURA COLDER HEMBRA",get_estado(bueno_acopladura_colder_hembra.isChecked(),regular_acopladura_colder_hembra.isChecked(),malo_acopladura_colder_hembra.isChecked()));
                    guardar_detalle_inspeccion_visual(33,id_inspeccion,"AV-230","DISTRIBUIDOR DE AIRE",get_estado(bueno_distribuidor_aire.isChecked(),regular_distribuidor_aire.isChecked(),malo_distribuidor_aire.isChecked()));
                    guardar_detalle_inspeccion_visual(34,id_inspeccion,"AV-1032","CONECTOR RAPIDO ENTRADA",get_estado(bueno_conector_r_entrada.isChecked(),regular_conector_r_entrada.isChecked(),malo_conector_r_entrada.isChecked()));
                    guardar_detalle_inspeccion_visual(35,id_inspeccion,"5430","SILBATO",get_estado(bueno_silbato.isChecked(),regular_silbato.isChecked(),malo_silbato.isChecked()));
                    guardar_detalle_inspeccion_visual(36,id_inspeccion,"5443","CONECTOR RAPIDO HEMBRA",get_estado(bueno_conector_r_hembra.isChecked(),regular_conector_r_hembra.isChecked(),malo_conector_r_hembra.isChecked()));
                    guardar_detalle_inspeccion_visual(37,id_inspeccion,"5445","CONECTOR RAPIDO MACHO",get_estado(bueno_conector_r_macho.isChecked(),regular_conector_r_macho.isChecked(),malo_conector_r_macho.isChecked()));
                    guardar_detalle_inspeccion_visual(38,id_inspeccion,"5728","VALVULA DE CUATRO SALIDAS",get_estado(bueno_valvula_4salidas.isChecked(),regular_valvula_4salidas.isChecked(),malo_valvula_4salidas.isChecked()));
                    guardar_detalle_inspeccion_visual(39,id_inspeccion,"5700","VALVULA DE UNA SALIDA",get_estado(bueno_valvula_1salida.isChecked(),regular_valvula_1salida.isChecked(),malo_valvula_1salida.isChecked()));
                    guardar_detalle_inspeccion_visual(40,id_inspeccion,"5709"," SUBPLACA SENCILLA",get_estado(bueno_subplaca_sencilla.isChecked(),regular_subplaca_sencilla.isChecked(),malo_subplaca_sencilla.isChecked()));
                    guardar_detalle_inspeccion_visual(41,id_inspeccion,"5730","RELAY SENSOR",get_estado(bueno_relay_sensor.isChecked(),regular_relay_sensor.isChecked(),malo_relay_sensor.isChecked()));
                    guardar_detalle_inspeccion_visual(42,id_inspeccion,"5701","",get_estado(bueno_celula_negativa.isChecked(),regular_celula_negativa.isChecked(),malo_celula_negativa.isChecked()));
                    guardar_detalle_inspeccion_visual(43,id_inspeccion,"5738","VALVULA DE LA AGUJA",get_estado(bueno_valvula_aguja.isChecked(),regular_valvula_aguja.isChecked(),malo_valvula_aguja.isChecked()));
                    guardar_detalle_inspeccion_visual(44,id_inspeccion,"5703","VALVULA DE IMPULSO",get_estado(bueno_valvula_impulso.isChecked(),regular_valvula_impulso.isChecked(),malo_valvula_impulso.isChecked()));
                    guardar_detalle_inspeccion_visual(45,id_inspeccion,"5600","PATAS DE CAUCHO",get_estado(bueno_patas_caucho.isChecked(),regular_patas_caucho.isChecked(),malo_patas_caucho.isChecked()));
                    guardar_detalle_inspeccion_visual(46,id_inspeccion,"5710","SWITCH DE TRES POSICIONES",get_estado(bueno_switch_3posiciones.isChecked(),regular_switch_3posiciones.isChecked(),malo_switch_3posiciones.isChecked()));
                    guardar_detalle_inspeccion_visual(47,id_inspeccion,"5726","REGULADOR DE AIRE",get_estado(bueno_regulador_aire.isChecked(),regular_regulador_aire.isChecked(),malo_regulador_aire.isChecked()));
                    guardar_detalle_inspeccion_visual(48,id_inspeccion,"5724","MANOMETRO",get_estado(bueno_manometro.isChecked(),regular_manometro.isChecked(),malo_manometro.isChecked()));
                    guardar_detalle_inspeccion_visual(49,id_inspeccion,"5423","CONTADOR TOTAL",get_estado(bueno_contador_total.isChecked(),regular_contador_total.isChecked(),malo_contador_total.isChecked()));
                    guardar_detalle_inspeccion_visual(50,id_inspeccion,"5426","PROTECTOR DE CONT. TOTAL",get_estado(bueno_protector_cont_total.isChecked(),regular_protector_cont_total.isChecked(),malo_protector_cont_total.isChecked()));
                    guardar_detalle_inspeccion_visual(51,id_inspeccion,"5422","CONTADOR PREFIJADO",get_estado(bueno_contador_prefijado.isChecked(),regular_contador_prefijado.isChecked(),malo_contador_prefijado.isChecked()));
                    guardar_detalle_inspeccion_visual(53,id_inspeccion,"5418","RE-ESTABLECEDOR DE CONTADOR",get_estado(bueno_reestablecedor_contador.isChecked(),regular_reestablecedor_contador.isChecked(),malo_reestablecedor_contador.isChecked()));
                    guardar_detalle_inspeccion_visual(52,id_inspeccion,"5425","PROTECTOR DE CONT.PREFIJADO",get_estado(bueno_protector_cont_prefijado.isChecked(),regular_protector_cont_prefijado.isChecked(),malo_protector_cont_prefijado.isChecked()));
                    guardar_detalle_inspeccion_visual(54,id_inspeccion,"AV-138","JERINGA DESCARTABLE",get_estado(bueno_jeringa_descartable.isChecked(),regular_jeringa_descartable.isChecked(),malo_jeringa_descartable.isChecked()));
                    guardar_detalle_inspeccion_visual(55,id_inspeccion,"3520","TUBERIA PEQUENA",get_estadoNumero(bueno_tuberia_pequena.getText().toString(),regular_tuberia_pequena.getText().toString(),malo_tuberia_pequena.getText().toString()));
                    guardar_detalle_inspeccion_visual(56,id_inspeccion,"SV-11155","TUBERIA LATEX",get_estadoNumero(bueno_tuberia_latex.getText().toString(),regular_tuberia_latex.getText().toString(),malo_tuberia_latex.getText().toString()));

                    ///REGISTRO DE INSPECCION E FUNCIONAMIENTO
                    int id_funcionamiento=id_inspeccion_funcionamiento()+1;
                    guardar_inspeccion_funcionamiento(id_funcionamiento,Observaciones_Funcionamiento.getText().toString(),Frecuencia_de_Uso.getText().toString(),id_servicio);

                    //REGISTO DE LOS DETALLES DE INSPECCION EL  FUNCIONAMIENTO,
                    guardar_detalle_inspeccion_funcionamiento(1,id_funcionamiento,"UBICACION DE MAQUINA",get_estado(bueno_ubicacion_maquina.isChecked(),false,malo_ubicacion_maquina.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(2,id_funcionamiento,"PRESION DE COMPRESORA",get_estado(bueno_presion_compresora.isChecked(),false,malo_presion_compresora.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(3,id_funcionamiento,"PRESION DE MAQUINA",get_estado(bueno_presion_maquina.isChecked(),false,malo_presion_maquina.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(4,id_funcionamiento,"ACTIVACION",get_estado(bueno_activacion.isChecked(),false,malo_activacion.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(5,id_funcionamiento,"FUNCIONAMIENTO DE CONTADORES",get_estado(bueno_funcionamiento_contadores.isChecked(),false,malo_funcionamiento_contadores.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(6,id_funcionamiento,"FUNCIONAMIENTO SILBATO",get_estado(bueno_funcionamiento_silbato.isChecked(),false,malo_funcionamiento_silbato.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(7,id_funcionamiento,"SALIDA DE AGUJA",get_estado(bueno_salida_aguja.isChecked(),false,malo_salida_aguja.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(8,id_funcionamiento,"CALIBRACION",get_estado(bueno_calibracion.isChecked(),false,malo_calibracion.isChecked()));

                    ///REGISTRO DE LIMPIEZA Y DESINFECCION
                    id_funcionamiento++;
                    guardar_inspeccion_funcionamiento(id_funcionamiento,Observaciones_Limpieza.getText().toString(),CantidadAvesVacunadas.getText().toString(),id_servicio);

                    //REGISTO DETALLE DE LIMPIEZA Y DESINFECCION,
                    guardar_detalle_inspeccion_funcionamiento(1,id_funcionamiento,"MATERIALES UTILIZADOS",get_estado(bueno_materiales_utilizados.isChecked(),false,malo_materiales_utilizados.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(2,id_funcionamiento,"CAMBIO DE PIEZAS DESCARTABLES",get_estado(bueno_cambio_piezas.isChecked(),false,malo_cambio_piezas.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(3,id_funcionamiento,"LIMPIEZA DE PLACA TWIN TOUCH",get_estado(bueno_limpieza_placa.isChecked(),false,malo_limpieza_placa.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(4,id_funcionamiento,"ESTERILIZADO DE VALVULA",get_estado(bueno_esterilizado_valvula.isChecked(),false,malo_esterilizado_valvula.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(5,id_funcionamiento,"LIMPIEZA DE MODULO INYECTOR",get_estado(bueno_limpieza_modulo.isChecked(),false,malo_limpieza_modulo.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(6,id_funcionamiento,"LIMPIEZA DE CEREBRO",get_estado(bueno_limpieza_cerebro.isChecked(),false,malo_limpieza_cerebro.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(7,id_funcionamiento,"SECADO",get_estado(bueno_secado.isChecked(),false,malo_secado.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(8,id_funcionamiento,"PROTECCION",get_estado(bueno_proteccion.isChecked(),false,malo_proteccion.isChecked()));


/*
 registro.put("id",String.valueOf(id));
        registro.put("observaciones", observaciones);
        registro.put("frecuencia", frecuencia);
        registro.put("id_servicio", String.valueOf(id_servicio));
        bd.insert("inspeccion_funcionamiento", null, registro);
*/
                    Log.w("Twin Shot","Se registro correctamente.");
                }
                else
                {
                    Log.e("Twin Shot","Error al registrar un servicio de mantenimiento de la maquina TWIN SHOT");
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

    public int get_estadoNumero(String bueno,String regular,String malo)
    {
        int estado=0;
        if(bueno.equals("")==false)
        {
            estado=Integer.parseInt(bueno);
        }else if(regular.equals("")==false)
        {
            estado=Integer.parseInt(regular);
        }else if(malo.equals("")==false)
        {
            estado=Integer.parseInt(malo);
        }
        return estado;
    }



}
