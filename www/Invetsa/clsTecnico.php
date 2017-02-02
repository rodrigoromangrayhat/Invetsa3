<?
include_once('clsConexion.php');
class Tecnico extends Conexion
{
	//atributos
	private $id;
	private $nombre;
	
	//construtor
	public function Tecnico()
	{   parent::Conexion();
		$this->id=0;
		$this->nombre="";	
	}
	//propiedades de acceso
	public function setId($valor)
	{
		$this->id=$valor;
	}
	public function getId()
	{
		return $this->id;
	}

	public function setNombre($valor)
	{
		$this->nombre=$valor;
	}
	public function getNombre()
	{
		return $this->nombre;
	}

	
	
	public function guardar()
	{
     $sql="insert into tecnico(nombre,edad) values('$this->nombre','$this->edad')";
		
		if(parent::ejecutar($sql))
			return true;
		else
			return false;	
	}
	
	
	
	public function buscar()
	{
		$sql="select * from tecnico";
		return parent::ejecutar($sql);
	}										

	
}    
?>