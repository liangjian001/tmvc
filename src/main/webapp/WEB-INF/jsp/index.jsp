<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>首页=<%=basePath %></h2>
<h2><a href="<%=basePath %>user/getUserList.shtml">用户管理</a></h2>
<h2><a href="<%=basePath %>user/getUserInfo.shtml">用户信息</a></h2>
</body>
</html>
