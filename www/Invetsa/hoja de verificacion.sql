
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

