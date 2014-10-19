register.php
<?php
 
// response json
$json = array();
 
/**
 * Registering a user device
 * Store reg id in users table
 */
if (isset($_POST["username"]) && isset($_POST["email"]) && isset($_POST["password"]) && isset($_POST["regId"]) && isset($_POST["number"])) {
    $username = $_POST["username"];
    $email = $_POST["email"];
	$number = $_POST["number"];
	$password = $_POST["password"];	
    $gcm_regid = $_POST["regId"]; // GCM Registration ID
    // Store user details in db
    include_once './db_functions.php';
    include_once './GCM.php';
 
    $db = new DB_Functions();
    $gcm = new GCM();
 
    $res = $db->storeUser($username, $email, $gcm_regid,$number,$password);
 
    $registatoin_ids = array($gcm_regid);
    $message = array("product" => "shirt");
 
    $result = $gcm->send_notification($registatoin_ids, $message);
 
    echo $result;
} else {
    // user details missing
}
?>