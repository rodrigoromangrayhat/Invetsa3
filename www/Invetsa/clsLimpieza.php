<?php
include_once('clsConexion.php');
class Limpieza extends Conexion
{
	private $criterio_evaluacion;	
	private $estado;
	private $id;
	private $id_servicio;

	public function limpieza()
	{
		parent::Conexion();
		$this->cantidad_aves_vacunadas="";		
		$this->id=0;
		$this->id_servicio="";
		$this->observaciones="";
		
		
	public function limpieza2($cantidad_aves_vacunadas,$id,$id_servicio,$observaciones)
	{
		$this->cantidad_aves_vacunadas=$cantidad_aves_vacunadas;
		$this->id=$id;	
		$this->id_servicio=$id_servicio;
		$this->observaciones=$observaciones;	
	}
	public function get_cantidad_aves_vacunadas()
	{
		return $this->cantidad_aves_vacunadas;
	}
	
	public function get_id()
	{
		return $this->id;
	}
	public function get_id_servicio()
	{
		return $this->id_servicio;
	}
	public function get_observaciones()
	{
		return $this->observaciones;
	}
	
	public function guardar()
	{
		sql="insert into limpieza(cantidad_aves_vacunadas,id,id_servicio,observaciones)values('$this->cantidad_aves_vacunadas','$this->id','$this->id_servicio','$this->observaciones')";
		if(parent::ejecutar($sql))
			return true;
		else
			return false;
	}
	public function buscar()
	{
		$sql="select * from limpieza";
		return parent::ejecutar($sql);
	}	
}

?>