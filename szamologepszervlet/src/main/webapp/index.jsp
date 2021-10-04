<%@page import="szamologepszervlet.ResultDto"%>
<html>
<body>
<%
szamologepszervlet.ResultDto result = (request.getAttribute("result") != null) ? (szamologepszervlet.ResultDto) request.getAttribute("result"):
	new ResultDto();
String resultText = (result == null) ?
		"" : "result " + result.getResult().toString();
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
