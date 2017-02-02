create table compania(
id integer auto_increment primary key,
nombre varchar(50)
);
create table tecnico(
id integer auto_increment primary key,
nombre varchar(50)
);

create table maquina(
id integer auto_increment primary key,
nombre varchar(50)
);

create table servicio_mantenimiento(
id integer auto_increment primary key,
fecha timestamp default CURRENT_TIMESTAMP,
hora_ingreso time,
hora_salidas time,
codigo varchar(20),
revision varchar(20),
firma_jefe_planta text,
firma_invetsa text,
id_maquina integer,
id_tecnico integer,
id_compania integer,
foreign key (id_maquina)references maquina(id),
foreign key(id_tecnico)references tecnico(id),
foreign key(id_compania)references compania(id)
);


create table inspeccion_visual(
id integer auto_increment primary key,
observaciones text,
piesas_cambiadas text,
id_servicio integer,
foreign key(id_servicio)references servicio_mantenimiento(id)
);


create table detalle_inspeccion_visual(
id integer auto_increment,
id_inspeccion integer,
codigo_sistema varchar(10),
codigo_proveedor varchar(10),
descripcion text,
estado tinyint,
primary key(id,id_inspeccion),
foreign key(id_inspeccion) references inspeccion_visual(id)
);

create table inspeccion_funcionamiento(
id integer auto_increment primary key,
observaciones text,
frecuencia_de_uso text,
id_servicio integer,
foreign key(id_servicio)references servicio_mantenimiento(id)
);


create table detalle_inspeccion_funcionamiento(
id integer auto_increment,
id_inspeccion integer,
criterio_evaluacion text,
estado tinyint,
primary key(id,id_inspeccion),
foreign key(id_inspeccion) references inspeccion_funcionamiento(id)
);

create table limpieza(
id integer auto_increment primary key,
observaciones text,
cantidad_aves_vacunadas text,
id_servicio integer,
foreign key(id_servicio)references servicio_mantenimiento(id)
);


create table detalle_limpieza(
id integer auto_increment,
id_inspeccion integer,
criterio_evaluacion text,
estado tinyint,
primary key(id,id_inspeccion),
foreign key(id_inspeccion) references limpieza(id)
);




-- scrip de Sistema integral de monitoreo.
create table empresa(
id integer  auto_increment primary key,
nombre varchar(50)
); 

create table granja (
id integer auto_increment,
id_empresa integer,
zona text,
primary key(id,id_empresa),
foreign key(id_empresa)references empresa(id)
);

create table galpon(
id integer auto_increment,
id_empresa integer,
id_granja integer,
cantidad_pollo integer,
primary key(id,id_granja,id_empresa),
foreign key(id_granja,id_empresa)references granja(id,id_empresa)
);

create table sistema_integral(
id integer auto_increment primary key,
codigo varchar(20),
revision varchar(20),
edad integer,
sexo varchar(1),
observaciones text,
imagen1 text,
imagen2 text,
imagen3 text,
imagen4 text,
imagen5 text,
id_galpon integer,
id_granja integer,
id_empresa integer,
foreign key (id_galpon,id_granja,id_empresa)references galpon(id,id_granja,id_empresa)
);

create table puntuacion(
id integer auto_increment primary key,
nombre varchar(50),
id_sistema integer,
foreign key(id_sistema)references sistema_integral(id)
);

create table detalle_puntuacion(
id integer auto_increment,
nombre varchar(50),
estado tinyint,
id_puntuacion integer,
primary key(id,id_puntuacion),
foreign key(id_puntuacion) references puntuacion(id)
);


create table peso(
id integer auto_increment primary key,
peso_corporal decimal(2,2),
pedo_bursa decimal(2,2),
peso_brazo decimal(2,2),
peso_timo decimal(2,2),
peso_higado decimal(2,2),
indice_bursal decimal(4,2),
indice_timico decimal(4,2),
indice_hepatico decimal(4,2),
bursometro decimal(4,2),
id_sistema integer,
foreign key(id_sistema)references sistema_integral(id)

);



--Scrio de la base de datos de HOJA DE VERIFICACION.

create table hoja_verificacion(
id integer auto_increment primary key,
hora_ingreso time,
hora_salida time,
codigo varchar(20),
revision varchar(20),
firma_invetsa text,
firma_empresa text,
productividad decimal(4,2),
sumatoria_manipulacion_vacuna decimal(10,2),
promedio_mantenimiento decimal(10,2),
puntaje_control_indice decimal(10,2),
id_galpon integer,
id_granja integer,
id_empresa integer,
foreign key (id_galpon,id_granja,id_empresa)references galpon(id,id_granja,id_empresa)
);

create table vacunador(
id integer auto_increment primary key,
nombre varchar(50)
);

create table accion(
id integer auto_increment primary key,
nombre varchar(50),
id_hoja_verificacion integer,
foreign key(id_hoja_verificacion)references hoja_verificacion(id)
);

create table detalle_acccion(
id integer auto_increment primary key,
esperado varchar(50),
encontrado varchar(50),
id_accion integer,
foreign key(id_accion) references accion(id)
);

create table mantenimiento_limpieza(
id integer auto_increment primary key,
nro_twin_shot_zootec integer,
irregularidades integer,
id_hoja_verificacion integer,
id_vacunador integer,
foreign key(id_hoja_verificacion)references hoja_verificacion(id),
foreign key(id_vacunador)references vacunador(id)
);


create table control_indice(
id integer auto_increment primary key,
nro_pollos_vacunado integer default 0,
puntaje integer default 0,
nro_pollos_controlados integer default 0,
nro_pollos_no_vacunados integer default 0,
nro_heridos integer default 0,
nro_mojados integer default 0,
nro_mala_posicion integer default 0,
nro_pollos_vacunados_correctamente integer default 0,
id_hoja_verificacion integer,
id_vacunador integer,
foreign key(id_hoja_verificacion)references hoja_verificacion(id),
foreign key(id_vacunador)references vacunador(id)
);

create table manipulacion_dilucion(
id integer auto_increment primary key,
codigo integer,
descripcion text,
puntaje decimal(2,2),
id_hoja_verificacion integer,
foreign key(id_hoja_verificacion)references hoja_verificacion(id)
);

