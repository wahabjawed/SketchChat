<?php

class DB_Functions {

    private $db;

    //put your code here
    // constructor
    function __construct() {
        include_once 'include/db_connect.php';
        // connecting to database
        $this->db = new DB_Connect();
        $this->db->connect();
    }

    // destructor
    function __destruct() {
        
    }

    /**
     * Storing new user
     * returns user details
     */
    public function storeUser($username, $email, $gcm_regid,$number,$password) {
        // insert user into database
        $result = mysql_query("INSERT INTO users(username, email, gcm_regid, created_at,number,password) VALUES('$username', '$email', '$gcm_regid', NOW(),'$number','$password')");
        // check for successful store
        if ($result) {
            // get user details
            $id = mysql_insert_id(); // last inserted id
            $result = mysql_query("SELECT * FROM users WHERE user_id = $id") or die(mysql_error());
            // return user details
            if (mysql_num_rows($result) > 0) {
                return mysql_fetch_array($result);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Get user by email and password
     */
    public function getUserByEmail($email) {
        $result = mysql_query("SELECT * FROM users WHERE email = '$email' LIMIT 1");
        return $result;
    }

    /**
     * Getting all users
     */
    public function getAllUsers() {
        $result = mysql_query("select * FROM users");
        return $result;
    }

    /**
     * Check user is existed or not
     */
    public function isUserExisted($email) {
        $result = mysql_query("SELECT email from users WHERE email = '$email'");
        $no_of_rows = mysql_num_rows($result);
        if ($no_of_rows > 0) {
            // user existed
            return true;
        } else {
            // user not existed
            return false;
        }
    }

}

?>