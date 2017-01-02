
<?php 

if(!isset($_GET['fname']) && (!isset($_POST['input']))){
?>

<html>
<body>
<h1>Dublin Anondson's Assignment 10</h1>
<p1>Please fill out the form below, then we'll play a fun game!</p1>
<form name='form1' action='assignment10.php' onsubmit='return validate();' method='GET'><br>
First Name: <input type='text' name='fname' value='Dublin'><br>
Last Name: <input type='text' name='lname' value='Anondson'><br>
Email Address: <input type='text' name='email' value='Danondso@email.uark.edu'><br>
<input type='submit' value='Submit'>
</form>
<p2 id='w'></p2>
</body>
</html>

 <?php   }

    if(isset($_GET['fname']) || isset($_POST['input']) && (($_POST['input']) != ($_POST['ans']))) 
     {
         //answer variable
         $answer = 0;

	if(!isset($_POST['ans']))
	{//generates the random number
            define("answer", rand(1,5), false);
	   $answer = answer;
        } //saves the variable if the guess was wrong and resubmits it to the hidden form field.
       else if(isset($_POST['ans']) && ($_POST['ans'] != ""))
		$answer = $_POST['ans'];

       //echo "With Dollar " . $answer . "<br>";
	//if statement for dynamic headings, saves making another form.
	if(isset($_GET['fname']) && !isset($_POST['input']))
          {
            echo "Hello " . $_GET['fname'] . " " . $_GET['lname'] . "!";
	    echo "<br>Guess a number between 1 and 5!"; 
          }
	else if(isset($_POST['input']) && ($_POST['input'] != $_POST['ans']))
            {
              echo "Oops, your guess of " . $_POST['input'] . " was wrong! Try again.";
            }

   ?>
<html>
<body>
<form name='form2' action='assignment10.php' method='POST'>
 Guess: <input type='text' name='input'>
 <input type='hidden' name='ans' value='<?php echo $answer; ?>'>
<input type='submit' value='Guess!'>
</form>
</body>
</html>

<?php  }
//if statement for the correct answer
 if(isset($_POST['input'])&&(($_POST['input'])==($_POST['ans'])))
	{
   ?>
<html>
<body>
That was fun! Let's play again sometime!
</body>
</html>

<?php } ?>

<script>
function validate()
{
 //validation function
 var f = document.forms.form1.fname.value;
 var l = document.forms.form1.lname.value;
 var e = document.forms.form1.email.value;
 var w = document.getElementById("w");
 if(f == '' || f == null)
   {w.innerHTML='Please enter a first name.'; return false;}
 if(l == '' || l == null)
   {w.innerHTML='Please enter a last name.'; return false;}
 if(e == '' || e == null)
   {w.innerHTML='Please enter an email.'; return false;}

    var atpos=e.indexOf('@');
    var dotpos=e.lastIndexOf('.');

    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=e.length)
     {w.innerHTML='Not a valid email address.';  return false;}

  return true;
}
</script>

