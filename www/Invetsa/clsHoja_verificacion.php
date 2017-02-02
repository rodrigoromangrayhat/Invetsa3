<?php

include_once('clsConexion.php');
class Hoja_verificacion extends Conexion
{
	//atributos
	private $codigo;
	private $firma_Empresa;
	private $firma_Invetsa;
	private $Hora_Ingreso;
	private $Hora_Salida;
	private $id;
	private $id_Empresa;
	private $id_Galpon;
	private $id_Granja;
	private $Productividad;
	private $Promedio_Mantenimiento;
	private $Puntaje_Control_Indice;
	private $Revision;
	private $sumatoria_Manipulacion_Vacuna;
	
	//construtor
	public function Hoja_Verificacion()
	{  
		parent::Conexion();
	 	$this->codigo="";
		$this->firma_Empresa="";
		$this->firma_Invetsa="";
		$this->Hora_Ingreso="";
		$this->Hora_Salida="";
		$this->id=0;
		$this->id_Empresa=0;
		$this->id_Galpon=0;
		$this->id_Granja=0;
		$this->Productividad=0;
		$this->Promedio_Mantenimiento=0;
		$this->Puntaje_Control_Indice=0;
		$this->Revision="";
		$this->sumatoria_Manipulacion_Vacuna=0;	
	}
	public function Hoja_Verificacion2($codigo,$firma_Empresa,$firma_Invetsa,$Hora_Ingreso,$Hora_Salida,$id,$id_Empresa,$id_Galpon,$id_Granja,$Productividad,$Promedio_Mantenimiento,$Puntaje_Control_Indice,$Revision,$sumatoria_Manipulacion_Vacuna)
	{
		parent::Conexion();
		$this->codigo=$codigo;
		$this->firma_Empresa=$firma_Empresa;
		$this->firma_Invetsa=$firma_Invetsa;
		$this->Hora_Ingreso=$Hora_Ingreso;
		$this->Hora_Salida=$Hora_Salida;
		$this->id=0;
		$this->id_Empresa=0;
		$this->id_Galpon=0;
		$this->id_Granja=0;
		$this->Productividad=$Productividad;
		$this->Promedio_Mantenimiento=$Promedio_Mantenimiento;
		$this->Puntaje_Control_Indice=$Puntaje_Control_Indice;
		$this->Revision=$Revision;
		$this->sumatoria_Manipulacion_Vacuna=$sumatoria_Manipulacion_Vacuna;	
	}

	public function getCodigo()
	{
		return $this->codigo;
	}
	public function getfirma_Empresa()
	{
		return $this->firma_Empresa;
	}
	public function getfirma_Invetsa()
	{
		return $this->firma_Invetsa;
	}
	public function getHora_Ingreso()
	{
		return $this->Hora_Ingreso;
	}

	public function getHora_Salida()
	{
			return $this->Hora_Salida;
	}

	public function getId()
	{
			return $this->id;
	}

	public function getId_Empresa()
	{
		return $this->id_Empresa;
	}
	public function getId_Galpon()
	{
		return $this->id_Galpon;
	}
	public function getId_Granja()
	{
		return $this->id_Granja;
	}
	public function getProductividad()
	{
		return $this->Productividad;
	}
	public function getPromedio_Mantenimiento()
	{
		return $this->Promedio_Mantenimiento;
	}
	public function getPuntaje_control_Indice()
	{
		return $this->Puntaje_Control_Indice;
	}
	public function getRevision()
	{
		return $this->Revision;
	}
	public function getSumatoria_Manipulacion_Vacuna()
	{
		return $this->sumatoria_Manipulacion_Vacuna;
	}

	public function guardar()
	{
     $sql="insert into hoja_verificacion(codigo,firma_empresa,firma_invetsa,hora_ingreso,hora_salida,id,id_empresa,id_galpon,id_granja,productividad,promedio_mantenimiento,puntaje_control_indice,revision,sumatoria_manipulacion_vacuna) values('$this->codigo','$this->firma_Empresa','$this->firma_Invetsa','$this->Hora_Ingreso','$this->Hora_Salida','$this->id','$this->id_Empresa','$this->id_Galpon','$this->id_Granja','$this->Productividad','$this->Promedio_Mantenimiento','$this->Puntaje_Control_Indice','$this->Revision','$this->sumatoria_Manipulacion_Vacuna')";
		
		if(parent::ejecutar($sql))
			return true;
		else
			return false;	
	}

	public function buscar()
	{
		$sql="select * from empresa";
		return parent::ejecutar($sql);
	}										

	
}    

?>