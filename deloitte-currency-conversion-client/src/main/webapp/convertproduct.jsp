
<!DOCTYPE html>
<%@page import="java.util.Set"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
  background-image: url("img4.jpg");
 background-repeat: no-repeat;
  background-size: cover; 
   height: 620px;
  background-position:center;   
  background-color: #cccccc;
  /*align:center;*/
}

h2 {
    color : #000000;
    text-align : center;
    line-height:20px;  
}
.center{
  text-align: center;
  vertical-align: middle;
  horizontal-align:middle;
  height:200px;
  width:400px;
  position:fixed;
  top:20%;
  left:30%;
}

/*form
{

    align:"center"; 
}*/

.dd{
  text-align: center;
  vertical-align: middle;
  horizontal-align:middle;
  height:500px;
  width:600px;
  position:fixed;
  top:50%;
  left:20%;
}
</style>
</head>
<body onload="validate()">
<div class="center">
<h2>
<%
Set<String> opts=(Set<String>)request.getAttribute("from");
Set<String> optsTo=(Set<String>)request.getAttribute("to");
%>
<form action="convert" method="get">
Enter FromCurrency:
<select id="t1" name="from" onchange="validate()">
<%

for(String opt:opts)
	{
	out.println("<option>"+opt+"</option>");
	
	}

	%>

                     
 </select><br>
Enter ToCurrency:
<select id="t2" name="to" onchange="validate()">
 <%

for(String opt:optsTo)
	{
	out.println("<option>"+opt+"</option>");
	
	}

	%>                     
 </select><br>
Enter Amount:
<input type="text" name="quantity"><br>
<input type="submit" id="sub1" value="Convert"><br>
<input type="reset" value="Reset">
</form></h2>
</div>

<script type="text/javascript">
validate();
function validate()
{
    var t1=document.getElementById("t1");
     var t2=document.getElementById("t2");
     var d1=document.getElementById("d1");
     var sub1=document.getElementById("sub1");
     var x=true;
     if(t1.value==t2.value)
		{
   		 x=false;
   		 d1.innerHTML="Currency Values cannot be same";
   		 sub1.disabled=true;
   		
		}
     else
    	 {
    	 d1.innerHTML="";
    	 sub1.disabled=false;
    	 }
	return x;
}

</script>
<div id=d1 class="dd">
</div>

</body>
</html>