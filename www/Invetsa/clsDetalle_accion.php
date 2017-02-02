<?php
include_once ('clsEmpresa.php');
include_once('clsConexion.php');
class DetalleAccion extends Conexion
{
	private $encontrado;
	private $esperado;
	private $id;
	private $id_accion;

	public function Detalle_accion()
	{
		parent::Conexion();
		$this->encontrado="";
		$this->esperado="";
		$this->id=0;
		$this->id_accion=0;
	}
	public function Detalle_accion2($encontrado,$esperado,$id,$id_accion)
	{
		$this->encontrado=$encontrado;
		$this->esperado=$esperado;
		$this->id=$id;
		$this->id_accion=$id_accion;

	}
	public function getencontrado()
	{
		return $this->encontrado;
	}
	public function getesperado()
	{
		return $this->esperado;
	}
	public function getid()
	{
		return $this->id;
	}
	public function getid_accion()
	{
		return $this->id_accion;
	}
	public function guardar()
	{
		sql="insert into detalle_accion(encontrado,esperado,id,id_accion)values('$this->encontrado','$this->esperado','$this->id','$this->id_accion')";
		if(parent::ejecutar($sql))
			return true;
		else
			return false;
	}
	public function buscar()
	{
		$sql="select * from detalle_accion";
		return parent::ejecutar($sql);
	}	
}

?>