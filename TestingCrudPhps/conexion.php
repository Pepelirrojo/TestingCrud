<?php

// Desactivar toda las notificaciónes del PHP

//error_reporting(0);

$servername = "localhost";
$user = "root";
$password = "";
$dbname = "colegio";
$conn = new mysqli($servername, $user,$password,$dbname);

// Check connection
if ($conn->connect_error) {
    $arrayMensaje = array();
    $arrayMensaje["estado"]= "error";
    $arrayMensaje["mensaje"] = "No se puede conectar a la BD";
    $mensajeJSON = json_encode($arrayMensaje, JSON_PRETTY_PRINT);
   die($mensajeJSON);
}

header("Access-Control-Allow-Origin: *");
if (isset($_SERVER['HTTP_ORIGIN'])) {
    header("Access-Control-Allow-Origin: {$_SERVER['HTTP_ORIGIN']}");
    header('Access-Control-Allow-Credentials: true');
    header('Access-Control-Max-Age: 86400');
}

if ($_SERVER['REQUEST_METHOD'] == 'OPTIONS') {
    if (isset($_SERVER['HTTP_ACCESS_CONTROL_REQUEST_METHOD']))
        header("Access-Control-Allow-Methods: GET, POST, PUT, DELETE, OPTIONS");

    if (isset($_SERVER['HTTP_ACCESS_CONTROL_REQUEST_HEADERS']))
        header("Access-Control-Allow-Headers: {$_SERVER['HTTP_ACCESS_CONTROL_REQUEST_HEADERS']}");
}

?>
