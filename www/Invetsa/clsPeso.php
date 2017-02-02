<?php
include_once('clsConexion.php');
class Peso extends Conexion
{
	private $bursometro;
	private $id;
	private $id_sistema;
	private $indice_bursal;
	private $indice_hepatico;
	private $indice_timico;
	private $pedo_bursa;
	private $peso_brazo;
	private $peso_corporal;
	private $peso_higado;
	private $peso_timo;

	public function peso()
	{
		parent::Conexion();
		$this->bursometro="";
		$this->id=0;
		$this->id_sistema="";
		$this->indice_bursal="";
		$this->indice_hepatico="";
		$this->indice_timico="";
		$this->pedo_bursa="";
		$this->peso_brazo="";
		$this->peso_corporal="";
		$this->peso_higado="";
		$this->peso_timo="";
		
		
	public function peso2($bursometro,$id,$id_sistema,$indice_bursal,$indice_hepatico,$indice_timico,$pedo_bursa,$peso_brazo,$peso_corporal,$peso_higado,$peso_timo)
	{
		$this->bursometro=$bursometro;
		$this->id=$id;
		$this->id_sistema=$id_sistema;
		$this->indice_bursal=$indice_bursal;	
		$this->indice_hepatico=$indice_hepatico;
		$this->indice_timico=$indice_timico;	
		$this->pedo_bursa=$pedo_bursa;
		$this->peso_brazo=$peso_brazo;
		$this->peso_corporal=$peso_corporal;
		$this->peso_higado=$peso_higado;
		$this->peso_timo=$peso_timo;
	}
	public function get_bursometro()
	{
		return $this->bursometro;
	}
	public function get_id()
	{
		return $this->id;
	}
	public function get_id_sistema()
	{
		return $this->id_sistema;
	}
	public function get_indice_bursal()
	{
		return $this->indice_bursal;
	}

	public function get_indice_hepatico()
	{
		return $this->indice_hepatico;
	}
	public function get_indice_timico()
	{
		return $this->indice_timico;
	}
	public function get_peso_bursa()
	{
		return $this->pedo_bursa;
	}
	public function get_peso_brazo()
	{
		return $this->peso_brazo;
	}
	public function get_peso_corporal()
	{
		return $this->peso_corporal;
	}
	public function get_peso_higado()
	{
		return $this->peso_higado;
	}
	public function get_peso_timo()
	{
		return $this->peso_timo;
	}
	
	public function guardar()
	{
		sql="insert into peso(bursometro,id,id_sistema,indice_bursal,indice_hepatico,indice_timico,pedo_bursa,peso_brazo,peso_corporal,peso_higado,peso_timo)values('$this->bursometro','$this->id','$this->id_sistema','$this->indice_bursal','$this->indice_hepatico','$this->indice_timico','$this->pedo_bursa','$this->peso_brazo','$this->peso_corporal','$this->peso_higado','$this->peso_timo')";
		if(parent::ejecutar($sql))
			return true;
		else
			return false;
	}
	public function buscar()
	{
		$sql="select * from peso";
		return parent::ejecutar($sql);
	}	
}

?>