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
    <h3 class="text-center">图书信息</h3>
    <br/>
    
    <table class="table table-striped table-hover ">
  <thead>
    <tr>
      <th>ISBN</th>  
            <th>Title</th>  
            <th>Publisher</th>  
            <th>PublishDate</th>  
            <th>Price</th>
            <th>AuthorName</th>
            <th>AuthorID</th>
            <th>AuthorAge</th>
            <th>AuthorCountry</th>
    </tr>
  </thead>
  <tbody>
  	<s:iterator value="#request.list" status="st">  
    <tr>
      <td><s:property value="ISBN"/></td>
      <td><s:property value="Title" /></td>
      <td><s:property value="Publisher"/></td>
      <td><s:property value="PublishDate"/></td>
      <td><s:property value="Price"/></td>
      <td><s:property value="Name"/></td>
      <td><s:property value="AuthorID"/></td>
      <td><s:property value="Age"/></td>
      <td><s:property value="Country"/></td>
    </tr>
    </s:iterator>
  </tbody>
</table> 
	</div>

  </body>
</html>
 
