<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import= "com.eboli.dao.EboliDAO,com.eboli.beans.ProductDetailsBean" %>
<html>
<head>
<script type="text/javascript">
var cat,name,price,bprice,desc;
function validate()
{
	
	var name1=document.form.name.value;
	if(name1.length==0)
	{alert("Invalid  Product Name");
	 return;
	}
	
	/*var cat = document.getElementById("cat").value;
	var name = document.getElementById("name").value;
	var price = document.getElementById("price").value;
	var bprice = document.getElementById("bprice").value;
	var desc = document.getElementById("desc").value;
	
	alert(cat+" "+name+" "+price+" "+bprice+" "+desc);*/
	
	//process(cat,name,price,bprice,desc);

}

	
</script>
</head>
<body background="dolphin3.jpg">

<center><h2>Add Product Form</h2><br>
<form method="post" name="form" action="prodsucces.jsp">
<table>
<tr><td>Product Category: </td><td>
<select name="cat" >
<option value="Electronics">Electronics</option>
<option value="Furnitures">Furnitures</option>
<option value="Automobiles">Automobiles</option>
<option value="Softwares">Softwares</option>
<option value="Mobiles">Mobiles</option>

<!--<option value="Accesories">Electronics</option>
<option value="Electricals">Furnitures</option>
<option value="Antics">Automobiles</option>
<option value="Vehicles">Softwares</option>
<option value="Cell Phones">Mobiles</option>

<option value="Fashion">Electronics</option>
<option value="Home Interiors">Furnitures</option>
<option value="SourceCodes">Softwares</option>
<option value="PDA">Mobiles</option>-->

<option value="Others">Others</option>
</select></td></tr>
<tr><td></td><td></td></tr>
<tr><td>Product Name:</td><td> <input type="text" name="name"></td>
<tr><td></td><td></td></tr>

<tr><td>Min Price(Rs):</td><td><input type="text" name="price"></td></tr>
<tr><td></td><td></td></tr>
<tr><td>Buy Now Price(Rs):</td><td><input type="text" name="bprice"></td></tr>
<tr><td></td><td></td></tr>
<tr><td>Description:</td><td><textarea name="desc" rows="4" cols="15" ></textarea></td></tr>
<tr><td></td><td></td></tr>
</table>
<br><br>


<input type="submit" value="ADD PRODUCT" onClick="validate()">
<input type="reset" ></center>






</body>
</html> 



