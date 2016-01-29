<%@ page contentType="text/html; charset=utf-8" language="java"   errorPage="" %>
<%
try{
	String json=(String)request.getAttribute("json");
	out.write(json);
}catch(Exception e){ 
	//JspLog.error("",e);
}
%>