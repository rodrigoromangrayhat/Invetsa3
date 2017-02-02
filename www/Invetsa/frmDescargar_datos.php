<?php
include_once ('clsEmpresa.php');
include_once ('clsTecnico.php');
include_once ('clsCompania.php');
include_once ('clsGalpon.php');
include_once ('clsGranja.php');
include_once ('clsMaquina.php');
include_once ('clsVacunador.php');

switch ($_GET['opcion']) {
	case 'get_empresa':
		get_empresa();
		break;
	
	default:
		
		break;
}

function get_empresa()
{$dato=json_decode(file_get_contents("php://input"),true);
	 $emp= new Empresa();	
	 $tec= new Tecnico();	
	 $com= new Compania();	
	 $gal= new Galpon();	
	 $gra= new Granja();	
	 $maq= new Maquina();	
	 $vac= new Vacunador();
	 	
           $resultado_emp=$emp->buscar();
           $resultado_tec=$tec->buscar();
           $resultado_com=$com->buscar();
           $resultado_gal=$gal->buscar();
           $resultado_gra=$gra->buscar();
           $resultado_maq=$maq->buscar();
           $resultado_vac=$vac->buscar();
           
           $empresas= array(); 
           $tecnicos=array();
           $companias=array();
           $galpones=array();
           $granjas=array();
           $maquinas=array();
           $vacunas=array();

        while($fila=mysqli_fetch_object( $resultado_emp)) {
		 array_push($empresas, $fila);
		    }

		 while($fila=mysqli_fetch_object( $resultado_tec)) {
		 array_push($tecnicos, $fila);
		    }

		    while($fila=mysqli_fetch_object( $resultado_com)) {
		 array_push($companias, $fila);
		    }

		    while($fila=mysqli_fetch_object( $resultado_gal)) {
		 array_push($galpones, $fila);
		    }

		    while($fila=mysqli_fetch_object( $resultado_gra)) {
		 array_push($granjas, $fila);
		    }
		    while($fila=mysqli_fetch_object( $resultado_maq)) {
		 array_push($maquinas, $fila);
		    }
		    while($fila=mysqli_fetch_object( $resultado_vac)) {
		 array_push($vacunas, $fila);
		    }
		    if($empresas && $tecnicos && $tecnicos && $companias && $galpones && $granjas && $maquinas && $maquinas && $vacunas){
		    $dato['empresa']=$empresas;
		    $dato['tecnico']=$tecnicos;
		    $dato['compania']=$companias;
		    $dato['galpon']=$galpones;
		    $dato['granja']=$granjas;
		    $dato['maquina']=$maquinas;
		    $dato['vacunador']=$vacunas;
		    $dato['suceso']="1";
		     $dato['mensaje']="Correcto.";
		}else
		{
			$dato['suceso']="0";
			 $dato['mensaje']="Error al descargar los datos.";
		}

          print json_encode($dato)	;
           
 	
}
?>