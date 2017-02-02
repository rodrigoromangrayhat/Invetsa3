<?php
include_once('clsConexion.php');
class detalle_inpeccion_funcionamiento extends Conexion
{
	private $criterio_evaluacion;
	private $estado;
	private $id;
	private $id_inspeccion;

	public function detalle_inpeccion_funcionamiento ()
	{
		parent::Conexion();
		$this->criterio_evaluacion="";
		$this->estado="";
		$this->id=0;
		$this->id_inspeccion="";
		
		
	public function detalle_inpeccion_funcionamiento2($criterio_evaluacion,$estado,$id,$id_inspeccion)
	{
		$this->criterio_evaluacion=$criterio_evaluacion;
		$this->estado=$estado;
		$this->id=$id;
		$this->id_inspeccion=$id_inspeccion;		
	}
	public function get_criterio_evaluacion()
	{
		return $this->criterio_evaluacion;
	}
	public function get_estado()
	{
		return $this->estado;
	}
	public function get_id()
	{
		return $this->id;
	}
	public function get_id_inspeccion()
	{
		return $this->id_inspeccion;
	}
	
	public function guardar()
	{
		sql="insert into detalle_inspeccion_funcionamiento(criterio_evaluacion,estado,id,id_inspeccion)values('$this->criterio_evaluacion','$this->estado','$this->id','$this->id_inspeccion')";
		if(parent::ejecutar($sql))
			return true;
		else
			return false;
	}
	public function buscar()
	{
		$sql="select * from detalle_inspeccion_funcionamiento";
		return parent::ejecutar($sql);
	}	
}

?>