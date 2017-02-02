package com.grayhatcorp.invetsa.invetsa.Base_de_datos;

/**
 * Created by elisoft on 07-11-16.
 */import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite extends SQLiteOpenHelper {

    public SQLite(Context context, String nombre, CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("create table compania(" +
                "id integer primary key not null," +
                "nombre varchar(50)" +
                ")");

        db.execSQL("create table tecnico(" +
                "id integer primary key not null," +
                "nombre varchar(50)" +
                ")");
        db.execSQL("create table maquina(" +
                "id integer primary key not null, " +
                "codigo varchar(15)," +
                "nombre varchar(50)" +
                ")");
        db.execSQL("create table servicio_mantenimiento(" +
                "id integer primary key not null," +
                "fecha timestamp default CURRENT_TIMESTAMP," +
                "hora_ingreso time," +
                "hora_salidas time," +
                "codigo varchar(20)," +
                "revision varchar(20)," +
                "firma_jefe_planta text," +
                "firma_invetsa text," +
                "id_maquina integer," +
                "id_tecnico integer," +
                "id_compania integer," +
                "foreign key (id_maquina)references maquina(id)," +
                "foreign key(id_tecnico)references tecnico(id)," +
                "foreign key(id_compania)references compania(id)" +
                ")");
        db.execSQL("create table inspeccion_visual(" +
                "id integer primary key not null," +
                "observaciones text," +
                "piesas_cambiadas text," +
                "id_servicio integer," +
                "foreign key(id_servicio)references servicio_mantenimiento(id)" +
                ")");

        db.execSQL("create table detalle_inspeccion_visual(" +
                "id integer not null," +
                "id_inspeccion integer not null," +
                "codigo_sistema varchar(10)," +
                "codigo_proveedor varchar(10)," +
                "descripcion text," +
                "estado tinyint," +
                "primary key(id,id_inspeccion)," +
                "foreign key(id_inspeccion) references inspeccion_visual(id)" +
                ")");
        db.execSQL("create table inspeccion_funcionamiento(" +
                "id integer  primary key not null," +
                "observaciones text," +
                "frecuencia_de_uso text," +
                "id_servicio integer," +
                "foreign key(id_servicio)references servicio_mantenimiento(id)" +
                ")");
        db.execSQL("create table detalle_inspeccion_funcionamiento(" +
                "id integer not null," +
                "id_inspeccion integer," +
                "criterio_evaluacion text," +
                "estado tinyint," +
                "primary key(id,id_inspeccion)," +
                "foreign key(id_inspeccion) references inspeccion_funcionamiento(id)" +
                ")");
        db.execSQL("create table limpieza(" +
                "id integer primary key not null," +
                "observaciones text," +
                "cantidad_aves_vacunadas text," +
                "id_servicio integer," +
                "foreign key(id_servicio)references servicio_mantenimiento(id)" +
                ")");
        db.execSQL("create table detalle_limpieza(" +
                "id integer not null," +
                "id_inspeccion integer," +
                "criterio_evaluacion text," +
                "estado tinyint," +
                "primary key(id,id_inspeccion)," +
                "foreign key(id_inspeccion) references limpieza(id)" +
                ")");
        db.execSQL("create table empresa(" +
                "id integer primary key not null," +
                "nombre varchar(50)" +
                ")");
        db.execSQL("create table granja (" +
                "id integer not null," +
                "id_empresa integer," +
                "zona text," +
                "primary key(id,id_empresa)," +
                "foreign key(id_empresa)references empresa(id)" +
                ")");
        db.execSQL("create table galpon(" +
                "id integer not null," +
                "id_empresa integer," +
                "id_granja integer," +
                "cantidad_pollo integer," +
                "primary key(id,id_granja,id_empresa)," +
                "foreign key(id_granja,id_empresa)references granja(id,id_empresa)" +
                ")");
        db.execSQL("create table sistema_integral(" +
                "id integer primary key not null," +
                "codigo varchar(20)," +
                "revision varchar(20)," +
                "edad integer," +
                "sexo varchar(1)," +
                "observaciones text," +
                "imagen1 text," +
                "imagen2 text," +
                "imagen3 text," +
                "imagen4 text," +
                "imagen5 text," +
                "id_galpon integer," +
                "id_granja integer," +
                "id_empresa integer," +
                "foreign key (id_galpon,id_granja,id_empresa)references galpon(id,id_granja,id_empresa)" +
                ")");
        db.execSQL("create table puntuacion(" +
                "id integer primary key not null," +
                "nombre varchar(50)," +
                "id_sistema integer," +
                "foreign key(id_sistema)references sistema_integral(id)" +
                ")");
        db.execSQL("create table detalle_puntuacion(" +
                "id integer not null," +
                "nombre varchar(50)," +
                "estado tinyint," +
                "id_puntuacion integer," +
                "primary key(id,id_puntuacion)," +
                "foreign key(id_puntuacion) references puntuacion(id)" +
                ")");
        db.execSQL("create table peso(" +
                "id integer primary key not null," +
                "peso_corporal decimal(2,2)," +
                "pedo_bursa decimal(2,2)," +
                "peso_brazo decimal(2,2)," +
                "peso_timo decimal(2,2)," +
                "peso_higado decimal(2,2)," +
                "indice_bursal decimal(4,2)," +
                "indice_timico decimal(4,2)," +
                "indice_hepatico decimal(4,2)," +
                "bursometro decimal(4,2)," +
                "id_sistema integer," +
                "foreign key(id_sistema)references sistema_integral(id)" +
                "" +
                ")");
        db.execSQL("create table hoja_verificacion(" +
                "id integer primary key not null," +
                "hora_ingreso time," +
                "hora_salida time," +
                "codigo varchar(20)," +
                "revision varchar(20)," +
                "firma_invetsa text," +
                "firma_empresa text," +
                "productividad decimal(4,2)," +
                "sumatoria_manipulacion_vacuna decimal(10,2)," +
                "promedio_mantenimiento decimal(10,2)," +
                "puntaje_control_indice decimal(10,2)," +
                "id_galpon integer," +
                "id_granja integer," +
                "id_empresa integer," +
                "foreign key (id_galpon,id_granja,id_empresa)references galpon(id,id_granja,id_empresa)" +
                ")");
        db.execSQL("create table vacunador(" +
                "id integer primary key not null," +
                "nombre varchar(50)" +
                ")");
        db.execSQL("create table accion(" +
                "id integer  primary key not null," +
                "nombre varchar(50)," +
                "id_hoja_verificacion integer," +
                "foreign key(id_hoja_verificacion)references hoja_verificacion(id)" +
                ")");
        db.execSQL("create table detalle_acccion(" +
                "id integer  primary key not null," +
                "esperado varchar(50)," +
                "encontrado varchar(50)," +
                "id_accion integer," +
                "foreign key(id_accion) references accion(id)" +
                ")");
        db.execSQL("create table mantenimiento_limpieza(" +
                "id integer primary key not null," +
                "nro_twin_shot_zootec integer," +
                "irregularidades integer," +
                "id_hoja_verificacion integer," +
                "id_vacunador integer," +
                "foreign key(id_hoja_verificacion)references hoja_verificacion(id)," +
                "foreign key(id_vacunador)references vacunador(id)" +
                ")");
        db.execSQL("create table control_indice(" +
                "id integer primary key not null," +
                "nro_pollos_vacunado integer default 0," +
                "puntaje integer default 0," +
                "nro_pollos_controlados integer default 0," +
                "nro_pollos_no_vacunados integer default 0," +
                "nro_heridos integer default 0," +
                "nro_mojados integer default 0," +
                "nro_mala_posicion integer default 0," +
                "nro_pollos_vacunados_correctamente integer default 0," +
                "id_hoja_verificacion integer," +
                "id_vacunador integer," +
                "foreign key(id_hoja_verificacion)references hoja_verificacion(id)," +
                "foreign key(id_vacunador)references vacunador(id)" +
                ")");
        db.execSQL("create table manipulacion_dilucion(" +
                "id integer primary key not null," +
                "codigo integer," +
                "descripcion text," +
                "puntaje decimal(2,2)," +
                "id_hoja_verificacion integer," +
                "foreign key(id_hoja_verificacion)references hoja_verificacion(id)" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
        db.execSQL("drop table if exists compania");
        db.execSQL("create table compania(" +
                "id integer primary key not null," +
                "nombre varchar(50)" +
                ")");
        db.execSQL("drop table if exists tecnico");
        db.execSQL("create table tecnico(" +
                "id integer primary key not null," +
                "nombre varchar(50)" +
                ")");
        db.execSQL("drop table if exists maquina");
        db.execSQL("create table maquina(" +
                "id integer primary key not null, " +
                "codigo varchar(15)," +
                "nombre varchar(50)" +
                ")");
        db.execSQL("drop table if exists servicio_mantenimiento");
        db.execSQL("create table servicio_mantenimiento(" +
                "id integer primary key not null," +
                "fecha timestamp default CURRENT_TIMESTAMP," +
                "hora_ingreso time," +
                "hora_salidas time," +
                "codigo varchar(20)," +
                "revision varchar(20)," +
                "firma_jefe_planta text," +
                "firma_invetsa text," +
                "id_maquina integer," +
                "id_tecnico integer," +
                "id_compania integer," +
                "foreign key (id_maquina)references maquina(id)," +
                "foreign key(id_tecnico)references tecnico(id)," +
                "foreign key(id_compania)references compania(id)" +
                ")");
        db.execSQL("drop table if exists inspeccion_visual");
        db.execSQL("create table inspeccion_visual(" +
                "id integer primary key not null," +
                "observaciones text," +
                "piesas_cambiadas text," +
                "id_servicio integer," +
                "foreign key(id_servicio)references servicio_mantenimiento(id)" +
                ")");
        db.execSQL("drop table if exists inspeccion_visual");
        db.execSQL("create table detalle_inspeccion_visual(" +
                "id integer not null," +
                "id_inspeccion integer not null," +
                "codigo_sistema varchar(10)," +
                "codigo_proveedor varchar(10)," +
                "descripcion text," +
                "estado tinyint," +
                "primary key(id,id_inspeccion)," +
                "foreign key(id_inspeccion) references inspeccion_visual(id)" +
                ")");
        db.execSQL("drop table if exists inspeccion_funcionamiento");
        db.execSQL("create table inspeccion_funcionamiento(" +
                "id integer  primary key not null," +
                "observaciones text," +
                "frecuencia_de_uso text," +
                "id_servicio integer," +
                "foreign key(id_servicio)references servicio_mantenimiento(id)" +
                ")");
        db.execSQL("drop table if exists detalle_inspeccion_funcionamiento");
        db.execSQL("create table detalle_inspeccion_funcionamiento(" +
                "id integer not null," +
                "id_inspeccion integer," +
                "criterio_evaluacion text," +
                "estado tinyint," +
                "primary key(id,id_inspeccion)," +
                "foreign key(id_inspeccion) references inspeccion_funcionamiento(id)" +
                ")");
        db.execSQL("drop table if exists limpieza");
        db.execSQL("create table limpieza(" +
                "id integer primary key not null," +
                "observaciones text," +
                "cantidad_aves_vacunadas text," +
                "id_servicio integer," +
                "foreign key(id_servicio)references servicio_mantenimiento(id)" +
                ")");
        db.execSQL("drop table if exists detalle_limpieza");
        db.execSQL("create table detalle_limpieza(" +
                "id integer not null," +
                "id_inspeccion integer," +
                "criterio_evaluacion text," +
                "estado tinyint," +
                "primary key(id,id_inspeccion)," +
                "foreign key(id_inspeccion) references limpieza(id)" +
                ")");
        db.execSQL("drop table if exists empresa");
        db.execSQL("create table empresa(" +
                "id integer primary key not null," +
                "nombre varchar(50)" +
                ")");
        db.execSQL("drop table if exists granja");
        db.execSQL("create table granja (" +
                "id integer not null," +
                "id_empresa integer," +
                "zona text," +
                "primary key(id,id_empresa)," +
                "foreign key(id_empresa)references empresa(id)" +
                ")");
        db.execSQL("drop table if exists galpon");
        db.execSQL("create table galpon(" +
                "id integer not null," +
                "id_empresa integer," +
                "id_granja integer," +
                "cantidad_pollo integer," +
                "primary key(id,id_granja,id_empresa)," +
                "foreign key(id_granja,id_empresa)references granja(id,id_empresa)" +
                ")");
        db.execSQL("drop table if exists sistema_integral");
        db.execSQL("create table sistema_integral(" +
                "id integer primary key not null," +
                "codigo varchar(20)," +
                "revision varchar(20)," +
                "edad integer," +
                "sexo varchar(1)," +
                "observaciones text," +
                "imagen1 text," +
                "imagen2 text," +
                "imagen3 text," +
                "imagen4 text," +
                "imagen5 text," +
                "id_galpon integer," +
                "id_granja integer," +
                "id_empresa integer," +
                "foreign key (id_galpon,id_granja,id_empresa)references galpon(id,id_granja,id_empresa)" +
                ")");
        db.execSQL("drop table if exists puntuacion");
        db.execSQL("create table puntuacion(" +
                "id integer primary key not null," +
                "nombre varchar(50)," +
                "id_sistema integer," +
                "foreign key(id_sistema)references sistema_integral(id)" +
                ")");
        db.execSQL("drop table if detalle_puntuacion");
        db.execSQL("create table detalle_puntuacion(" +
                "id integer not null," +
                "nombre varchar(50)," +
                "estado tinyint," +
                "id_puntuacion integer," +
                "primary key(id,id_puntuacion)," +
                "foreign key(id_puntuacion) references puntuacion(id)" +
                ")");
        db.execSQL("drop table if peso");
        db.execSQL("create table peso(" +
                "id integer primary key not null," +
                "peso_corporal decimal(2,2)," +
                "pedo_bursa decimal(2,2)," +
                "peso_brazo decimal(2,2)," +
                "peso_timo decimal(2,2)," +
                "peso_higado decimal(2,2)," +
                "indice_bursal decimal(4,2)," +
                "indice_timico decimal(4,2)," +
                "indice_hepatico decimal(4,2)," +
                "bursometro decimal(4,2)," +
                "id_sistema integer," +
                "foreign key(id_sistema)references sistema_integral(id)" +
                "" +
                ")");
        db.execSQL("drop table if hoja_verificacion");
        db.execSQL("create table hoja_verificacion(" +
                "id integer primary key not null," +
                "hora_ingreso time," +
                "hora_salida time," +
                "codigo varchar(20)," +
                "revision varchar(20)," +
                "firma_invetsa text," +
                "firma_empresa text," +
                "productividad decimal(4,2)," +
                "sumatoria_manipulacion_vacuna decimal(10,2)," +
                "promedio_mantenimiento decimal(10,2)," +
                "puntaje_control_indice decimal(10,2)," +
                "id_galpon integer," +
                "id_granja integer," +
                "id_empresa integer," +
                "foreign key (id_galpon,id_granja,id_empresa)references galpon(id,id_granja,id_empresa)" +
                ")");
        db.execSQL("drop table if vacunador");
        db.execSQL("create table vacunador(" +
                "id integer primary key not null," +
                "nombre varchar(50)" +
                ")");
        db.execSQL("drop table if accion");
        db.execSQL("create table accion(" +
                "id integer  primary key not null," +
                "nombre varchar(50)," +
                "id_hoja_verificacion integer," +
                "foreign key(id_hoja_verificacion)references hoja_verificacion(id)" +
                ")");
        db.execSQL("drop table if detalle_acccion");
        db.execSQL("create table detalle_acccion(" +
                "id integer  primary key not null," +
                "esperado varchar(50)," +
                "encontrado varchar(50)," +
                "id_accion integer," +
                "foreign key(id_accion) references accion(id)" +
                ")");
        db.execSQL("drop table if mantenimiento_limpieza");
        db.execSQL("create table mantenimiento_limpieza(" +
                "id integer primary key not null," +
                "nro_twin_shot_zootec integer," +
                "irregularidades integer," +
                "id_hoja_verificacion integer," +
                "id_vacunador integer," +
                "foreign key(id_hoja_verificacion)references hoja_verificacion(id)," +
                "foreign key(id_vacunador)references vacunador(id)" +
                ")");
        db.execSQL("drop table if control_indice");
        db.execSQL("create table control_indice(" +
                "id integer primary key not null," +
                "nro_pollos_vacunado integer default 0," +
                "puntaje integer default 0," +
                "nro_pollos_controlados integer default 0," +
                "nro_pollos_no_vacunados integer default 0," +
                "nro_heridos integer default 0," +
                "nro_mojados integer default 0," +
                "nro_mala_posicion integer default 0," +
                "nro_pollos_vacunados_correctamente integer default 0," +
                "id_hoja_verificacion integer," +
                "id_vacunador integer," +
                "foreign key(id_hoja_verificacion)references hoja_verificacion(id)," +
                "foreign key(id_vacunador)references vacunador(id)" +
                ")");
        db.execSQL("drop table if manipulacion_dilucion");
        db.execSQL("create table manipulacion_dilucion(" +
                "id integer primary key not null," +
                "codigo integer," +
                "descripcion text," +
                "puntaje decimal(2,2)," +
                "id_hoja_verificacion integer," +
                "foreign key(id_hoja_verificacion)references hoja_verificacion(id)" +
                ")");

    }
}

