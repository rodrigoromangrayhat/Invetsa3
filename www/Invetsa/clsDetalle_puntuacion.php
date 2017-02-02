<?php
include_once('clsConexion.php');
class Detalle_Puntuacion extends Conexion
{
	private $estado;
	private $id;	
	private $id_puntuacion;
	private $nombre;

	public function puntuacion()
	{
		parent::Conexion();
		$this->estado="";
		$this->id=0;		
		$this->id_puntuacion="";
		$this->nombre="";
		
		
	public function puntuacion2($id,$id_sistema,$nombre)
	{
		$this->estado=$estado;
		$this->id=$id;
		$this->id_puntuacion=$id_puntuacion;	
		$this->nombre=$nombre;	
	}
	public function get_estado()
	{
		return $this->estado;
	}
	public function get_id()
	{
		return $this->id;
	}
	
	public function get_id_puntuacion()
	{
		return $this->id_puntuacion;
	}
	public function get_nombre()
	{
		return $this->nombre;
	}
	
	public function guardar()
	{
		sql="insert into detalle_puntuacion(estado,id,id_puntuacion,nombre)values('$this->estado','$this->id','$this->id_puntuacion','$this->nombre')";
		if(parent::ejecutar($sql))
			return true;
		else
			return false;
	}
	public function buscar()
	{
		$sql="select * from detalle_puntuacion";
		return parent::ejecutar($sql);
	}	
}

?>