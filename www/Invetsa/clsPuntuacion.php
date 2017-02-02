<?php
include_once('clsConexion.php');
class Puntuacion extends Conexion
{
	private $id;	
	private $id_sistema;
	private $nombre;

	public function puntuacion()
	{
		parent::Conexion();
		$this->id=0;		
		$this->id_sistema="";
		$this->nombre="";
		
		
	public function puntuacion2($id,$id_sistema,$nombre)
	{
		$this->id=$id;
		$this->id_sistema=$id_sistema;	
		$this->nombre=$nombre;	
	}
	public function get_id()
	{
		return $this->id;
	}
	
	public function get_id_sistema()
	{
		return $this->id_sistema;
	}
	public function get_nombre()
	{
		return $this->nombre;
	}
	
	public function guardar()
	{
		sql="insert into puntuacion(id,id_sistema,nombre)values('$this->id','$this->id_sistema','$this->nombre')";
		if(parent::ejecutar($sql))
			return true;
		else
			return false;
	}
	public function buscar()
	{
		$sql="select * from puntuacion";
		return parent::ejecutar($sql);
	}	
}

?>