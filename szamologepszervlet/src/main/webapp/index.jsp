<html>
<body>
<%
Double result = (Double) request.getAttribute("result");
String resultText = (result == null) ?
		"" : "result " + result.toString();
%>
<form method="post" action="szamologep.do">
<input type="text" name="a" /><br>
<input type="text" name="b" /><br>
<select name="operator">
<option value="+" > + </option>
<option value="-" > - </option>
<option value="*" > * </option>
<option value="/" > / </option>
</select><br>

<%= resultText %>
<input type="submit" /><br>
</form>
</body>
</html>
