<?php

include_once('clsConexion.php');
class Accion extends Conexion
{
	private $id;
	private $id_hoja_verificacion;
	private $nombre;

	public function Accion()
	{  
		parent::Conexion();
		$this->id=0;
		$this->id_hoja_verificacion="";
		$this->nombre="";
		
	}
	public function Accion2($id,$id_hoja_verificacion,$nombre)
	{
		parent::Conexion();
		$this->id=$id;
		$this->id_hoja_verificacion=$id_hoja_verificacion;
		$this->nombre=$nombre;
	}
	public function getid()
	{
		return $this->id;
	}
	public function getid_hoja_verificacion()
	{
		return $this->id_hoja_verificacion;
	}
	public function getnombre()
	{
		return $this->nombre;
	}

	public function guardar()
	{
		$sql="insert into accion(id,id_hoja_verificacion,nombre)values('$this->id','$this->id_hoja_verificacion','$this->nombre')";

		if(parent::ejecutar($sql))
			return true;
		else
			return false;
	}
	public function buscar()
	{
		$sql="select * from accion";
		return parent::ejecutar($sql);
	}	

}

?>