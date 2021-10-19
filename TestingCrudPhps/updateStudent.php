<?php

header('Access-Control-Allow-Origin: *');
header("Access-Control-Allow-Headers: Origin, X-Requested-With, Content-Type, Accept");
header('Access-Control-Allow-Methods: GET, POST, PUT, DELETE');

include 'conexion.php';
$arrayMensaje = array();
$parameters = file_get_contents("php://input");

if (isset($parameters)) {
    $jsonRecibido = json_decode($parameters, true);
    $id= $jsonRecibido["id"];
    $name = $jsonRecibido["name"];
    $surname = $jsonRecibido["surname"];
    $averageGrade = $jsonRecibido["averageGrade"];
    $sex = $jsonRecibido["sex"];
    $query = "UPDATE `alumnos` SET `name`='$name',`surname`='$surname',`averageGrade`='$averageGrade',`sex`='$sex' WHERE `id` = '$id'";

    $result = $conn->query ( $query );
    if (isset ( $result ) && $result) {
      $arrayMensaje["status"] = true;
    } else {
      $arrayMensaje["status"] = false;
    }

    $mensajeJSON = json_encode($arrayMensaje, JSON_PRETTY_PRINT);
    echo $mensajeJSON;

    }

?>
