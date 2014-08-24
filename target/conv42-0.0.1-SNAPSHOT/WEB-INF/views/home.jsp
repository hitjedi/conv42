<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

        <head>
                <title>Currency Converter App</title>
                <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />" />
        		
        </head>

<body>
<div class="container">
	<h1> List of items </h1>
	
	<form:form modelAttribute="order">
		<table class="table table-striped">
			<tbody>
				<tr>
					<td>
						<input type="text" id="input" onkeyup = 'this.value=parseInt(this.value) | 0' name="amount" value="${amount}"/>		
					</td>		
					<td>
						<select name="dropDownFrom" id="CurrencyFrom">
    						<option value="UAH" selected="selected">UAH</option>
    						<option value="USD">USD</option>
    						<option value="EUR">EUR</option>
  						</select>
					</td>
					<td>
						<select name="dropDownTo" id="CurrencyTo">
    						<option value="UAH">UAH</option>
    						<option value="USD">USD</option>
    						<option value="EUR">EUR</option>
  						</select>  						
					</td>
						<td>
							<input type="text" id="output" value="${result}" readonly/>		
						</td>
					</tr>
			</tbody>
		</table>
		<form:button name="button" id="button">Update</form:button>
	</form:form>
	
	<script>
	
	
	document.getElementById("CurrencyFrom").onchange = function() {
		sessionStorage['CurrencyFrom'] = document.getElementById("CurrencyFrom").value;	
	}
	document.getElementById("CurrencyTo").onchange = function() {
		sessionStorage['CurrencyTo'] = document.getElementById("CurrencyTo").value;	
	}

	
	window.onload = function(){
		if(sessionStorage['CurrencyFrom'])
		  document.getElementById("CurrencyFrom").value = sessionStorage['CurrencyFrom'];
		if(sessionStorage['CurrencyTo'])
		  document.getElementById("CurrencyTo").value = sessionStorage['CurrencyTo'];
	}
	/*
	window.onunload = function(){
		
		sessionStorage.removeItem("CurrencyTo");
		
	}
	*/
	
	/*
	var a = document.getElementById("CurrencyTo").value;
	document.getElementById("CurrencyTo").onchange = function() {
		 localStorage['CurrencyTo'] = document.getElementById("CurrencyTo").value;
		}

	document.getElementById('button').onclick = function() {
		alert("sdssd");
		if(localStorage['CurrencyTo'])
	        document.getElementById("CurrencyTo").value = localStorage['CurrencyTo'];
		   //alert("button was clicked");
	}
	*/
	//window.onload= aaa;
	/*
	window.onunload = window.onbeforeunload = (function(){

		  return function(){
			  document.getElementById("CurrencyTo").value = a;
		  }

		}());
	
	*/
		//var a = document.getElementById("CurrencyTo").value;
		/*
		document.getElementById("CurrencyTo").onchange = function() {
			    localStorage.setItem('CurrencyTo', document.getElementById("CurrencyTo").value);
		}
		
		document.getElementById('button').onclick = function() {
			if(localStorage['CurrencyTo'])
		        document.getElementById("CurrencyTo").value = localStorage['CurrencyTo'];
			   //alert("button was clicked");
		}
		
		*/

	//document.getElementById("CurrencyTo").value= a;
		
		//document.getElementById("CurrencyTo").onchange = function() {
		//    localStorage.setItem('CurrencyTo', document.getElementById("CurrencyTo").value);
		//}
		
		//if (localStorage.getItem('CurrencyTo')) {
			//alert(a);
		//    document.getElementById("CurrencyTo").options[localStorage.getItem('CurrencyTo')].selected = true;
		//}
		/*
		window.onbeforeunload = function(){
			
			document.getElementById("CurrencyTo").value = a;
			
			return document.getElementById("CurrencyTo").value;
			
		}*/
		
		/*
		function sdd(){
	        	document.getElementById("CurrencyTo").value=a;
		}
		
	    function MyFunc(){

	    	if (localStorage.getItem('CurrencyTo')) {
		        alert(document.getElementById("CurrencyTo").value);
			    document.getElementById("CurrencyTo").options[localStorage.getItem('CurrencyTo')].selected = true;
			}
	    	*/
	        //document.getElementById("CurrencyTo").value;
	        //alert(document.getElementById("CurrencyTo").value);
	        
	       // window.onbeforeunload = ssd();

		/*
		document.getElementById("CurrencyTo").onchange = function() {
			 localStorage['CurrencyTo'] = document.getElementById("CurrencyTo").value;
			}
		
		window.onkeypress = function(){
		    if(localStorage['CurrencyTo'])
		        document.getElementById("CurrencyTo").value = localStorage['CurrencyTo'];
		}
		*/
		/*
			window.onload= function(){
			    if(localStorage['CurrencyTo'] != a){
			        document.getElementById("CurrencyTo").value = localStorage['CurrencyTo'];
			    } else {
			    	window.onbeforeunload = function(){
			    		
			    		document.getElementById("CurrencyTo").value = a;
						
						return document.getElementById("CurrencyTo").value;
			    		
			    	}
			    }
			}
			*/
			
		
		/*
		function MyFunc(){
			
			window.onbeforeunload = ff();
			
		}
		
		function ff(){
			
			document.getElementById("CurrencyTo").value = a;
			
		}
		
		*/
		//window.onbeforeunload = function(){
		//	document.getElementById("CurrencyTo").value = a;
		//}
		
		//document.getElementById("dropDownTo").onchange = function() {
		//	 localStorage['dropDownTo'] = document.getElementById("dropDownTo").value;
		//}
				
		//window.onload  = function(){
			
			//if(localStorage['dropDownTo']){
				//alert("hello world");
		        //document.getElementById("dropDownTo").value = localStorage['dropDownTo'];
			
			//}
		//}
		

		//function sdd(){
			//alert("hello world");

		    //if(localStorage['dropDownTo'])
		      //  document.getElementById("dropDownTo").value = localStorage['dropDownTo'];
		//}
</script>
	
</div>



</body>
</html>
