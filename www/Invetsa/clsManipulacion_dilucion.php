<?php
include_once('clsConexion.php');
class ManipulacionDilucion extends Conexion
{
	private $codigo;
	private $descripcion;
	private $id;
	private $id_hoja_verificacion;
	private $puntaje;

	public function Manipulacion_Dilucion()
	{
		parent::Conexion();
		$this->codigo="";
		$this->descripcion="";
		$this->id=0;
		$this->id_hoja_verificacion=0;
		$this->puntaje=0;
	}
	public function Manipulacion_Dilucion2($codigo,$descripcion,$id,$id_hoja_verificacion,$puntaje)
	{
		$this->codigo=$codigo;
		$this->descripcion=$descripcion;
		$this->id=$id;
		$this->id_hoja_verificacion=$id_hoja_verificacion;
		$this->puntaje=$puntaje;

	}
	public function getcodigo()
	{
		return $this->codigo;
	}
	public function getdescripcion()
	{
		return $this->descripcion;
	}
	public function getid()
	{
		return $this->id;
	}
	public function getid_hoja_verificacion()
	{
		return $this->id_hoja_verificacion;
	}
	public function getpuntaje()
	{
		return $this->puntaje;
	}
	public function guardar()
	{
		sql="insert into manipulacion_dilucion(codigo,descripcion,id,id_hoja_verificacion)values('$this->codigo','$this->descripcion','$this->id','$this->id_hoja_verificacion','$this->puntaje')";
		if(parent::ejecutar($sql))
			return true;
		else
			return false;
	}
	public function buscar()
	{
		$sql="select * from manipulacion_dilucion";
		return parent::ejecutar($sql);
	}	
}

?>