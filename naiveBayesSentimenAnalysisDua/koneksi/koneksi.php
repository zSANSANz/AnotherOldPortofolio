<?php

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "db_naive_bayes_classifier";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

?>