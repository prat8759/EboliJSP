<html>
<head>
<script type="text/javascript">

function validate()
{i=document.form.email.value.indexOf("@")
name=document.form.name1.value


if(name.length==0)
{alert("Invalid name")
 return false}
 
 
 
if (i==-1)
{alert("Invalid email id")
 return false
}

return true
}

function pwd()
{
i=document.form.pass.value
if(i<6) {alert("Password should be atleast six characters long");return false;}
}

</script>
</head>
<body background="world.jpg">

<center><h2>Registration Form</h2></center>

<form method="post" name="form" action="regsuccess.jsp" onSubmit="return validate();">
<table>
<tr><td>First Name:</td><td> <input type="text" name="name1"></td></tr>
<tr><td></td><td></td></tr>
<tr><td>Last Name:</td> <td><input type="text" name="name2"></td></tr>
<tr><td></td><td></td></tr>
<tr><td>Username:</td><td><input type="text" name="user"></td></tr>
<tr><td></td><td></td></tr>
<tr><td>Password:</td><td><input type="password" name="pass"></td></tr>
<tr><td></td><td></td></tr>
<tr><td>Re-enter Password:</td><td><input type="password" name="pass1" onFocus="pwd()"></td></tr>
<tr><td></td><td></td></tr>
<tr><td>Age:</td><td><input type="text" name="age" ></td></tr>
<tr><td></td><td></td></tr>
<tr><td>Gender:</td><td><input type="radio" name="r1" value="rr">Male <input type="radio" name="r1" value=rr>Female</td></tr>
<tr><td></td><td></td></tr>
<tr><td>Email Id:</td><td><input type="text" name="email"></td></tr>
<tr><td></td><td></td></tr>
<tr><td>City:</td><td><input type="text" name="add"></td></tr>
<tr><td></td><td></td></tr>
<tr><td>Pin Code.:</td><td><input type="text" name="cont"></td></tr>
<tr><td></td><td></td></tr></table>
Hobbies:
<table>
<tr><td><input type="checkbox" name="c">Reading</td><td><input type="checkbox" name="c">Blogging</td><td><input type="checkbox" name="c">Surfing</td></tr>
<tr><td></td><td></td></td><td></tr>
<tr><td><input type="checkbox" name="c">Singing</td><td><input type="checkbox" name="c">Dancing</td><td><input type="checkbox" name="c">Acting</td></tr>
<tr><td></td><td></td></td><td></tr>
<tr><td><input type="checkbox" name="c">Sleeping</td><td><input type="checkbox" name="c">Sports</td><td><input type="checkbox" name="c">Cooking</td></tr>
</table>
<center>

<input type="submit" value="submit"  /><!--  onClick="validate()-->
<input type="reset" />
<input type="button" value="Back" onClick="history.back()"/></center>
</form>
</body>
</html> 



