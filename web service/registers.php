<?php

/*
 * Following code will create a new user row
 * All user details are read from HTTP Post Request
 */

// array for JSON response
$response = array();

// check for required fields
if (isset($_POST['number']) && isset($_POST['email']) && isset($_POST['password'])  && isset($_POST['username'])) {
    
    $number = $_POST['number'];
    $email = $_POST['email'];
    $password = $_POST['password'];
	$username=$_POST['username'];
	

    // include db connect class
    require_once __DIR__ . '/include/db_connect.php';

    // connecting to db
    $db = new DB_CONNECT();

    // mysql inserting a new row
    $result = mysql_query("INSERT INTO user(number, email, password,username) VALUES('$name', '$email', '$password' , '$username')");

    // check if row inserted or not
    if ($result) {
		
		$result = mysql_query("SELECT * FROM user WHERE email = '$email' && password = '$password'");
		$result = mysql_fetch_array($result);
		
        // successfully inserted into database
        $response["success"] = 1;
        $response["message"] = "Account successfully created.";
		$response["ID"] = $result["user_id"];

        // echoing JSON response
        echo json_encode($response);
    } else {
        // failed to insert row
        $response["success"] = 0;
        $response["message"] = "Oops! The Email Address is already registered.";
        
        // echoing JSON response
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";

    // echoing JSON response
    echo json_encode($response);
}
?>