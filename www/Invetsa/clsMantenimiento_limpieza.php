<?php
include_once('clsConexion.php');
class Mantenimiento_Limpieza extends Conexion
{
	private $id;
	private $id_hoja_verificacion;
	private $id_vacunador;
	private $irregularidades;
	private $nro_twin_shot_zootec;

	public function Mantenimiento_Limpieza ()
	{
		parent::Conexion();
		$this->id=0;
		$this->id_hoja_verificacion="";
		$this->id_vacunador="";
		$this->irregularidades="";
		$this->nro_twin_shot_zootec="";
		
	public function Mantenimiento_Limpieza2($id,$id_hoja_verificacion,$id_vacunador,$irregularidades,$nro_twin_shot_zootec)
	{
		$this->id=$id;
		$this->id_hoja_verificacion=$id_hoja_verificacion;
		$this->id_vacunador=$id_vacunador;
		$this->irregularidades=$irregularidades;
		$this->nro_twin_shot_zootec=$nro_twin_shot_zootec;
	}
	public function getid()
	{
		return $this->id;
	}
	public function getid_hoja_verificacion()
	{
		return $this->id_hoja_verificacion;
	}
	public function getid_vacunador()
	{
		return $this->id_vacunador;
	}
	public function get_irregularidades()
	{
		return $this->irregularidades;
	}
	public function get_nro_twin_shot()
	{
		return $this->nro_twin_shot_zootec;
	}
	
	public function guardar()
	{
		sql="insert into mantenimiento_limpieza(id,id_hoja_verificacion,id_vacunador,irregularidades,nro_twin_shot_zootec)values('$this->id','$this->id_hoja_verificacion','$this->id_vacunador','$this->irregularidades','$this->nro_twin_shot_zootec')";
		if(parent::ejecutar($sql))
			return true;
		else
			return false;
	}
	public function buscar()
	{
		$sql="select * from mantenimiento_limpieza";
		return parent::ejecutar($sql);
	}	
}

?>