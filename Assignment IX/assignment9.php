
<?php

if($_REQUEST == null)
{
 echo"<title>Assigment 9: no query string</title>";
 echo"<p1>Hello World!</p1><br>";
 echo"<p2>Dublin Anondson's Assignment 9</p2><br>";
 echo"<p3>The query string is null.</p3>";
}
 else
{
  echo"<title>Assigment 9: with query string</title>";
  echo"<p1>Hello World!</p1><br>";
  echo"<p2>Dublin Anondson's Assignment 9</p2><br>";
  echo"The query string is ";
  echo var_dump($_REQUEST);
}
phpinfo();
?>
