<?php  
 function check(){
  
   $user = $_GET['user'];
   $pass = $_GET['pwd'];
 
  $file=fopen("assignment11-account-info.txt","r"); 
  
   while(!feof($file))
        {
         $check = fgets($file);
	 if($check == $user)
 	
 	 if($check == $pwd)
           
        }
       fclose($file);
 }

 function validate()
{




}


 ?>


<html>
<h1>Welcome to Dublin Anondson's Assignment XI PHP Page!</h1>
<p1>Please Login.</p1><br>
<form name="login" action="assignment11.php" onsubmit="<?php check(); ?>" method="GET">
 Username:<input type="text" name="user"><br>
 Password:<input type="password" name="pwd"><br>
 <input type="submit" value="Login">
</form>
<p2>Don't have an account?</p2><br>
<form name="create" action="assignment11.php" onsubmit="return validate();" method="GET">
Username:<input type="text" name="username"><br>
Password:<input type="text" name="pass"><br>
First Name:<input type="text" name="fname"><br>
Last Name:<input type="text" name="lname">
<input type="submit" value="Create Account">
</form>
</html>
