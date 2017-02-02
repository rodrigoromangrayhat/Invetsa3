<?php
include_once('clsConexion.php');
class Sistema_Integral extends Conexion
{
	private $codigo;	
	private $edad;
	private $id;
	private $id_empresa;
	private $id_galpon;
	private $id_granja;
	private $imagen1;
	private $imagen2;
	private $imagen3;
	private $imagen4;
	private $imagen5;
	private $observaciones;
	private $revision;
	private $sexo;

	public function Sistema_Integral()
	{
		parent::Conexion();
		$this->codigo="";		
		$this->edad="";
		$this->id=0;
		$this->id_empresa="";
		$this->id_galpon="";
		$this->id_granja="";
		$this->imagen1="";
		$this->imagen2="";
		$this->imagen3="";
		$this->imagen4="";
		$this->imagen5="";
		$this->observaciones="";
		$this->revision="";
		$this->sexo="";
		
		
		
	public function Sistema_Integral2($codigo,$edad,$id,$id_empresa,$id_galpon,$id_granja,$imagen1,$imagen2,$imagen3,$imagen4,$imagen5,$observaciones,$revision,$sexo)
	{
		$this->codigo=$codigo;
		$this->edad=$edad;	
		$this->id=$id;
		$this->id_empresa=$id_empresa;
		$this->id_galpon=$id_galpon;
		$this->id_granja=$id_granja;
		$this->imagen1=$imagen1;
		$this->imagen2=$imagen2;	
		$this->imagen3=$imagen3;
		$this->imagen4=$imagen4;
		$this->imagen5=$imagen5;
		$this->observaciones=$observaciones;
		$this->revision=$revision;
		$this->sexo=$sexo;
	}
	public function get_codigo()
	{
		return $this->codigo;
	}
	
	public function get_edad()
	{
		return $this->edad;
	}
	public function get_id()
	{
		return $this->id;
	}
	public function get_id_empresa()
	{
		return $this->id_empresa;
	}
	
	public function get_id_galpon()
	{
		return $this->id_galpon;
	}
	
	public function get_id_granja()
	{
		return $this->id_granja;
	}
	
	public function get_imagen1()
	{
		return $this->imagen1;
	}
	public function get_imagen2()
	{
		return $this->imagen2;
	}
	public function get_imagen3()
	{
		return $this->imagen3;
	}
	public function get_imagen4()
	{
		return $this->imagen4;
	}
	public function get_imagen5()
	{
		return $this->imagen5;
	}
	public function get_observaciones()
	{
		return $this->observaciones;
	}
	public function get_revision()
	{
		return $this->revision;
	}

	public function get_sexo()
	{
		return $this->sexo;
	}
	
	public function guardar()
	{
		sql="insert into sistema_integral(codigo,edad,id,id_empresa,id_galpon,id_granja,imagen1,imagen2,imagen3,imagen4,imagen5,observaciones,revision,sexo)values('$this->codigo','$this->fecha','$this->firma_invetsa','$this->firma_jefe_planta','$this->hora_ingreso','$this->hora_salidas','$this->id','$this->id_compania','$this->id_maquina','$this->id_tecnico','$this->revision')";
		if(parent::ejecutar($sql))
			return true;
		else
			return false;
	}
	public function buscar()
	{
		$sql="select * from sistema_integral";
		return parent::ejecutar($sql);
	}	
}

?>