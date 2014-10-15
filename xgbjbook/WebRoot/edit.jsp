<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
<body>
<h2>添加图书: </h2>
<s:form action="add">
 <s:textfield name="Title" label="Title"/><br>
 <s:textfield name="ISBN" label="ISBN"/><br>
 <s:textfield name="AuthorID" label="AuthorID"/><br>
 <s:textfield name="Publisher" label="Publisher"/><br>
 <s:textfield name="PublishDate" label="PublishDate"/><br>
 <s:textfield name="Price" label="Price"/><br>
<s:submit />
</s:form>

  
  </body>
</html>
