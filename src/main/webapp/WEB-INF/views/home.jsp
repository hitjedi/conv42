<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

        <head>
                <title>Currency Converter App</title>
                <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
                <link href="<c:url value="/resources/css/images/18-512.png" />" rel="shortcut icon">
        </head>

<body>
<div id="container">
	<div id="header">
	<h2>Currency Converter Application</h2>
	</div>
    <div id="line"></div>
    <div id="content">            
	<form:form modelAttribute="order">
		<table class="cv-table">
			<tr>
				<td>
					<input type="text" class="input" onkeyup = 'this.value=parseInt(this.value) | 0' name="amount" value="${amount}"/>		
				</td>		
				<td>
					<select name="dropDownFrom" id="CurrencyFrom" class="select">
    					<option value="UAH">UAH</option>
    					<option value="USD">USD</option>
   						<option value="EUR">EUR</option>
  					</select>
				</td>
				<td>
					<select name="dropDownTo" id="CurrencyTo" class="select">
						<option value="UAH">UAH</option>
    					<option value="USD">USD</option>
    					<option value="EUR">EUR</option>
  					</select>  						
				</td>
				<td>
					<input type="text" class="input" id="output" value="${result}" readonly/>		
				</td>
				<td>
					<form:button name="button" id="button" class="button">Convert</form:button>
				</td>
			</tr>
		</table>
	</form:form>
	</div>
	    <div id="curr">  
	    
		<table class="wp-table">
		<TR><TH></TH><TH>Buy Rate</TH><TH>Sell Rate</TH></TR> 
		
		<tr>
			<td>UAH</td>
			<td>1</td>
			<td>1</td>
		</tr>
		
		<tr>
			<td>USD</td>
			<td>${dollarBuy}</td>
			<td>${dollarSell}</td>
		</tr>
		<tr>
			<td>EUR</td>
			<td>${euroBuy}</td>
			<td>${euroSell}</td>
		</tr>
	</table>
	    
	    </div>
	</div>
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
	
</script>
</body>
</html>
