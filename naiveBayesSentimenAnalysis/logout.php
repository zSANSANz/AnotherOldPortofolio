<?php
/**
 * Created by PhpStorm.
 * User: heroes-4
 * Date: 1/1/2017
 * Time: 3:09 PM
 */

   session_start();

   if(session_destroy()) {
       header("Location: login.php");
   }
?>