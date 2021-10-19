<?php

header('Access-Control-Allow-Origin: *');
header("Access-Control-Allow-Headers: Origin, X-Requested-With, Content-Type, Accept");
header('Access-Control-Allow-Methods: GET, POST, PUT, DELETE');

include 'conexion.php';
$arrayMsg = array();
$arrayStudents = array();

$sql = "Select * from Alumnos";
$arrayMsg["state"] = $sql;
$result = $conn->query($sql);

     if(isset($result) && $result){
        if ($result->num_rows > 0) {
            while($row = $result->fetch_assoc()) {
                $arrayStudents[] = $row;
            }

            $arrayMsg["state"] = "ok";
            $arrayMsg["students"] = $arrayStudents;

        }else{
            $arrayMsg["state"] = "Not students found";
        }

    $msgJSON = json_encode($arrayMsg, JSON_PRETTY_PRINT);
    echo $msgJSON;
    }
?>
