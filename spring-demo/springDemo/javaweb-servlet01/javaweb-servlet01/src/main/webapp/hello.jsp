<%--JSP本质是servlet, .java文件，再tomcat工作目录可以查看--%>

<%--设置编码。防止中文乱码--%>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<body>
<h2>Hello World!</h2>

<%
    String name = "凯瑞";
//    request.setCharacterEncoding("utf-8");
//    response.setCharacterEncoding("utf-8");
%>
name：<%=name%>
</body>
</html>
