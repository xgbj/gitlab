<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<html>

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
  
  <div class="container">
    <h3 class="text-center">图书列表</h3>
    <br/>
    
    <table class="table table-striped table-hover ">
  <thead>
    <tr>
            <th>Title</th>  
            <th>Price</th>
    </tr>
  </thead>
  <tbody>
  	<s:iterator value="#request.list" status="st">  
    <tr>
      <td><a href='detail.action?name=<s:property value="Title"/>'><s:property value="Title"/></a></td>
      <td><s:property value="Price"/></td>
      <td><a href='delete.action?name=<s:property value="Title"/>'>delete</a></td>
    </tr>
    </s:iterator>
  </tbody>
</table> 
	</div>
    <a href='index.jsp'><h3>返回</h3></a>
  </body>
</html>
 
