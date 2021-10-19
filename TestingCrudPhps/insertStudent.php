<?php

header('Access-Control-Allow-Origin: *');
header("Access-Control-Allow-Headers: Origin, X-Requested-With, Content-Type, Accept");
header('Access-Control-Allow-Methods: GET, POST, PUT, DELETE');

include 'conexion.php';
$arrayMensaje = array();
$parameters = file_get_contents("php://input");

if (isset($parameters)) {
    $jsonRecibido = json_decode($parameters, true);
    $name = $jsonRecibido["name"];
    $surname = $jsonRecibido["surname"];
    $averageGrade = $jsonRecibido["averageGrade"];
    $sex = $jsonRecibido["sex"];
    $query  = "INSERT INTO alumnos(`name`, `surname`, `averageGrade`, `sex`) ";
    $query .= "VALUES ('$name','$surname','$averageGrade', '$sex')";
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
