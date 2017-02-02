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

public class Maquina_zootec extends AppCompatActivity implements View.OnClickListener {

    ArrayAdapter<String> adapter;
    AutoCompleteTextView autoCompania,autoMaquina,autoDireccion;
    EditText encargado,hora_ingreso,hora_salida,ultima_visita,fecha;
    EditText observacion_inspeccion,piezas_cambiadas_inspeccion,observacion_funcionamiento,frecuencia_uso_funcionamiento,observacion_desinfeccion,cantidad_aves_desinfeccion;

    RadioButton bueno_plato_divisor_gabinete,regular_plato_divisor_gabinete,malo_plato_divisor_gabinete;
    RadioButton bueno_cubierta_trasera,regular_cubierta_trasera,malo_cubierta_trasera;
    RadioButton bueno_bisagra_cubierta,regular_bisagra_cubierta,malo_bisagra_cubierta;
    RadioButton bueno_cubierta_del_frente,regular_cubierta_del_frente,malo_cubierta_del_frente;
    RadioButton bueno_tapa_inferior_gabinete,regular_tapa_inferior_gabinete,malo_tapa_inferior_gabinete;
    RadioButton bueno_pata_de_goma,regular_pata_de_goma,malo_pata_de_goma;
    RadioButton bueno_tornillo_cubierta_plato,regular_tornillo_cubierta_plato,malo_tornillo_cubierta_plato;
    RadioButton bueno_tuerca_montaje_plato,regular_tuerca_montaje_plato,malo_tuerca_montaje_plato;
    RadioButton bueno_boton_toque,regular_boton_toque,malo_boton_toque;
    RadioButton bueno_micro_valvula_cilidro,regular_micro_valvula_cilidro,malo_micro_valvula_cilidro;
    RadioButton bueno_cubierta_plato_colocacion,regular_cubierta_plato_colocacion,malo_cubierta_plato_colocacion;
    RadioButton bueno_plato_colocacion,regular_plato_colocacion,malo_plato_colocacion;
    RadioButton bueno_plato_colocacion_emsamblaje,regular_plato_colocacion_emsamblaje,malo_plato_colocacion_emsamblaje;
    RadioButton bueno_tornillo_para_ZT40x2,regular_tornillo_para_ZT40x2,malo_tornillo_para_ZT40x2;
    RadioButton bueno_placa_montaje_TTP,regular_placa_montaje_TTP,malo_placa_montaje_TTP;
    RadioButton bueno_conector_Y_4mm,regular_conector_Y_4mm,malo_conector_Y_4mm;
    RadioButton bueno_sensor_sangrado,regular_sensor_sangrado,malo_sensor_sangrado;
    RadioButton bueno_tornillo_para_ZT403NSx2,regular_tornillo_para_ZT403NSx2,malo_tornillo_para_ZT403NSx2;
    RadioButton bueno_boton_tactil,regular_boton_tactil,malo_boton_tactil;
    RadioButton bueno_TTP_cuerpo_placa,regular_TTP_cuerpo_placa,malo_TTP_cuerpo_placa;
    RadioButton bueno_conjunto_placa_tactil,regular_conjunto_placa_tactil,malo_conjunto_placa_tactil;
    RadioButton bueno_jeringa_secundaria01,regular_jeringa_secundaria01,malo_jeringa_secundaria01;
    RadioButton bueno_jeringa_secundaria02,regular_jeringa_secundaria02,malo_jeringa_secundaria02;
    RadioButton bueno_tuerca_seguridad_punta,regular_tuerca_seguridad_punta,malo_tuerca_seguridad_punta;
    RadioButton bueno_conector_ZT621NS,regular_conector_ZT621NS,malo_conector_ZT621NS;
    RadioButton bueno_tuberia_conectar_jeringasPSx10NS,regular_tuberia_conectar_jeringasPSx10NS,malo_tuberia_conectar_jeringasPSx10NS;
    RadioButton bueno_tuberia_conectar_jeringasPSx10,regular_tuberia_conectar_jeringasPSx10,malo_tuberia_conectar_jeringasPSx10;
    RadioButton bueno_juego_empaques_1millon01,regular_juego_empaques_1millon01,malo_juego_empaques_1millon01;
    RadioButton bueno_juego_empaques_1millon02,regular_juego_empaques_1millon02,malo_juego_empaques_1millon02;
    RadioButton bueno_manometro,regular_manometro,malo_manometro;
    RadioButton bueno_contador_de_lote,regular_contador_de_lote,malo_contador_de_lote;
    RadioButton bueno_contador_totalizador,regular_contador_totalizador,malo_contador_totalizador;
    RadioButton bueno_cubierta_cont_lote,regular_cubierta_cont_lote,malo_cubierta_cont_lote;
    RadioButton bueno_cubierta_cont_totalizador,regular_cubierta_cont_totalizador,malo_cubierta_cont_totalizador;
    RadioButton bueno_placa_fijar_cont_lote,regular_placa_fijar_cont_lote,malo_placa_fijar_cont_lote;
    RadioButton bueno_placa_fijar_cont_totalizador,regular_placa_fijar_cont_totalizador,malo_placa_fijar_cont_totalizador;
    RadioButton bueno_filtro_regulador,regular_filtro_regulador,malo_filtro_regulador;
    RadioButton bueno_conector_espigado14,regular_conector_espigado14,malo_conector_espigado14;
    RadioButton bueno_conector_macho_aire,regular_conector_macho_aire,malo_conector_macho_aire;
    RadioButton bueno_conector_hembra_aire,regular_conector_hembra_aire,malo_conector_hembra_aire;
    RadioButton bueno_acople_reductor_manometro,regular_acople_reductor_manometro,malo_acople_reductor_manometro;
    RadioButton bueno_tapon_de_gomaValAguja,regular_tapon_de_gomaValAguja,malo_tapon_de_gomaValAguja;

    RadioButton bueno_empaque_conector_macho_airex10,regular_empaque_conector_macho_airex10,malo_empaque_conector_macho_airex10;
    RadioButton bueno_plato_montaje_tornillos_manometro,regular_plato_montaje_tornillos_manometro,malo_plato_montaje_tornillos_manometro;
    RadioButton bueno_boton_reinicio_contador,regular_boton_reinicio_contador,malo_boton_reinicio_contador;
    RadioButton bueno_mecanismo_interno_botonReiniciador,regular_mecanismo_interno_botonReiniciador,malo_mecanismo_interno_botonReiniciador;
    RadioButton bueno_interruptor_encendido_apagado,regular_interruptor_encendido_apagado,malo_interruptor_encendido_apagado;
    RadioButton bueno_mec_interruptor_ONOF,regular_mec_interruptor_ONOF,malo_mec_interruptor_ONOF;
    RadioButton bueno_boton_prueba,regular_boton_prueba,malo_boton_prueba;
    RadioButton bueno_mec_interno_boton_prueba,regular_mec_interno_boton_prueba,malo_mec_interno_boton_prueba;
    RadioButton bueno_interruptor_preSeleccion,regular_interruptor_preSeleccion,malo_interruptor_preSeleccion;
    RadioButton bueno_mec_interruptor_preSeleccion,regular_mec_interruptor_preSeleccion,malo_mec_interruptor_preSeleccion;
    RadioButton bueno_valvula_neumaticaAguja,regular_valvula_neumaticaAguja,malo_valvula_neumaticaAguja;
    RadioButton bueno_celula_logica_azul,regular_celula_logica_azul,malo_celula_logica_azul;
    RadioButton bueno_celula_logica_gris,regular_celula_logica_gris,malo_celula_logica_gris;
    RadioButton bueno_celula_logica_amarilla,regular_celula_logica_amarilla,malo_celula_logica_amarilla;
    RadioButton bueno_valvula_activacionZT35,regular_valvula_activacionZT35,malo_valvula_activacionZT35;
    RadioButton bueno_ONOFF_interruptor_prueba,regular_ONOFF_interruptor_prueba,malo_ONOFF_interruptor_prueba;
    RadioButton bueno_ONOFF_mec_cambio_prueba,regular_ONOFF_mec_cambio_prueba,malo_ONOFF_mec_cambio_prueba;
    RadioButton bueno_simple_doble_mec_interruptorModo,regular_simple_doble_mec_interruptorModo,malo_simple_doble_mec_interruptorModo;
    RadioButton bueno_simple_doble_mec_interruptor,regular_simple_doble_mec_interruptor,malo_simple_doble_mec_interruptor;
    RadioButton bueno_conector_recto4mm,regular_conector_recto4mm,malo_conector_recto4mm;
    RadioButton bueno_valvula_retencion_linea,regular_valvula_retencion_linea,malo_valvula_retencion_linea;
    RadioButton bueno_valvula_unidireccional,regular_valvula_unidireccional,malo_valvula_unidireccional;
    RadioButton bueno_conectorT_4mm,regular_conectorT_4mm,malo_conectorT_4mm;
    RadioButton bueno_distribuidor_aire_multiple,regular_distribuidor_aire_multiple,malo_distribuidor_aire_multiple;
    RadioButton bueno_conector_cruz4mm,regular_conector_cruz4mm,malo_conector_cruz4mm;
    RadioButton bueno_valvula3salidas,regular_valvula3salidas,malo_valvula3salidas;
    RadioButton bueno_celula_base,regular_celula_base,malo_celula_base;
    RadioButton bueno_valvula_impulso,regular_valvula_impulso,malo_valvula_impulso;
    RadioButton bueno_espaciador_entrada_segundaJeringa,regular_espaciador_entrada_segundaJeringa,malo_espaciador_entrada_segundaJeringa;
    RadioButton bueno_cilidro_aire_tuercaMontaje,regular_cilidro_aire_tuercaMontaje,malo_cilidro_aire_tuercaMontaje;
    RadioButton bueno_conector4mm_cilindro_aire,regular_conector4mm_cilindro_aire,malo_conector4mm_cilindro_aire;
    RadioButton bueno_detector_manetico,regular_detector_manetico,malo_detector_manetico;
    RadioButton bueno_conector_acople,regular_conector_acople,malo_conector_acople;
    RadioButton bueno_impulsorEspaciador_jeringaSecundaria,regular_impulsorEspaciador_jeringaSecundaria,malo_impulsorEspaciador_jeringaSecundaria;
    RadioButton bueno_resorteSostenedor_jeringa,regular_resorteSostenedor_jeringa,malo_resorteSostenedor_jeringa;
    RadioButton bueno_sostenedor_jeringa,regular_sostenedor_jeringa,malo_sostenedor_jeringa;
    RadioButton bueno_tornillos_fijacion6x20,regular_tornillos_fijacion6x20,malo_tornillos_fijacion6x20;
    RadioButton bueno_tornillos_fijacion6x50,regular_tornillos_fijacion6x50,malo_tornillos_fijacion6x50;
    RadioButton bueno_placa_mont_sostenedorJeringa,regular_placa_mont_sostenedorJeringa,malo_placa_mont_sostenedorJeringa;
    RadioButton bueno_plato_guiaSostenedor_jeringa,regular_plato_guiaSostenedor_jeringa,malo_plato_guiaSostenedor_jeringa;
    RadioButton bueno_probeta_calibrador,regular_probeta_calibrador,malo_probeta_calibrador;
    RadioButton bueno_pieza_finalPiston,regular_pieza_finalPiston,malo_pieza_finalPiston;
    RadioButton bueno_resortes_embolo,regular_resortes_embolo,malo_resortes_embolo;
    RadioButton bueno_tuerca_tapaEmbolo,regular_tuerca_tapaEmbolo,malo_tuerca_tapaEmbolo;
    RadioButton bueno_tornillo_4x16,regular_tornillo_4x16,malo_tornillo_4x16;
    RadioButton bueno_aceite_vaselinaSpray,regular_aceite_vaselinaSpray,malo_aceite_vaselinaSpray;

    RadioButton bueno_ubicacion_maquina,malo_ubicacion_maquina;
    RadioButton bueno_presion_compresora,malo_presion_compresora;
    RadioButton bueno_presion_maquina,malo_presion_maquina;
    RadioButton bueno_activacion,malo_activacion;
    RadioButton bueno_funcion_contadores,malo_funcion_contadores;
    RadioButton bueno_funcion_silbato,malo_funcion_silbato;
    RadioButton bueno_salida_aguja,malo_salida_aguja;
    RadioButton bueno_calibracion,malo_calibracion;
    RadioButton bueno_materiales_utilizados,malo_materiales_utilizados;
    RadioButton bueno_cambio_descartables,malo_cambio_descartables;
    RadioButton bueno_limpieza_plato_colocacion,malo_limpieza_plato_colocacion;
    RadioButton bueno_esterilizado_jeringa,malo_esterilizado_jeringa;
    RadioButton bueno_limpieza_mod_inyector,malo_limpieza_mod_inyector;
    RadioButton bueno_limpieza_cerebro,malo_limpieza_cerebro;
    RadioButton bueno_secado,malo_secado;
    RadioButton bueno_proteccion,malo_proteccion;

    Button guardar,cancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maquina_zootec);

        autoCompania = (AutoCompleteTextView)findViewById(R.id.autoCompania);
        autoMaquina = (AutoCompleteTextView)findViewById(R.id.autoMaquina);
        autoDireccion=(AutoCompleteTextView)findViewById(R.id.autoDireccion);
        encargado=(EditText)findViewById(R.id.TextViewEncargado);
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

        bueno_plato_divisor_gabinete=(RadioButton)findViewById(R.id.BuenoPlatoDivisor);
        regular_plato_divisor_gabinete=(RadioButton)findViewById(R.id.RegularPlatoDivisor);
        malo_plato_divisor_gabinete=(RadioButton)findViewById(R.id.MaloPlatoDivisor);

        bueno_cubierta_trasera=(RadioButton)findViewById(R.id.BuenoCubiertaTraseraconLogo);
        regular_cubierta_trasera=(RadioButton)findViewById(R.id.RegularCubiertaTraseraconLogo);
        malo_cubierta_trasera=(RadioButton)findViewById(R.id.MaloCubiertaTraseraconLogo);

        bueno_bisagra_cubierta=(RadioButton)findViewById(R.id.BuenoBisagraParaLaCubierta);
        regular_bisagra_cubierta=(RadioButton)findViewById(R.id.RegularBisagraParaLaCubierta);
        malo_bisagra_cubierta=(RadioButton)findViewById(R.id.MaloBisagraParaLaCubierta);

        bueno_cubierta_del_frente=(RadioButton)findViewById(R.id.BuenoCubiertaEnAceroInox);
        regular_cubierta_del_frente=(RadioButton)findViewById(R.id.RegularCubiertaEnAceroInox);
        malo_cubierta_del_frente=(RadioButton)findViewById(R.id.MaloCubiertaEnAceroInox);

        bueno_tapa_inferior_gabinete=(RadioButton)findViewById(R.id.BuenoTapaInferiordelGabinete);
        regular_tapa_inferior_gabinete=(RadioButton)findViewById(R.id.RegularTapaInferiordelGabinete);
        malo_tapa_inferior_gabinete=(RadioButton)findViewById(R.id.MaloTapaInferiordelGabinete);

        bueno_pata_de_goma=(RadioButton)findViewById(R.id.BuenoPatadeGoma);
        regular_pata_de_goma=(RadioButton)findViewById(R.id.RegularPatadeGoma);
        malo_pata_de_goma=(RadioButton)findViewById(R.id.MaloPatadeGoma);

        bueno_tornillo_cubierta_plato=(RadioButton)findViewById(R.id.BuenoTornilloCuniertadePlato);
        regular_tornillo_cubierta_plato=(RadioButton)findViewById(R.id.RegularTornilloCuniertadePlato);
        malo_tornillo_cubierta_plato=(RadioButton)findViewById(R.id.MaloTornilloCuniertadePlato);

        bueno_tuerca_montaje_plato=(RadioButton)findViewById(R.id.BuenoTuercaMontajedelPlatodeColocacion);
        regular_tuerca_montaje_plato=(RadioButton)findViewById(R.id.RegularTuercaMontajedelPlatodeColocacion);
        malo_tuerca_montaje_plato=(RadioButton)findViewById(R.id.MaloTuercaMontajedelPlatodeColocacion);

        bueno_boton_toque=(RadioButton)findViewById(R.id.BuenoBotondeToque);
        regular_boton_toque=(RadioButton)findViewById(R.id.RegularBotondeToque);
        malo_boton_toque=(RadioButton)findViewById(R.id.MaloBotondeToque);

        bueno_micro_valvula_cilidro=(RadioButton)findViewById(R.id.BuenoMicroValvulaCilindro);
        regular_micro_valvula_cilidro=(RadioButton)findViewById(R.id.RegularMicroValvulaCilindro);
        malo_micro_valvula_cilidro=(RadioButton)findViewById(R.id.MaloMicroValvulaCilindro);

        bueno_cubierta_plato_colocacion=(RadioButton)findViewById(R.id.BuenoCubiertadelPlatoColocacion);
        regular_cubierta_plato_colocacion=(RadioButton)findViewById(R.id.RegularCubiertadelPlatoColocacion);
        malo_cubierta_plato_colocacion=(RadioButton)findViewById(R.id.MaloCubiertadelPlatoColocacion);

        bueno_plato_colocacion=(RadioButton)findViewById(R.id.BuenoPlatodeColocacion);
        regular_plato_colocacion=(RadioButton)findViewById(R.id.RegularPlatodeColocacion);
        malo_plato_colocacion=(RadioButton)findViewById(R.id.MaloPlatodeColocacion);

        bueno_plato_colocacion_emsamblaje=(RadioButton)findViewById(R.id.BuenoPlatoColocacionEmsamblaje);
        regular_plato_colocacion_emsamblaje=(RadioButton)findViewById(R.id.RegularPlatoColocacionEmsamblaje);
        malo_plato_colocacion_emsamblaje=(RadioButton)findViewById(R.id.MaloPlatoColocacionEmsamblaje);

        bueno_tornillo_para_ZT40x2=(RadioButton)findViewById(R.id.BuenoTornilloZt40pns);
        regular_tornillo_para_ZT40x2=(RadioButton)findViewById(R.id.RegularTornilloZt40pns);
        malo_tornillo_para_ZT40x2=(RadioButton)findViewById(R.id.MaloTornilloZt40pns);

        bueno_placa_montaje_TTP=(RadioButton)findViewById(R.id.BuenoPlacadeMontajeTTP);
        regular_placa_montaje_TTP=(RadioButton)findViewById(R.id.RegularPlacadeMontajeTTP);
        malo_placa_montaje_TTP=(RadioButton)findViewById(R.id.MaloPlacadeMontajeTTP);

        bueno_conector_Y_4mm=(RadioButton)findViewById(R.id.BuenoConectorY4mm);
        regular_conector_Y_4mm=(RadioButton)findViewById(R.id.RegularConectorY4mm);
        malo_conector_Y_4mm=(RadioButton)findViewById(R.id.MaloConectorY4mm);

        bueno_sensor_sangrado=(RadioButton)findViewById(R.id.BuenoSensordeSangrado);
        regular_sensor_sangrado=(RadioButton)findViewById(R.id.RegularSensordeSangrado);
        malo_sensor_sangrado=(RadioButton)findViewById(R.id.MaloSensordeSangrado);

        bueno_tornillo_para_ZT403NSx2=(RadioButton)findViewById(R.id.BuenoTornilloZT403NS);
        regular_tornillo_para_ZT403NSx2=(RadioButton)findViewById(R.id.RegularTornilloZT403NS);
        malo_tornillo_para_ZT403NSx2=(RadioButton)findViewById(R.id.MaloTornilloZT403NS);

        bueno_boton_tactil=(RadioButton)findViewById(R.id.BuenoBotonTactil);
        regular_boton_tactil=(RadioButton)findViewById(R.id.RegularBotonTactil);
        malo_boton_tactil=(RadioButton)findViewById(R.id.MaloBotonTactil);

        bueno_TTP_cuerpo_placa=(RadioButton)findViewById(R.id.BuenoCuerpodelaPlaca);
        regular_TTP_cuerpo_placa=(RadioButton)findViewById(R.id.RegularCuerpodelaPlaca);
        malo_TTP_cuerpo_placa=(RadioButton)findViewById(R.id.MaloCuerpodelaPlaca);

        bueno_conjunto_placa_tactil=(RadioButton)findViewById(R.id.BuenoConjuntodePlacaTactil);
        regular_conjunto_placa_tactil=(RadioButton)findViewById(R.id.RegularConjuntodePlacaTactil);
        malo_conjunto_placa_tactil=(RadioButton)findViewById(R.id.MaloConjuntodePlacaTactil);

        bueno_jeringa_secundaria01=(RadioButton)findViewById(R.id.BuenoJeringaSecundaria01ml);
        regular_jeringa_secundaria01=(RadioButton)findViewById(R.id.RegularJeringaSecundaria01ml);
        malo_jeringa_secundaria01=(RadioButton)findViewById(R.id.MaloJeringaSecundaria01ml);

        bueno_jeringa_secundaria02=(RadioButton)findViewById(R.id.BuenoJeringaSecundario2ml);
        regular_jeringa_secundaria02=(RadioButton)findViewById(R.id.RegularJeringaSecundario2ml);
        malo_jeringa_secundaria02=(RadioButton)findViewById(R.id.MaloJeringaSecundario2ml);

        bueno_tuerca_seguridad_punta=(RadioButton)findViewById(R.id.BuenoTuercaSeguridadPuntaJeringa);
        regular_tuerca_seguridad_punta=(RadioButton)findViewById(R.id.RegularTuercaSeguridadPuntaJeringa);
        malo_tuerca_seguridad_punta=(RadioButton)findViewById(R.id.MaloTuercaSeguridadPuntaJeringa);

        bueno_conector_ZT621NS=(RadioButton)findViewById(R.id.BuenoConectorZT621NS);
        regular_conector_ZT621NS=(RadioButton)findViewById(R.id.RegularConectorZT621NS);
        malo_conector_ZT621NS=(RadioButton)findViewById(R.id.MaloConectorZT621NS);

        bueno_tuberia_conectar_jeringasPSx10NS=(RadioButton)findViewById(R.id.BuenoTuberiaParaJeringasx10NS);
        regular_tuberia_conectar_jeringasPSx10NS=(RadioButton)findViewById(R.id.RegularTuberiaParaJeringasx10NS);
        malo_tuberia_conectar_jeringasPSx10NS=(RadioButton)findViewById(R.id.MaloTuberiaParaJeringasx10NS);

        bueno_tuberia_conectar_jeringasPSx10=(RadioButton)findViewById(R.id.BuenoTuberiaParaConectarJeringasx10);
        regular_tuberia_conectar_jeringasPSx10=(RadioButton)findViewById(R.id.RegularTuberiaParaConectarJeringasx10);
        malo_tuberia_conectar_jeringasPSx10=(RadioButton)findViewById(R.id.MaloTuberiaParaConectarJeringasx10);

        bueno_juego_empaques_1millon01=(RadioButton)findViewById(R.id.BuenoJuegoEmpaques01ml);
        regular_juego_empaques_1millon01=(RadioButton)findViewById(R.id.RegularJuegoEmpaques01ml);
        malo_juego_empaques_1millon01=(RadioButton)findViewById(R.id.MaloJuegoEmpaques01ml);

        bueno_juego_empaques_1millon02=(RadioButton)findViewById(R.id.BuenoJuegoEmpaques02ml);
        regular_juego_empaques_1millon02=(RadioButton)findViewById(R.id.RegularJuegoEmpaques02ml);
        malo_juego_empaques_1millon02=(RadioButton)findViewById(R.id.MaloJuegoEmpaques02ml);

        bueno_manometro=(RadioButton)findViewById(R.id.BuenoManometro);
        regular_manometro=(RadioButton)findViewById(R.id.RegularManometro);
        malo_manometro=(RadioButton)findViewById(R.id.MaloManometro);

        bueno_contador_de_lote=(RadioButton)findViewById(R.id.BuenoContadordeLote);
        regular_contador_de_lote=(RadioButton)findViewById(R.id.RegularContadordeLote);
        malo_contador_de_lote=(RadioButton)findViewById(R.id.MaloContadordeLote);

        bueno_contador_totalizador=(RadioButton)findViewById(R.id.BuenoContadortotalizador);
        regular_contador_totalizador=(RadioButton)findViewById(R.id.RegularContadortotalizador);
        malo_contador_totalizador=(RadioButton)findViewById(R.id.MaloContadortotalizador);

        bueno_cubierta_cont_lote=(RadioButton)findViewById(R.id.BuenoCubiertaConLote);
        regular_cubierta_cont_lote=(RadioButton)findViewById(R.id.RegularCubiertaConLote);
        malo_cubierta_cont_lote=(RadioButton)findViewById(R.id.MaloCubiertaConLote);

        bueno_cubierta_cont_totalizador=(RadioButton)findViewById(R.id.BuenoCubiertaContTotalizador);
        regular_cubierta_cont_totalizador=(RadioButton)findViewById(R.id.RegularCubiertaContTotalizador);
        malo_cubierta_cont_totalizador=(RadioButton)findViewById(R.id.RegularCubiertaContTotalizador);

        bueno_placa_fijar_cont_lote=(RadioButton)findViewById(R.id.BuenoPlacaFijarContLote);
        regular_placa_fijar_cont_lote=(RadioButton)findViewById(R.id.RegularPlacaFijarContLote);
        malo_placa_fijar_cont_lote=(RadioButton)findViewById(R.id.MaloPlacaFijarContLote);

        bueno_placa_fijar_cont_totalizador=(RadioButton)findViewById(R.id.BuenoPlacaFijarContotalizador);
        regular_placa_fijar_cont_totalizador=(RadioButton)findViewById(R.id.RegularPlacaFijarContotalizador);
        malo_placa_fijar_cont_totalizador=(RadioButton)findViewById(R.id.MaloPlacaFijarContotalizador);

        bueno_filtro_regulador=(RadioButton)findViewById(R.id.BuenoFiltroRegulador);
        regular_filtro_regulador=(RadioButton)findViewById(R.id.RegularFiltroRegulador);
        malo_filtro_regulador=(RadioButton)findViewById(R.id.MaloFiltroRegulador);

        bueno_conector_espigado14=(RadioButton)findViewById(R.id.BuenoConectorEspigado);
        regular_conector_espigado14=(RadioButton)findViewById(R.id.RegularConectorEspigado);
        malo_conector_espigado14=(RadioButton)findViewById(R.id.MaloConectorEspigado);

        bueno_conector_macho_aire=(RadioButton)findViewById(R.id.BuenoConectorMAchoAire);
        regular_conector_macho_aire=(RadioButton)findViewById(R.id.RegularConectorMAchoAire);
        malo_conector_macho_aire=(RadioButton)findViewById(R.id.RegularConectorMAchoAire);

        bueno_conector_hembra_aire=(RadioButton)findViewById(R.id.BuenoConectorHembraaire);
        regular_conector_hembra_aire=(RadioButton)findViewById(R.id.RegularConectorHembraaire);
        malo_conector_hembra_aire=(RadioButton)findViewById(R.id.MaloConectorHembraaire);

        bueno_acople_reductor_manometro=(RadioButton)findViewById(R.id.BuenoAcopleReductorMAnometro);
        regular_acople_reductor_manometro=(RadioButton)findViewById(R.id.RegularAcopleReductorMAnometro);
        malo_acople_reductor_manometro=(RadioButton)findViewById(R.id.MaloAcopleReductorMAnometro);

        bueno_tapon_de_gomaValAguja=(RadioButton)findViewById(R.id.BuenoTapondeGoma);
        regular_tapon_de_gomaValAguja=(RadioButton)findViewById(R.id.RegularTapondeGoma);
        malo_tapon_de_gomaValAguja=(RadioButton)findViewById(R.id.MaloTapondeGoma);

        bueno_empaque_conector_macho_airex10=(RadioButton)findViewById(R.id.BuenoEmpaqueConectorMAcho);
        regular_empaque_conector_macho_airex10=(RadioButton)findViewById(R.id.RegularEmpaqueConectorMAcho);
        malo_empaque_conector_macho_airex10=(RadioButton)findViewById(R.id.MaloEmpaqueConectorMAcho);

        bueno_plato_montaje_tornillos_manometro=(RadioButton)findViewById(R.id.BuenoPlatoMontajeTornilloManometro);
        regular_plato_montaje_tornillos_manometro=(RadioButton)findViewById(R.id.RegularPlatoMontajeTornilloManometro);
        malo_plato_montaje_tornillos_manometro=(RadioButton)findViewById(R.id.MaloPlatoMontajeTornilloManometro);

        bueno_boton_reinicio_contador=(RadioButton)findViewById(R.id.BuenoBotondeReiniciodelContador);
        regular_boton_reinicio_contador=(RadioButton)findViewById(R.id.RegularBotondeReiniciodelContador);
        malo_boton_reinicio_contador=(RadioButton)findViewById(R.id.MaloBotondeReiniciodelContador);

        bueno_mecanismo_interno_botonReiniciador=(RadioButton)findViewById(R.id.BuenoMecanismoInternoBoton);
        regular_mecanismo_interno_botonReiniciador=(RadioButton)findViewById(R.id.RegularMecanismoInternoBoton);
        malo_mecanismo_interno_botonReiniciador=(RadioButton)findViewById(R.id.MaloMecanismoInternoBoton);

        bueno_interruptor_encendido_apagado=(RadioButton)findViewById(R.id.BuenoInterruptorENcendido);
        regular_interruptor_encendido_apagado=(RadioButton)findViewById(R.id.RegularInterruptorENcendido);
        malo_interruptor_encendido_apagado=(RadioButton)findViewById(R.id.MaloInterruptorENcendido);

        bueno_mec_interruptor_ONOF=(RadioButton)findViewById(R.id.BuenoMecanismoInternoBoton);
        regular_mec_interruptor_ONOF=(RadioButton)findViewById(R.id.RegularMecanismoInternoBoton);
        malo_mec_interruptor_ONOF=(RadioButton)findViewById(R.id.MaloMecanismoInternoBoton);

        bueno_boton_prueba=(RadioButton)findViewById(R.id.BuenoBotondePrueba);
        regular_boton_prueba=(RadioButton)findViewById(R.id.RegularBotondePrueba);
        malo_boton_prueba=(RadioButton)findViewById(R.id.MaloBotondePrueba);

        bueno_mec_interno_boton_prueba=(RadioButton)findViewById(R.id.BuenoMecanismoInternoBoton);
        regular_mec_interno_boton_prueba=(RadioButton)findViewById(R.id.RegularMecanismoInternoBoton);
        malo_mec_interno_boton_prueba=(RadioButton)findViewById(R.id.MaloMecanismoInternoBoton);

        bueno_interruptor_preSeleccion=(RadioButton)findViewById(R.id.BuenoInterruptorPReseleccion);
        regular_interruptor_preSeleccion=(RadioButton)findViewById(R.id.RegularInterruptorPReseleccion);
        malo_interruptor_preSeleccion=(RadioButton)findViewById(R.id.MaloInterruptorPReseleccion);

        bueno_mec_interruptor_preSeleccion=(RadioButton)findViewById(R.id.BuenoMecInterPreSeleccion);
        regular_mec_interruptor_preSeleccion=(RadioButton)findViewById(R.id.RegularMecInterPreSeleccion);
        malo_mec_interruptor_preSeleccion=(RadioButton)findViewById(R.id.MaloMecInterPreSeleccion);

        bueno_valvula_neumaticaAguja=(RadioButton)findViewById(R.id.BuenoValvulaNeumaticaAguja);
        regular_valvula_neumaticaAguja=(RadioButton)findViewById(R.id.RegularValvulaNeumaticaAguja);
        malo_valvula_neumaticaAguja=(RadioButton)findViewById(R.id.MaloValvulaNeumaticaAguja);

        bueno_celula_logica_azul=(RadioButton)findViewById(R.id.BuenoCelulaLogicaAzul);
        regular_celula_logica_azul=(RadioButton)findViewById(R.id.RegularCelulaLogicaAzul);
        malo_celula_logica_azul=(RadioButton)findViewById(R.id.MaloCelulaLogicaAzul);

        bueno_celula_logica_gris=(RadioButton)findViewById(R.id.BuenoCelulaLogicaGris);
        regular_celula_logica_gris=(RadioButton)findViewById(R.id.RegularCelulaLogicaGris);
        malo_celula_logica_gris=(RadioButton)findViewById(R.id.MaloCelulaLogicaGris);

        bueno_celula_logica_amarilla=(RadioButton)findViewById(R.id.BuenoCelulaLogicaamarrilla);
        regular_celula_logica_amarilla=(RadioButton)findViewById(R.id.RegularCelulaLogicaamarrilla);
        malo_celula_logica_amarilla=(RadioButton)findViewById(R.id.MaloCelulaLogicaamarrilla);

        bueno_valvula_activacionZT35=(RadioButton)findViewById(R.id.BuenoValvulaDeActivacion);
        regular_valvula_activacionZT35=(RadioButton)findViewById(R.id.RegularValvulaDeActivacion);
        malo_valvula_activacionZT35=(RadioButton)findViewById(R.id.MaloValvulaDeActivacion);

        bueno_ONOFF_interruptor_prueba=(RadioButton)findViewById(R.id.BuenoOnOffInterruptor);
        regular_ONOFF_interruptor_prueba=(RadioButton)findViewById(R.id.RegularOnOffInterruptor);
        malo_ONOFF_interruptor_prueba=(RadioButton)findViewById(R.id.MaloOnOffInterruptor);

        bueno_ONOFF_mec_cambio_prueba=(RadioButton)findViewById(R.id.BuenoOnOffMecanismodeCambio);
        regular_ONOFF_mec_cambio_prueba=(RadioButton)findViewById(R.id.RegularOnOffMecanismodeCambio);
        malo_ONOFF_mec_cambio_prueba=(RadioButton)findViewById(R.id.MaloOnOffMecanismodeCambio);

        bueno_simple_doble_mec_interruptorModo=(RadioButton)findViewById(R.id.BuenoSimpleDobleMecanismodelInterruptor);
        regular_simple_doble_mec_interruptorModo=(RadioButton)findViewById(R.id.RegularSimpleDobleMecanismodelInterruptor);
        malo_simple_doble_mec_interruptorModo=(RadioButton)findViewById(R.id.MaloSimpleDobleMecanismodelInterruptor);

        bueno_simple_doble_mec_interruptor=(RadioButton)findViewById(R.id.BuenoSimpleDobleMecanismo);
        regular_simple_doble_mec_interruptor=(RadioButton)findViewById(R.id.RegularSimpleDobleMecanismo);
        malo_simple_doble_mec_interruptor=(RadioButton)findViewById(R.id.MaloSimpleDobleMecanismo);

        bueno_conector_recto4mm=(RadioButton)findViewById(R.id.BuenoConectorrecto4mm);
        regular_conector_recto4mm=(RadioButton)findViewById(R.id.RegularConectorrecto4mm);
        malo_conector_recto4mm=(RadioButton)findViewById(R.id.MaloConectorrecto4mm);

        bueno_valvula_retencion_linea=(RadioButton)findViewById(R.id.BuenoValvulaRetencionLinea);
        regular_valvula_retencion_linea=(RadioButton)findViewById(R.id.RegularValvulaRetencionLinea);
        malo_valvula_retencion_linea=(RadioButton)findViewById(R.id.MaloValvulaRetencionLinea);

        bueno_valvula_unidireccional=(RadioButton)findViewById(R.id.BuenoValuvulaUnidireccional);
        regular_valvula_unidireccional=(RadioButton)findViewById(R.id.RegularValuvulaUnidireccional);
        malo_valvula_unidireccional=(RadioButton)findViewById(R.id.MaloValuvulaUnidireccional);

        bueno_conectorT_4mm=(RadioButton)findViewById(R.id.BuenoConectorT4mm);
        regular_conectorT_4mm=(RadioButton)findViewById(R.id.RegularConectorT4mm);
        malo_conectorT_4mm=(RadioButton)findViewById(R.id.MaloConectorT4mm);

        bueno_distribuidor_aire_multiple=(RadioButton)findViewById(R.id.BuenoDistribuidordeAireMultiple);
        regular_distribuidor_aire_multiple=(RadioButton)findViewById(R.id.RegularDistribuidordeAireMultiple);
        malo_distribuidor_aire_multiple=(RadioButton)findViewById(R.id.MaloDistribuidordeAireMultiple);
        bueno_conector_cruz4mm=(RadioButton)findViewById(R.id.BuenoConectorenCruz4mm);
        regular_conector_cruz4mm=(RadioButton)findViewById(R.id.RegularConectorenCruz4mm);
        malo_conector_cruz4mm=(RadioButton)findViewById(R.id.MaloConectorenCruz4mm);
        bueno_valvula3salidas=(RadioButton)findViewById(R.id.BuenoValvula3salidasMac);
        regular_valvula3salidas=(RadioButton)findViewById(R.id.RegularValvula3salidasMac);
        malo_valvula3salidas=(RadioButton)findViewById(R.id.MaloValvula3salidasMac);
        bueno_celula_base=(RadioButton)findViewById(R.id.BuenoCelulabaseAmarillo);
        regular_celula_base=(RadioButton)findViewById(R.id.RegularCelulabaseAmarillo);
        malo_celula_base=(RadioButton)findViewById(R.id.MaloCelulabaseAmarillo);
        bueno_valvula_impulso=(RadioButton)findViewById(R.id.BuenoValvuladeImpulsoConector);
        regular_valvula_impulso=(RadioButton)findViewById(R.id.RegularValvuladeImpulsoConector);
        malo_valvula_impulso=(RadioButton)findViewById(R.id.MaloValvuladeImpulsoConector);
        bueno_espaciador_entrada_segundaJeringa=(RadioButton)findViewById(R.id.BuenoEspaciadorentradaSegundaJeringa);
        regular_espaciador_entrada_segundaJeringa=(RadioButton)findViewById(R.id.RegularEspaciadorentradaSegundaJeringa);
        malo_espaciador_entrada_segundaJeringa=(RadioButton)findViewById(R.id.MaloEspaciadorentradaSegundaJeringa);
        bueno_cilidro_aire_tuercaMontaje=(RadioButton)findViewById(R.id.BuenoCilindroAireTuercaMontaje);
        regular_cilidro_aire_tuercaMontaje=(RadioButton)findViewById(R.id.RegularCilindroAireTuercaMontaje);
        malo_cilidro_aire_tuercaMontaje=(RadioButton)findViewById(R.id.MaloCilindroAireTuercaMontaje);
        bueno_conector4mm_cilindro_aire=(RadioButton)findViewById(R.id.BuenoConectorde4mmCilindroaire);
        regular_conector4mm_cilindro_aire=(RadioButton)findViewById(R.id.RegularConectorde4mmCilindroaire);
        malo_conector4mm_cilindro_aire=(RadioButton)findViewById(R.id.MaloConectorde4mmCilindroaire);
        bueno_detector_manetico=(RadioButton)findViewById(R.id.BuenoDetectorMAnetico);
        regular_detector_manetico=(RadioButton)findViewById(R.id.RegularDetectorMAnetico);
        malo_detector_manetico=(RadioButton)findViewById(R.id.MaloDetectorMAnetico);
        bueno_conector_acople=(RadioButton)findViewById(R.id.BuenoImpulsadorEspaciador);
        regular_conector_acople=(RadioButton)findViewById(R.id.RegularImpulsadorEspaciador);
        malo_conector_acople=(RadioButton)findViewById(R.id.MaloImpulsadorEspaciador);
        bueno_impulsorEspaciador_jeringaSecundaria=(RadioButton)findViewById(R.id.BuenoImpulsadorEspaciador);
        regular_impulsorEspaciador_jeringaSecundaria=(RadioButton)findViewById(R.id.RegularImpulsadorEspaciador);
        malo_impulsorEspaciador_jeringaSecundaria=(RadioButton)findViewById(R.id.MaloImpulsadorEspaciador);
        bueno_resorteSostenedor_jeringa=(RadioButton)findViewById(R.id.BuenoResortessostenedorJeringa);
        regular_resorteSostenedor_jeringa=(RadioButton)findViewById(R.id.RegularResortessostenedorJeringa);
        malo_resorteSostenedor_jeringa=(RadioButton)findViewById(R.id.MaloResortessostenedorJeringa);
        bueno_sostenedor_jeringa=(RadioButton)findViewById(R.id.BuenosostenedorJeringa);
        regular_sostenedor_jeringa=(RadioButton)findViewById(R.id.RegularsostenedorJeringa);
        malo_sostenedor_jeringa=(RadioButton)findViewById(R.id.MalosostenedorJeringa);
        bueno_tornillos_fijacion6x20=(RadioButton)findViewById(R.id.BuenoTornillosdeFijacion6x20);
        regular_tornillos_fijacion6x20=(RadioButton)findViewById(R.id.RegularTornillosdeFijacion6x20);
        malo_tornillos_fijacion6x20=(RadioButton)findViewById(R.id.MaloTornillosdeFijacion6x20);
        bueno_tornillos_fijacion6x50=(RadioButton)findViewById(R.id.BuenoTornillosFijacion6x50);
        regular_tornillos_fijacion6x50=(RadioButton)findViewById(R.id.RegularTornillosFijacion6x50);
        malo_tornillos_fijacion6x50=(RadioButton)findViewById(R.id.MaloTornillosFijacion6x50);
        bueno_placa_mont_sostenedorJeringa=(RadioButton)findViewById(R.id.BuenoPlacaMonsostenedorJeringa);
        regular_placa_mont_sostenedorJeringa=(RadioButton)findViewById(R.id.RegularPlacaMonsostenedorJeringa);
        malo_placa_mont_sostenedorJeringa=(RadioButton)findViewById(R.id.MaloPlacaMonsostenedorJeringa);
        bueno_plato_guiaSostenedor_jeringa=(RadioButton)findViewById(R.id.BuenoPlatosostenedorDeJeringa);
        regular_plato_guiaSostenedor_jeringa=(RadioButton)findViewById(R.id.RegularPlatosostenedorDeJeringa);
        malo_plato_guiaSostenedor_jeringa=(RadioButton)findViewById(R.id.MaloPlatosostenedorDeJeringa);
        bueno_probeta_calibrador=(RadioButton)findViewById(R.id.BuenoProbetaCalibrador);
        regular_probeta_calibrador=(RadioButton)findViewById(R.id.RegularProbetaCalibrador);
        malo_probeta_calibrador=(RadioButton)findViewById(R.id.MaloProbetaCalibrador);
        bueno_pieza_finalPiston=(RadioButton)findViewById(R.id.BuenoPiezafinalPistonJeringa);
        regular_pieza_finalPiston=(RadioButton)findViewById(R.id.RegularPiezafinalPistonJeringa);
        malo_pieza_finalPiston=(RadioButton)findViewById(R.id.MaloPiezafinalPistonJeringa);
        bueno_resortes_embolo=(RadioButton)findViewById(R.id.BuenoResortesEmbolo);
        regular_resortes_embolo=(RadioButton)findViewById(R.id.RegularResortesEmbolo);
        malo_resortes_embolo=(RadioButton)findViewById(R.id.MaloResortesEmbolo);
        bueno_tuerca_tapaEmbolo=(RadioButton)findViewById(R.id.BuenoTuercaTapaEmbolo);
        regular_tuerca_tapaEmbolo=(RadioButton)findViewById(R.id.RegularTuercaTapaEmbolo);
        malo_tuerca_tapaEmbolo=(RadioButton)findViewById(R.id.MaloTuercaTapaEmbolo);
        bueno_tornillo_4x16=(RadioButton)findViewById(R.id.BuenoTornillo4x16);
        regular_tornillo_4x16=(RadioButton)findViewById(R.id.RegularTornillo4x16);
        malo_tornillo_4x16=(RadioButton)findViewById(R.id.MaloTornillo4x16);
        bueno_aceite_vaselinaSpray=(RadioButton)findViewById(R.id.BuenoAceiteVegetal);
        regular_aceite_vaselinaSpray=(RadioButton)findViewById(R.id.RegularAceiteVegetal);
        malo_aceite_vaselinaSpray=(RadioButton)findViewById(R.id.MaloAceiteVegetal);
        bueno_ubicacion_maquina=(RadioButton)findViewById(R.id.BuenoUbicaciondelaMAquina);
        malo_ubicacion_maquina=(RadioButton)findViewById(R.id.MaloUbicaciondelaMAquina);
        bueno_presion_compresora=(RadioButton)findViewById(R.id.BuenoPresionCompresora);
        malo_presion_compresora=(RadioButton)findViewById(R.id.MaloPresionCompresora);
        bueno_presion_maquina=(RadioButton)findViewById(R.id.BuenoPresionMAquina);malo_presion_maquina=(RadioButton)findViewById(R.id.MaloPresionMAquina);
        bueno_activacion=(RadioButton)findViewById(R.id.BuenoActivacion);malo_activacion=(RadioButton)findViewById(R.id.MaloActivacion);
        bueno_funcion_contadores=(RadioButton)findViewById(R.id.BuenoFuncionesDeContadores);malo_funcion_contadores=(RadioButton)findViewById(R.id.MaloFuncionesDeContadores);
        bueno_funcion_silbato=(RadioButton)findViewById(R.id.BuenoFuncionesdeSilvato);malo_funcion_silbato=(RadioButton)findViewById(R.id.MaloFuncionesdeSilvato);
        bueno_salida_aguja=(RadioButton)findViewById(R.id.BuenoSalidadeAguja);malo_salida_aguja=(RadioButton)findViewById(R.id.MaloSalidadeAguja);
        bueno_calibracion=(RadioButton)findViewById(R.id.BuenoCalibracion);malo_calibracion=(RadioButton)findViewById(R.id.MaloCalibracion);
        bueno_materiales_utilizados=(RadioButton)findViewById(R.id.BuenoMaterialesUtilizados);malo_materiales_utilizados=(RadioButton)findViewById(R.id.MaloMaterialesUtilizados);
        bueno_cambio_descartables=(RadioButton)findViewById(R.id.BuenoCambioPiezasDescartables);malo_cambio_descartables=(RadioButton)findViewById(R.id.MaloCambioPiezasDescartables);
        bueno_limpieza_plato_colocacion=(RadioButton)findViewById(R.id.BuenoLimpiezadePlatoColocaion);malo_limpieza_plato_colocacion=(RadioButton)findViewById(R.id.MaloLimpiezadePlatoColocaion);
        bueno_esterilizado_jeringa=(RadioButton)findViewById(R.id.BuenoEsterilizadodeJeringa);malo_esterilizado_jeringa=(RadioButton)findViewById(R.id.MaloEsterilizadodeJeringa);
        bueno_limpieza_mod_inyector=(RadioButton)findViewById(R.id.BuenoLimpiezaModuloInyector);malo_limpieza_mod_inyector=(RadioButton)findViewById(R.id.MaloLimpiezaModuloInyector);
        bueno_limpieza_cerebro=(RadioButton)findViewById(R.id.BuenoLimpiezadelCerebro);malo_limpieza_cerebro=(RadioButton)findViewById(R.id.MaloLimpiezadelCerebro);
        bueno_secado=(RadioButton)findViewById(R.id.BuenoSecado);malo_secado=(RadioButton)findViewById(R.id.MaloSecado);
        bueno_proteccion=(RadioButton)findViewById(R.id.BuenoProteccion);malo_proteccion=(RadioButton)findViewById(R.id.MaloProteccion);



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

    public void guardar_detalle_inspeccion_visual(int id,int id_inspeccion, String CodSistema, String codigo,String descripcion,int estado)
    {
        SQLite admin = new SQLite(this,
                "invetsa", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();

        registro.put("id",String.valueOf(id));
        registro.put("id_inspeccion", String.valueOf(id_inspeccion));
        registro.put("codigosistema",CodSistema);
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

                    guardar_detalle_inspeccion_visual(1,id_inspeccion,"","ZT50","PLATO DIVISOR DEL MEDIO DEL GABINETE",get_estado(bueno_plato_divisor_gabinete.isChecked(),regular_plato_divisor_gabinete.isChecked(),malo_plato_divisor_gabinete.isChecked()));
                    guardar_detalle_inspeccion_visual(2,id_inspeccion,"","ZT51M-ZT51D","CUBIERTA TRASERA CON LOGO MERIAL",get_estado(bueno_cubierta_trasera.isChecked(),regular_cubierta_trasera.isChecked(),malo_cubierta_trasera.isChecked()));
                    guardar_detalle_inspeccion_visual(3,id_inspeccion,"PRTO-00477","ZT52","BISAGRA PARA LA CUBIERTA DEL FRENTE",get_estado(bueno_bisagra_cubierta.isChecked(),regular_bisagra_cubierta.isChecked(),malo_bisagra_cubierta.isChecked()));
                    guardar_detalle_inspeccion_visual(4,id_inspeccion,"","ZT53S-ZT53DNS","CUBIERTA DEL FRENTE EN ACERO INOX",get_estado(bueno_cubierta_del_frente.isChecked(),regular_cubierta_del_frente.isChecked(),malo_cubierta_del_frente.isChecked()));
                    guardar_detalle_inspeccion_visual(5,id_inspeccion,"","ZT54-ZT54D","TAPA INFERIOR DEL GABINETE",get_estado(bueno_tapa_inferior_gabinete.isChecked(),regular_tapa_inferior_gabinete.isChecked(),malo_tapa_inferior_gabinete.isChecked()));
                    guardar_detalle_inspeccion_visual(6,id_inspeccion,"RPTO-00478","ZT55","PATA DE GOMA",get_estado(bueno_pata_de_goma.isChecked(),regular_pata_de_goma.isChecked(),malo_pata_de_goma.isChecked()));
                    guardar_detalle_inspeccion_visual(7,id_inspeccion,"RPTO-00363","ZT46","TORNILLO P/L CUBIERTA DE PLATO",get_estado(bueno_tornillo_cubierta_plato.isChecked(),regular_tornillo_cubierta_plato.isChecked(),malo_tornillo_cubierta_plato.isChecked()));
                    guardar_detalle_inspeccion_visual(8,id_inspeccion,"RPTO-00508","ZT45","TUERCA MONTAJE DEL PLATO DE COLOCACION",get_estado(bueno_tuerca_montaje_plato.isChecked(),regular_tuerca_montaje_plato.isChecked(),malo_tuerca_montaje_plato.isChecked()));
                    guardar_detalle_inspeccion_visual(9,id_inspeccion,"RPTO-00362","ZT44","BOTON DE TOQUE",get_estado(bueno_boton_toque.isChecked(),regular_boton_toque.isChecked(),malo_boton_toque.isChecked()));
                    guardar_detalle_inspeccion_visual(10,id_inspeccion,"RPTO-00349","ZT43","MICRO VALVULA P.ACTIVAR CILINDRO DE AIRE",get_estado(bueno_micro_valvula_cilidro.isChecked(),regular_micro_valvula_cilidro.isChecked(),malo_micro_valvula_cilidro.isChecked()));
                    guardar_detalle_inspeccion_visual(11,id_inspeccion,"","ZT42","CUBIERTA DEL PLATO DE COLOCACION",get_estado(bueno_cubierta_plato_colocacion.isChecked(),regular_cubierta_plato_colocacion.isChecked(),malo_cubierta_plato_colocacion.isChecked()));
                    guardar_detalle_inspeccion_visual(12,id_inspeccion,"","ZT41","PLATO DE COLOCACION",get_estado(bueno_plato_colocacion.isChecked(),regular_plato_colocacion.isChecked(),malo_plato_colocacion.isChecked()));
                    guardar_detalle_inspeccion_visual(13,id_inspeccion,"","ZT40","PLATO DE COLOCACION EMSAMBLAJE CUBIERTA",get_estado(bueno_plato_colocacion_emsamblaje.isChecked(),regular_plato_colocacion_emsamblaje.isChecked(),malo_plato_colocacion_emsamblaje.isChecked()));
                    guardar_detalle_inspeccion_visual(14,id_inspeccion,"","ZT410","TORNILLO PARA ZT409NS(x2)",get_estado(bueno_tornillo_para_ZT40x2.isChecked(),regular_tornillo_para_ZT40x2.isChecked(),malo_tornillo_para_ZT40x2.isChecked()));
                    guardar_detalle_inspeccion_visual(15,id_inspeccion,"","ZT409","PLACA DE MONTAJE PARA TTP",get_estado(bueno_placa_montaje_TTP.isChecked(),regular_placa_montaje_TTP.isChecked(),malo_placa_montaje_TTP.isChecked()));
                    guardar_detalle_inspeccion_visual(16,id_inspeccion,"","ZT407","CONECTOR Y (4mm)",get_estado(bueno_conector_Y_4mm.isChecked(),regular_conector_Y_4mm.isChecked(),malo_conector_Y_4mm.isChecked()));
                    guardar_detalle_inspeccion_visual(17,id_inspeccion,"","ZT406","SENSOR DE SANGRADO",get_estado(bueno_sensor_sangrado.isChecked(),regular_sensor_sangrado.isChecked(),malo_sensor_sangrado.isChecked()));
                    guardar_detalle_inspeccion_visual(18,id_inspeccion,"","ZT405","TORNILLO PARA ZT403NS(x2)",get_estado(bueno_tornillo_para_ZT403NSx2.isChecked(),regular_tornillo_para_ZT403NSx2.isChecked(),malo_tornillo_para_ZT403NSx2.isChecked()));
                    guardar_detalle_inspeccion_visual(19,id_inspeccion,"","ZT403","BOTON TACTIL",get_estado(bueno_boton_tactil.isChecked(),regular_boton_tactil.isChecked(),malo_boton_tactil.isChecked()));
                    guardar_detalle_inspeccion_visual(20,id_inspeccion,"","ZT401","TTP CUERPO DE LA PLACA",get_estado(bueno_TTP_cuerpo_placa.isChecked(),regular_TTP_cuerpo_placa.isChecked(),malo_TTP_cuerpo_placa.isChecked()));
                    guardar_detalle_inspeccion_visual(21,id_inspeccion,"","ZT400","CONJUNTO DE PLACA TACTIL DOBLE TTP",get_estado(bueno_conjunto_placa_tactil.isChecked(),regular_conjunto_placa_tactil.isChecked(),malo_conjunto_placa_tactil.isChecked()));
                    guardar_detalle_inspeccion_visual(22,id_inspeccion,"","ZT57SM","JERINGA SECUNDARIA DE 0.1ml",get_estado(bueno_jeringa_secundaria01.isChecked(),regular_jeringa_secundaria01.isChecked(),malo_jeringa_secundaria01.isChecked()));
                    guardar_detalle_inspeccion_visual(23,id_inspeccion,"RPTO-00457","ZT58SM","JERINGA SECUNDARIA DE 0.2ml",get_estado(bueno_jeringa_secundaria02.isChecked(),regular_jeringa_secundaria02.isChecked(),malo_jeringa_secundaria02.isChecked()));
                    guardar_detalle_inspeccion_visual(24,id_inspeccion,"RPTO-00512","ZT63M","TUERCA SEGURIDAD PUNTA JERINGA",get_estado(bueno_tuerca_seguridad_punta.isChecked(),regular_tuerca_seguridad_punta.isChecked(),malo_tuerca_seguridad_punta.isChecked()));
                    guardar_detalle_inspeccion_visual(25,id_inspeccion,"","ZT626","CONECTOR PARA ZT621NS-ZT625NS",get_estado(bueno_conector_ZT621NS.isChecked(),regular_conector_ZT621NS.isChecked(),malo_conector_ZT621NS.isChecked()));
                    guardar_detalle_inspeccion_visual(26,id_inspeccion,"","ZT623NS","TUBERIA PARA CONECTAR JERINGAS P./S.(x10)NS",get_estado(bueno_tuberia_conectar_jeringasPSx10NS.isChecked(),regular_tuberia_conectar_jeringasPSx10NS.isChecked(),malo_tuberia_conectar_jeringasPSx10NS.isChecked()));
                    guardar_detalle_inspeccion_visual(27,id_inspeccion,"RPTO-00351","ZT623","TUBERIA PARA CONECTAR JERINGAS P./S.(x10)",get_estado(bueno_tuberia_conectar_jeringasPSx10.isChecked(),regular_tuberia_conectar_jeringasPSx10.isChecked(),malo_tuberia_conectar_jeringasPSx10.isChecked()));
                    guardar_detalle_inspeccion_visual(28,id_inspeccion,"RPTO-00358","ZT661M","JUEGO EMPAQUES 1MILLON INY.0.1ML.",get_estado(bueno_juego_empaques_1millon01.isChecked(),regular_juego_empaques_1millon01.isChecked(),malo_juego_empaques_1millon01.isChecked()));
                    guardar_detalle_inspeccion_visual(29,id_inspeccion,"RPTO-00359","ZT681M","JUEGO EMPAQUES 1MILLON INY.0.2ML.",get_estado(bueno_juego_empaques_1millon02.isChecked(),regular_juego_empaques_1millon02.isChecked(),malo_juego_empaques_1millon02.isChecked()));
                    guardar_detalle_inspeccion_visual(30,id_inspeccion,"","ZT01-ZT01NS","MANOMETRO",get_estado(bueno_manometro.isChecked(),regular_manometro.isChecked(),malo_manometro.isChecked()));
                    guardar_detalle_inspeccion_visual(31,id_inspeccion,"","ZT02","CONTADOR DE LOTE",get_estado(bueno_contador_de_lote.isChecked(),regular_contador_de_lote.isChecked(),malo_contador_de_lote.isChecked()));
                    guardar_detalle_inspeccion_visual(32,id_inspeccion,"RPTO-00466","ZT03","CONTADOR TOTALIZADOR",get_estado(bueno_contador_totalizador.isChecked(),regular_contador_totalizador.isChecked(),malo_contador_totalizador.isChecked()));
                    guardar_detalle_inspeccion_visual(33,id_inspeccion,"","ZT04","CUBIERTA DEL CONT. LOTE",get_estado(bueno_cubierta_cont_lote.isChecked(),regular_cubierta_cont_lote.isChecked(),malo_cubierta_cont_lote.isChecked()));
                    guardar_detalle_inspeccion_visual(34,id_inspeccion,"RPTO-00468","ZT05","CUBIERTA CONT. TOTALIZADOR",get_estado(bueno_cubierta_cont_totalizador.isChecked(),regular_cubierta_cont_totalizador.isChecked(),malo_cubierta_cont_totalizador.isChecked()));
                    guardar_detalle_inspeccion_visual(35,id_inspeccion,"","ZT06","PLACA PARA FIJAR EL CONT. LOTE",get_estado(bueno_placa_fijar_cont_lote.isChecked(),regular_placa_fijar_cont_lote.isChecked(),malo_placa_fijar_cont_lote.isChecked()));
                    guardar_detalle_inspeccion_visual(36,id_inspeccion,"","ZT07","PLACA PARA FIJAR EL CONT. TOTALIZADOR",get_estado(bueno_placa_fijar_cont_totalizador.isChecked(),regular_placa_fijar_cont_totalizador.isChecked(),malo_placa_fijar_cont_totalizador.isChecked()));
                    guardar_detalle_inspeccion_visual(37,id_inspeccion,"RPTO-00364","ZT17","FILTRO REGULADOR",get_estado(bueno_filtro_regulador.isChecked(),regular_filtro_regulador.isChecked(),malo_filtro_regulador.isChecked()));
                    guardar_detalle_inspeccion_visual(38,id_inspeccion,"RPTO-00470","ZT18","CONECTOR ESPIGADO EN CODO 1/4 P/FILTRO",get_estado(bueno_conector_espigado14.isChecked(),regular_conector_espigado14.isChecked(),malo_conector_espigado14.isChecked()));
                    guardar_detalle_inspeccion_visual(39,id_inspeccion,"RPTO-00472","ZT23","CONECTOR MACHO PARA AIRE",get_estado(bueno_conector_macho_aire.isChecked(),regular_conector_macho_aire.isChecked(),malo_conector_macho_aire.isChecked()));
                    guardar_detalle_inspeccion_visual(40,id_inspeccion,"RPTO-00355","ZT24","CONECTOR HEMBRA PARA AIRE",get_estado(bueno_conector_hembra_aire.isChecked(),regular_conector_hembra_aire.isChecked(),malo_conector_hembra_aire.isChecked()));
                    guardar_detalle_inspeccion_visual(41,id_inspeccion,"","ZT25","ACOPLE REDUCTOR CONECTOR DEL MANOMETRO",get_estado(bueno_acople_reductor_manometro.isChecked(),regular_acople_reductor_manometro.isChecked(),malo_acople_reductor_manometro.isChecked()));
                    guardar_detalle_inspeccion_visual(42,id_inspeccion,"RPTO-00473","ZT28","TAPON DE GOMA(VAL.AGUJA)",get_estado(bueno_tapon_de_gomaValAguja.isChecked(),regular_tapon_de_gomaValAguja.isChecked(),malo_tapon_de_gomaValAguja.isChecked()));

                    guardar_detalle_inspeccion_visual(43,id_inspeccion,"","ZT26","EMPAQUE P/CONECTOR MACHO AIRE(x10)",get_estado(bueno_empaque_conector_macho_airex10.isChecked(),regular_empaque_conector_macho_airex10.isChecked(),malo_empaque_conector_macho_airex10.isChecked()));
                    guardar_detalle_inspeccion_visual(44,id_inspeccion,"","ZT30","PLATO DE MONTAJE C/TORNILLOS-MANOMETRO",get_estado(bueno_plato_montaje_tornillos_manometro.isChecked(),regular_plato_montaje_tornillos_manometro.isChecked(),malo_plato_montaje_tornillos_manometro.isChecked()));
                    guardar_detalle_inspeccion_visual(45,id_inspeccion,"RPTO-00501","ZT14","BOTON DE REINICIO DEL CONTADOR",get_estado(bueno_boton_reinicio_contador.isChecked(),regular_boton_reinicio_contador.isChecked(),malo_boton_reinicio_contador.isChecked()));
                    guardar_detalle_inspeccion_visual(46,id_inspeccion,"RPTO-00502","ZT16","MECANISMO INTERNO BOTON DE INICIADOR",get_estado(bueno_mecanismo_interno_botonReiniciador.isChecked(),regular_mecanismo_interno_botonReiniciador.isChecked(),malo_mecanismo_interno_botonReiniciador.isChecked()));
                    guardar_detalle_inspeccion_visual(47,id_inspeccion,"RPTO-00496","ZT08","INTERRUPTOR ENCENDIDO / APAGADO",get_estado(bueno_interruptor_encendido_apagado.isChecked(),regular_interruptor_encendido_apagado.isChecked(),malo_interruptor_encendido_apagado.isChecked()));
                    guardar_detalle_inspeccion_visual(48,id_inspeccion,"RPTO-00499","ZT10","MEC. INTERNO P/INTERRUPTOR ON/OFF",get_estado(bueno_mec_interruptor_ONOF.isChecked(),regular_mec_interruptor_ONOF.isChecked(),malo_mec_interruptor_ONOF.isChecked()));
                    guardar_detalle_inspeccion_visual(49,id_inspeccion,"RPTO-00469","ZT11","BOTON DE PRUEBA",get_estado(bueno_boton_prueba.isChecked(),regular_boton_prueba.isChecked(),malo_boton_prueba.isChecked()));
                    guardar_detalle_inspeccion_visual(50,id_inspeccion,"RPTO-00500","ZT13","MEC. INTERNO DEL BOTON DE PRUEBA",get_estado(bueno_mec_interno_boton_prueba.isChecked(),regular_mec_interno_boton_prueba.isChecked(),malo_mec_interno_boton_prueba.isChecked()));
                    guardar_detalle_inspeccion_visual(51,id_inspeccion,"RPTO-00497","ZT091","INTERRUPTOR PRE-SELECCION METODO INY.",get_estado(bueno_interruptor_preSeleccion.isChecked(),regular_interruptor_preSeleccion.isChecked(),malo_interruptor_preSeleccion.isChecked()));
                    guardar_detalle_inspeccion_visual(52,id_inspeccion,"RPTO-00498","ZT092","MEC. INTERNO P/INTERRUPTOR PRE-SELECCION",get_estado(bueno_mec_interruptor_preSeleccion.isChecked(),regular_mec_interruptor_preSeleccion.isChecked(),malo_mec_interruptor_preSeleccion.isChecked()));
                    guardar_detalle_inspeccion_visual(53,id_inspeccion,"RPTO-00504","ZT27","VALVULA NEUMATICA DE LA AGUJA",get_estado(bueno_valvula_neumaticaAguja.isChecked(),regular_valvula_neumaticaAguja.isChecked(),malo_valvula_neumaticaAguja.isChecked()));
                    guardar_detalle_inspeccion_visual(54,id_inspeccion,"RPTO-00505","ZT37","CELULA LOGICA AZUL",get_estado(bueno_celula_logica_azul.isChecked(),regular_celula_logica_azul.isChecked(),malo_celula_logica_azul.isChecked()));
                    guardar_detalle_inspeccion_visual(55,id_inspeccion,"RPTO-00506","ZT38","CELULA LOGICA GRIS",get_estado(bueno_celula_logica_gris.isChecked(),regular_celula_logica_gris.isChecked(),malo_celula_logica_gris.isChecked()));
                    guardar_detalle_inspeccion_visual(56,id_inspeccion,"RPTO-00507","ZT39","CELULA LOGICA AMARILLA",get_estado(bueno_celula_logica_amarilla.isChecked(),regular_celula_logica_amarilla.isChecked(),malo_celula_logica_amarilla.isChecked()));
                    guardar_detalle_inspeccion_visual(57,id_inspeccion,"RPTO-00476","ZT355","VALVULA DE ACTIVACION PARA EL ZT35",get_estado(bueno_valvula_activacionZT35.isChecked(),regular_valvula_activacionZT35.isChecked(),malo_valvula_activacionZT35.isChecked()));
                    guardar_detalle_inspeccion_visual(58,id_inspeccion,"","ZT367","ON-OFF INTERRUPTOR DE PRUEBA",get_estado(bueno_ONOFF_interruptor_prueba.isChecked(),regular_ONOFF_interruptor_prueba.isChecked(),malo_ONOFF_interruptor_prueba.isChecked()));
                    guardar_detalle_inspeccion_visual(59,id_inspeccion,"","ZT365","ON-OFF MECANISMO DE CAMBIO DE PRUEBA",get_estado(bueno_ONOFF_mec_cambio_prueba.isChecked(),regular_ONOFF_mec_cambio_prueba.isChecked(),malo_ONOFF_mec_cambio_prueba.isChecked()));
                    guardar_detalle_inspeccion_visual(60,id_inspeccion,"","ZT368","SIMPLE/DOBLE MECANISMO(INTERRUPTOR DE MODO)",get_estado(bueno_simple_doble_mec_interruptorModo.isChecked(),regular_simple_doble_mec_interruptorModo.isChecked(),malo_simple_doble_mec_interruptorModo.isChecked()));
                    guardar_detalle_inspeccion_visual(61,id_inspeccion,"","ZT366","SIMPLE/DOBLE MECANISMO DEL INTERRUPTOR",get_estado(bueno_simple_doble_mec_interruptor.isChecked(),regular_simple_doble_mec_interruptor.isChecked(),malo_simple_doble_mec_interruptor.isChecked()));
                    guardar_detalle_inspeccion_visual(62,id_inspeccion,"","ZT363","CONECTOR RECTO 4MM",get_estado(bueno_conector_recto4mm.isChecked(),regular_conector_recto4mm.isChecked(),malo_conector_recto4mm.isChecked()));
                    guardar_detalle_inspeccion_visual(63,id_inspeccion,"","ZT370","VALVULA RETENCION EN LINEA(VAL. FLUJO LIBRE)",get_estado(bueno_valvula_retencion_linea.isChecked(),regular_valvula_retencion_linea.isChecked(),malo_valvula_retencion_linea.isChecked()));
                    guardar_detalle_inspeccion_visual(64,id_inspeccion,"","ZT362","VALVULA UNIDIRECCIONAL",get_estado(bueno_valvula_unidireccional.isChecked(),regular_valvula_unidireccional.isChecked(),malo_valvula_unidireccional.isChecked()));
                    guardar_detalle_inspeccion_visual(65,id_inspeccion,"","ZT357","CONECTOR T (4mm)",get_estado(bueno_conectorT_4mm.isChecked(),regular_conectorT_4mm.isChecked(),malo_conectorT_4mm.isChecked()));
                    guardar_detalle_inspeccion_visual(66,id_inspeccion,"","ZT356","DISTRIBUIDOR DE AIRE MULTIPLE",get_estado(bueno_distribuidor_aire_multiple.isChecked(),regular_distribuidor_aire_multiple.isChecked(),malo_distribuidor_aire_multiple.isChecked()));
                    guardar_detalle_inspeccion_visual(67,id_inspeccion,"","ZT358","CONECTOR EN CRUZ (4mm)",get_estado(bueno_conector_cruz4mm.isChecked(),regular_conector_cruz4mm.isChecked(),malo_conector_cruz4mm.isChecked()));
                    guardar_detalle_inspeccion_visual(68,id_inspeccion,"","ZT361","VALVULA 3 SALIDAS",get_estado(bueno_valvula3salidas.isChecked(),regular_valvula3salidas.isChecked(),malo_valvula3salidas.isChecked()));
                    guardar_detalle_inspeccion_visual(69,id_inspeccion,"","ZT360","CELULA+BASE(RELE SENSOR AMARILLO)",get_estado(bueno_celula_base.isChecked(),regular_celula_base.isChecked(),malo_celula_base.isChecked()));
                    guardar_detalle_inspeccion_visual(70,id_inspeccion,"","ZT369","VALVULA DE IMPULSO+CONECTOR",get_estado(bueno_valvula_impulso.isChecked(),regular_valvula_impulso.isChecked(),malo_valvula_impulso.isChecked()));
                    guardar_detalle_inspeccion_visual(71,id_inspeccion,"RPTO-00511","ZT625NS","ESPACIADOR ENTRADA D/L SEGUNDA JERINGA",get_estado(bueno_espaciador_entrada_segundaJeringa.isChecked(),regular_espaciador_entrada_segundaJeringa.isChecked(),malo_espaciador_entrada_segundaJeringa.isChecked()));
                    guardar_detalle_inspeccion_visual(72,id_inspeccion,"RPTO-00357","ZT19","CILINDRO DE AIRE CON TUERCA DE MONTAJE",get_estado(bueno_cilidro_aire_tuercaMontaje.isChecked(),regular_cilidro_aire_tuercaMontaje.isChecked(),malo_cilidro_aire_tuercaMontaje.isChecked()));
                    guardar_detalle_inspeccion_visual(73,id_inspeccion,"RPTO-00503","ZT20","CONECTOR DE 4mm P/CILINDRO DE AIRE",get_estado(bueno_conector4mm_cilindro_aire.isChecked(),regular_conector4mm_cilindro_aire.isChecked(),malo_conector4mm_cilindro_aire.isChecked()));
                    guardar_detalle_inspeccion_visual(74,id_inspeccion,"RPTO-00471","ZT191","DETECTOR MANETICO DE POSICION P/CILINDRO DE AIIRE",get_estado(bueno_detector_manetico.isChecked(),regular_detector_manetico.isChecked(),malo_detector_manetico.isChecked()));
                    guardar_detalle_inspeccion_visual(75,id_inspeccion,"RPTO-00348","ZT21B","CONECTOR PARA ACOPLE DE JERINGA",get_estado(bueno_conector_acople.isChecked(),regular_conector_acople.isChecked(),malo_conector_acople.isChecked()));
                    guardar_detalle_inspeccion_visual(76,id_inspeccion,"","ZT212","IMPULSADOR ESPACIADOR D/L JERINGA SECUNDARIA",get_estado(bueno_impulsorEspaciador_jeringaSecundaria.isChecked(),regular_impulsorEspaciador_jeringaSecundaria.isChecked(),malo_impulsorEspaciador_jeringaSecundaria.isChecked()));
                    guardar_detalle_inspeccion_visual(77,id_inspeccion,"RPTO-00474","ZT33","RESORTE P/SOSTENEDOR DE LA JERINGA",get_estado(bueno_resorteSostenedor_jeringa.isChecked(),regular_resorteSostenedor_jeringa.isChecked(),malo_resorteSostenedor_jeringa.isChecked()));
                    guardar_detalle_inspeccion_visual(78,id_inspeccion,"RPTO-00369","ZT311","SOSTENEDOR DE LA JERINGA",get_estado(bueno_sostenedor_jeringa.isChecked(),regular_sostenedor_jeringa.isChecked(),malo_sostenedor_jeringa.isChecked()));
                    guardar_detalle_inspeccion_visual(79,id_inspeccion,"","ZT91","TORNILLOS DE FIJACION 6x20 PARA ZT31(x2)",get_estado(bueno_tornillos_fijacion6x20.isChecked(),regular_tornillos_fijacion6x20.isChecked(),malo_tornillos_fijacion6x20.isChecked()));
                    guardar_detalle_inspeccion_visual(80,id_inspeccion,"","ZT911","TORNILLOS DE FIJACION 6x50",get_estado(bueno_tornillos_fijacion6x50.isChecked(),regular_tornillos_fijacion6x50.isChecked(),malo_tornillos_fijacion6x50.isChecked()));
                    guardar_detalle_inspeccion_visual(81,id_inspeccion,"RPTO-00475","ZT34","PLACA P/MONT. DEL SOSTENEDOR D/L JERINGA",get_estado(bueno_placa_mont_sostenedorJeringa.isChecked(),regular_placa_mont_sostenedorJeringa.isChecked(),malo_placa_mont_sostenedorJeringa.isChecked()));
                    guardar_detalle_inspeccion_visual(82,id_inspeccion,"","ZT49","PLATO GUIA P/SOSTENEDOR D/L JERINGA",get_estado(bueno_plato_guiaSostenedor_jeringa.isChecked(),regular_plato_guiaSostenedor_jeringa.isChecked(),malo_plato_guiaSostenedor_jeringa.isChecked()));
                    guardar_detalle_inspeccion_visual(83,id_inspeccion,"","ZT84","PROBETA CALIBRADOR",get_estado(bueno_probeta_calibrador.isChecked(),regular_probeta_calibrador.isChecked(),malo_probeta_calibrador.isChecked()));
                    guardar_detalle_inspeccion_visual(84,id_inspeccion,"","ZT83M","PIEZA FINAL DEL PISTON DE LA JERINGA",get_estado(bueno_pieza_finalPiston.isChecked(),regular_pieza_finalPiston.isChecked(),malo_pieza_finalPiston.isChecked()));
                    guardar_detalle_inspeccion_visual(85,id_inspeccion,"","ZT82M","RESORTES DEL EMBOLO D/L JERINGA",get_estado(bueno_resortes_embolo.isChecked(),regular_resortes_embolo.isChecked(),malo_resortes_embolo.isChecked()));
                    guardar_detalle_inspeccion_visual(86,id_inspeccion,"","ZT81M","TUERCA TAPA D/EMBOLO D/L JERINGA",get_estado(bueno_tuerca_tapaEmbolo.isChecked(),regular_tuerca_tapaEmbolo.isChecked(),malo_tuerca_tapaEmbolo.isChecked()));
                    guardar_detalle_inspeccion_visual(87,id_inspeccion,"","ZT90","TORNILLO 4x16 P/L PIEZA FINAL JERINGA ZT83M",get_estado(bueno_tornillo_4x16.isChecked(),regular_tornillo_4x16.isChecked(),malo_tornillo_4x16.isChecked()));
                    guardar_detalle_inspeccion_visual(88,id_inspeccion,"RPTO-00368","ZT101","ACEITE VASELINA EN SPRAY (VEGETAL)",get_estado(bueno_aceite_vaselinaSpray.isChecked(),regular_aceite_vaselinaSpray.isChecked(),malo_aceite_vaselinaSpray.isChecked()));


                    ///REGISTRO DE INSPECCION E FUNCIONAMIENTO
                    int id_funcionamiento=id_inspeccion_funcionamiento()+1;
                    guardar_inspeccion_funcionamiento(id_funcionamiento,observacion_funcionamiento.getText().toString(),frecuencia_uso_funcionamiento.getText().toString(),id_servicio);

                    //REGISTO DE LOS DETALLES DE INSPECCION EL  FUNCIONAMIENTO,
                    guardar_detalle_inspeccion_funcionamiento(1,id_funcionamiento,"UBICACION DE LA MAQUINA",get_estado(bueno_ubicacion_maquina.isChecked(),false,malo_ubicacion_maquina.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(2,id_funcionamiento,"PRESION DE COMPRESORA",get_estado(bueno_presion_compresora.isChecked(),false,malo_presion_compresora.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(3,id_funcionamiento,"PRESION DE MAQUINA",get_estado(bueno_presion_maquina.isChecked(),false,malo_presion_maquina.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(4,id_funcionamiento,"ACTIVACION",get_estado(bueno_activacion.isChecked(),false,malo_activacion.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(5,id_funcionamiento,"FUNCION DE CONTADORES",get_estado(bueno_funcion_contadores.isChecked(),false,malo_funcion_contadores.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(6,id_funcionamiento,"FUNCIONAMIENTO SILVATO",get_estado(bueno_funcion_silbato.isChecked(),false,malo_funcion_silbato.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(7,id_funcionamiento,"SALIDA DE AGUJA",get_estado(bueno_salida_aguja.isChecked(),false,malo_salida_aguja.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(8,id_funcionamiento,"CALIBRACION",get_estado(bueno_calibracion.isChecked(),false,malo_calibracion.isChecked()));

                    ///REGISTRO DE LIMPIEZA Y DESINFECCION
                    id_funcionamiento++;
                    guardar_inspeccion_funcionamiento(id_funcionamiento,observacion_desinfeccion.getText().toString(),cantidad_aves_desinfeccion.getText().toString(),id_servicio);

                    //REGISTO DETALLE DE LIMPIEZA Y DESINFECCION,
                    guardar_detalle_inspeccion_funcionamiento(1,id_funcionamiento,"MATERIALES UTILIZADOS",get_estado(bueno_materiales_utilizados.isChecked(),false,malo_materiales_utilizados.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(2,id_funcionamiento,"CAMBIO DE PIEZAS DESCARTABLES",get_estado(bueno_cambio_descartables.isChecked(),false,malo_cambio_descartables.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(3,id_funcionamiento,"LIMPIEZA PLATO COLOCACION",get_estado(bueno_limpieza_plato_colocacion.isChecked(),false,malo_limpieza_plato_colocacion.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(4,id_funcionamiento,"ESTERILIZADO DE JERINGA",get_estado(bueno_esterilizado_jeringa.isChecked(),false,malo_esterilizado_jeringa.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(5,id_funcionamiento,"LIMPIEZA MODULO INYECTOR",get_estado(bueno_limpieza_mod_inyector.isChecked(),false,malo_limpieza_mod_inyector.isChecked()));
                    guardar_detalle_inspeccion_funcionamiento(6,id_funcionamiento,"LIMPIEZA DEL CEREBRO",get_estado(bueno_limpieza_cerebro.isChecked(),false,malo_limpieza_cerebro.isChecked()));
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
