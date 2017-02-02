<?php
include_once('clsConexion.php');
class Servicio_Mantenimiento extends Conexion
{
	private $codigo;	
	private $fecha;
	private $firma_invetsa;
	private $firma_jefe_planta;
	private $hora_ingreso;
	private $hora_salidas;
	private $id;
	private $id_compania;
	private $id_maquina;
	private $id_tecnico;
	private $revision;

	public function servicio_mantenimiento()
	{
		parent::Conexion();
		$this->codigo="";		
		$this->fecha="";
		$this->firma_invetsa="";
		$this->firma_jefe_planta="";
		$this->hora_ingreso="";
		$this->hora_salidas="";
		$this->id=0;
		$this->id_compania="";
		$this->id_maquina="";
		$this->id_tecnico="";
		$this->revision="";
		
		
	public function servicio_mantenimiento2($codigo,$fecha,$firma_invetsa,$firma_jefe_planta,$hora_ingreso,$hora_salidas,$id,$id_compania,$id_maquina,$id_tecnico,$revision)
	{
		$this->codigo=$codigo;
		$this->fecha=$fecha;	
		$this->firma_invetsa=$firma_invetsa;
		$this->firma_jefe_planta=$firma_jefe_planta;
		$this->hora_ingreso=$hora_ingreso;
		$this->hora_salidas=$hora_salidas;
		$this->id=$id;
		$this->id_maquina=$id_compania;	
		$this->id_maquina=$id_maquina;
		$this->id_tecnico=$id_tecnico;
		$this->revision=$revision;
	}
	public function get_codigo()
	{
		return $this->codigo;
	}
	
	public function get_fecha()
	{
		return $this->fecha;
	}
	public function get_firma_invetsa()
	{
		return $this->firma_invetsa;
	}
	public function get_firma_jefe_planta()
	{
		return $this->firma_jefe_planta;
	}
	
	public function get_hora_ingreso()
	{
		return $this->hora_ingreso;
	}
	
	public function get_hora_salidas()
	{
		return $this->hora_salidas;
	}
	
	public function get_id()
	{
		return $this->id;
	}
	
	public function get_id_compania()
	{
		return $this->id_compania;
	}
	public function get_id_maquina()
	{
		return $this->id_maquina;
	}
	
	public function get_id_tecnico()
	{
		return $this->id_tecnico;
	}
	
	public function get_revision()
	{
		return $this->revision;
	}
	
	
	
	public function guardar()
	{
		sql="insert into servicio_mantenimiento(codigo,fecha,firma_invetsa,firma_jefe_planta,hora_ingreso,hora_salidas,id,id_compania,id_maquina,id_tecnico,revision)values('$this->codigo','$this->fecha','$this->firma_invetsa','$this->firma_jefe_planta','$this->hora_ingreso','$this->hora_salidas','$this->id','$this->id_compania','$this->id_maquina','$this->id_tecnico','$this->revision')";
		if(parent::ejecutar($sql))
			return true;
		else
			return false;
	}
	public function buscar()
	{
		$sql="select * from servicio_mantenimiento";
		return parent::ejecutar($sql);
	}	
}

?>