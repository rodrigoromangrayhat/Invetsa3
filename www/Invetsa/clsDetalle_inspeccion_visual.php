<?php
include_once('clsConexion.php');
class detalle_inpeccion_visual extends Conexion
{
	private $codigo_proveedor;
	private $codigo_sistema;
	private $descripcion;
	private $estado;
	private $id;
	private $id_inspeccion;

	public function detalle_inpeccion_visual()
	{
		parent::Conexion();
		$this->codigo_proveedor="";
		$this->codigo_sistema="";
		$this->descripcion="";
		$this->estado="";
		$this->id=0;
		$this->id_inspeccion="";
		
		
	public function detalle_inpeccion_visual2($codigo_proveedor,$codigo_sistema,$descripcion,$estado,$id,$id_inspeccion)
	{
		$this->codigo_proveedor=$codigo_proveedor;
		$this->codigo_sistema=$codigo_sistema;
		$this->descripcion=$descripcion;
		$this->estado=$estado;	
		$this->id=$id;
		$this->id_inspeccion=$id_inspeccion;	
	}
	public function get_codigo_proveedor()
	{
		return $this->codigo_proveedor;
	}
	public function get_codigo_sistema()
	{
		return $this->codigo_sistema;
	}
	public function get_descripcion()
	{
		return $this->descripcion;
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
		sql="insert into detalle_inspeccion_visual(codigo_proveedor,codigo_sistema,descripcion,estado,id,id_inspeccion)values('$this->codigo_proveedor','$this->codigo_sistema','$this->descripcion','$this->estado','$this->id','$this->id_inspeccion')";
		if(parent::ejecutar($sql))
			return true;
		else
			return false;
	}
	public function buscar()
	{
		$sql="select * from detalle_inspeccion_visual";
		return parent::ejecutar($sql);
	}	
}

?>